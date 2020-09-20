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

public class LeisterCity extends JFrame {
	Container c = getContentPane();
	Status s = new Status();

	LeisterCity() {
		// ���̾ƿ�
		setTitle("�����ͽ�Ƽ�� ��½�Ų Ĳ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("�����ͽ�Ƽ");
		team.setFont(new Font("�������", Font.BOLD, 30));
		c.add(team);

		// �ȳ���
		JLabel info = new JLabel("�޿� 20��, �Ƿ� 10 �̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/leisterCity.jpg");
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
					// ÿ�� ����
					if (s.isTranfer() == 3 && s.getTeam() == 2) {
						dispose();
						new Chelsea();
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
						// ÿ�� ����
						if (s.isTranfer() == 3 && s.getTeam() == 2) {
							dispose();
							new Chelsea();
							s.setTeam();
						}
					}
				}
			};
		});

		// �̿��
		JButton btnBarbers = new JButton("�̿��");
		c.add(btnBarbers);
		btnBarbers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("�̿��") && s.getSalary() >= 10) {
					setVisible(false);
					new Barbers();
				}
			};
		});
		setSize(450, 530);
		setVisible(true);
	}
}