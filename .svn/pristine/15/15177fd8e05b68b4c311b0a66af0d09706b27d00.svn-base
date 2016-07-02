package com.ideal.spdb.thirdinfo.service.impl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.dao.impl.ApprovalDaoImpl;
import com.ideal.spdb.thirdinfo.model.AppInfoModel;
import com.ideal.spdb.thirdinfo.model.EduImportModel;
import com.ideal.spdb.thirdinfo.model.EucVehicleModel;
import com.ideal.spdb.thirdinfo.service.IEucVehicleExcelService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FileOperateUtil;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.HttpClientUtil;

/**
 * 处理euc excel文件 service 实现类
 * 
 * @author uatmy06136
 * 
 */
@Service
public class EucVehicleExcelServiceImpl implements IEucVehicleExcelService {
	
	private static final Logger log = Logger.getLogger(EucVehicleExcelServiceImpl.class);
	@Inject
	private IEucVehicleExcelDao dao; // 操作dao
	@Inject
	private IApprovalDao appdao;

	/**
	 * 业务处理类
	 *  ftp文件目录：APWZ\XXSJ\SHEBAO  本地备份目录：LOCAL_ROOT=D\:\\spdbFolder
	 *  
	 * @throws Exception
	 */
	@Override
	public boolean handleEucExcel() throws Exception {
		boolean flag = true;
		try{
			log.info("处理EUC excel文件 业务处理开始！！");
			// ftp根目录
			//ftp存放excel文件的目录
			String serverFolder = AppConfigFile.getInstance().getValue("FTP_EUCVEHICLE");
			//下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_ROOT")+File.separator + "DOWN" +File.separator  +"CHELIANG";
			// 下载文件
			FtpUtil ftpUtil = new FtpUtil();
			ftpUtil.initFtpUtil();
			if(DownloadFtpFile.downloadByOK(ftpUtil, serverFolder, loacalDownSaveFolder)){
				File [] files=new File(loacalDownSaveFolder).listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.endsWith(".xls")||name.endsWith(".xlsx");
					}
				});
				for (File file : files) {
					// 备份到bak
					List<EucVehicleModel> datalist = parseExcelData(file.getPath());
					DownloadFtpFile.moveLocalFile2Bak(file, loacalDownSaveFolder + File.separator +"BAK");
					//存入本地数据库
					this.insertIntoData(datalist);
					// 查询到的数据循环调用社保接口 并更新表中flag为1
					this.initEucProcess(datalist);
				}
			}

		} catch (Exception e) {
			log.error(e);
			flag = false;
		}
		return flag;
	}

	/**
	 * 从ftp下载excel文件 
	 * 
	 * @return
	 */
	private synchronized String downFtpServerFile(String serverFolder,String loacalDownSaveFolder) {
		FtpUtil ftpUtil=new FtpUtil();
		boolean ret = false;
		ftpUtil.initFtpUtil();
		String serverFileName = "";
		List serverFileList = ftpUtil.getFileList(serverFolder,new String[]{".xls",".xlsx"});
		if(serverFileList!=null&&serverFileList.size()>0){
			for (int i = 0; i < serverFileList.size(); i++) {
				String temp = (String) serverFileList.get(i);
				serverFileName = temp.substring(temp.lastIndexOf("/") + 1, temp
						.length());
				long ds = ftpUtil.downloadFile(
						serverFolder + serverFileName,
						loacalDownSaveFolder + serverFileName);
				ret = ds >= 0 ? true : false;
				log.info("serverFileName = " + serverFileName);
			}
		}
		ftpUtil.closeServer();
		return serverFileName;
	}
     
	/**
	 * 下载完成后删除文件
	 */
	private void deleteFile(String fileName){
		FtpUtil ftpUtil=new FtpUtil();
		ftpUtil.initFtpUtil();
		ftpUtil.deleteFile(fileName);
		ftpUtil.closeServer();
	}
	
	/**
	 * 解析所下载的excel文件数据
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private List<EucVehicleModel> parseExcelData(String filePath) throws FileNotFoundException, IOException {
		log.info("《=======开始解析所下载的excel数据=========》"+filePath);
		 List<EucVehicleModel> list  = new ArrayList<EucVehicleModel>();
		 if (filePath.indexOf("xlsx") > 0) {
				XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));
				XSSFSheet st = wb.getSheetAt(0);
				XSSFCell cell = null;
				if (st == null) {
					return null;
				}
				for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
					XSSFRow row = st.getRow(rowIndex);
					if (row == null) {
						continue;
					}
					EucVehicleModel mes = new EucVehicleModel();
					for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
						cell = row.getCell(columnIndex);
						String value = "";
						if (cell != null) {
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_STRING:
							    value = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									Date date = cell.getDateCellValue();
									if (date != null) {
										value = new SimpleDateFormat("yyyyMMdd")
												.format(date);
									} else {
										value = "";
									}
								} else {
									value = new DecimalFormat("0").format(cell
											.getNumericCellValue());
								}
								break;
							case HSSFCell.CELL_TYPE_FORMULA:
								if (!cell.getStringCellValue().equals("")) {
									value = cell.getStringCellValue();
								} else {
									value = cell.getStringCellValue()+"";
								}
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								break;
							case HSSFCell.CELL_TYPE_ERROR:
								value = "";
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN:
								value = (cell.getBooleanCellValue() == true ? "Y" : "N");
								break;
							default:
								value = "";
							}
							 //每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
							System.out.println(rowIndex + "," + columnIndex + ":"
									+ value);
							
							value = value.trim();
							if(columnIndex == 0){
								//列为0
								mes.setShenqingshucode(value);
							}else if(columnIndex == 1){
								//列为1，以下依次类推
								mes.setShenqingrenzhongwenminchen(value);
							}else if(columnIndex == 2){
								mes.setShengqingrencardnumber(value);
							}else if(columnIndex == 3){
								mes.setCarno(value);
							}else if(columnIndex == 4){
								if(value==null || "".equals(value)){
									mes.setCartype("02");
								}else{
									mes.setCartype(value);
								}
							}else if(columnIndex == 5){
								mes.setApprovalcode(value);
							}
						}
						if(mes.getShenqingshucode()!=null&&!"".equals(mes.getShenqingshucode())
								&& mes.getShenqingrenzhongwenminchen()!=null &&!"".equals(mes.getShenqingrenzhongwenminchen())
								&& mes.getShengqingrencardnumber()!=null &&!"".equals(mes.getShengqingrencardnumber())
								&& mes.getCarno()!=null &&!"".equals(mes.getCarno())//车辆类型没有，处理默认为02
								 ){
							   list.add(mes);
						   }
					}
					}
		 }else{
			 POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(new File(filePath)));
				HSSFWorkbook wb = new HSSFWorkbook(fs);
				HSSFCell cell = null;
				HSSFSheet st = wb.getSheetAt(0);
				for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
					HSSFRow row = st.getRow(rowIndex);
					if (row == null) {
						continue;
					}
					EucVehicleModel mes = new EucVehicleModel();
					for (int columnIndex = 0, size = row.getLastCellNum(); columnIndex <= size; columnIndex++) {
						cell = row.getCell(columnIndex);
						String value = "";
						if (cell != null) {
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_STRING:
								value = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									Date date = cell.getDateCellValue();
									if (date != null) {
										value = new SimpleDateFormat("yyyyMMdd")
												.format(date);
									} else {
										value = "";
									}
								} else {
									value = new DecimalFormat("0").format(cell
											.getNumericCellValue());
								}
								break;
							case HSSFCell.CELL_TYPE_FORMULA:
								if (!cell.getStringCellValue().equals("")) {
									value = cell.getStringCellValue();
								} else{
									value = cell.getStringCellValue()+"";
								}
								break;
							case HSSFCell.CELL_TYPE_BLANK:
								break;
							case HSSFCell.CELL_TYPE_ERROR:
								value = "";
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN:
								value = (cell.getBooleanCellValue() == true ? "Y" : "N");
								break;
							default:
								value = "";
							}
							 //每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
							System.out.println(rowIndex + "," + columnIndex + ":"
									+ value);
							
							value = value.trim();
							if(columnIndex == 0){
								//列为0
								mes.setShenqingshucode(value);
							}else if(columnIndex == 1){
								//列为1，以下依次类推
								mes.setShenqingrenzhongwenminchen(value);
							}else if(columnIndex == 2){
								mes.setShengqingrencardnumber(value);
							}else if(columnIndex == 3){
								mes.setCarno(value);
							}else if(columnIndex == 4){
								if(value==null || "".equals(value)){
									mes.setCartype("02");
								}else{
									mes.setCartype(value);
								}
							}else if(columnIndex == 5){
								mes.setApprovalcode(value);
							}
						}
					}
					   if(mes.getShenqingshucode()!=null&&!"".equals(mes.getShenqingshucode())
							&& mes.getShenqingrenzhongwenminchen()!=null &&!"".equals(mes.getShenqingrenzhongwenminchen())
							&& mes.getShengqingrencardnumber()!=null &&!"".equals(mes.getShengqingrencardnumber())
							&& mes.getCarno()!=null &&!"".equals(mes.getCarno())//车辆类型没有，处理默认为02
							 ){
						   list.add(mes);
					   }
					}
		 }
			return list;
		}
	
	/**
	 * 存入本地数据库
	 * @throws Exception 
	 */
	private boolean insertIntoData(List<EucVehicleModel> list) throws Exception{
		
		return this.dao.batchAdd("eucvehicleexcel.insertObject", list);
	}


	/**
	 * 循环调用社保接口 并更新表中flag为1
	 * 
	 * @throws Exception
	 */
	private void initEucProcess(List<EucVehicleModel> list) throws Exception {
		if (list != null && list.size() > 0) {
			List<EucVehicleModel> comlist  = new ArrayList<EucVehicleModel>();
			for (EucVehicleModel model : list) {
				model.setFlag("01");
				comlist.add(model);
					AppInfoModel appmodel = new AppInfoModel(model.getShenqingshucode(), null, 
							model.getShenqingrenzhongwenminchen(), model.getShengqingrencardnumber(), model.getApprovalcode(), "1");
					appdao.insertOrUpdateAppInfo(appmodel);
			}
			this.dao.batchAdd("eucvehicleexcel.insertProcess", comlist);
			this.dao.uporinset("eucvehicleexcel.insertOrUpdateApp",comlist);
		}
	}
}



