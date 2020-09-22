package com.nglkante;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SecondDivision extends JFrame {
	private Container c = getContentPane();
	Status s = new Status();
	JLabel salary = new JLabel("�޿�: " + s.currencyFormat(s.getSalary()) + "��");
	JLabel skill = new JLabel("�Ƿ�: " + s.getSkill());

	SecondDivision() {

		// ���̾ƿ�
		setTitle("SM Ĳ�� 1�θ��׷� �°ݽ�Ų Ĳ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("2�θ���");
		team.setFont(new Font("�������", Font.BOLD, 30));
		c.add(team);

		// �ȳ���
		JLabel info = new JLabel("�޿� " + s.currencyFormat(s.getLeisterCitySalary()) + "��, �Ƿ� " + s.getLeisterCitySkill() + "�̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/secondDivision.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		c.add(salary);
		c.add(skill);

		// ������
		JButton btnMatch = new JButton("������");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.AddSalary(s.getSecondDivisionRandSalary());
				refreshSalary();
				// ������ ����
				if (s.isTranfer() == 2 && s.getTeam() == 1) {
					dispose();
					new LeisterCity();
					s.setTeam(2);
				} else
					s.setTeam(1);
			}
		});

		// �Ʒ�
		JButton btnTraining = new JButton("�Ʒ�");
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.tranning()) {
					refreshSkill();
					// ������ ����
					if (s.isTranfer() == 2 && s.getTeam() == 1) {
						dispose();
						new LeisterCity();
						s.setTeam(2);
					} else
						s.setTeam(1);
				}

			};
		});
		setSize(450, 530);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// �����
	void refreshSalary() {
		salary.setText("�޿�: " + s.currencyFormat(s.getSalary()) + "��");
	}

	void refreshSkill() {
		skill.setText("�Ƿ�: " + s.getSkill());
	}
}
