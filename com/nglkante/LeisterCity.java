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

	JLabel salary = new JLabel("�޿�: " + s.currencyFormat(s.getSalary()) + "��");
	JLabel skill = new JLabel("�Ƿ�: " + s.getSkill());
	JButton btnBarbers = new JButton("�̿��");

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
		JLabel info = new JLabel("�޿� " + s.currencyFormat(s.getChelseaSalary()) + "��, �Ƿ� " + s.getChelseaSkill() + "�̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/leisterCity.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		c.add(salary);
		c.add(skill);

		// ������
		JButton btnMatch = new JButton("������");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.AddSalary(s.getLeisterCityRandSalary());
				isEnableEvent();
				refreshSalary();
				// ÿ�� ����
				if (s.isTranfer() == 3 && s.getTeam() == 2) {
					dispose();
					new Chelsea();
					s.setTeam(3);
				} else
					s.setTeam(2);
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
						refreshSkill();
						// ÿ�� ����
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
		// �̿��
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

	// �����
	void refreshSalary() {
		salary.setText("�޿�: " + s.currencyFormat(s.getSalary()) + "��");
	}

	void refreshSkill() {
		skill.setText("�Ƿ�: " + s.getSkill());
	}

	// �̺�Ʈ Ȱ��ȭ
	void isEnableEvent() {
		if (s.getSalary() >= s.getEventBarberCost())
			btnBarbers.setEnabled(true);
		else
			btnBarbers.setEnabled(false);
	}
}