package com.iterator.sec.dinermerger.menu;

import java.util.Iterator;

import com.iterator.sec.dinermerger.entity.MenuItem;

/**
 * 
 * @Package: com.iterator.sec.dinermerger.menu
 * @ClassName: Menu.java
 *
 * @Description: 让客户能够取得菜单项迭代器
 * 				   实现该接口后, 女招待可以利用接口(而不是具体类)来引用每一个菜单对象
 * 				   可以减少女招待和具体类之间的依赖(针对接口编程而不是针对实现编程)
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月18日 下午2:25:44
 * @UpdateDate: 2018年1月18日 下午2:25:44
 * @Version: V1.0
 */
public interface Menu {
	
	public Iterator<MenuItem> createIterator();
	
}
