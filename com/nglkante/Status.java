package com.nglkante;

import java.util.Random;

public class Status {
	private static int mTeam = 1; // 1 = 2부리그, 2 = 레스터, 3 = 첼시, 4 = 결말
	private static int salary = 0;
	private static int skill = 0;
	// private int addend = 1;
	private Random rand = new Random();

	// 팀
	public int getTeam() {
		return mTeam;
	}

	// 이적
	public void setTeam() {
		mTeam++;
	}

	// 급여
	public int getSalary() {
		return salary;
	}

	public void AddSalary(int add) {
		salary = salary + add;
	}

	public void SubSalary(int sub) {
		salary = salary - sub;
	}

	// 훈련
	public boolean tranning() {
		int r = rand.nextInt(10);
		if (r == 7) {
			skill++;
			return true;
		} else
			return false;
	}

	public int getSkill() {
		return skill;
	}

	public void addSkill(int add) {
		skill = skill + add;
	}

	// 이적여부
	public int isTranfer() {
		if (salary >= 30 && skill >= 10) // 첼시
			return 4;
		else if (salary >= 20 && skill >= 5) // 첼시
			return 3;
		else if (salary >= 10 && skill >= 1) // 레스터
			return 2;
		else
			return 1;
	}
}
