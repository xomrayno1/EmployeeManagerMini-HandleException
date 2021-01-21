package com.tampro.springrest01.model.request;

public class TeamPagingSearchSortModel {
	
	private int sortKey;
	private String search;
	private boolean isAsc;
	private int pageNumber;
	private int pageSize;
	
	
	public TeamPagingSearchSortModel() {
		super();
	}
	public TeamPagingSearchSortModel(int sortKey, String search, int pageNumber, int pageSize) {
		super();
		this.sortKey = sortKey;
		this.search = search;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public int getSortKey() {
		return sortKey;
	}
	public void setSortKey(int sortKey) {
		this.sortKey = sortKey;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
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
	public boolean isAsc() {
		return isAsc;
	}
	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}
	
	
	

}
