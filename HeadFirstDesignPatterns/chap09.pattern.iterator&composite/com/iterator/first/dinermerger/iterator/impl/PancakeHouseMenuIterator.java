package com.iterator.first.dinermerger.iterator.impl;

import java.util.ArrayList;

import com.iterator.first.dinermerger.entity.MenuItem;
import com.iterator.first.dinermerger.iterator.Iterator;

/**
 * 
 * @Package: com.iterator.first.dinermerger.iterator.impl
 * @ClassName: PancakeHouseMenuIterator.java
 *
 * @Description: 煎饼屋菜单迭代器(用List存储菜品)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月11日 下午4:31:19
 * @UpdateDate: 2018年1月11日 下午4:31:19
 * @Version: V1.0
 */
public class PancakeHouseMenuIterator implements Iterator {

	
	int position = 0; 			// 位置  
	ArrayList<MenuItem> items;	// 菜单项, 用数组存储菜品
	
	public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.position >= items.size()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return this.items.get(this.position++);
	}

}
