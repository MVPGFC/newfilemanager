package com.gfc.newfilemanager.dmo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @author Administrator
 *
 * @param <T>
 */
public class Pager<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分页的大小
	 */
	private Integer pageSize;
	/**
	 * 分页的起始页
	 */
	private Integer currentPage;
	/**
	 * 总记录数
	 */
	private Long totalCount;
	/**
	 * 分页的数据
	 */
	private List<T> datas;


	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	@Override
	public String toString() {
		return "com.cnpc.common.dao.Pager";
	}
	
}
