package com.base.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	/**
	 * 
	 * @Title: showListByPage
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 *   @param dataList
	 *   @param pageNum 页数
	 *   @param pageSize 每页数量
	 *
	 * @Return: void
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2016年3月25日 下午3:49:32
	 * @ChangeDate: 2016年3月25日 下午3:49:32
	 * @Author: 李立
	 */
	public static void showListByPage(List<String> dataList, int pageNum, int pageSize) {
		
		if (dataList != null && dataList.size() > 0) {
			
			//总页数
			int allPageNum = (int) Math.ceil(dataList.size() / (pageSize * 1.0));
			
			List<String> tempList = null;
			
			pageNum = pageNum > allPageNum ? allPageNum : pageNum;
			
			int fromIndex = 0;
			int toIndex = 0;
			
			for (; pageNum <= allPageNum; ++pageNum) {
				
				fromIndex = (pageNum - 1) * pageSize;
				
				if (pageNum == allPageNum) {
					toIndex = dataList.size();
				} else {
					toIndex = pageNum * pageSize;
				}
				
				System.out.println("******************** [pageNum :" + pageNum + ", pageSize : " + pageSize + " - fromIndex : " + fromIndex + ", toIndex : " + toIndex + "] ********************");
				tempList = dataList.subList(fromIndex, toIndex);
				
				for (String s : tempList) {
					System.out.println(s);
				}
				
				System.out.println();System.out.println();
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		List<String> indexList = new ArrayList<String> ();
		for (int i = 1; i <= 53; ++i) {
			indexList.add(i+"");
		}
		
		showListByPage(indexList, 1, 10);
		
		System.out.println();System.out.println();
		System.out.println("#################################");
		
		showListByPage(indexList, 6, 6);
	}
	// List<Object> tempList = new ArrayList<Object>(lists.subList((pageno-1)*pagesize, pageno*pagesize>totalSize?(totalSize):pageno*pagesize)); 
}
