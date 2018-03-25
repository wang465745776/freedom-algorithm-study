package com.wanggt.freedom.algorithm.study.constant;

/**
 * 排序方式
 * @author freedom wang
 * @date 2018年3月25日上午10:17:16
 * @version 1.0
 */
public enum SortType {

	/** 升序 */
	ASC("ASC"),

	/** 降序 */
	DESC("DESC");

	private String sortType;

	private SortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortType() {
		return sortType;
	}

}
