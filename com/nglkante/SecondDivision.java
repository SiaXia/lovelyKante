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
		// ���̾ƿ�
		setTitle("SM Ĳ�� 1�θ��׷� �°ݽ�Ų Ĳ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("2�θ���");
		team.setFont(new Font("�������", Font.BOLD, 30));
		c.add(team);

		// �ȳ���
		JLabel info = new JLabel("�޿� 10��, �Ƿ� 1 �̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/secondDivision.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// �޿�
		JLabel salary = new JLabel("�޿�: " + s.getSalary() + "��");
		c.add(salary);

		// �Ƿ�
		JLabel skill = new JLabel("�Ƿ�: " + s.getSkill());
		c.add(skill);

		// ������
		JButton btnMatch = new JButton("������");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("������")) {
					s.AddSalary(1);
					salary.setText("�޿�: " + s.getSalary() + "��");
					// ������ ����
					if (s.isTranfer() == 2 && s.getTeam() == 1) {
						setVisible(false);
						new LeisterCity();
						s.setTeam();
					}
				}
			}
		});

		// �Ʒ�
		JButton btnTraining = new JButton("�Ʒ�");
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("�Ʒ�")) {
					if (s.tranning()) {
						skill.setText("�Ƿ�: " + s.getSkill());
						// ������ ����
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
