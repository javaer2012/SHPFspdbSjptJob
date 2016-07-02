package com.ideal.spdb.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class AddressUtil {
	
	public static List<String> parseAddress(String address,int count){
		List<String> result = new ArrayList<String>();
		result = parse(result, address, count);
		if(StringUtils.isNotEmpty(result.get(0)) && result.get(0).getBytes().length > 40){
			result.set(0, "");
		}
		if(StringUtils.isNotEmpty(result.get(1)) && result.get(1).getBytes().length > 40){
			result.set(1, "");
		}
		if(StringUtils.isNotEmpty(result.get(2)) && result.get(2).getBytes().length > 200){
			result.set(2, "");
		}
		return result;
	}
	
	private static List<String> parse(List<String> list,String address,int count){
		if(count==3){
			
			if(address.indexOf("省") > -1){
				list.add(address.substring(0,address.indexOf("省")+1));
				return parse(list,address.substring(address.indexOf("省")+1),--count);
			}else if(address.indexOf("自治区") > -1){
				list.add(address.substring(0,address.indexOf("自治区")+3));
				return parse(list,address.substring(address.indexOf("自治区")+3),--count);
			}else if(address.indexOf("市") > -1){
				list.add(address.substring(0,address.indexOf("市")+1));
				return parse(list,address.substring(address.indexOf("市")+1),--count);
			}else {
				list.add("");
				return parse(list,address, --count);
			}
		}
		
		if(count == 2){
			if(address.indexOf("自治区") > -1){
				list.add(address.substring(0,address.indexOf("自治区")+3));
				return parse(list,address.substring(address.indexOf("自治区")+3),--count);
			}else if(address.indexOf("市") > -1){
				list.add(address.substring(0,address.indexOf("市")+1));
				return parse(list,address.substring(address.indexOf("市")+1),--count);
			}else if(address.indexOf("县") > -1){
				list.add(address.substring(0,address.indexOf("县")+1));
				return parse(list,address.substring(address.indexOf("县")+1),--count);
			}else if(address.indexOf("区") > -1){
				list.add(address.substring(0,address.indexOf("区")+1));
				return parse(list,address.substring(address.indexOf("区")+1),--count);
			}else{
				list.add("");
				return parse(list,address, --count);
			}
		}
		
		if(count==1){
			list.add(address);
			return list;
		}
		
		return parse(list,address, --count);
	} 
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String str = null;
		System.out.println(parseAddress("", 3));
	}
}
