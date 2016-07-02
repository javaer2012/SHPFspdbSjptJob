package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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

import com.ideal.spdb.tencent.model.TencentFraudReportModel;
import com.ideal.spdb.tencent.model.TencentReportModel;
import com.ideal.spdb.tencent.service.TencentReportService;
import com.ideal.spdb.thirdinfo.dao.IApprovalDao;
import com.ideal.spdb.thirdinfo.dao.ISocialsecurityDao;
import com.ideal.spdb.thirdinfo.dao.TencentDao;
import com.ideal.spdb.thirdinfo.model.AppInfoModel;
import com.ideal.spdb.thirdinfo.model.EduImportModel;
import com.ideal.spdb.thirdinfo.model.TencentModel;
import com.ideal.spdb.thirdinfo.service.TencentService;
import com.ideal.spdb.thirdinfo.util.DownloadFtpFile;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.AppConfigFile;

@Service
public class TencentServiceImpl implements TencentService {

	private static final Logger log = Logger.getLogger(TencentServiceImpl.class);
	
	@Inject
	private TencentDao dao;
	@Inject
	private TencentReportService tencentService;
	@Inject
	ISocialsecurityDao SocialsecuritDao;
	@Inject
	private IApprovalDao appdap;


	/**
	 * 征信
	 */
	@Override
	public void creditExcel() throws Exception {
		try {
			log.info("处理Tencent征信excel文件！！");
			// ftp根目录
			String ftproot = AppConfigFile.getInstance().getValue("FTP_ROOT");
			// ftp存放excel文件的目录
			String serverFolder = ftproot + AppConfigFile.getInstance().getValue("TENCENT_CREDIT_INPUT");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_ROOT")+File.separator+"CREDIT";
			//本地备份目录
			String localBakFolder=loacalDownSaveFolder+File.separator+"BAK";
			
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
					List<TencentModel> datalist = parseExcelData(file.getPath());
					for (TencentModel model : datalist) {
						if(StringUtils.isNotEmpty(model.getShengqingrencardnumber()) && model.getShengqingrencardnumber().length() == 18){
							model.setFlow("00000100");//授权评分、授权欺诈、授权评分欺诈
							model.setProcessFinish("11111011");
						}else{
							model.setFlow("00000000");//授权评分、授权欺诈、授权评分欺诈
							model.setProcessFinish("11111111");
						}
						AppInfoModel appmodel = new AppInfoModel(model.getShenqingshucode(), null, 
								model.getShenqingrenzhongwenminchen(), model.getShengqingrencardnumber(), model.getApprovalcode(), "1");
						appdap.insertOrUpdateAppInfo(appmodel);
					}
					initTencentProcess(datalist);
					FileUtils.moveFile(file, new File(localBakFolder+ File.separator + file.getName() + Math.random()));
				}
			}
			ftpUtil.closeServer();
			
			
//			// 下载文件
//			String fileName = this.downFtpServerFile(serverFolder,loacalDownSaveFolder);
//			// 下载完成后删除文件
//			if (!fileName.isEmpty() || fileName != "") {
//				this.deleteFile(serverFolder + fileName);
//				// 解析所下载的excel文件数据
//				List<TencentModel> datalist = parseExcelData(loacalDownSaveFolder + fileName);
//				// 存入本地数据库
//				//this.insertIntoData(datalist);
//				
//				for (TencentModel model : datalist) {
//					if(StringUtils.isNotEmpty(model.getShengqingrencardnumber()) && model.getShengqingrencardnumber().length() == 18){
//						model.setFlow("00000100");//授权评分、授权欺诈、授权评分欺诈
//						model.setProcessFinish("11111011");
//					}else{
//						model.setFlow("00000000");//授权评分、授权欺诈、授权评分欺诈
//						model.setProcessFinish("11111111");
//					}
//				}
//				this.initTencentProcess(datalist);
//			} else {
//				log.info("<===========ftp目录下没有可以下载的文件===========>");
//			}
		} catch (Exception e) {
			log.error("异常:"+e);
		}
	}



	/**
	 * 欺诈
	 */
	@Override
	public void fraudExcel() throws Exception {
		try {
			log.info("处理Tencent反欺诈excel文件！！");
			// ftp根目录
			String ftproot = AppConfigFile.getInstance().getValue("FTP_ROOT");
			// ftp存放excel文件的目录
			String serverFolder = ftproot + AppConfigFile.getInstance().getValue("TENCENT_FRAUD_INPUT");
			// 下载文件存放位置
			String loacalDownSaveFolder = AppConfigFile.getInstance().getValue("LOCAL_ROOT")+File.separator+"FRAUD";
			//本地备份目录
			String localBakFolder=loacalDownSaveFolder+File.separator+"BAK";
			
			
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
					List<TencentModel> datalist = parseExcelData(file.getPath());
					for (TencentModel model : datalist) {
						if(StringUtils.isNotEmpty(model.getShengqingrencardnumber()) && model.getShengqingrencardnumber().length() == 18){
							model.setFlow("00000010");//授权评分、授权欺诈、授权评分欺诈
							model.setProcessFinish("11111101");
						}else{
							model.setFlow("00000000");//授权评分、授权欺诈、授权评分欺诈
							model.setProcessFinish("11111111");
						}
						AppInfoModel appmodel = new AppInfoModel(model.getShenqingshucode(), null, 
								model.getShenqingrenzhongwenminchen(), model.getShengqingrencardnumber(), model.getApprovalcode(), "1");
						appdap.insertOrUpdateAppInfo(appmodel);
					}
					initTencentProcess(datalist);
					FileUtils.moveFile(file, new File(localBakFolder+ File.separator + file.getName() + Math.random()));
				}
			}
			ftpUtil.closeServer();
