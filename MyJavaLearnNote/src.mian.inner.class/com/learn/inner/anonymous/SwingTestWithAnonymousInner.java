package com.learn.inner.anonymous;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTestWithAnonymousInner {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Anonymous Inner");
		JButton button = new JButton("JButton");
		
		button.addActionListener(
			//匿名内部类
			//new出来一个实现了ActionListener接口的类的实例
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.out.println("Hello Anonymous Inner Class!!");
				}
				
			}
		);
		
		//加入按钮
		frame.getContentPane().add(button);
		
		//设置关闭行为
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(200, 200);
        
        frame.addWindowListener(
        		//匿名内部类
        		//也可以使用继承了适配器类的匿名内部类
        		new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e)
                    {
                    
                        System.out.println("Closing");
                        System.exit(0);
                    }
				}
        );
        
        frame.setVisible(true);
	}
	
}
