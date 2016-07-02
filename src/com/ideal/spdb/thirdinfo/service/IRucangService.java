package com.ideal.spdb.thirdinfo.service;

import java.util.List;

import com.ideal.spdb.thirdinfo.model.RucangFileModel;
import com.ideal.spdb.thirdinfo.model.RucangModel;
import com.ideal.spdb.thirdinfo.work.util.FtpUtil;

public interface IRucangService {

	public boolean everyDayRucang(String sql1, String sql2,RucangFileModel rfm);

	public RucangFileModel getRfModel(String type);
	
	public List<RucangModel> getList(String querySql);

	public String modelToTxt(List<RucangModel> rucangList);

	public boolean writeTxtToFile(String txt, RucangFileModel rfm);

	public void uploadFileToFTP(RucangFileModel rfm);

	public void updateRucangFlag(String string, List<RucangModel> rucangList);

	public String getRucangTitle();
}
