package com.adapter.first.turkey.duck.test;

import com.adapter.first.turkey.duck.adapter.TurkeyAdapter;
import com.adapter.first.turkey.duck.client.DuckShowClient;
import com.adapter.first.turkey.duck.client.TurkeyShowClient;
import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;
import com.adapter.first.turkey.duck.component.impl.MallardDuck;
import com.adapter.first.turkey.duck.component.impl.WildTurkey;

public class DuckTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duck mallardDuck = new MallardDuck();
		
		Turkey wildTurkey = new WildTurkey();
		
		//将火鸡包装进一个火鸡适配器中, 使它看起来像一只鸭子
		Duck turkeyAdapterDuck = new TurkeyAdapter(wildTurkey);
		
		System.out.println("The Turkey say...");
		TurkeyShowClient.turkeyShow(wildTurkey);
		
		//DuckShowClient是客户, 需要 DUCK
		System.out.println("\nThe Duck says...");
		DuckShowClient.showDuck(mallardDuck);
		
		
		System.out.println("\nThe TurkeyAdapter says...");
		DuckShowClient.showDuck(turkeyAdapterDuck);
		
		
	}

}
