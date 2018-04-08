package com.adapter.sec.iterenum.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 
 * @Package: com.adapter.sec.iterenum.adapter
 * @ClassName: IteratorEnumerationAdapter.java
 *
 * @Description: 迭代器&枚举适配器
 * 				   将迭代器适配为枚举
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月11日 上午11:29:48
 * @UpdateDate: 2017年12月11日 上午11:29:48
 * @Version: V1.0
 */
public class IteratorEnumerationAdapter<E> implements Enumeration<E> {

	private Iterator<E> iterator;
	
	//// 用 组合 的方法将  迭代器对象结合到适配器中
	public IteratorEnumerationAdapter(Iterator<E> iterator) {
		this.iterator = iterator;
	}
	
	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		// 适配对应方法
		return this.iterator.hasNext();
	}

	@Override
	public E nextElement() {
		// TODO Auto-generated method stub
		// 适配对应方法
		return this.iterator.next();
	}

}
