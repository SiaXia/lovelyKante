package com.nglkante;

import java.util.Random;

public class Status {
	private static int mTeam = 1; // 1 = 2�θ���, 2 = ������, 3 = ÿ��, 4 = �ḻ
	private static int salary = 0;
	private static int skill = 0;
	// private int addend = 1;
	private Random rand = new Random();

	// ��
	public int getTeam() {
		return mTeam;
	}

	// ����
	public void setTeam() {
		mTeam++;
	}

	// �޿�
	public int getSalary() {
		return salary;
	}

	public void AddSalary(int add) {
		salary = salary + add;
	}

	public void SubSalary(int sub) {
		salary = salary - sub;
	}

	// �Ʒ�
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

	// ��������
	public int isTranfer() {
		if (salary >= 30 && skill >= 10) // ÿ��
			return 4;
		else if (salary >= 20 && skill >= 5) // ÿ��
			return 3;
		else if (salary >= 10 && skill >= 1) // ������
			return 2;
		else
			return 1;
	}
}
