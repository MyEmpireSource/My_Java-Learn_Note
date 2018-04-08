package com.templatemethod.sec.hook.jfram;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * 
 * @Package: com.templatemethod.sec.hook.jfram
 * @ClassName: MyFrame.java
 *
 * @Description: 绘图挂钩
 * 				
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年1月5日 下午3:57:21
 * @UpdateDate: 2018年1月5日 下午3:57:21
 * @Version: V1.0
 */
public class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	/**
	 * JFrame.paint() 默认状态下不做任何事, 它是一个钩子 
	 * 通过覆盖paint(), 可以将自己的代码插入JFrame算法中, 显示出你所想要的画面
	 */
	public void paint(Graphics graphics) {
		super.paint(graphics);
		
		String msg = "I rule!!";
		
		graphics.drawString(msg, 100, 100);
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("Head First Design Patterns");
	}
	
}
