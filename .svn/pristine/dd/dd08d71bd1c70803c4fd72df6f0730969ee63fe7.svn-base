package com.ideal.spdb.thirdinfo.work.others;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.dao.IEucVehicleExcelDao;
import com.ideal.spdb.thirdinfo.dao.IZfbzxDao;
import com.ideal.spdb.thirdinfo.model.ThirdinfoModel;
import com.ideal.spdb.thirdinfo.model.ZfbzxModel;
import com.ideal.spdb.thirdinfo.service.IZfbzxService;
import com.ideal.spdb.thirdinfo.work.util.RequestIp;

public class ZfbzxWork {
	private static final Logger log = Logger.getLogger(ZfbzxWork.class);
	@Inject
	private IEucVehicleExcelDao vehicleDao;
	
	@Inject
	private IZfbzxService service;
	
	@Inject
	private IZfbzxDao dao;

	public void everydayUpload(){
		log.info("=========ZfbzxWork.everydayUpload()开始执行=============");
		long start = System.currentTimeMillis();
		try {
			String localhostIp = RequestIp.getLocalhostIp();
			String serverIp = this.vehicleDao.getConfigIP("SERVER_IP");
			log.info("localhostIp = " + localhostIp);
			log.info("serverIp = " + serverIp);
			if (localhostIp.equals(serverIp)) {
				List<ZfbzxModel> list = null;
				list = dao.getNeedExportInfo("zfbzx.queryInfo");
				if(list == null || list.size() == 0){
					log.info("没有需要上传的信息，不生成文件");
					return;
				}
				String txt = parseTxt(list);
				boolean flag = service.doservice(3,"ZFBTXT",txt);
				if(flag){
					log.info("文件生成成功..开始修改上传状态");
					for(ZfbzxModel ZfbzxModel:list){
						dao.updateFlag(ZfbzxModel, "zfbzx.updataFlag");
					}
				}else{
					log.info("文件生成失败..不修改上传状态");
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		long end = System.currentTimeMillis();
		log.info("ZfbzxWork.everydayUpload()执行完成..用时：" + (end - start) + "m");
	}

	private String parseTxt(List<ZfbzxModel> list) {
		StringBuffer sb = new StringBuffer();
		for(ZfbzxModel zm : list){
			sb.append(zm.getAppid());
			sb.append("|");
			sb.append(zm.getCretid());
			sb.append("|");
			sb.append(zm.getCrettype());
			sb.append("|");
			sb.append(zm.getName());
			sb.append("|");
			sb.append(zm.getRegisttime());
			sb.append("|");
			sb.append(zm.getTaobaotrade());
			sb.append("|");
			sb.append(zm.getBestudent());
			sb.append("|");
			sb.append(zm.getBizcustomer());
			sb.append("|");
			sb.append(zm.getVerifyscore());
			sb.append("|");
			sb.append(zm.getRealtype());
			sb.append("|");
			sb.append(zm.getTradeinfolife());
			sb.append("|");
			sb.append(zm.getTradeinfofinance());
			sb.append("|");
			sb.append(zm.getTradeinfomaterial());
			sb.append("|");
			sb.append(zm.getAddrscore());
			sb.append("|");
			sb.append(zm.getBindfastpayment());
			sb.append("|");
			sb.append(zm.getCustlevel());
			sb.append("|");
			sb.append(zm.getConsumesingle());
			sb.append("|");
			sb.append(zm.getConsumemonthly());
			sb.append("|");
			sb.append(zm.getCapitalfund());
			sb.append("|");
			sb.append(zm.getCosumeluxury());
			sb.append("|");
			sb.append(zm.getZmscore());
			sb.append("|");
			sb.append(zm.getCredithistory());
			sb.append("|");
			sb.append(zm.getHonestyscene());
			sb.append("|");
			sb.append(zm.getDeadbeat());
			sb.append("|");
			sb.append(zm.getConsumelevel());
			sb.append("|");
			sb.append(zm.getConsumestability());
			sb.append("|");
			sb.append(zm.getPaylevel());
			sb.append("|");
			sb.append(zm.getAlipayscene());
			sb.append("|");
			sb.append(zm.getInterest());
			sb.append("|");
			sb.append(zm.getSnsinfluence());
			sb.append("|");
			sb.append(zm.getContactsstability());
			sb.append("|");
			sb.append(zm.getAddressfixeddays());
			sb.append("|");
			sb.append(zm.getMobilefixeddays());
			sb.append("\r\n");
		}
		return sb.toString().trim();
	}
}