//			// 下载文件
//			String fileName = this.downFtpServerFile(serverFolder,loacalDownSaveFolder);
//			// 下载完成后删除文件
//			if (!fileName.isEmpty() || fileName != "") {
//				this.deleteFile(serverFolder + fileName) ;
//				// 解析所下载的excel文件数据
//				List<TencentModel> datalist = this.parseExcelData(loacalDownSaveFolder + fileName);
//				// 存入本地数据库
//				//this.insertIntoData(datalist);
//
//				for (TencentModel model : datalist) {
//					if(StringUtils.isNotEmpty(model.getShengqingrencardnumber()) && model.getShengqingrencardnumber().length() == 18){
//						model.setFlow("00000010");//授权评分、授权欺诈、授权评分欺诈
//						model.setProcessFinish("11111101");
//					}else{
//						model.setFlow("00000000");//授权评分、授权欺诈、授权评分欺诈
//						model.setProcessFinish("11111111");
//					}
//				}
//				this.initTencentProcess(datalist);
//			} else {
//				log.info("<===========ftp目录下没有可以下载的文件===========>");
//			}
		} catch (Exception e) {
			log.error("异常:"+e);
		}
	}




	/**
	 * 从ftp下载excel文件
	 * 
	 * @return
	 */
	private synchronized String downFtpServerFile(String serverFolder,
			String loacalDownSaveFolder) {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		String serverFileName = "";
		List serverFileList = ftpUtil.getFileList(serverFolder, new String[] {".xls", ".xlsx" });
		if (serverFileList != null && serverFileList.size() > 0) {
			for (int i = 0; i < serverFileList.size(); i++) {
				String temp = (String) serverFileList.get(i);
				serverFileName = temp.substring(temp.lastIndexOf(File.separator) + 1,temp.length());
				long ds = ftpUtil.downloadFile(serverFolder + serverFileName,
						loacalDownSaveFolder + serverFileName);
				log.info("serverFileName = " + serverFileName);
			}
		}
		ftpUtil.closeServer();
		return serverFileName;
	}

	/**
	 * 下载完成后删除文件
	 */
	private void deleteFile(String fileName) {
		FtpUtil ftpUtil = new FtpUtil();
		ftpUtil.initFtpUtil();
		ftpUtil.deleteFile(fileName);
		ftpUtil.closeServer();
	}

	/**
	 * 解析所下载的excel文件数据
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static List<TencentModel> parseExcelData(String filePath)
			throws FileNotFoundException, IOException {
		log.info("《=======开始解析所下载的excel数据=========》" + filePath);
		List<TencentModel> list = new ArrayList<TencentModel>();
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
				TencentModel model = new TencentModel();
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
								value = cell.getStringCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y"
									: "N");
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						log.info(rowIndex + "," + columnIndex + ":" + value);

						value = value.trim();
						if (columnIndex == 0) {
							model.setShenqingshucode(value);// 申请书编号
						} else if (columnIndex == 1) {
							model.setShenqingrenzhongwenminchen(value);// 中文名
						} else if (columnIndex == 2) {
							model.setShengqingrencardnumber(value);// /证件号
						} else if (columnIndex == 3) {
							model.setShenqingrenmobilenumber(value);// 手机
						} else if (columnIndex == 4) {
							model.setQQ(value);
						} else if (columnIndex == 5) {
							model.setIP(value);
						} else if (columnIndex == 6) {
							model.setApprovalcode(value);
						}
					}
				}
				if (StringUtils.isNotEmpty(model.getShenqingshucode())
						&& StringUtils.isNotEmpty(model.getShenqingrenzhongwenminchen())
						&& StringUtils.isNotEmpty(model.getShengqingrencardnumber())
						//&& StringUtils.isNotEmpty(model.getShenqingrenmobilenumber())
								) {
					list.add(model);
				}
			}
		} else {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					new File(filePath)));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFCell cell = null;
			HSSFSheet st = wb.getSheetAt(0);
			for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				TencentModel model = new TencentModel();
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
								value = cell.getStringCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y"
									: "N");
							break;
						default:
							value = "";
						}
						// 每次循环输出：第几行的第几列的值（如：0,0，第一行第一列）
						log.info(rowIndex + "," + columnIndex + ":" + value);
						value = value.trim();
						if (columnIndex == 0) {
							model.setShenqingshucode(value);// 申请书编号
						} else if (columnIndex == 1) {
							model.setShenqingrenzhongwenminchen(value);// 中文名
						} else if (columnIndex == 2) {
							model.setShengqingrencardnumber(value);// /证件号
						} else if (columnIndex == 3) {
							model.setShenqingrenmobilenumber(value);// 手机
						} else if (columnIndex == 4) {
							model.setQQ(value);
						} else if (columnIndex == 5) {
							model.setIP(value);
						} else if (columnIndex == 6) {
							model.setApprovalcode(value);
						}
					}
				}
				if (StringUtils.isNotEmpty(model.getShenqingshucode())
						&& StringUtils.isNotEmpty(model.getShenqingrenzhongwenminchen())
						&& StringUtils.isNotEmpty(model.getShengqingrencardnumber())
						//&& StringUtils.isNotEmpty(model.getShenqingrenmobilenumber())
								) {
					list.add(model);
				}
			}
		}
		return list;
	}

	/**
	 * 存入本地数据库
	 * @throws Exception
	 */
	private boolean insertIntoData(List<TencentModel> list) throws Exception {
		return this.dao.batchAdd("tencent.insertProcess", list);
	}

	/**
	 * 存入流程表 主表
	 */
	private void initTencentProcess(List<TencentModel> list) throws Exception {
			this.dao.batchAdd("tencent.insertProcess", list);
			this.dao.uporinset(list);
	}
	
