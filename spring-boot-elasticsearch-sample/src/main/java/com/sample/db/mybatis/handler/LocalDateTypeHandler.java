package com.sample.db.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDate;

/**
 * Example with LocalDate java8 Handler
 *
 */
@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler<LocalDate> {
	@Override
	public void setParameter(final PreparedStatement ps, final int index, final LocalDate parameter, final JdbcType jdbcType) throws SQLException {
		final LocalDate date = parameter;
		if (date != null) {
			ps.setDate(index, Date.valueOf(parameter));
		} else {
			ps.setDate(index, null);
		}
	}

	@Override
	public LocalDate getResult(final ResultSet rs, final String columnName) throws SQLException {
		final Date date = rs.getDate(columnName);
		if (date != null) {
			return date.toLocalDate();
		} else {
			return null;
		}
	}

	@Override
	public LocalDate getResult(final ResultSet rs, final int columnIndex) throws SQLException {
		final Date date = rs.getDate(columnIndex);
		if (date != null) {
			return date.toLocalDate();
		} else {
			return null;
		}
	}

	@Override
	public LocalDate getResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		final Date date = cs.getDate(columnIndex);
		if (date != null) {
			return date.toLocalDate();
		} else {
			return null;
		}
	}
}
