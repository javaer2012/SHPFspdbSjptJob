package com.ideal.spdb.utils;

import org.apache.log4j.Logger;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:取得汉字首字母工具类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author dinghui create date: 2011-9-11
 * @version 1.0
 */
public class ChineseSpelling {
	protected static Logger log=Logger.getLogger(ChineseSpelling.class);

	private ChineseSpelling() {
	}

	// 字母Z使用了两个标签，这里有２７个值
	// i, u, v都不做声母, 跟随前面的字母
	private static char[] chartable = { '啊', '芭', '擦', '搭', '蛾', '发', '噶', '哈',
			'哈', '击', '喀', '垃', '妈', '拿', '哦', '啪', '期', '然', '撒', '塌', '塌',
			'塌', '挖', '昔', '压', '匝', '座' };
	// 首字母表
	private static char[] initialtable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z' };

	private static int[] table = new int[27];

	// 初始化
	static {
		for (int i = 0; i < 27; ++i) {
			table[i] = gbValue(chartable[i]);
		}
	}

	/**
	 * 根据一个包含汉字的字符串返回一个汉字拼音首字母的字符串
	 * 
	 * @param sourceStr
	 *            源字符串
	 * @return 拼音首字母的字符串
	 */
	public static String getChineseInitial(String sourceStr) {
		log.info("run getChineseInitial!");
		StringBuilder sb = new StringBuilder();
		int strLength = sourceStr.length();
		int i;
		try {
			for (i = 0; i < strLength; i++) {
				sb.append(char2Initial(sourceStr.charAt(i)));
			}
		} catch (Exception e) {
			log.error("run getChineseInitial:",e);
		}
		return sb.toString();
	}

	/**
	 * 输入字符,得到他的声母,英文字母返回对应的大写字母,其他非简体汉字返回 '0'
	 * 
	 * @param ch
	 *            字符
	 * @return 拼音首字母
	 */
	private static char char2Initial(char ch) {
		if (ch >= 'a' && ch <= 'z')
			return (char) (ch - 'a' + 'A');
		if (ch >= 'A' && ch <= 'Z')
			return ch;
		int gb = gbValue(ch);
		if (gb < table[0])
			return ch;
		int i;
		for (i = 0; i < 26; ++i) {
			if (match(i, gb))
				break;
		}
		if (i >= 26)
			return ch;
		else
			return initialtable[i];
	}

	private static boolean match(int i, int gb) {
		if (gb < table[i])
			return false;
		int j = i + 1;
		// 字母Z使用了两个标签
		while (j < 26 && (table[j] == table[i]))
			++j;
		if (j == 26)
			return gb <= table[j];
		else
			return gb < table[j];

	}

	/**
	 * 取出汉字的编码 cn 汉字
	 */
	private static int gbValue(char ch) {
		String str = "";
		str += ch;
		try {
			byte[] bytes = str.getBytes("GB2312");
			if (bytes.length < 2)
				return 0;
			return (bytes[0] << 8 & 0xff00) + (bytes[1] & 0xff);
		} catch (Exception e) {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getChineseInitial("你好"));
		System.out.println(getChineseInitial(""));
		System.out.println(getChineseInitial("熔岩abc123"));
	}
}
