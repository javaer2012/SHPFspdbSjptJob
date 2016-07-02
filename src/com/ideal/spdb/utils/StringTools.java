package com.ideal.spdb.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 处理字符串的工具类。
 */
public class StringTools {
	private static Logger log = Logger.getLogger(StringTools.class);
   
	/**
	 * 把字符串分割成二维数组，使用 & | 分割。支持每一行列数不相同，用于小规模的分割。
	 * 
	 * @param value
	 *            需要分割的字符串
	 * @return 分割后的数组
	 * @roseuid 3C85E0430185
	 */
	public static String[][] parse2Ds(String value) {
		List total = new ArrayList();
		int index1, index2;
		index1 = 0;
		index2 = value.indexOf("&", index1);
		String temp1;
		List temp2;
		int i1, i2;
		boolean breakTime = false;
		while (true) {
			if (index2 == -1) {
				breakTime = true;
				temp1 = value.substring(index1);
			} else {
				temp1 = value.substring(index1, index2);
			}
			i1 = 0;
			i2 = temp1.indexOf("|", i1);
			temp2 = new ArrayList();
			while (i2 != -1) {
				temp2.add(temp1.substring(i1, i2));
				i1 = i2 + 1;
				i2 = temp1.indexOf("|", i1);
			}
			temp2.add(temp1.substring(i1));
			total.add(convert1D(temp2));
			if (breakTime) {
				break;
			}
			index1 = index2 + 1;
			index2 = value.indexOf("&", index1);
		}
		return convert2D(total);
	}

