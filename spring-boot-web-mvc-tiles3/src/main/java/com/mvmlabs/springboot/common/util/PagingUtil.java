package com.mvmlabs.springboot.common.util;

import java.util.Map;

public class PagingUtil {

	/**
	 * paging 관련 변수의 값을 확인하여 초기화
	 *
	 * @param param
	 *            - paging 관련 값
	 * @return Map<String,Object> - 초기화된 paging 값
	 */
	public static Map<String, Object> putPagingParam(Map<String, Object> param) {
		Object currentPageNumberObj = param.get("currentPageNumber");
		Object rowsPerPageObj = param.get("rowsPerPage");

		int currentPageNumber = (currentPageNumberObj instanceof String)
				? Integer.parseInt((String) currentPageNumberObj) : (Integer) currentPageNumberObj;
		int rowsPerPage = (rowsPerPageObj instanceof String) ? Integer.parseInt((String) rowsPerPageObj)
				: (Integer) rowsPerPageObj;

		param.put("startRow", (currentPageNumber - 1) * rowsPerPage + 1);
		param.put("endRow", currentPageNumber * rowsPerPage);
		
		return param;
	}
}
