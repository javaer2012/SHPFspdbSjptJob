package com.ideal.spdb.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ideal.spdb.system.model.SysUserModel;


/**
 * 
 * <p>Title: 浦发五星项目</p>
 * <p>Description:登录session监听类（单点登录）</p>
 * <p>Company: 上海理想信息产业(集团)有限公司</p>
 * @author dinghui
 * create date: 2011-12-22
 * @version 1.0
 */
public class LoginSessionListener implements HttpSessionAttributeListener {
	private Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	/**
	 * session属性添加的时候被调用
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		if (Constants.USERINFO_SESSION_ATTRIBUTE.equals(name)) {
			SysUserModel sysUserModel = (SysUserModel) event.getValue();
			if (map.get(sysUserModel.getUserName()) != null) {
				HttpSession session = map.get(sysUserModel.getUserName());
				session.removeAttribute(Constants.USERINFO_SESSION_ATTRIBUTE);
				// 让session失效
				session.setMaxInactiveInterval(1);
			}
			// 将session以用户名为索引放入session
			map.put(sysUserModel.getUserName(), event.getSession());
		}

	}

	/**
	 * session属性删除的时候调用
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name = event.getName();
		if (Constants.USERINFO_SESSION_ATTRIBUTE.equals(name)) {
			SysUserModel sysUserModel = (SysUserModel) event.getValue();
			// 移除的session在map中移除
			map.remove(sysUserModel.getUserName());
		}
	}

	/**
	 * session属性修改的时候调用
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		if (Constants.USERINFO_SESSION_ATTRIBUTE.equals(name)) {
			SysUserModel sysUser = (SysUserModel) event.getValue();
			// 移除旧的登录信息
			map.remove(sysUser.getUserName());

			// 新的的登录信息
			SysUserModel sysUserModel = (SysUserModel) event.getSession()
					.getAttribute(Constants.USERINFO_SESSION_ATTRIBUTE);

			// 判断是否在别的机器上登录过
			if (map.get(sysUserModel.getUserName()) != null) {
				HttpSession session = map.get(sysUserModel.getUserName());
				session.removeAttribute(Constants.USERINFO_SESSION_ATTRIBUTE);
				// 让session失效
				session.setMaxInactiveInterval(1);
			}
			// 将session以用户名为索引放入session
			map.put(sysUserModel.getUserName(), event.getSession());
		}
	}

}
