package com.templatemethod.sec.hook.barista.beverage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.templatemethod.sec.hook.barista.template.CaffeineBeverageWithHook;

public class TeaWithHook extends CaffeineBeverageWithHook {
 
	protected void brew() {
		System.out.println("Steeping the tea");
	}
 
	protected void addCondiments() {
		System.out.println("Adding Lemon");
	}
 
	/**
	 * 覆盖钩子方法, 提供了自己的功能
	 */
	protected boolean customerWantsCondiments() {

		//让用户输入对调料的决定, 根据用户的输入返回 true 或  false, 由此来影响算法走向
		//即 钩子 能够作为条件控制, 影响抽象类中的算法流程
		String answer = getUserInput();

		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}
 
	private String getUserInput() {
		// get the user's response
		String answer = null;

		System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException ioe) {
			System.err.println("IO error trying to read your answer");
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
