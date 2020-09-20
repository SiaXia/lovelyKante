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
		JLabel info = new JLabel("�޿� 30��, �Ƿ� 10 �̻� ����");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/chelsea.jpg");
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
					// �ḻ
					if (s.isTranfer() == 4 && s.getTeam() == 3) {
						dispose();
						new Ending();
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
		JButton btnLingard = new JButton("�������� �౸����");
		c.add(btnLingard);
		btnLingard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("�������� �౸����") && s.getSalary() >= 10) {
					setVisible(false);
					new LingardSchool();
				}
			};
		});
		
		setSize(450, 530);
		setVisible(true);
	}
}