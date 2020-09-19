package com.nglkante;

import java.util.Random;

public class Status {
	private int salary=0;
	private int skill=0;
	private int addend=1;
	private Random rand=new Random();
	
	// 급여
	public int salary() {
		return salary;
	}
	public void AddSalary(){
		salary=salary+addend;
	}
	
	// 훈련
	public boolean tranning() {
		int r=rand.nextInt(10);
		if(r==7) {
			skill++;
			return true;
		}
		else
			return false;
	}
	
	// 스킬
	public int skill() {
		return skill;
	}
}
