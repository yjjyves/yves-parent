package com.yves.dao.plugin.dialect;


/**
 * Oracle 分页
 * 
 * @author Administrator
 *
 */
public class OracleDialect extends Dialect {
	@Override
	public boolean supportsLimit() {
		return true;
	}

	@Override
	public boolean supportsLimitOffset() {
		
		return true;
	}
	
	@Override
	public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
		sql = sql.trim();
		boolean isForUpdate = false;
		if ( sql.toLowerCase().endsWith(" for update") ) {
			sql = sql.substring( 0, sql.length()-11 );
			isForUpdate = true;
		}
		StringBuffer pagingSelect = new StringBuffer( sql.length()+100 );	
		pagingSelect.append("select  * from ( select row_.*, rownum rownum_ from ( ");
		
		pagingSelect.append(sql);
	
		if (offset > 1) {
			String endString = offsetPlaceholder+"+"+limitPlaceholder;
			
			pagingSelect.append(" ) row_ where rownum<="+endString+" ) where  rownum_ > " + offsetPlaceholder);
		}
		else {
			pagingSelect.append(" ) row_  where rownum <= "+limitPlaceholder+") " );
		}
		if ( isForUpdate ) {
			pagingSelect.append( " for update" );
		}
		
		return pagingSelect.toString();
	}
}
