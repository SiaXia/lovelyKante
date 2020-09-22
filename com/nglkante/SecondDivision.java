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
	JLabel salary = new JLabel("급여: " + s.currencyFormat(s.getSalary()) + "￡");
	JLabel skill = new JLabel("실력: " + s.getSkill());

	SecondDivision() {

		// 레이아웃
		setTitle("SM 캉을 1부리그로 승격시킨 캉요미");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("2부리그");
		team.setFont(new Font("맑은고딕", Font.BOLD, 30));
		c.add(team);

		// 안내문
		JLabel info = new JLabel("급여 " + s.currencyFormat(s.getLeisterCitySalary()) + "￡, 실력 " + s.getLeisterCitySkill() + "이상 이적");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);

		// 사진
		ImageIcon imageIcon = new ImageIcon("images/secondDivision.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		c.add(salary);
		c.add(skill);

		// 시즌경기
		JButton btnMatch = new JButton("시즌경기");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.AddSalary(s.getSecondDivisionRandSalary());
				refreshSalary();
				// 레스터 이적
				if (s.isTranfer() == 2 && s.getTeam() == 1) {
					dispose();
					new LeisterCity();
					s.setTeam(2);
				} else
					s.setTeam(1);
			}
		});

		// 훈련
		JButton btnTraining = new JButton("훈련");
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.tranning()) {
					refreshSkill();
					// 레스터 이적
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

	// 재출력
	void refreshSalary() {
		salary.setText("급여: " + s.currencyFormat(s.getSalary()) + "￡");
	}

	void refreshSkill() {
		skill.setText("실력: " + s.getSkill());
	}
}
