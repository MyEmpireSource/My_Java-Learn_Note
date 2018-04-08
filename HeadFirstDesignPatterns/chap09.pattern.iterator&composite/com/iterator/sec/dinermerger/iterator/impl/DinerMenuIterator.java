package com.iterator.sec.dinermerger.iterator.impl;

import java.util.Arrays;
import java.util.Iterator;

import com.iterator.sec.dinermerger.entity.MenuItem;

/**
 * 
 * @Package: com.iterator.sec.dinermerger.iterator.impl
 * @ClassName: DinerMenuIterator.java
 *
 * @Description: 餐厅菜单迭代器(用数组存储菜品), 接口为JDK java.util.Iterator
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月17日 下午3:16:16
 * @UpdateDate: 2018年1月17日 下午3:16:16
 * @Version: V1.0
 */
public class DinerMenuIterator implements Iterator<MenuItem> {

	int position = 0; 	// 位置  
	MenuItem[] menuItems;	// 菜单项, 用数组存储菜品
	
	public DinerMenuIterator(MenuItem[] menuItems) {
		this.menuItems = menuItems;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		if (this.position >= this.menuItems.length || this.menuItems[this.position] == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public MenuItem next() {
		// TODO Auto-generated method stub
		return this.menuItems[this.position++];
	}

	/**
	 * 删除由 next() 方法返回的元素(不仅是聚合最后一个)
	 * DinerMenu 用数组保存菜单, 删除时把后面元素向前移动一位
	 */
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
		if (this.hasNext()) {
			for (int i = this.position; i < this.menuItems.length - 1; i++) {
				this.menuItems[i] = this.menuItems[i + 1];
			}
			this.menuItems[this.menuItems.length-1] = null;
		} else {
			throw new IllegalStateException("You can’t remove an item until you’ve done at least one next()!!!");
		}
		
	}

	@Override
	public String toString() {
		return this.position + ", " + Arrays.toString(this.menuItems);
	}
	
	

}
