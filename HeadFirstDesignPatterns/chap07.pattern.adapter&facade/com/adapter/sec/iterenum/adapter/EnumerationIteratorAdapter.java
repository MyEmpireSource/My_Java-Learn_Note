package com.adapter.sec.iterenum.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * 
 * @param <E>
 * @Package: com.adapter.sec.iterenum.adapter
 * @ClassName: EnumerationIterator.java
 *
 * @Description: 枚举&迭代器适配器
 * 				   将枚举适配为迭代器
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2017年12月11日 上午11:21:01
 * @UpdateDate: 2017年12月11日 上午11:21:01
 * @Version: V1.0
 */
public class EnumerationIteratorAdapter<E> implements Iterator<E> {

	private Enumeration<E> enumeration;
	
	// 用 组合 的方法将  枚举对象结合到适配器中
	public EnumerationIteratorAdapter(Enumeration<E> enumeration) {
		this.enumeration = enumeration;
	}
	
	
	@Override
	public boolean hasNext() {
		// 适配对应方法
		// TODO Auto-generated method stub
		return this.enumeration.hasMoreElements();
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		// 适配对应方法
		return this.enumeration.nextElement();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
		//由于枚举类没有对应的 remover() 方法, 
		//所以不得不放弃, 这里我们抛出异常
		throw new UnsupportedOperationException();
	}

}
