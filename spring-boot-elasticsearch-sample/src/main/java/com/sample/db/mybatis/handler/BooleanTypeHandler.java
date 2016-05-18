package com.sample.db.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Example with values S,N to boolean Handler
 *
 */
@MappedTypes(Boolean.class)
public class BooleanTypeHandler implements TypeHandler<Boolean> {
	private static final String FALSE_STRING = "N";
	private static final String TRUE_STRING = "S";

	@Override
	public void setParameter(final PreparedStatement ps, final int index, final Boolean parameter, final JdbcType jdbcType) throws SQLException {
		if (parameter != null) {
			ps.setString(index, parameter.booleanValue() ? TRUE_STRING : FALSE_STRING);
		} else {
			ps.setString(index, FALSE_STRING);
		}
	}

	@Override
	public Boolean getResult(final ResultSet rs, final String columnName) throws SQLException {
		return TRUE_STRING.equalsIgnoreCase(rs.getString(columnName));
	}

	@Override
	public Boolean getResult(final ResultSet rs, final int columnIndex) throws SQLException {
		return TRUE_STRING.equalsIgnoreCase(rs.getString(columnIndex));
	}

	@Override
	public Boolean getResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return TRUE_STRING.equalsIgnoreCase(cs.getString(columnIndex));
	}
}
