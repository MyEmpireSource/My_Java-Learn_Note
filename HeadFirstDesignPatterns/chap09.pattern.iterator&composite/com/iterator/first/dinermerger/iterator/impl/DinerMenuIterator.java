package com.iterator.first.dinermerger.iterator.impl;

import com.iterator.first.dinermerger.entity.MenuItem;
import com.iterator.first.dinermerger.iterator.Iterator;

/**
 * 
 * @Package: com.iterator.first.dinermerger.iterator.impl
 * @ClassName: DinerMenuIterator.java
 *
 * @Description: 餐厅菜单迭代器(用数组存储菜品)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月11日 下午3:26:45
 * @UpdateDate: 2018年1月11日 下午3:26:45
 * @Version: V1.0
 */
public class DinerMenuIterator implements Iterator {
	
	int position = 0; 	// 位置  
	MenuItem[] menuItems;	// 菜单项, 用数组存储菜品
	
	/**
	 * 
	 * @Description: TODO(用一句话描述该文件做什么)
	 * 
	 * @Params:
	 * @param items 菜单项的数组
	 *
	 * @Throws:
	 *
	 * @CreateDate: 2018年1月16日 下午4:00:38
	 * @ChangeDate: 2018年1月16日 下午4:00:38
	 * @Author: ZCX
	 */
	public DinerMenuIterator(MenuItem[] items) {
		this.menuItems = items;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.position >= menuItems.length || this.menuItems[this.position] == null) {
			return false;
		} 
		
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		
		return this.menuItems[this.position++];
		
	}

}