//	public static void main(String[] args) {
//		try {
//			parseExcelData("D:/spdbFolder/DOWN/FRAUD/TX2015070101.xlsx");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}



	@Override
	public void uploadReoprt2CRM() throws Exception {
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要生成的tencent2crm信息----------------------------");
		List<TencentReportModel> amList = tencentService.getAllList("queryAllByYesterday",null);
		//如果当天没有相关文件就直接返回
	
		//生成文件名
		log.info("==================开始生成tencent2crm的txt文件======================");
		fileName = getFileName();
		fileFolder = AppConfigFile.getInstance().getValue("LOCAL_TENCENT_CRM");//腾讯crm 本地
		File folder=new File(fileFolder);
		if(!folder.exists()){
			folder.mkdir();
		}
		filePathAndName = fileFolder+File.separator+fileName;

		log.info("===============创建了文件名===========filePathAndName："+filePathAndName);
		//生成txt文件 
		bluidTxtFile(filePathAndName, amList);
		log.info("--------------------tencent2CRM信息文件生成成功 --------------------");
		 //4.上传文件
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil(1);
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_TENCENT_CRM");//腾讯FTP
		 log.info("------------tencent2CRM信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 ftpUtil.upload(filePathAndName,ftpTagertFolder+File.separator+fileName);
		 ftpUtil.closeServer();
		 
		 FtpUtil ftpUtil1=new FtpUtil();
		 ftpUtil1.initFtpUtil();
		 String ftpTagertFolder1 = AppConfigFile.getInstance().getValue("FTP_TENCENT_COM_TXZX");//腾讯FTP
		 log.info("------------tencent2COM信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder1);
		 //上传txt文件
		 ftpUtil1.upload(filePathAndName,ftpTagertFolder1+File.separator+fileName);
		 ftpUtil1.closeServer();
	}
	
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		sb.append("TXZX_ALL_");
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		sb.append(df.format(c.getTime()));
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	public boolean bluidTxtFile(String filepathAndName,List<TencentReportModel> amList){
		log.info("进入了bluidTxtFile方法准备开始创建txt");
		boolean ret = false;
		if (amList == null) {
			return ret;
		}
		// 生成TXT文件
		try {
			File file = new File(filepathAndName);
			log.info("开始生成writeString并做成txt");
			FileUtils.writeStringToFile(file,makeString(amList),"GBK");
			ret = true;
		} catch (Exception e) {
			ret = false;
			log.error("bluidTxtFile方法异常" + e);
		}
		
		return ret;
	}



	private String makeString(List<TencentReportModel> amList) {
		StringBuffer sb=new StringBuffer();
		String line=System.getProperty("line.separator");//换行符
		sb.append("APPID|IDNO|CARD_TYPE|APPNAME|CDATE|SCORE|PD|QUERY_DATE|QUERY_TYPE|FREG_HIS|FREAL_HIS|FBIND_CREDIT_HIS|FBIND_CRE_CNT|FBIND_CRE_CNT|FBIND_MOBILE_HIS|FBIND_MOBILE_RECENT|FBIND_MOBILE_CHG|FADDRESS_CHG|FXF_LEVEL|FZZ_LEVEL|FLC_LEVEL|FHK_LEVEL|FJF_LEVEL|FLOAN_BALANCE|FLOAN_UNPAY_CNT|FLOAN_STATE|FLAST_DEAD_LINE|FDEAD_UNPAY_CNT|FINTERNET_AGE|FACTIVE_LEVEL|FSOCIAL_LEVEL|FJY_AMT_LEVEL|FJY_MONTH_LEVEL"+line);
		for (TencentReportModel model : amList) {
			sb.append(model.getAppid());
			sb.append("|");
			sb.append(model.getIdno());
			sb.append("|");
			sb.append(model.getCard_type());
			sb.append("|");
			sb.append(model.getAppname());
			sb.append("|");
			sb.append(model.getCdate()==null?"":model.getCdate());
			sb.append("|");
			sb.append(model.getScore()==null?"":model.getScore());
			sb.append("|");
			sb.append(model.getPd()==null?"":model.getPd());
			sb.append("|");
			sb.append(model.getCreateDate()==null?"":model.getCreateDate());
			sb.append("|");
			sb.append(model.getCallType()==null?"":model.getCallType());
			sb.append("|");
			sb.append(model.getFreg_his()==null?"":model.getFreg_his());
			sb.append("|");
			sb.append(model.getFreal_his()==null?"":model.getFreal_his());
			sb.append("|");
			sb.append(model.getFbind_credit_his()==null?"":model.getFbind_credit_his());
			sb.append("|");
			sb.append(model.getFbind_cre_cnt()==null?"":model.getFbind_cre_cnt());
			sb.append("|");
			sb.append(model.getFbind_cre_cnt()==null?"":model.getFbind_cre_cnt());
			sb.append("|");
			sb.append(model.getFbind_mobile_his()==null?"":model.getFbind_mobile_his());
			sb.append("|");
			sb.append(model.getFbind_mobile_recent()==null?"":model.getFbind_mobile_recent());
			sb.append("|");
			sb.append(model.getFbind_mobile_chg()==null?"":model.getFbind_mobile_chg());
			sb.append("|");
			sb.append(model.getFaddress_chg()==null?"":model.getFaddress_chg());
			sb.append("|");
			sb.append(model.getFxf_level()==null?"":model.getFxf_level());
			sb.append("|");
			sb.append(model.getFzz_level()==null?"":model.getFzz_level());
			sb.append("|");
			sb.append(model.getFlc_level()==null?"":model.getFlc_level());
			sb.append("|");
			sb.append(model.getFhk_level()==null?"":model.getFhk_level());
			sb.append("|");
			sb.append(model.getFjf_level()==null?"":model.getFjf_level());
			sb.append("|");
			sb.append(model.getFloan_balance()==null?"":model.getFloan_balance());
			sb.append("|");
			sb.append(model.getFloan_unpay_cnt()==null?"":model.getFloan_unpay_cnt());
			sb.append("|");
			sb.append(model.getFloan_state()==null?"":model.getFloan_state());
			sb.append("|");
			sb.append(model.getFlast_dead_line()==null?"":model.getFlast_dead_line());
			sb.append("|");
			sb.append(model.getFdead_unpay_cnt()==null?"":model.getFdead_unpay_cnt());
			sb.append("|");
			sb.append(model.getFinternet_age()==null?"":model.getFinternet_age());
			sb.append("|");
			sb.append(model.getFactive_level()==null?"":model.getFactive_level());
			sb.append("|");
			sb.append(model.getFsocial_level()==null?"":model.getFsocial_level());
			sb.append("|");
			sb.append(model.getFjy_amt_level()==null?"":model.getFjy_amt_level());
			sb.append("|");
			sb.append(model.getFjy_month_level()==null?"":model.getFjy_month_level());
			sb.append(line);
		}
		return sb.toString();
	}
	
	private String getApprovalFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("txzx_auto_");
		Date d = new Date();
		sb.append(sdf.format(d));
		sb.append("_");
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(2).get("out_system_seq");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	/**
	 * 上传文件至审批
	 */
	@Override
	public void uploadReportToApproval() throws Exception {
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要生成的tencent2Approval信息----------------------------");
		List<TencentReportModel> amList = tencentService.getAllList("queryAllNeedUploadReportToApproval",null);
		//如果当天没有相关文件就直接返回
		if(null == amList||amList.size() == 0)return;
		//生成文件名
		log.info("==================开始生成tencent2Approval的txt文件======================");
		fileName = getApprovalFileName();
		fileFolder = AppConfigFile.getInstance().getValue("LOCAL_TENCENT_CRM");//腾讯crm 本地
		File folder=new File(fileFolder);
		if(!folder.exists()){
			folder.mkdir();
		}
		filePathAndName = fileFolder+File.separator+fileName;

		log.info("===============创建了文件名===========filePathAndName："+filePathAndName);
		//生成txt文件 
		bluidUploadReportToApprovalTxtFile(filePathAndName, amList);
		log.info("--------------------tencent2Approval信息文件生成成功 --------------------");
		 //4.上传文件
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_TENCENT_APPROVAL");//腾讯FTP
		 log.info("------------tencent2Approval信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 ftpUtil.upload(filePathAndName,ftpTagertFolder+File.separator+fileName);
		 File f = new File(filePathAndName+".ok");
		 f.createNewFile();
		 //上传.ok文件
		 ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+File.separator+fileName+".ok");
		 ftpUtil.closeServer();
		 //更新数据库
		 dao.batchApprovalUpdate(amList);
		 
	}	
	/**
	 * 创建上传审批文件
	 * @param filepathAndName
	 * @param amList
	 * @return
	 */
	public boolean bluidUploadReportToApprovalTxtFile(String filepathAndName,List<TencentReportModel> amList){
		log.info("进入了bluidTxtFile方法准备开始创建txt");
		boolean ret = false;
		if (amList == null) {
			return ret;
		}
		// 生成TXT文件
		try {
			File file = new File(filepathAndName);
			log.info("开始生成writeString并做成txt");
			FileUtils.writeStringToFile(file,makeUploadReportToApprovalString(amList),"GBK");
			ret = true;
		} catch (Exception e) {
			ret = false;
			log.error("bluidTxtFile方法异常" + e);
		}
		
		return ret;
	}
	/**
	 * 拼接上传审批文件
	 * @param amList
	 * @return
	 */
	private String makeUploadReportToApprovalString(List<TencentReportModel> amList) {
		StringBuffer sb=new StringBuffer();
		String line=System.getProperty("line.separator");//换行符
		for (TencentReportModel model : amList) {
			sb.append(model.getAppid());
			sb.append("|");
			sb.append(model.getIdno());
			sb.append("|");
			sb.append(model.getCard_type());
			sb.append("|");
			sb.append(model.getAppname());
			sb.append("|");
			sb.append(model.getCdate()==null?"":model.getCdate());
			sb.append("|");
			sb.append(model.getScore()==null?"":model.getScore());
			sb.append("|");
			sb.append(model.getPd()==null?"":model.getPd());
			sb.append("|");
			sb.append(model.getFreg_his()==null?"":model.getFreg_his());
			sb.append("|");
			sb.append(model.getFreal_his()==null?"":model.getFreal_his());
			sb.append("|");
			sb.append(model.getFbind_credit_his()==null?"":model.getFbind_credit_his());
			sb.append("|");
			sb.append(model.getFbind_cre_cnt()==null?"":model.getFbind_cre_cnt());
			sb.append("|");
			sb.append(model.getFbind_mobile_his()==null?"":model.getFbind_mobile_his());
			sb.append("|");
			sb.append(model.getFbind_mobile_recent()==null?"":model.getFbind_mobile_recent());
			sb.append("|");
			sb.append(model.getFbind_mobile_chg()==null?"":model.getFbind_mobile_chg());
			sb.append("|");
			sb.append(model.getFaddress_chg()==null?"":model.getFaddress_chg());
			sb.append("|");
			sb.append(model.getFxf_level()==null?"":model.getFxf_level());
			sb.append("|");
			sb.append(model.getFzz_level()==null?"":model.getFzz_level());
			sb.append("|");
			sb.append(model.getFlc_level()==null?"":model.getFlc_level());
			sb.append("|");
			sb.append(model.getFhk_level()==null?"":model.getFhk_level());
			sb.append("|");
			sb.append(model.getFjf_level()==null?"":model.getFjf_level());
			sb.append("|");
			sb.append(model.getFloan_balance()==null?"":model.getFloan_balance());
			sb.append("|");
			sb.append(model.getFloan_unpay_cnt()==null?"":model.getFloan_unpay_cnt());
			sb.append("|");
			sb.append(model.getFloan_state()==null?"":model.getFloan_state());
			sb.append("|");
			sb.append(model.getFlast_dead_line()==null?"":model.getFlast_dead_line());
			sb.append("|");
			sb.append(model.getFdead_unpay_cnt()==null?"":model.getFdead_unpay_cnt());
			sb.append("|");
			sb.append(model.getFinternet_age()==null?"":model.getFinternet_age());
			sb.append("|");
			sb.append(model.getFactive_level()==null?"":model.getFactive_level());
			sb.append("|");
			sb.append(model.getFsocial_level()==null?"":model.getFsocial_level());
			sb.append("|");
			sb.append(model.getFjy_amt_level()==null?"":model.getFjy_amt_level());
			sb.append("|");
			sb.append(model.getFjy_month_level()==null?"":model.getFjy_month_level());
			sb.append("|");
			sb.append(line);
		}
		return sb.toString();
	}
	
	private String getFraudFileName(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sb.append("txfqz_auto_");
		Date d = new Date();
		sb.append(sdf.format(d));
		sb.append("_");
		//获取批次号
		String xuHao = "";
		xuHao = SocialsecuritDao.getXuHao(2).get("out_system_seq");
		sb.append(xuHao);
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	/**
	 * 上传反欺诈文件至审批
	 */
	@Override
	public void uploadFraudReportToApproval() throws Exception {
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要生成的tencentFraud2Approval信息----------------------------");
		List<TencentFraudReportModel> amList = dao.getNeedUploadFraudReportList();
		//如果当天没有相关文件就直接返回
		if(null == amList||amList.size() == 0)return;
		//生成文件名
		log.info("==================开始生成tencentFraud2Approval的txt文件======================");
		fileName = getFraudFileName();
		fileFolder = AppConfigFile.getInstance().getValue("LOCAL_TENCENT_CRM");//腾讯crm 本地
		File folder=new File(fileFolder);
		if(!folder.exists()){
			folder.mkdir();
		}
		filePathAndName = fileFolder+File.separator+fileName;

		log.info("===============创建了文件名===========filePathAndName："+filePathAndName);
		//生成txt文件 
		bluidUploadFraudReportToApprovalTxtFile(filePathAndName, amList);
		log.info("--------------------tencentFraud2Approval信息文件生成成功 --------------------");
		 //4.上传文件
		 FtpUtil ftpUtil=new FtpUtil();
		 ftpUtil.initFtpUtil();
		 String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_TENCENT_Fraud");//腾讯FTP
		 log.info("------------tencentFraud2Approval信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder);
		 //上传txt文件
		 ftpUtil.upload(filePathAndName,ftpTagertFolder+File.separator+fileName);
		 File f = new File(filePathAndName+".ok");
		 f.createNewFile();
		 //上传.ok文件
		 ftpUtil.upload(filePathAndName+".ok",ftpTagertFolder+File.separator+fileName+".ok");
		 ftpUtil.closeServer();
		 //更新数据库
		 dao.batchFraudApprovalUpdate(amList);
		 
	}
	
	/**
	 * 创建上传审批文件
	 * @param filepathAndName
	 * @param amList
	 * @return
	 */
	public boolean bluidUploadFraudReportToApprovalTxtFile(String filepathAndName,List<TencentFraudReportModel> amList){
		log.info("进入了bluidTxtFile方法准备开始创建txt");
		boolean ret = false;
		if (amList == null) {
			return ret;
		}
		// 生成TXT文件
		try {
			File file = new File(filepathAndName);
			log.info("开始生成writeString并做成txt");
			FileUtils.writeStringToFile(file,makeUploadFraudReportToApprovalString(amList),"GBK");
			ret = true;
		} catch (Exception e) {
			ret = false;
			log.error("bluidTxtFile方法异常" + e);
		}
		
		return ret;
	}
	/**
	 * 拼接上传审批文件
	 * @param amList
	 * @return
	 */
	private String makeUploadFraudReportToApprovalString(List<TencentFraudReportModel> amList) {
		StringBuffer sb=new StringBuffer();
		String line=System.getProperty("line.separator");//换行符
		for (TencentFraudReportModel model : amList) {
			sb.append(model.getAppid());
			sb.append("|");
			sb.append(model.getRemark());
			sb.append("|");
			sb.append(StringUtils.isNotEmpty(model.getQq_name())?model.getQq_name():"");
			sb.append("|");
			sb.append(StringUtils.isNotEmpty(model.getQq_id())?model.getQq_id():"");
			sb.append("|");
			sb.append(StringUtils.isNotEmpty(model.getQq_mobile())?model.getQq_mobile():"");
			sb.append("|");
			sb.append(StringUtils.isNotEmpty(model.getId_name())?model.getId_name():"");
			sb.append("|");
			sb.append(StringUtils.isNotEmpty(model.getId_mobile())?model.getId_mobile():"");
			
			sb.append(line);
		}
		return sb.toString();
	}
}
