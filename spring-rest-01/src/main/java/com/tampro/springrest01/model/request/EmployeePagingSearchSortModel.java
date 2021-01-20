package com.tampro.springrest01.model.request;

public class EmployeePagingSearchSortModel {
	//private String conId;
	private String searchKey;
	private int sortKey;
	private boolean ascSort;
	private int pageNumber;
	private int pageSize;
	
	
	
	public EmployeePagingSearchSortModel() {
		 
	}
	public EmployeePagingSearchSortModel(String searchKey, int sortKey, boolean ascSort, int pageNumber, int pageSize) {
		 
		this.searchKey = searchKey;
		this.sortKey = sortKey;
		this.ascSort = ascSort;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
//	public String getConId() {
//		return conId;
//	}
//	public void setConId(String conId) {
//		this.conId = conId;
//	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public int getSortKey() {
		return sortKey;
	}
	public void setSortKey(int sortKey) {
		this.sortKey = sortKey;
	}
	public boolean isAscSort() {
		return ascSort;
	}
	public void setAscSort(boolean ascSort) {
		this.ascSort = ascSort;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
