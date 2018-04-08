package com.adapter.first.turkey.duck.test;

import com.adapter.first.turkey.duck.adapter.DuckAdapter;
import com.adapter.first.turkey.duck.client.TurkeyShowClient;
import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;
import com.adapter.first.turkey.duck.component.impl.MallardDuck;

public class TurkeyTestDrive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duck mallardDuck = new MallardDuck();
		
		//将鸭子包装进一个鸭子适配器中, 使它看起来像一只火鸡
		Turkey duckAdapterTurkey = new DuckAdapter(mallardDuck);
 
		for(int i = 0; i < 10; i++) {
			System.out.println("The DuckAdapter says...");
			TurkeyShowClient.turkeyShow(duckAdapterTurkey);
			
			System.out.println("\n\n");
		}
		
	}

}
