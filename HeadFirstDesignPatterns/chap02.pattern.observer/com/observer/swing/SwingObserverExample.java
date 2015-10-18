package com.observer.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @Package: com.observer.swing 
 * @ClassName: SwingObserverExample
 * 
 * @Description: 测试JAVA中内置的其它观察者模式 
 *
 * @Company: ZCX&Empire 
 * @Author: ZCX
 * @CreateDate: 2015年10月18日 下午2:16:22 
 * @ChangeDate: 2015年10月18日 下午2:16:22 
 *
 */
public class SwingObserverExample {
	JFrame frame;
	
	public static void main(String[] args) {
		SwingObserverExample example = new SwingObserverExample();
		example.go();
	}
	
	public void go() {
		frame = new JFrame();

		JButton button = new JButton("Should I do it?");
		//两个监听者
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);

		// Set frame properties 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @Package: com.observer.swing 
	 * @ClassName: AngelListener
	 * 
	 * @Description: 观察者
	 * 
	 *
	 * @Company: ZCX&Empire 
	 * @Author: ZCX
	 * @CreateDate: 2015年10月18日 下午2:17:50 
	 * @ChangeDate: 2015年10月18日 下午2:17:50 
	 *
	 */
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Don't do it, you might regret it!");
		}
	}

	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Come on, do it!");
		}
	}
}
