package com.nglkante;

import java.util.Random;

public class Status {
	private int salary=0;
	private int skill=0;
	private int addend=1;
	private Random rand=new Random();
	
	// �޿�
	public int salary() {
		return salary;
	}
	public void AddSalary(){
		salary=salary+addend;
	}
	
	// �Ʒ�
	public boolean tranning() {
		int r=rand.nextInt(10);
		if(r==7) {
			skill++;
			return true;
		}
		else
			return false;
	}
	
	// ��ų
	public int skill() {
		return skill;
	}
}
