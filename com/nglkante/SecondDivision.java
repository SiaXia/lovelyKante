package com.nglkante;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SecondDivision extends JFrame {
	private Container c = getContentPane();
	Status s = new Status();

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
		JLabel info = new JLabel("급여 10￡, 실력 1 이상 이적");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);

		// 사진
		ImageIcon imageIcon = new ImageIcon("images/secondDivision.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// 급여
		JLabel salary = new JLabel("급여: " + s.getSalary() + "￡");
		c.add(salary);

		// 실력
		JLabel skill = new JLabel("실력: " + s.getSkill());
		c.add(skill);

		// 시즌경기
		JButton btnMatch = new JButton("시즌경기");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("시즌경기")) {
					s.AddSalary(1);
					salary.setText("급여: " + s.getSalary() + "￡");
					// 레스터 이적
					if (s.isTranfer() == 2 && s.getTeam() == 1) {
						setVisible(false);
						new LeisterCity();
						s.setTeam();
					}
				}
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
						skill.setText("실력: " + s.getSkill());
						// 레스터 이적
						if (s.isTranfer() == 2 && s.getTeam() == 1) {
							setVisible(false);
							new LeisterCity();
							s.setTeam();
						}
					}
				}
			};
		});
		setSize(450, 530);
		setVisible(true);
	}
}
