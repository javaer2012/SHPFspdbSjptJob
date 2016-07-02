package com.ideal.spdb.utils;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * <p>
 * Title: 浦发五星项目
 * </p>
 * <p>
 * Description:导出excel文件通用组件
 * </p>
 * <p>
 * Company: 上海理想信息产业(集团)有限公司
 * </p>
 * 
 * @author dinghui create date: 2012-1-16
 * @version 1.0
 */
public class DataToExcelModel {
	private static final int pageCount = 10000;
	private static final DataToExcelModel dataToExcelModel = new DataToExcelModel();

	/**
	 * 导出excel数据
	 * 
	 * @param source
	 *            要导出的数据
	 * @param className
	 *            封装数据BEAN的包名.类名
	 * @param excelName
	 *            导出的excel文件名
	 * @param response
	 *            响应对象
	 * @param title
	 *            excel文件标题
	 * 
	 * @return 返回导出结果
	 * @throws Exception
	 *             抛出所有异常
	 */
	@SuppressWarnings("unchecked")
	public boolean dataToExcelUtil(List<?> source, String className,
			String excelName, HttpServletResponse response, String title)
			throws Exception {
		boolean flag = false;
		Class<?> classEntity = Class.forName(className);
		// 对需要打印的属性名进行排序
		Field[] fields = classEntity.getDeclaredFields();
		ArrayList<Field> arrFieldList = new ArrayList<Field>();
		for (Field field : fields) {
			if (field.isAnnotationPresent(ExcelAnnotation.class)) {
				arrFieldList.add(field);
			}
		}
		Field[] arrField = {};
		arrField = arrFieldList.toArray(arrField);
		Arrays.sort(arrField, new FieldComparator());

		// 生成对应的方法名,要打印的列名
		String columnName = ""; // 打印的列名
		String beanName = ""; // 属性名
		String methodName = ""; // 方法名
		int nameSize = arrField.length;
		ArrayList<String> columnArr = new ArrayList<String>(); // 属性名集合
		ArrayList<String> methodArr = new ArrayList<String>(); // 列名集合
		StringBuilder sb=new StringBuilder();
		for (Field field : arrField) {
			ExcelAnnotation ann = field.getAnnotation(ExcelAnnotation.class);
			columnName = ann.name();
			columnArr.add(columnName);
			beanName = field.getName();
			sb.delete(0, sb.length()) ;
			sb.append("get");
			sb.append(beanName.substring(0, 1).toUpperCase());
			sb.append(beanName.substring(1));
			methodName =sb.toString();
			methodArr.add(methodName);
		}
		// 分页sheet
		int max = source.size();
		int sheetCount = max / pageCount + (max % pageCount == 0 ? 0 : 1);
		sheetCount=sheetCount>0?sheetCount:1;
		Workbook wb = new HSSFWorkbook();
		for (int i = 0; i < sheetCount; i++) {
			sb.delete(0, sb.length()) ;
			sb.append(title);
			sb.append("第");
			sb.append(i + 1);
			sb.append("页");
			Sheet sheet = this.foundSheet(wb, sb.toString());
			Row row = sheet.createRow(0);
			Cell cell = null;
			int begin = pageCount * (i);
			for (int j = 0; j < nameSize; j++) {
				cell = row.createCell((short) j);
				cell.setCellValue(columnArr.get(j));
				cell.setCellStyle(this.setStyle(wb));
			}
			int k = 0;
			while (k < pageCount && (begin + k < max)) {
				Object object = source.get(begin + k);
				Class<?> clasz = object.getClass();
				row = sheet.createRow(k + 1);
				for (int m = 0; m < nameSize; m++) {
					cell = row.createCell((short) m);
					methodName = methodArr.get(m);
					Method method = clasz.getMethod(methodName);
					String value = "";
					if (null != method.invoke(object)) {
						value = method.invoke(object).toString();
					}
					cell.setCellValue(new HSSFRichTextString(value));
				}
				k++;
			}
		}
		this.setResponseHeader(response, excelName);
		wb.write(response.getOutputStream());
		flag = true;

		return flag;
	}
	
	
	   /**
     * excel数据导出通用组件
     * 
     * @param source
     *            要导出的数据
     * @param className
     *            封装数据BEAN的包名.类名
     * @param excelName
     *            导出的excel文件名
     * @param OutputStream
     *            输出IO流
     * @param title
     *            excel文件标题
     * 
     * @return 返回导出结果
     * @throws Exception
     *             抛出所有异常
     */
    @SuppressWarnings("unchecked")
    public boolean JobdataToExcelUtil(List<?> source, String className,
            String excelName, OutputStream wirter, String title)
            throws Exception {
        boolean flag = false;
        Class<?> classEntity = Class.forName(className);
        // 对需要打印的属性名进行排序
        Field[] fields = classEntity.getDeclaredFields();
        ArrayList<Field> arrFieldList = new ArrayList<Field>();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelAnnotation.class)) {
                arrFieldList.add(field);
            }
        }
        Field[] arrField = {};
        arrField = arrFieldList.toArray(arrField);
        Arrays.sort(arrField, new FieldComparator());

        // 生成对应的方法名,要打印的列名
        String columnName = ""; // 打印的列名
        String beanName = ""; // 属性名
        String methodName = ""; // 方法名
        int nameSize = arrField.length;
        ArrayList<String> columnArr = new ArrayList<String>(); // 属性名集合
        ArrayList<String> methodArr = new ArrayList<String>(); // 列名集合
        StringBuilder sb=new StringBuilder();
        for (Field field : arrField) {
            ExcelAnnotation ann = field.getAnnotation(ExcelAnnotation.class);
            columnName = ann.name();
            columnArr.add(columnName);
            beanName = field.getName();
            sb.delete(0, sb.length()) ;
            sb.append("get");
            sb.append(beanName.substring(0, 1).toUpperCase());
            sb.append(beanName.substring(1));
            methodName =sb.toString();
            methodArr.add(methodName);
        }
        // 分页sheet
        int max = source.size();
        int sheetCount = max / pageCount + (max % pageCount == 0 ? 0 : 1);
        sheetCount=sheetCount>0?sheetCount:1;
        Workbook wb = new HSSFWorkbook();
        for (int i = 0; i < sheetCount; i++) {
            sb.delete(0, sb.length()) ;
            sb.append(title);
            sb.append("第");
            sb.append(i + 1);
            sb.append("页");
            Sheet sheet = this.foundSheet(wb, sb.toString());
            Row row = sheet.createRow(0);
            Cell cell = null;
            int begin = pageCount * (i);
            for (int j = 0; j < nameSize; j++) {
                cell = row.createCell((short) j);
                cell.setCellValue(columnArr.get(j));
                cell.setCellStyle(this.setStyle(wb));
            }
            int k = 0;
            while (k < pageCount && (begin + k < max)) {
                Object object = source.get(begin + k);
                Class<?> clasz = object.getClass();
                row = sheet.createRow(k + 1);
                for (int m = 0; m < nameSize; m++) {
                    cell = row.createCell((short) m);
                    methodName = methodArr.get(m);
                    Method method = clasz.getMethod(methodName);
                    String value = "";
                    if (null != method.invoke(object)) {
                        value = method.invoke(object).toString();
                    }
                    cell.setCellValue(new HSSFRichTextString(value));
                }
                k++;
            }
        }
        wb.write(wirter);
        flag = true;
        return flag;
    }

	/**
	 * 创建工作区
	 * 
	 * @param wb
	 *            创建Excel文件的对象
	 * @param title
	 *            工作区标题
	 * @return 返回工作区
	 */
	private Sheet foundSheet(Workbook wb, String title) {
		Sheet sheet = wb.createSheet(title);// 创建工作区
		Row row1 = sheet.createRow(0);
		CellStyle style = wb.createCellStyle();// 设置单元格样式
		Font font = wb.createFont();
		font.setColor(HSSFColor.RED.index);// 红色
		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体
		font.setFontHeightInPoints((short) 12);
		style.setFont(font);
		Cell cell0 = row1.createCell(0);
		cell0.setCellValue(new HSSFRichTextString(title));
		cell0.setCellStyle(style);
		return sheet;
	}

	/**
	 * 设置字体样式
	 * 
	 * @param wb
	 *            创建Excel文件的对象
	 * @return 返回样式对象
	 */
	private CellStyle setStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();// 设置单元格样式
		Font font = wb.createFont();
		font.setColor(HSSFColor.BLUE.index);// 蓝色
		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体
		style.setFont(font);
		return style;
	}

	/**
	 * 设置响应头
	 * 
	 * @param response响应对象
	 * @param excelName
	 *            excel文件名
	 */
	private void setResponseHeader(HttpServletResponse response,
			String excelName) {
		response.setContentType("application/octet-stream;charset=iso-8859-1");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String(URLEncoder.encode(excelName, "utf-8"))
					+ ".xls");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DataToExcelModel getInstance() {
		return dataToExcelModel;
	}
}
