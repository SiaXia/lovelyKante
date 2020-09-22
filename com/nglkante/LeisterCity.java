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

public class LeisterCity extends JFrame {
	Container c = getContentPane();
	Status s = new Status();

	JLabel salary = new JLabel("급여: " + s.currencyFormat(s.getSalary()) + "￡");
	JLabel skill = new JLabel("실력: " + s.getSkill());
	JButton btnBarbers = new JButton("미용실");

	LeisterCity() {
		// 레이아웃
		setTitle("레스터시티를 우승시킨 캉요미");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("레스터시티");
		team.setFont(new Font("맑은고딕", Font.BOLD, 30));
		c.add(team);

		// 안내문
		JLabel info = new JLabel("급여 " + s.currencyFormat(s.getChelseaSalary()) + "￡, 실력 " + s.getChelseaSkill() + "이상 이적");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);

		// 사진
		ImageIcon imageIcon = new ImageIcon("images/leisterCity.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		c.add(salary);
		c.add(skill);

		// 시즌경기
		JButton btnMatch = new JButton("시즌경기");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.AddSalary(s.getLeisterCityRandSalary());
				isEnableEvent();
				refreshSalary();
				// 첼시 이적
				if (s.isTranfer() == 3 && s.getTeam() == 2) {
					dispose();
					new Chelsea();
					s.setTeam(3);
				} else
					s.setTeam(2);
			}
		});

		// 훈련
		JButton btnTraining = new JButton("훈련");
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("훈련")) {
					if (s.tranning()) {
						refreshSkill();
						// 첼시 이적
						if (s.isTranfer() == 3 && s.getTeam() == 2) {
							dispose();
							new Chelsea();
							s.setTeam(3);
						} else
							s.setTeam(2);
					}
				}
			};
		});
		// 미용실
		c.add(btnBarbers);
		btnBarbers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.getSalary() >= s.getEventBarberCost()) {
					dispose();
					new Barbers();
				}
			};
		});
		isEnableEvent();
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

	// 이벤트 활성화
	void isEnableEvent() {
		if (s.getSalary() >= s.getEventBarberCost())
			btnBarbers.setEnabled(true);
		else
			btnBarbers.setEnabled(false);
	}
}