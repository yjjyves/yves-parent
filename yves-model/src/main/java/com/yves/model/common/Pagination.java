package com.yves.model.common;


import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 通用分页排序类
 * @author Administrator
 */
public class Pagination<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8526247195479423534L;
	public static final int DEFAULT_PAGE = 1;
	public static int DEFAULT_PAGE_SIZE = 30;
	private List<T> items;
	private int recordCount = -1;
	private int pageSize = DEFAULT_PAGE_SIZE;
	private int currentPageStartIndex = 0;
	private int currentPage = DEFAULT_PAGE;
	/**
	 * 排序方式 DESC/ASC
	 */
	private Sort sort = Sort.DESC;

	/**
	 * 排序字段
	 */
	private String sortField;

	/**
	 * 排序枚举
	 */
	public static enum Sort {
		DESC, ASC
	}
	
	public Pagination() {
		this(DEFAULT_PAGE_SIZE, DEFAULT_PAGE);
	}

	/**
	 * 用于直查询条数用
	 * @return
	 */
	public static<T> Pagination<T> getZeroPageSizePagination(){
		final Pagination<T> page=new Pagination<T>();
		page.pageSize=0;
		return page;
	}
	
	public Pagination(int pageSize, int page) {
		if (pageSize < 1) {
			throw new IllegalArgumentException("Count should be greater than zero!");
		} else if (currentPage < 1) {
			page = 1;
		} else {
			this.pageSize = pageSize;
			this.currentPage = page;
		}
	}
	
	public String getCount(){
		return this.getRecordCount()+"";
	}
	
	public void setPageSize(int countOnEachPage) {
		this.pageSize = countOnEachPage;
	}

	public List<T> getItems() {
		if(null==this.items) {
			this.items = new ArrayList();
		}
		return items;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public int getCurrentPageStartIndex() {
		currentPageStartIndex = (currentPage - 1) * pageSize;
//		if(currentPageStartIndex==0){
//			currentPageStartIndex=1;
//		}
		return currentPageStartIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void setRecordCount(int totalCount) {
		this.recordCount = totalCount;
	}
	

	public int getPageCount() {
		return (recordCount == 0) ? 1 : ((recordCount % pageSize == 0) ? (recordCount / pageSize)
				: (recordCount / pageSize) + 1);
	}

	public int getPreviousPage() {
		if(currentPage > 1) {
			return currentPage - 1;
		} else {
			return DEFAULT_PAGE;
		}
	}
	
	public int getNextPage() {
		if(currentPage < getPageCount()) {
			return currentPage + 1;
		} else {
			return getPageCount();
		}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	/**
	 * 存在上一页
	 * @return
	 */
	public boolean getExistUp()
	{
		return currentPage>1?true:false;
	}
	
	/**
	 * 存在下一页
	 * @return
	 */
	public boolean getExistNext()
	{
		return currentPage<this.getPageCount()?true:false;
	}
	
	public static<T> Pagination<T> createZeroPageSizePagination(){
		final Pagination<T> page=new Pagination<T>();
		page.pageSize=0;
		return page;
	}

	public RowBounds getRowBounds(){
		return new RowBounds(getCurrentPageStartIndex(), getPageSize());
	}

	
	public void setPage(int page) {
		setCurrentPage(page);
	}
	
}