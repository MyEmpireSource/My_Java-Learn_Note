package com.iterator.first.dinermerger.iterator;

/**
 * 
 * @Package: com.iterator.first.dinermerger.iterator
 * @ClassName: Iterator.java
 *
 * @Description: 迭代器接口
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月11日 下午3:22:23
 * @UpdateDate: 2018年1月11日 下午3:22:23
 * @Version: V1.0
 */
public interface Iterator {
	
	/**
	 * 
	 * @Title: hasNext
	 * @Description: 返回聚合中是否还有其它元素
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: boolean
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年1月11日 下午3:22:36
	 * @ChangeDate: 2018年1月11日 下午3:22:36
	 * @Author: ZCX
	 */
	public boolean hasNext();
	
	/**
	 * 
	 * @Title: next
	 * @Description: 返回聚合中的下一个元素
	 * 
	 * @Params:
	 *   @return
	 *
	 * @Return: Object
	 * 
	 * @Throws:
	 *
	 * @CreateDate: 2018年1月11日 下午3:23:03
	 * @ChangeDate: 2018年1月11日 下午3:23:03
	 * @Author: ZCX
	 */
	public Object next();
	
}
