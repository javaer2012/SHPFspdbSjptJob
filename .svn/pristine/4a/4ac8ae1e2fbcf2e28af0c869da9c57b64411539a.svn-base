package com.ideal.spdb.utils;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * 
 * <p>
 * Title:  浦发五星项目
 * </p>
 * <p>
 * Description:Freemarker模板工具类
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author dinghui create date: 2011-10-26
 * @version 1.0
 */
public class FreemarkerUtilTool {
	private static final FreemarkerUtilTool fut = new FreemarkerUtilTool();

	/**
	 * 获取模板所在路径
	 * 
	 * @param className
	 *            工具类名称
	 * @param dirTemplateName
	 *            模板所在文件夹名称
	 * @return 返回Freemarker模板所在路径
	 */
	private String getTemplatePath(Class<?> className, String dirTemplateName) {
		// 模板所在路径
		StringBuilder sb = new StringBuilder();
		String dir = className.getResource(File.separator).getPath().split("WEB-INF")[0];
		sb.append(dir);
		sb.append(dirTemplateName);
		return sb.toString();
	}

	/**
	 * 完成freemarker模板文件初始化
	 * 
	 * @param dir
	 *            Freemarker模板所在路径
	 * @return 返回Configuration对象
	 * @throws Exception
	 *             抛出所有异常
	 */
	private Configuration getConfiguration(String dir, String encoding)
			throws Exception {
		Configuration cfg = new Configuration();
		// 加载freemarker模板文件
		cfg.setDirectoryForTemplateLoading(new File(dir));
		// 设置对象包装器
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		// 设置默认编码
		cfg.setDefaultEncoding(encoding);
		// 设计异常处理器
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		return cfg;
	}

	/**
	 * 获取freemarker模板生成对应的HTML网页响应给客户端
	 * 
	 * @param cfg
	 *            Configuration对象
	 * @param data
	 *            数据
	 * @param dir
	 *            freemarker模板所在路径
	 * @param templateName
	 *            模板名称
	 * @param encoding
	 *            编码
	 * @param response
	 *            响应
	 */
	private void getTemplate(Configuration cfg, Map<String, Object> data,
			String dir, String templateName, String encoding,
			HttpServletResponse response) {
		Writer out = null;
		try {
			// 获取指定模板文件
			Template template = cfg.getTemplate(templateName);
			// 设置模板编码
			template.setEncoding(encoding);
			// 将freemarker模板生成对应的HTML网页响应给客户端
			response.setContentType("text/html; charset=" + encoding);
			out = response.getWriter();
			// 最后开始生成
			template.process(data, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 获取freemarker模板生成对应的HTML网页响应给客户端
	 * 
	 * @param className
	 *            工具类名称
	 * @param dirTemplateName
	 *            freemarker模板所在文件夹名称
	 * @param data
	 *            数据
	 * @param templateName
	 *            模板名称
	 * @param encoding
	 *            编码
	 * @param response
	 *            响应
	 * @throws Exception
	 *             抛出所有异常
	 */
	public void executeFreemarke(Class<?> className, String dirTemplateName,
			Map<String, Object> data, String templateName, String encoding,
			HttpServletResponse response) throws Exception {
		String dir = this.getTemplatePath(className, dirTemplateName);
		Configuration cfg = this.getConfiguration(dir, encoding);
		this.getTemplate(cfg, data, dir, templateName, encoding, response);
	}

	public static FreemarkerUtilTool getInstance() {
		return fut;
	}

	/**
	 * 主函数(调用例子)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 定义并设置数据
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("persion", "用户列表");
		try {
			FreemarkerUtilTool.getInstance().executeFreemarke(
					FreemarkerUtilTool.class, "freemarker", data, "test.ftl",
					"UTF-8", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