	/**
	 * 把字符串分割成二维int数组，使用 & | 分割。支持每一行列数不相同，用于小规模的分割。
	 * 
	 * @param value
	 *            需要分割的字符串
	 * @return 分割后的数组
	 * @roseuid 3C85E0430185
	 */
	public static int[][] parse2Di(String value) {
		String[][] temp = parse2Ds(value);
		if (temp == null) {
			return null;
		}

		int[][] intTemp = new int[temp.length][];
		int length;
		for (int i = 0; i < temp.length; i++) {
			length = temp[i].length;
			if (length == 1 && temp[i][0].length() == 0) {
				continue;
			}
			intTemp[i] = new int[length];
			for (int j = 0; j < length; j++) {
				intTemp[i][j] = Integer.parseInt(temp[i][j]);
			}
		}
		return intTemp;
	}

 
	/**
	 * 把数组组合成字符串，使用& 分割。
	 * 
	 * @param value
	 *            需要组合的数组
	 * @return 组合后的字符串
	 * @roseuid 3C85E082021C
	 */
	public static String assemble(String[] value) {
		if (value == null || value.length == 0) {
			return "";
		}

		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			temp.append(value[i]);
			temp.append('&');
		}
		temp.deleteCharAt(temp.length() - 1);
		return temp.toString();
	}

	/**
	 * 把数组组合成字符串，使用 &，| 分割。
	 * 
	 * @param value
	 *            需要组合的数组
	 * @return 组合后的字符串
	 * @roseuid 3C85E08E0219
	 */
	public static String assemble(String[][] value) {
		if (value == null || value.length == 0 || value[0] == null
				|| value[0].length == 0) {
			return "";
		}

		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				temp.append(value[i][j]);
				temp.append('|');
			}
			temp.deleteCharAt(temp.length() - 1);
			temp.append('&');
		}
		temp.deleteCharAt(temp.length() - 1);
		return temp.toString();
	}

	/**
	 * 把 value1 和 value2 的列合并起来。
	 * 
	 * @param value1
	 *            被合并的数组
	 * @param value2
	 *            被合并的数组
	 * @return 合并后的数组
	 * @roseuid 3C85E13003A3
	 */
	public static String[][] combine(String[] value1, String[] value2) {
		return null;
	}

	/**
	 * 把 value1 和 value2 的列合并起来。
	 * 
	 * @param value1
	 *            被合并的数组
	 * @param value2
	 *            被合并的数组
	 * @return 合并后的数组
	 * @roseuid 3C85E3C70284
	 */
	public static String[][] combine(String[] value1, String[][] value2) {
		return null;
	}

	/**
	 * 把 value1 和 value2 的列合并起来。
	 * 
	 * @param value1
	 *            被合并的数组
	 * @param value2
	 *            被合并的数组
	 * @return 合并后的数组
	 * @roseuid 3C85E17A0088
	 */
	public static String[][] combine(String[][] value1, String[][] value2) {
		return null;
	}

	/**
	 * 把 value1 和 value2 的行相加起来。
	 * 
	 * @param value1
	 *            被相加的数组
	 * @param value2
	 *            被相加的数组
	 * @return 相加后的数组
	 * @roseuid 3C85E31C03AA
	 */
	public static String[] join(String[] value1, String[] value2) {
		return null;
	}

	/**
	 * 把 value1 和 value2 的行相加起来。
	 * 
	 * @param value1
	 *            被相加的数组
	 * @param value2
	 *            被相加的数组
	 * @return 相加后的数组
	 * @roseuid 3C85E37E02D9
	 */
	public static String[][] join(String[][] value1, String[][] value2) {
		return null;
	}

	/**
	 * 把列表转换成字符串数组，列表中存放的是String对象。
	 * 
	 * @param list
	 *            列表
	 * @return 转换后的字符串数组
	 */
	public static String[] convert1D(Collection list) {
		if (list.size() == 0) {
			return null;
		}

		Iterator it = list.iterator();
		String[] result = new String[list.size()];
		for (int i = 0; it.hasNext(); i++) {
			result[i] = (String) it.next();
		}
		return result;
	}

	/**
	 * 把列表转换成字符串二维数组，列表中存放的是String[]对象。
	 * 
	 * @param list
	 *            列表
	 * @return 转换后的字符串二维数组
	 */
	public static String[][] convert2D(Collection list) {
		if (list == null || list.size() == 0) {
			return null;
		}

		Iterator it = list.iterator();
		String[][] result = new String[list.size()][];
		for (int i = 0; it.hasNext(); i++) {
			result[i] = (String[]) it.next();
		}
		return result;
	}

	/**
	 * 将字符串中的&换为回车换行，将|换为tab键,在将字符串下载到客户端的文件中时， <br>
	 * 使用该函数对其做转换 <br>
	 * 
	 * @param data
	 *            String <br>
	 * @return String,转换后的字符串 <br>
	 */
	public static String convertStringToDownLoad(String data) {
		if (data == null || data.equals("")) {
			return data;
		}

		StringBuffer sbData = new StringBuffer(data);
		int iPos = 0;
		while (iPos < sbData.length()) {
			if (sbData.charAt(iPos) == '|') {
				sbData.replace(iPos, iPos + 1, "\t");
				iPos++;
			}

			else if (sbData.charAt(iPos) == '&') {
				sbData.replace(iPos, iPos + 1, "\r\n");
				iPos += 2;
			} else {
				iPos++;
			}
		}
		return sbData.toString();
	}
 
	public static Collection arrayToCollection(Object[] value) {
		if (value == null) {
			return null;
		}
		Collection result = new ArrayList();
		for (int i = 0; i < value.length; i++) {
			if (value[i] instanceof Object[]) {
				result.add(arrayToCollection((Object[]) value[i]));
			} else {
				result.add(value[i]);
			}
		}
		return result;
	}

	/**
	 * 从集合里面取出一维数组的某几列，放在集合中的集合。
	 */
	public static Collection selectColumns(Collection value, String index) {
		if (value == null || value.size() == 0 || index == null
				|| index.length() == 0) {
			return null;
		}
		int[] indexes = StringTools.parse2Di(index)[0];
		Collection result = new ArrayList();
		Iterator it = value.iterator();
		Object[] o;
		Collection n;
		while (it.hasNext()) {
			o = (Object[]) it.next();
			n = new ArrayList();
			for (int i = 0; i < indexes.length; i++) {
				n.add(o[indexes[i]]);
			}
			result.add(n);
		}
		return result;
	}

	/**
	 * 从集合里面取出一维数组的某几列，合并之后放在集合中。
	 */
	public static Collection combineColumns(Collection value, String index) {
		if (value == null || value.size() == 0 || index == null
				|| index.length() == 0) {
			return null;
		}
		int[] indexes = StringTools.parse2Di(index)[0];
		Collection result = new ArrayList();
		Iterator it = value.iterator();
		Object[] o;
		StringBuffer n;
		while (it.hasNext()) {
			o = (Object[]) it.next();
			n = new StringBuffer();
			for (int i = 0; i < indexes.length; i++) {
				n.append(o[indexes[i]]);
				n.append('|');
			}
			n.deleteCharAt(n.length() - 1);
			result.add(n.toString());
		}
		return result;
	}

	/**
	 * 从集合里面取出一维数组的某几列，合并之后放在Set集合中。
	 */
	public static Set combineColumnsToSet(Collection value, String index) {
		if (value == null || value.size() == 0 || index == null
				|| index.length() == 0) {
			return null;
		}
		int[] indexes = StringTools.parse2Di(index)[0];
		Set result = new HashSet();
		Iterator it = value.iterator();
		Object[] o;
		StringBuffer n;
		while (it.hasNext()) {
			o = (Object[]) it.next();
			n = new StringBuffer();
			for (int i = 0; i < indexes.length; i++) {
				n.append(o[indexes[i]]);
				n.append('|');
			}
			n.deleteCharAt(n.length() - 1);
			result.add(n.toString());
		}
		return result;
	}

	// 去掉字符串中的 "
	public static String removeQuot(String data) {
		if (data == null) {
			return null;
		} else {
			return data.replace('\"', ' ').trim();
		}
	}

	// 去掉哈希表中的 "
	public static Hashtable removeQuot(Hashtable data) {
		if (data == null) {
			return null;
		}

		Hashtable rehs = new Hashtable();
		for (Enumeration e = data.keys(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			String value = (String) data.get(name);
			value = removeQuot(value);
			rehs.put(name, value);
		}
		return rehs;
	}

	// 分转换成元
	public static String convertfentoyuan(String dealvalue) {
		// 易思博 add
		log.info("dealvalue ========  " + dealvalue);
		if (dealvalue == null || dealvalue.trim().equals(""))
			return "";
		// 易思博 add end

		if (dealvalue.length() > 9) {
			String largeyuan = dealvalue.substring(0, dealvalue.length() - 2)
					+ "." + dealvalue.substring(dealvalue.length() - 2);
			return largeyuan;
		}
		long valueconvert = Long.parseLong(dealvalue);
		double dtemp = (double) valueconvert / 100;
		String yuan = Double.toString(dtemp);
		int position = 0;
		if ((position = yuan.indexOf(".")) != -1) {
			if (yuan.substring(position + 1).length() == 1) {
				yuan = yuan + "0";
			}
		}
		return yuan;
	}

	// 元转换成分
	public static String convertyuantofen(String dealvalue) {
		if (dealvalue == null) {
			return "";
		}
		String temp = dealvalue.trim();
		int postion = -100;
		postion = temp.indexOf(".");
		if (postion != 0) {
			long inhead = 0;
//			String inheads = "";
//			String infoots = "";
			if (postion != -1) {
				long head = Long.parseLong(temp.substring(0, postion));
				String foots = temp.substring(postion + 1, temp.length());
				if (foots.length() >= 3) {
					inhead = Long.parseLong(foots.substring(0, 2));
//					infoots = foots.substring(2, foots.length());
					temp = "" + (head * 100 + inhead);
					return temp;
				} else if (foots.length() == 2) {
					temp = "" + (head * 100 + Long.parseLong(foots));
					return temp;
				} else {
					temp = "" + (head * 100 + (Long.parseLong(foots)) * 10);
					return temp;
				}

			} else {
				long head = Long.parseLong(temp);
				temp = "" + (head * 100);
				return temp;
			}
		} else {
			long head = Long.parseLong(temp);
			temp = "" + (head * 100);
			return temp;
		}
		// return temp;
	}

	// 取得现在的日期，格式yyyymmddhhmmss
	public static String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String cDate = Integer.toString(year);
		if (month < 10) {
			cDate = cDate + "0" + Integer.toString(month);
		} else {
			cDate = cDate + Integer.toString(month);
		}
		if (day < 10) {
			cDate = cDate + "0" + Integer.toString(day);
		} else {
			cDate = cDate + Integer.toString(day);
		}
		if (hour < 10) {
			cDate = cDate + "0" + Integer.toString(hour);
		} else {
			cDate = cDate + Integer.toString(hour);
		}
		if (minute < 10) {
			cDate = cDate + "0" + Integer.toString(minute);
		} else {
			cDate = cDate + Integer.toString(minute);
		}
		if (second < 10) {
			cDate = cDate + "0" + Integer.toString(second);
		} else {
			cDate = cDate + Integer.toString(second);
		}
		return cDate.trim();
	}
	// 取得现在的日期，格式yyyy-mm-dd hh:mm:ss
	public static String getCurrentDate2() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String cDate = Integer.toString(year);
		if (month < 10) {
			cDate = cDate + "-0" + Integer.toString(month);
		} else {
			cDate = cDate + "-" + Integer.toString(month);
		}
		if (day < 10) {
			cDate = cDate + "-"+ "0" + Integer.toString(day);
		} else {
			cDate = cDate + "-"+ Integer.toString(day);
		}
		if (hour < 10) {
			cDate = cDate + " "+ "0" + Integer.toString(hour);
		} else {
			cDate = cDate + " "+ Integer.toString(hour);
		}
		if (minute < 10) {
			cDate = cDate + ":"+ "0" + Integer.toString(minute);
		} else {
			cDate = cDate + ":"+ Integer.toString(minute);
		}
		if (second < 10) {
			cDate = cDate + ":"+ "0" + Integer.toString(second);
		} else {
			cDate = cDate + ":"+ Integer.toString(second);
		}
		return cDate.trim();
	} 
	// ////////////////////////D300版本新增部分////////////////////////////////////
	// 将格式为2002121208的日期转换成2002-12-12 08时
	public static String customDateFormat(String dateTime) {
		String year, month, day, hour;

		year = dateTime.substring(0, 4);
		month = dateTime.substring(4, 6);
		if (dateTime.length() == 6) {
			return year + "年" + month + "月";
		}
		day = dateTime.substring(6, 8);
		if (dateTime.length() == 8) {
			return year + "年" + month + "月" + day + "日";
		}
		hour = dateTime.substring(8, 10);
		return (year + "年" + month + "月" + day + "日" + hour + "时");
	}

	// ////////////////////////D300版本新增部分////////////////////////////////////
	// 将格式为20021212080000的日期转换成2002-12-12 08:00:00时
	public static String customDateTimeFormat(String dateTime) {
		String year, month, day, hour, Second, Minute;

		year = dateTime.substring(0, 4);
		month = dateTime.substring(4, 6);
		day = dateTime.substring(6, 8);
		hour = dateTime.substring(8, 10);
		Minute = dateTime.substring(10, 12);
		Second = dateTime.substring(12, 14);
		String str = year + "-" + month + "-" + day + " " + hour + ":" + Minute
				+ ":" + Second;
		return str;
	}

	// //////////////////////////////////////////////////////////////////////////////
	// ///////////////////////////////////////////////////////////////////////////////////
	// 取得当前日期,格式yyyy-mm-dd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String getTodayDate() {
		// 初始化时间
		Calendar RightNow = Calendar.getInstance();
		return changeDatetoString(RightNow);
	}

	// 取得当前日期,格式yyyymmdd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String getTodayDate2() {
		// 初始化时间
		Calendar RightNow = Calendar.getInstance();
		return changeDatetoString2(RightNow);
	}

	// ///////////////////////////////////////////////////////////////////////////////////
	// 将日期转换成字符串,格式yyyymmdd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String changeDatetoString2(Calendar cDate) {
		int Year;
		int Month;
		int Day;
		String sDate = "";

		// 初始化时间
		Year = cDate.get(Calendar.YEAR);
		Month = cDate.get(Calendar.MONTH) + 1;
		Day = cDate.get(Calendar.DAY_OF_MONTH);

		sDate = Integer.toString(Year);
		if (Month >= 10) {
			sDate = sDate + Integer.toString(Month);
		} else {
			sDate = sDate + "0" + Integer.toString(Month);
		}
		if (Day >= 10) {
			sDate = sDate + Integer.toString(Day);
		} else {
			sDate = sDate + "0" + Integer.toString(Day);
		}
		return sDate;
	}// end of public static String changeDatetoString(Calendar cDate;)

	// ///////////////////////////////////////////////////////////////////////////////////
	// 取得当前日期前后若干天的日期,格式yyyy-mm-dd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String getDate(int day) {
		// 初始化时间
		Calendar RightNow = Calendar.getInstance();
		RightNow.add(Calendar.DATE, day);
		return changeDatetoString(RightNow);
	}

	// ///////////////////////////////////////////////////////////////////////////////////
	// 将字符串yyyymmdd转换成字符串,格式yyyy-mm-dd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String changeDate2(String sDate) {
		String sTmp1 = "";
		String sTmp2 = "";
		String sTmp3 = "";
		sTmp1 = sDate.substring(0, 4);
		sTmp2 = sDate.substring(4, 6);
		sTmp3 = sDate.substring(6, 8);
		sDate = sTmp1 + "-" + sTmp2 + "-" + sTmp3;
		return sDate;
	}

	public static String changeDate3(String sDate) {
		String sTmp1 = "";
		String sTmp2 = "";
		sTmp1 = sDate.substring(0, 4);
		sTmp2 = sDate.substring(4, 6);
		sDate = sTmp1 + "-" + sTmp2;
		return sDate;
	}

	// ///////////////////////////////////////////////////////////////////////////////////

	// 将日期转换成字符串,格式yyyy-mm-dd
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String changeDatetoString(Calendar cDate) {
		int Year;
		int Month;
		int Day;
		String sDate = "";

		// 初始化时间
		Year = cDate.get(Calendar.YEAR);
		Month = cDate.get(Calendar.MONTH) + 1;
		Day = cDate.get(Calendar.DAY_OF_MONTH);

		sDate = Integer.toString(Year) + "-";
		if (Month >= 10) {
			sDate = sDate + Integer.toString(Month) + "-";
		} else {
			sDate = sDate + "0" + Integer.toString(Month) + "-";
		}
		if (Day >= 10) {
			sDate = sDate + Integer.toString(Day);
		} else {
			sDate = sDate + "0" + Integer.toString(Day);
		}
		return sDate;
	}// end of public static String changeDatetoString(Calendar cDate;)

	// ///////////////////////////////////////////////////////////////////////////////////
	// 将日期转换成字符串,格式
	// ///////////////////////////////////////////////////////////////////////////////////
	public static String changeDateTimetoString(Calendar cDate) {
		int Year;
		int Month;
		int Day;
		int Hour;
		int Minute;
		int Second;
		String sDate = "";

		// 初始化时间
		Year = cDate.get(Calendar.YEAR);
		Month = cDate.get(Calendar.MONTH) + 1;
		Day = cDate.get(Calendar.DAY_OF_MONTH);
		Hour = cDate.get(Calendar.HOUR_OF_DAY);
		Minute = cDate.get(Calendar.MINUTE);
		Second = cDate.get(Calendar.SECOND);

		sDate = Integer.toString(Year);
		if (Month >= 10) {
			sDate = sDate + Integer.toString(Month);
		} else {
			sDate = sDate + "0" + Integer.toString(Month);
		}
		if (Day >= 10) {
			sDate = sDate + Integer.toString(Day);
		} else {
			sDate = sDate + "0" + Integer.toString(Day);
		}

		if (Hour >= 10) {
			sDate = sDate + Integer.toString(Hour);
		} else {
			sDate = sDate + "0" + Integer.toString(Hour);
		}

		if (Minute >= 10) {
			sDate = sDate + Integer.toString(Minute);
		} else {
			sDate = sDate + "0" + Integer.toString(Minute);
		}

		if (Second >= 10) {
			sDate = sDate + Integer.toString(Second);
		} else {
			sDate = sDate + "0" + Integer.toString(Second);
		}
		return sDate;
	}// end of public static String changeDatetoString(Calendar cDate;)

	// 取出对应数组中的值，应用于模板中的取数据
	public static String get(String[] data, int index) {
		if (data == null || data.length == 0 || data.length <= index) {
			return "";
		} else {
			return data[index];
		}
	}
	
	 
	
	  //对字符串 - 在右边填充指定符号
	  public static String addSymbolAtRight(String s, int fullLength,char addSymbol) 
	  {
		if(s==null)
		{
			return null;
		}
		
	    String result=s;
	    int length = s.length();
	    
	    if (length >= fullLength) {
	      System.out.println("StringTools:addSymbolAtRight() --> Warinning ,the length is equal or larger than fullLength!");
	    }

	    else
	    {
		    char[] newChars = new char[fullLength];
	
		    for (int i = 0; i < length; i++) {
		      newChars[i] = s.charAt(i);
		    }
	
		    for (int j = length; j < fullLength; j++) {
		      newChars[j] = addSymbol;
		    }
		    result = new String(newChars);
	    }
	    
	    return result;
	  }
	  
	  
      //对字符串 - 在左边填充指定符号
	  public static String addSymbolAtLeft(String s, int fullLength,char addSymbol) 
	  {
		if(s==null)
		{
			return null;
		}
		  
	    int distance = 0;
	    String result = s;
	    int length = s.length();
	    distance = fullLength - length;
	    
	    if (distance <= 0) {
	      System.out.println("StringTools:addSymbolAtleft() --> Warinning ,the length is equal or larger than fullLength!");
	    }

	    else
	    {
		    char[] newChars = new char[fullLength];
		    for (int i = 0; i < length; i++) {
		      newChars[i + distance] = s.charAt(i);
		    }
	
		    for (int j = 0; j < distance; j++) {
		      newChars[j] = addSymbol;
		    }
	
		    result = new String(newChars);
	    }
	    
	    return result;
	  }
	  
	  
	  /*
	   * 格式货币分 001000.00
	   * 格式化后为 1000 
	   */
	  public static String formatFen(String fen)
	  {
		  if(fen==null)
		  {
			  return null;
		  }
		  
		  int pos=fen.indexOf(".");
		  
		  try
		  {
			  if(pos==0)
			  {
				  return "0";
			  }
			  else if(pos>0)
			  {
				  return String.valueOf(Integer.parseInt(fen.substring(0,pos)));
			  }
			  else
			  {
				  return String.valueOf(Integer.parseInt(fen));
			  }
		  }
		  catch(Exception e)
		  {
			  System.out.println("StringTools: Exception when formatFen() - "+e);
			  return null;
		  }
		  
	  }
	  
	  public static String view(Object o){
		  if(o == null)
			  return "";
		  return o.toString().trim(); 
	  }
	  
	  public static String viewPhoneNo(Object o){
		  if(o == null){
			  return ""; 
		  }else{
			  if(regexMobile(o.toString().trim())){
				  return o.toString().trim(); 
			  }else{
				  return "";
			  }
		  }
	  }
	  
	  public static boolean validAmount(String amount){
		  try{
			  Double.parseDouble(amount);
			  return true;
		  }catch(Exception e){
			  return false;
		  }
	  }
	  
	  public static String getCurrentYearMonth(){
		  Calendar cal = Calendar.getInstance();
		  StringBuffer str = new StringBuffer();
		  int month = cal.get(Calendar.MONTH) + 1; 
		  str.append(cal.get(Calendar.YEAR)).append(month < 10 ? "0" + month : month);
		  return str.toString();
	  }
	
	  public static boolean regexMobile(String str) {
			String regex1 = "153\\d{8}";
			String regex2 = "133\\d{8}";
			String regex3 = "189\\d{8}";
			String regex4 = "180\\d{8}";
			Pattern pattern1 = Pattern.compile(regex1);
			Matcher matcher1 = pattern1.matcher(str);
			Pattern pattern2 = Pattern.compile(regex2);
			Matcher matcher2 = pattern2.matcher(str);
			Pattern pattern3 = Pattern.compile(regex3);
			Matcher matcher3 = pattern3.matcher(str);
			Pattern pattern4 = Pattern.compile(regex4);
			Matcher matcher4 = pattern4.matcher(str);
			boolean b1 = matcher1.matches();
			boolean b2 = matcher2.matches();
			boolean b3 = matcher3.matches();
			boolean b4 = matcher4.matches();
			boolean b = false;
			if( b1 || b2 || b3 || b4)
				b = true;
			return b;
	  }
	  public static boolean regexFFBPwd(String str) {
			String regex = "[0-9A-Za-z_]*";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(str);
			return matcher.matches();
	  }	  
	  
	  public static void main(String[] args) { 
		  System.out.println("|"+viewPhoneNo("18923456789")+"|");
		  //System.out.println(NumberUtils.isDigits("dsfsdf"));
	}
}