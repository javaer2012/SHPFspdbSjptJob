package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.ideal.spdb.bairong.model.BairongModel;
import com.ideal.spdb.bairong.service.BairongService;
import com.ideal.spdb.bairong.to.BairongRecord;
import com.ideal.spdb.thirdinfo.service.BairongCrmService;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;
import com.ideal.spdb.utils.AppConfigFile;
import com.ideal.spdb.utils.BairongUtil;

@Service("bairongCrmService")
public class BairongCrmServiceImpl implements BairongCrmService {

	private static final Logger log = Logger.getLogger(BairongCrmServiceImpl.class);
	@Inject
	private BairongService bairongService;
	
	@Override
	public void uploadReoprt2CRM() throws Exception {
		// 生成文件的路径+文件名
		String filePathAndName = "";
		// 生成文件的文件名
		String fileName = "";
		// 生成文件的路径
		String fileFolder = "";
		log.info("-------------------开始查询需要生成的bairong2crm信息----------------------------");
		List<BairongModel> list = bairongService.getAllList("bairong.queryBairong2Crm",null);
		//如果当天没有相关文件就直接返回
		//生成文件名
		log.info("==================开始生成bairong2crm的txt文件======================");
		fileName = getFileName();
		fileFolder = AppConfigFile.getInstance().getValue("LOCAL_BAIRONG_CRM");//百融crm 本地
		File folder=new File(fileFolder);
		if(!folder.exists()){
			folder.mkdir();
		}
		filePathAndName = fileFolder+File.separator+fileName;

		log.info("===============创建了文件名===========filePathAndName："+filePathAndName);
		//生成txt文件 
		bluidTxtFile(filePathAndName, list);
		log.info("--------------------bairong2CRM信息文件生成成功 --------------------");
		//4.上传文件
		FtpUtil ftpUtil=new FtpUtil();
		ftpUtil.initFtpUtil(1);
		String ftpTagertFolder = AppConfigFile.getInstance().getValue("FTP_BAIRONG_CRM");//腾讯FTP
		log.info("------------bairong2CRM信息文件上传目标文件夹生成-----ftpTagertFolder："+ftpTagertFolder);
		//上传txt文件
		ftpUtil.upload(filePathAndName,ftpTagertFolder+File.separator+fileName);
		ftpUtil.closeServer();
	}
	
	private String getFileName(){
		StringBuffer sb = new StringBuffer();
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		sb.append("BRJF_ALL_");
		DateFormat df=new SimpleDateFormat("yyyyMMdd");
		sb.append(df.format(c.getTime()));
		sb.append(".txt");
		return sb.toString().trim();
		
	}
	
