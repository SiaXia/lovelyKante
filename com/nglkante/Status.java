package com.nglkante;

import java.util.Random;

public class Status {
	private static int mTeam = 1; // 1 = 2부리그, 2 = 레스터, 3 = 첼시, 4 = 결말
	private static int salary = 0;
	private static int skill = 0;

	// 변수 조정
	private int leisterCitySalary = 8000000; // 급여
	private int chelseaSalary = 32000000;
	private int endingSalary = 83000000;
	
	private int leisterCitySkill = 40; // 실력
	private int chelseaSkill = 250;
	private int endingSkill = 700;
	
	private int eventBarberCost = 2000000;
	private int eventLingardCost = 15000000;

	// 확률 조정
	private Random rand = new Random();
	private int secondDivisionRandSalary = rand.nextInt(20000);
	private int leisterCityRandSalary = rand.nextInt(100000);
	private int chelseaRandSalary = rand.nextInt(300000);
	
	private int eventBarberRand = rand.nextInt(25) + 1;
	private int eventLingardRand = rand.nextInt(45) + 1;

	// 팀
	public int getTeam() {
		return mTeam;
	}

	// 이적
	public void setTeam(int set) {
		mTeam = set;
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
		int r = rand.nextInt(9);
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
		if (salary >= endingSalary && skill >= endingSkill) // 엔딩
			return 4;
		else if (salary >= chelseaSalary && skill >= chelseaSkill) // 첼시
			return 3;
		else if (salary >= leisterCitySalary && skill >= leisterCitySkill) // 레스터
			return 2;
		else
			return 1;
	}

	// getters
	public int getLeisterCitySalary() {
		return leisterCitySalary;
	}

	public int getChelseaSalary() {
		return chelseaSalary;
	}

	public int getEndingSalary() {
		return endingSalary;
	}

	public int getLeisterCitySkill() {
		return leisterCitySkill;
	}

	public int getChelseaSkill() {
		return chelseaSkill;
	}

	public int getEndingSkill() {
		return endingSkill;
	}

	public int getSecondDivisionRandSalary() {
		return secondDivisionRandSalary;
	}

	public int getLeisterCityRandSalary() {
		return leisterCityRandSalary;
	}

	public int getChelseaRandSalary() {
		return chelseaRandSalary;
	}

	public int getEventBarberCost() {
		return eventBarberCost;
	}

	public int getEventLingardCost() {
		return eventLingardCost;
	}

	public int getEventBarberRand() {
		return eventBarberRand;
	}

	public int getEventLingardRand() {
		return eventLingardRand;
	}
}
