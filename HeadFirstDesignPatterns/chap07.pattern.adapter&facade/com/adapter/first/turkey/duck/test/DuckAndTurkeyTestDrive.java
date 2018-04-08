package com.adapter.first.turkey.duck.test;

import com.adapter.first.turkey.duck.adapter.DuckAndTurkeyAdapter;
import com.adapter.first.turkey.duck.client.DuckShowClient;
import com.adapter.first.turkey.duck.client.TurkeyShowClient;
import com.adapter.first.turkey.duck.component.Duck;
import com.adapter.first.turkey.duck.component.Turkey;
import com.adapter.first.turkey.duck.component.impl.MallardDuck;
import com.adapter.first.turkey.duck.component.impl.WildTurkey;

public class DuckAndTurkeyTestDrive {
	
	public static void main(String[] args) {
		Duck mallardDuck = new MallardDuck();
		Turkey wildTurkey = new WildTurkey();
		
		DuckAndTurkeyAdapter duckAndTurkeyAdapter = new DuckAndTurkeyAdapter(mallardDuck, wildTurkey);
		
		DuckShowClient.showDuck(duckAndTurkeyAdapter);
		
		System.out.println("\n\n");
		TurkeyShowClient.turkeyShow(duckAndTurkeyAdapter);
	}
	
}
