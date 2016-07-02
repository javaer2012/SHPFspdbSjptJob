package com.ideal.spdb.thirdinfo.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ideal.spdb.thirdinfo.dao.ICapsBlackListDao;
import com.ideal.spdb.thirdinfo.model.CapsBlackListModel;
import com.ideal.spdb.thirdinfo.service.ICapsBlackListService;

@Service("CapsBlackListService")
public class CapsBlackListServiceImpl implements ICapsBlackListService {
	@Inject
	ICapsBlackListDao dao;
	private static final Logger log = Logger.getLogger(CapsBlackListServiceImpl.class);

	@Override
	public List<CapsBlackListModel> parseTxtData(File file) {
		List<CapsBlackListModel> reslist = null;

		try {
			reslist = new ArrayList<CapsBlackListModel>();
			List<String> testList = FileUtils.readLines(file, "GBK");
			for (String txt : testList) {
				List<String> list  = Arrays.asList(txt.split("\\|"));
				int size = list.size();
				if(size>=6){
					CapsBlackListModel model =  new CapsBlackListModel();
						model.setCardNo(list.get(0));
						model.setCardtype(list.get(1));
						model.setUsername(list.get(2));
						model.setChannel(list.get(3));
						model.setFromtype(list.get(4));
						model.setRecordreason(list.get(5));
						if(size == 7){
							model.setImportdate(list.get(6));
						}else{
							model.setImportdate("");
						}
						reslist.add(model);
				}else{
					log.info("格式有误，不进行导入");
				}
			}
			
//			FileInputStream fis = new FileInputStream(file);
//			InputStreamReader isr = new InputStreamReader(fis, "GBK");
//			BufferedReader br = new BufferedReader(isr);
//			while ((txt = br.readLine()) != null) { // 读取流读取一次后清空br
//				try {
//				CapsBlackListModel model = new CapsBlackListModel();
//				// 这里将进行字节转码，所以显示出来的文本中文会有乱码；后面会再转成GBK，中文就不会有乱码
//				String[] listTxt = txt.split("\\|");
//				model.setCardNo(listTxt[0]);
//				model.setCardtype(listTxt[1]);
//				model.setUsername(listTxt[2]);
//				model.setChannel(listTxt[3]);
//				model.setFromtype(listTxt[4]);
//				model.setRecordreason(listTxt[5]);
//				model.setImportdate(listTxt[6]);
//				list.add(model);
//				} catch (Exception e1) {
//					log.error(e1);
//				}
//			}
//			br.close();
//			isr.close();
//			fis.close();
		} catch (Exception e) {
			log.error(e);
		}
		return reslist;
	}

	@Override
	public List<String> initProcess(List<CapsBlackListModel> datalist) {
		List<String> list = new ArrayList<String>();
		for (CapsBlackListModel model : datalist) {
			boolean flag;
			try {
				flag = this.dao.add("capsblacklist.insertcapsblacklist", model);
				if (!flag) {
					list.add(model.getCardNo());
				}
			} catch (Exception e) {
				log.error(e);
				log.error("导入失败,身份证号：" + model.getCardNo());
				list.add(model.getCardNo());
			}
		}
		return list;
	}
}
