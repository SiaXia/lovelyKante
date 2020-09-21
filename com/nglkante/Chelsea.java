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

public class Chelsea extends JFrame {
	Container c = getContentPane();
	Status s = new Status();

	JLabel salary = new JLabel("�޿�: " + s.getSalary() + "��");
	JLabel skill = new JLabel("�Ƿ�: " + s.getSkill());
	JButton btnLingard = new JButton("�౸����");

	Chelsea() {
		// ���̾ƿ�
		setTitle("ÿ�ø� ������ Ĳ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel team = new JLabel("ÿ��");
		team.setFont(new Font("�������", Font.BOLD, 30));
		c.add(team);

		// �ȳ���
		JLabel info = new JLabel("�޿� " + s.getEndingSalary() + "��, �Ƿ� " + s.getEndingSkill() + "�̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/chelsea.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		c.add(salary);
		c.add(skill);

		// ������
		JButton btnMatch = new JButton("������");
		c.add(btnMatch);
		btnMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.AddSalary(s.getChelseaRandSalary());
				isEnableEvent();
				refreshSalary();
				// �ḻ
				if (s.isTranfer() == 4 && s.getTeam() == 3) {
					dispose();
					new Ending();
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
						refreshSkill();
						// �ḻ
						if (s.isTranfer() == 4 && s.getTeam() == 3) {
							dispose();
							new Ending();
						}
					}
				}
			};
		});
		// �������� �౸����
		c.add(btnLingard);
		btnLingard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (s.getSalary() >= s.getEventLingardCost()) {
					setVisible(false);
					new LingardSchool();
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
		salary.setText("�޿�: " + s.getSalary() + "��");
	}

	void refreshSkill() {
		skill.setText("�Ƿ�: " + s.getSkill());
	}

	// �̺�Ʈ Ȱ��ȭ
	void isEnableEvent() {
		if (s.getSalary() >= s.getEventLingardCost())
			btnLingard.setEnabled(true);
		else
			btnLingard.setEnabled(false);
	}
}