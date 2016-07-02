package com.ideal.spdb.thirdinfo.work;

import org.apache.log4j.Logger;

import com.ideal.spdb.thirdinfo.model.Num;

public class countWork {
	private static Logger log = Logger.getLogger(SheBaoDataReturnWork.class);
	public void setCount(){
		log.info("===============开始执行count===========");
		Num.count=0;
	}
}