	public boolean bluidTxtFile(String filepathAndName,List<BairongModel> amList){
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



	public static String makeString(List<BairongModel> amList) {
		StringBuffer sb=new StringBuffer();
		String line=System.getProperty("line.separator");//换行符
		sb.append("APPID|ID|CELL|MAIL|NAME|GID|BR_QUERY_DATE|SPECIALLISTC_ID_BANKBAD|SPECIALLISTC_ID_BANKOVERDUE|SPECIALLISTC_ID_BANKFRAUD|SPECIALLISTC_ID_BANKLOST|SPECIALLISTC_ID_BANK_REFUSE|SPECIALLISTC_ID_CREDITBAD|SPECIALLISTC_ID_P2PBAD|SPECIALLISTC_ID_P2POVERDUE|SPECIALLISTC_ID_P2PFRAUD|SPECIALLISTC_ID_P2PLOST|SPECIALLISTC_ID_P2PREFUSE|SPECIALLISTC_ID_PHONEOVERDUE|SPECIALLISTC_ID_INSURANCEFRAUD|SPECIALLISTC_ID_COURTBAD|SPECIALLISTC_ID_COURTEXECUTED|SPECIALLISTC_CELL_BANKBAD|SPECIALLISTC_CELL_BANKOVERDUE|SPECIALLISTC_CELL_BANKFRAUD|SPECIALLISTC_CELL_BANKLOST|SPECIALLISTC_CELL_BANKREFUSE|SPECIALLISTC_CELL_P2POVERDUE|SPECIALLISTC_CELL_P2PFRAUD|SPECIALLISTC_CELL_INSURANCEFRAUD|SPECIALLISTC_CELL_P2PBAD|SPECIALLISTC_CELL_P2PLOST|SPECIALLISTC_CELL_P2PREFUSE|SPECIALLISTC_GID_BANKBAD|SPECIALLISTC_GID_BANKOVERDUE|SPECIALLISTC_GID_BANKFRAUD|SPECIALLISTC_GID_BANKLOST|SPECIALLISTC_GID_BANKREFUSE|SPECIALLISTC_GID_P2POVERDUE|SPECIALLISTC_GID_P2PFRAUD|SPECIALLISTC_GID_INSURANCEFRAUD|SPECIALLISTC_GID_P2PBAD|SPECIALLISTC_GID_P2PLOST|SPECIALLISTC_GID_P2PREFUSE|APPLYLOAN_MONTH3_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH3_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH3_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH6_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH6_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_ID_BANK_SELFNUMBER|APPLYLOAN_MONTH12_ID_BANK_ALLNUMBER|APPLYLOAN_MONTH12_ID_BANK_ORGNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_ID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH3_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH3_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH3_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH6_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH6_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_CELL_BANK_SELFNUMBER|APPLYLOAN_MONTH12_CELL_BANK_ALLNUMBER|APPLYLOAN_MONTH12_CELL_BANK_ORGNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_CELL_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH3_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH3_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH3_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH3_GID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH6_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH6_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH6_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH6_GID_NOTBANK_ORGNUMBER|APPLYLOAN_MONTH12_GID_BANK_SELFNUMBER|APPLYLOAN_MONTH12_GID_BANK_ALLNUMBER|APPLYLOAN_MONTH12_GID_BANK_ORGNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_SELFNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_ALLNUMBER|APPLYLOAN_MONTH12_GID_NOTBANK_ORGNUMBER|LOCATION_HOMEADDR_ADDR11|LOCATION_HOMEADDR_ADDR12|LOCATION_BIZADDR_ADDR21|LOCATION_BIZADDR_ADDR22|LOCATION_PERADDR_ADDR31|LOCATION_PERADDR_ADDR32|LOCATION_APPLYADDR_ADDR41|LOCATION_APPLYADDR_ADDR42|LOCATION_OTHADDR_ADDR51|LOCATION_OTHADDR_ADDR52|STABILITYC_AUTHENTICATION_ID|STABILITYC_AUTHENTICATION_CELL|STABILITYC_AUTHENTICATION_MAIL|STABILITYC_AUTHENTICATION_KEYRELATION|STABILITYC_AUTHENTICATION_NAME|STABILITYC_AUTHENTICATION_BIZTEL|STABILITYC_AUTHENTICATION_HOMETEL|STABILITYC_AUTHENTICATION_IDNAME|STABILITYC_ID_NUMBER|STABILITYC_CELL_NUMBER|STABILITYC_CELL_FIRSTTIME|STABILITYC_MAIL_NUMBER|STABILITYC_NAME_NUMBER|STABILITYC_TEL_NUMBER|STABILITYC_ADDR_NUMBER|MEDIAC_MAX_MONTH3_VISITDAYS|MEDIAC_MAX_MONTH3_CATE|MEDIAC_MAX_MONTH3_DAYSPROP|MEDIAC_MAX_MONTH12_VISITDAYS|MEDIAC_MAX_MONTH12_CATE|MEDIAC_MAX_MONTH12_DAYSPROP|MEDIAC_TOTAL_MONTH3_VISITDAYS|MEDIAC_TOTAL_MONTH3_CATENUM|MEDIAC_TOTAL_MONTH12_VISITDAYS|MEDIAC_TOTAL_MONTH12_CATENUM|CONSUMPTIONC_CONTINUE|CONSUMPTIONC_TIMERECENT|CONSUMPTIONC_MAX_MONTH3_NUMBER|CONSUMPTIONC_MAX_MONTH3_PAY|CONSUMPTIONC_MAX_MONTH3_PAYCATE|CONSUMPTIONC_MAX_MONTH12_NUMBER|CONSUMPTIONC_MAX_MONTH12_PAY|CONSUMPTIONC_MAX_MONTH12_PAYCATE|CONSUMPTIONC_TOTAL_MONTH3_VISITS|CONSUMPTIONC_TOTAL_MONTH3_NUMBER|CONSUMPTIONC_TOTAL_MONTH3_PAY|CONSUMPTIONC_TOTAL_MONTH3_PCATENUM|CONSUMPTIONC_TOTAL_MONTH3_VCATENUM|CONSUMPTIONC_TOTAL_MONTH12_VISITS|CONSUMPTIONC_TOTAL_MONTH12_NUMBER|CONSUMPTIONC_TOTAL_MONTH12_PAY|CONSUMPTIONC_TOTAL_MONTH12_PCATENUM|CONSUMPTIONC_TOTAL_MONTH12_VCATENUM|ACCOUNTCHANGE_CARDINDEX|ACCOUNTCHANGE_REGIONNO|ACCOUNTCHANGE_M1M3_LOAN|ACCOUNTCHANGE_M1M3_CREDITCARD_CASH|ACCOUNTCHANGE_M1M3_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M1M3_CREDITCARD_INCOME|ACCOUNTCHANGE_M1M3_CREDITCARD_OUTGO|ACCOUNTCHANGE_M1M3_CREDITCARD_STATUS|ACCOUNTCHANGE_M1M3_DEBITCARD_BALANCE|ACCOUNTCHANGE_M1M3_DEBITCARD_INCOME|ACCOUNTCHANGE_M1M3_DEBITCARD_OUTGO|ACCOUNTCHANGE_M1M3_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M1M3_DEBITCARD_REPAY|ACCOUNTCHANGE_M4M6_LOAN|ACCOUNTCHANGE_M4M6_CREDITCARD_CASH|ACCOUNTCHANGE_M4M6_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M4M6_CREDITCARD_INCOME|ACCOUNTCHANGE_M4M6_CREDITCARD_OUTGO|ACCOUNTCHANGE_M4M6_CREDITCARD_STATUS|ACCOUNTCHANGE_M4M6_DEBITCARD_BALANCE|ACCOUNTCHANGE_M4M6_DEBITCARD_INCOME|ACCOUNTCHANGE_M4M6_DEBITCARD_OUTGO|ACCOUNTCHANGE_M4M6_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M4M6_DEBITCARD_REPAY|ACCOUNTCHANGE_M7M9_LOAN|ACCOUNTCHANGE_M7M9_CREDITCARD_CASH|ACCOUNTCHANGE_M7M9_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M7M9_CREDITCARD_INCOME|ACCOUNTCHANGE_M7M9_CREDITCARD_OUTGO|ACCOUNTCHANGE_M7M9_CREDITCARD_STATUS|ACCOUNTCHANGE_M7M9_DEBITCARD_BALANCE|ACCOUNTCHANGE_M7M9_DEBITCARD_INCOME|ACCOUNTCHANGE_M7M9_DEBITCARD_OUTGO|ACCOUNTCHANGE_M7M9_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M7M9_DEBITCARD_REPAY|ACCOUNTCHANGE_M10M12_LOAN|ACCOUNTCHANGE_M10M12_CREDITCARD_CASH|ACCOUNTCHANGE_M10M12_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M10M12_CREDITCARD_INCOME|ACCOUNTCHANGE_M10M12_CREDITCARD_OUTGO|ACCOUNTCHANGE_M10M12_CREDITCARD_STATUS|ACCOUNTCHANGE_M10M12_DEBITCARD_BALANCE|ACCOUNTCHANGE_M10M12_DEBITCARD_INCOME|ACCOUNTCHANGE_M10M12_DEBITCARD_OUTGO|ACCOUNTCHANGE_M10M12_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M10M12_DEBITCARD_REPAY|ACCOUNTCHANGE_M13M15_LOAN|ACCOUNTCHANGE_M13M15_CREDITCARD_CASH|ACCOUNTCHANGE_M13M15_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M13M15_CREDITCARD_INCOME|ACCOUNTCHANGE_M13M15_CREDITCARD_OUTGO|ACCOUNTCHANGE_M13M15_CREDITCARD_STATUS|ACCOUNTCHANGE_M13M15_DEBITCARD_BALANCE|ACCOUNTCHANGE_M13M15_DEBITCARD_INCOME|ACCOUNTCHANGE_M13M15_DEBITCARD_OUTGO|ACCOUNTCHANGE_M13M15_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M13M15_DEBITCARD_REPAY|ACCOUNTCHANGE_M16M18_LOAN|ACCOUNTCHANGE_M16M18_CREDITCARD_CASH|ACCOUNTCHANGE_M16M18_CREDITCARD_DEFAULT|ACCOUNTCHANGE_M16M18_CREDITCARD_INCOME|ACCOUNTCHANGE_M16M18_CREDITCARD_OUTGO|ACCOUNTCHANGE_M16M18_CREDITCARD_STATUS|ACCOUNTCHANGE_M16M18_DEBITCARD_BALANCE|ACCOUNTCHANGE_M16M18_DEBITCARD_INCOME|ACCOUNTCHANGE_M16M18_DEBITCARD_OUTGO|ACCOUNTCHANGE_M16M18_DEBITCARD_INVESTMENT|ACCOUNTCHANGE_M16M18_DEBITCARD_REPAY|PAYCONSUMPTION_THM1_PAY|PAYCONSUMPTION_THM1_NUMBER|PAYCONSUMPTION_THM1_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM1_FIRST_PAYMCC|PAYCONSUMPTION_THM1_FIRST_NUMBERMCC|PAYCONSUMPTION_THM1_SECOND_PAYMCC|PAYCONSUMPTION_THM1_SECOND_NUMBERMCC|PAYCONSUMPTION_THM1_THIRD_PAYMCC|PAYCONSUMPTION_THM1_THIRD_NUMBERMCC|PAYCONSUMPTION_THM1_NIGHT_PAY|PAYCONSUMPTION_THM1_NIGHT_NUMBER|PAYCONSUMPTION_THM2_PAY|PAYCONSUMPTION_THM2_NUMBER|PAYCONSUMPTION_THM2_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM2_FIRST_PAYMCC|PAYCONSUMPTION_THM2_FIRST_NUMBERMCC|PAYCONSUMPTION_THM2_SECOND_PAYMCC|PAYCONSUMPTION_THM2_SECOND_NUMBERMCC|PAYCONSUMPTION_THM2_THIRD_PAYMCC|PAYCONSUMPTION_THM2_THIRD_NUMBERMCC|PAYCONSUMPTION_THM2_NIGHT_PAY|PAYCONSUMPTION_THM2_NIGHT_NUMBER|PAYCONSUMPTION_THM3_PAY|PAYCONSUMPTION_THM3_NUMBER|PAYCONSUMPTION_THM3_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM3_FIRST_PAYMCC|PAYCONSUMPTION_THM3_FIRST_NUMBERMCC|PAYCONSUMPTION_THM3_SECOND_PAYMCC|PAYCONSUMPTION_THM3_SECOND_NUMBERMCC|PAYCONSUMPTION_THM3_THIRD_PAYMCC|PAYCONSUMPTION_THM3_THIRD_NUMBERMCC|PAYCONSUMPTION_THM3_NIGHT_PAY|PAYCONSUMPTION_THM3_NIGHT_NUMBER|PAYCONSUMPTION_THM4_PAY|PAYCONSUMPTION_THM4_NUMBER|PAYCONSUMPTION_THM4_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM4_FIRST_PAYMCC|PAYCONSUMPTION_THM4_FIRST_NUMBERMCC|PAYCONSUMPTION_THM4_SECOND_PAYMCC|PAYCONSUMPTION_THM4_SECOND_NUMBERMCC|PAYCONSUMPTION_THM4_THIRD_PAYMCC|PAYCONSUMPTION_THM4_THIRD_NUMBERMCC|PAYCONSUMPTION_THM4_NIGHT_PAY|PAYCONSUMPTION_THM4_NIGHT_NUMBER|PAYCONSUMPTION_THM5_PAY|PAYCONSUMPTION_THM5_NUMBER|PAYCONSUMPTION_THM5_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM5_FIRST_PAYMCC|PAYCONSUMPTION_THM5_FIRST_NUMBERMCC|PAYCONSUMPTION_THM5_SECOND_PAYMCC|PAYCONSUMPTION_THM5_SECOND_NUMBERMCC|PAYCONSUMPTION_THM5_THIRD_PAYMCC|PAYCONSUMPTION_THM5_THIRD_NUMBERMCC|PAYCONSUMPTION_THM5_NIGHT_PAY|PAYCONSUMPTION_THM5_NIGHT_NUMBER|PAYCONSUMPTION_THM6_PAY|PAYCONSUMPTION_THM6_NUMBER|PAYCONSUMPTION_THM6_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM6_FIRST_PAYMCC|PAYCONSUMPTION_THM6_FIRST_NUMBERMCC|PAYCONSUMPTION_THM6_SECOND_PAYMCC|PAYCONSUMPTION_THM6_SECOND_NUMBERMCC|PAYCONSUMPTION_THM6_THIRD_PAYMCC|PAYCONSUMPTION_THM6_THIRD_NUMBERMCC|PAYCONSUMPTION_THM6_NIGHT_PAY|PAYCONSUMPTION_THM6_NIGHT_NUMBER|PAYCONSUMPTION_THM7_PAY|PAYCONSUMPTION_THM7_NUMBER|PAYCONSUMPTION_THM7_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM7_FIRST_PAYMCC|PAYCONSUMPTION_THM7_FIRST_NUMBERMCC|PAYCONSUMPTION_THM7_SECOND_PAYMCC|PAYCONSUMPTION_THM7_SECOND_NUMBERMCC|PAYCONSUMPTION_THM7_THIRD_PAYMCC|PAYCONSUMPTION_THM7_THIRD_NUMBERMCC|PAYCONSUMPTION_THM7_NIGHT_PAY|PAYCONSUMPTION_THM7_NIGHT_NUMBER|PAYCONSUMPTION_THM8_PAY|PAYCONSUMPTION_THM8_NUMBER|PAYCONSUMPTION_THM8_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM8_FIRST_PAYMCC|PAYCONSUMPTION_THM8_FIRST_NUMBERMCC|PAYCONSUMPTION_THM8_SECOND_PAYMCC|PAYCONSUMPTION_THM8_SECOND_NUMBERMCC|PAYCONSUMPTION_THM8_THIRD_PAYMCC|PAYCONSUMPTION_THM8_THIRD_NUMBERMCC|PAYCONSUMPTION_THM8_NIGHT_PAY|PAYCONSUMPTION_THM8_NIGHT_NUMBER|PAYCONSUMPTION_THM9_PAY|PAYCONSUMPTION_THM9_NUMBER|PAYCONSUMPTION_THM9_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM9_FIRST_PAYMCC|PAYCONSUMPTION_THM9_FIRST_NUMBERMCC|PAYCONSUMPTION_THM9_SECOND_PAYMCC|PAYCONSUMPTION_THM9_SECOND_NUMBERMCC|PAYCONSUMPTION_THM9_THIRD_PAYMCC|PAYCONSUMPTION_THM9_THIRD_NUMBERMCC|PAYCONSUMPTION_THM9_NIGHT_PAY|PAYCONSUMPTION_THM9_NIGHT_NUMBER|PAYCONSUMPTION_THM10_PAY|PAYCONSUMPTION_THM10_NUMBER|PAYCONSUMPTION_THM10_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM10_FIRST_PAYMCC|PAYCONSUMPTION_THM10_FIRST_NUMBERMCC|PAYCONSUMPTION_THM10_SECOND_PAYMCC|PAYCONSUMPTION_THM10_SECOND_NUMBERMCC|PAYCONSUMPTION_THM10_THIRD_PAYMCC|PAYCONSUMPTION_THM10_THIRD_NUMBERMCC|PAYCONSUMPTION_THM10_NIGHT_PAY|PAYCONSUMPTION_THM10_NIGHT_NUMBER|PAYCONSUMPTION_THM11_PAY|PAYCONSUMPTION_THM11_NUMBER|PAYCONSUMPTION_THM11_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM11_FIRST_PAYMCC|PAYCONSUMPTION_THM11_FIRST_NUMBERMCC|PAYCONSUMPTION_THM11_SECOND_PAYMCC|PAYCONSUMPTION_THM11_SECOND_NUMBERMCC|PAYCONSUMPTION_THM11_THIRD_PAYMCC|PAYCONSUMPTION_THM11_THIRD_NUMBERMCC|PAYCONSUMPTION_THM11_NIGHT_PAY|PAYCONSUMPTION_THM11_NIGHT_NUMBER|PAYCONSUMPTION_THM12_PAY|PAYCONSUMPTION_THM12_NUMBER|PAYCONSUMPTION_THM12_MAXNUMBERPROVINCE|PAYCONSUMPTION_THM12_FIRST_PAYMCC|PAYCONSUMPTION_THM12_FIRST_NUMBERMCC|PAYCONSUMPTION_THM12_SECOND_PAYMCC|PAYCONSUMPTION_THM12_SECOND_NUMBERMCC|PAYCONSUMPTION_THM12_THIRD_PAYMCC|PAYCONSUMPTION_THM12_THIRD_NUMBERMCC|PAYCONSUMPTION_THM12_NIGHT_PAY|PAYCONSUMPTION_THM12_NIGHT_NUMBER|SCORE_BANKPFPOINT|AUTHENTICATION_ID|AUTHENTICATION_CELL|AUTHENTICATION_MAIL|AUTHENTICATION_KEYRELATION|AUTHENTICATION_NAME|AUTHENTICATION_BIZTEL|AUTHENTICATION_HOMETEL|AUTHENTICATION_IDNAME"+line);
		for (BairongModel model : amList) {
			sb.append(model.getApplicationId());
			sb.append("|");
			sb.append(model.getIdentityCard());
			sb.append("|");
			sb.append(model.getMobile()==null?"":model.getMobile());
			sb.append("|");
			sb.append(model.getEmail()==null?"":model.getEmail());
			sb.append("|");
			sb.append(model.getUserName()==null?"":model.getUserName());
			sb.append("|");
			sb.append(model.getGid()==null?"":model.getGid());
			sb.append("|");
			sb.append(model.getCall_date()==null?"":model.getCall_date());
			sb.append("|");
			BairongRecord record = JSONArray.parseObject(model.getJson(),BairongRecord.class);
			sb.append(BairongUtil.parseBairong(record));
			sb.append(line);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		List<BairongModel> list = new ArrayList<BairongModel>();
		BairongModel model = new BairongModel();
		model.setApplicationId("");
		model.setIdentityCard("");
		model.setMobile("");
		model.setEmail("");
		model.setUserName("");
		model.setGid("");
		model.setCall_date("");
		model.setJson("{\"code\":\"00\",\"swift_number\":\"100179_20151217154154_4295\",\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"tel_biz\":\"0\",\"tel_home\":\"0\"},\"Location\":{\"home_addr\":{\"addr11\":\"15.8\"},\"biz_addr\":{\"addr21\":\"13.3\"},\"per_addr\":{},\"apply_addr\":{},\"oth_addr\":{}},\"Stability_c\":{\"Authentication\":{\"id\":\"0\",\"cell\":\"1\",\"mail\":\"0\",\"key_relation\":\"000\",\"name\":\"0\",\"id-name\":\"0\",\"biz_tel\":\"0\",\"home_tel\":\"0\"},\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Stability\":{\"id\":{\"number\":\"0\"},\"cell\":{\"number\":\"1\",\"firsttime\":\"2009\"},\"mail\":{\"number\":\"1\"},\"name\":{\"number\":\"1\"},\"tel\":{\"number\":\"0\"},\"addr\":{\"number\":\"1\"}},\"Consumption_c\":{\"continue\":\"M1\",\"time_recent\":\"T1\",\"total\":{\"month3\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"},\"month12\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"p_catenum\":\"1\",\"v_catenum\":\"1\"}},\"max\":{\"month3\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"},\"month12\":{\"number\":\"1\",\"pay\":\"10\",\"paycate\":\"C22\"}},\"month3\":{},\"month12\":{}},\"Consumption\":{\"month3\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month6\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\"}},\"month12\":{\"文化娱乐\":{\"visits\":\"5\",\"number\":\"1\",\"pay\":\"10\",\"maxpay\":\"10\"}},\"level\":{\"文化娱乐\":\"0.0724\"}},\"ApplyLoan\":{},\"SpecialList_c\":{},\"Score\":{\"bankpfpoint\":\"667\"},\"Accountchange\":{\"cardindex\":\"4\",\"regionno\":\"0021\",\"m1m3\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"03\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"20\",\"outgo\":\"20\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m4m6\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"01\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"38\",\"outgo\":\"38\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m7m9\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"24\",\"outgo\":\"23\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m10m12\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"25\",\"outgo\":\"25\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m13m15\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"12\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"22\",\"outgo\":\"21\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"},\"m16m18\":{\"creditcard\":{\"cash\":\"99\",\"default\":\"9\",\"income\":\"99\",\"outgo\":\"00\",\"status\":\"9\"},\"debitcard\":{\"balance\":\"99\",\"income\":\"23\",\"outgo\":\"24\",\"investment\":\"99\",\"repay\":\"99\"},\"loan\":\"99\"}},\"Assets\":{\"house\":\"0\",\"car\":\"0\",\"fin\":\"0\",\"wealth\":\"0\"},\"Media_c\":{\"total\":{\"month3\":{\"visitdays\":\"2\",\"catenum\":\"1\"},\"month12\":{\"visitdays\":\"2\",\"catenum\":\"1\"}},\"max\":{\"month3\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"},\"month12\":{\"visitdays\":\"2\",\"cate\":\"C10\",\"days_prop\":\"1.0000\"}},\"month3\":{},\"month12\":{}},\"Media\":{\"month3\":{\"教育\":{\"visitdays\":\"2\"}},\"month6\":{\"教育\":{\"visitdays\":\"2\"}},\"month12\":{\"教育\":{\"visitdays\":\"2\"}}},\"Flag\":{\"core\":{\"key\":\"1\"},\"media_c\":\"1\",\"consumption_c\":\"1\",\"stability_c\":\"1\",\"specialList_c\":\"0\",\"accountChange\":\"1\",\"location\":\"1\",\"applyLoan\":\"0\",\"score\":\"1\"}}");
		list.add(model);
		System.out.println(makeString(list));
	}
}