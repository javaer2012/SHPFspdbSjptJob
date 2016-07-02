package com.ideal.spdb.thirdinfo.util;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.BFILE;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class BFileHandler implements TypeHandler{

	@Override
	public Object getResult(CallableStatement callableStatement, int index)
			throws SQLException {
		BFILE bfile=(BFILE) callableStatement.getObject(index);
		bfile.openFile();
		String xmlStr=null;
		try {
			xmlStr = IOUtils.toString(bfile.getBinaryStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bfile.closeFile();
		return xmlStr;
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		BFILE bfile=(BFILE) rs.getObject(columnName);
		bfile.openFile();
		String xmlStr=null;
		try {
			xmlStr = IOUtils.toString(bfile.getBinaryStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bfile.closeFile();
		return xmlStr;
	}

	@Override
	public void setParameter(PreparedStatement preparedStatement, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i, (String) parameter);
	}
	 
}
