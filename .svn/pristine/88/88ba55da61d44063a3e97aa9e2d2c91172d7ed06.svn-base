package com.ideal.spdb.utils;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;


/**
 * SIT域验证
 * @author wls
 * @date 2012-8-24
 * @version V1.0
 */
public class SitLdap {
	
	public boolean tryMoreLdapUrl(String userName, String userPwd){
		boolean flag = false;
		String[] ldapUrlArr = AppConfigFile.getInstance().getValue("LDAP_URL").split(",");
		if(null != ldapUrlArr && ldapUrlArr.length != 0){
			for (int i = 0; i < ldapUrlArr.length; i++) {
				flag = getUserCheck(userName, userPwd,ldapUrlArr[i]);
				if(flag)break;
			}
		}
		return flag;
	}
	
	public boolean getUserCheck(String userName, String userPwd, String ldapUrl) {
		boolean ischeck = true; // 验证是否存在,存在true,不存在:false
		Hashtable HashEnv = new Hashtable();

//		String LDAP_URL = "ldap://192.168.1.23:389"; // LDAP访问地址,服务器ip地址,端口号不用配,会自动配置为389
//		String LDAP_URL = AppConfigFile.getInstance().getValue("LDAP_URL"); // LDAP访问地址,服务器ip地址,端口号不用配,会自动配置为389
		String LDAP_URL = ldapUrl;
		String searchFilter = "objectClass=User"; // specify the LDAP search
//		String searchBase = "DC=wuxin,DC=com"; // Specify the Base for the
		String searchBase = "DC="+AppConfigFile.getInstance().getValue("DC")+",DC=com"; // Specify the Base for the
		// search//搜索域节点(例如你的服务器后缀名为abc.com，那么对应dc=abc,dc=com)
		// String url=System.getProperty("user.dir");
		// url=url.substring(0,url.length()-3);
		// String ls_url=url;

		// String[] luoshiParam=setLuoshiVal(ls_url);

		// String LDAP_URL=luoshiParam[0];
		// String searchFilter=luoshiParam[1];
		// String searchBase=luoshiParam[2];//这个我解析xml获取的域配置信息，这里直接写在java代码里面了

		String adminName = userName +"@"+AppConfigFile.getInstance().getValue("DC") + ".com"; // (帐号@域名)注意用户名的写法：domain\User 或 ,=帐号+后缀名
		String adminPassword = userPwd; // 密码

		HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)
		HashEnv.put(Context.SECURITY_PRINCIPAL, adminName); // AD User
		HashEnv.put(Context.SECURITY_CREDENTIALS, adminPassword); // AD
		// Password
		HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
		HashEnv.put(Context.PROVIDER_URL, LDAP_URL);

		try {
			LdapContext ctx = new InitialLdapContext(HashEnv, null); // 如果用户错误会报异常,正确会遍历所以域用户信息
			SearchControls searchCtls = new SearchControls(); // Create the
			// search
			// controls
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE); // Specify
			// the
			// search
			// scope

			int totalResults = 0;

			String returnedAtts[] = { "url", "whenChanged", "employeeID",
					"name", "userPrincipalName", "physicalDeliveryOfficeName",
					"departmentNumber", "telephoneNumber", "homePhone",
					"mobile", "department", "sAMAccountName", "whenChanged",
					"mail" }; // 定制返回属性

			searchCtls.setReturningAttributes(returnedAtts); // 设置返回属性集

			// Search for objects using the filter
			NamingEnumeration answer = ctx.search(searchBase, searchFilter,
					searchCtls);

//			if (answer == null) {
//				System.out.println("answer is null");
//			} else {
//				System.out.println("answer not null");
//				System.out.println(answer.hasMoreElements());
//			}
//			while (answer.hasMoreElements()) {
//				SearchResult sr = (SearchResult) answer.next();
//				System.out
//						.println("************************************************");
//				System.out.println(sr.getName());
//
//				Attributes Attrs = sr.getAttributes();
//				if (Attrs != null) {
//					try {
//						for (NamingEnumeration ne = Attrs.getAll(); ne
//								.hasMore();) {
//							Attribute Attr = (Attribute) ne.next();
//							System.out.println(" AttributeID="
//									+ Attr.getID().toString());
//
//							// 读取属性值
//							for (NamingEnumeration e = Attr.getAll(); e
//									.hasMore(); totalResults++) {
//								System.out.println(" AttributeValues="
//										+ e.next().toString());
//							}
//							System.out.println(" ---------------");
//
//							// 读取属性值
//							Enumeration values = Attr.getAll();
//							if (values != null) { // 迭代
//								while (values.hasMoreElements()) {
//									System.out.println(" AttributeValues="
//											+ values.nextElement());
//								}
//							}
//							System.out.println(" ---------------");
//						}
//					} catch (NamingException e) {
//						System.err.println("Throw Exception : " + e);
//					}
//				}
//			}
//			System.out.println("Number: " + totalResults);
			ctx.close();
		}

		catch (NamingException e) {
			e.printStackTrace();
			System.err.println("Throw Exception : " + e);
			ischeck = false;
		}
		return ischeck;

	}
	
	public static void main(String[] args) {
		String userName="wuxintest";
		String userPwd="Spdbccc2012";
//		String userName="uatbg90116";
//		String userPwd="Iccc2012";
		
		SitLdap sitLdap = new SitLdap();
		boolean flag = false;
		String[] ldapUrlArr = AppConfigFile.getInstance().getValue("LDAP_URL").split(",");
		if(null != ldapUrlArr && ldapUrlArr.length != 0){
			for (int i = 0; i < ldapUrlArr.length; i++) {
				flag = sitLdap.getUserCheck(userName, userPwd,ldapUrlArr[i]);
				System.out.println(flag);
				if(flag)break;
			}
		}
	}
}
