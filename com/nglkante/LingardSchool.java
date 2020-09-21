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

public class LingardSchool extends JFrame {
	private Random rand = new Random();

	LingardSchool() {
		Chelsea ch = new Chelsea();
		ch.setVisible(false);

		// ���̾ƿ�
		Status s = new Status();
		Container c = getContentPane();
		setTitle("�������� ����");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// �ȳ���
		JLabel info1 = new JLabel("������� �������� �౸�����Դϴ�. ������ ��� �ǽ���?");
		info1.setFont(new Font("�������", Font.BOLD, 20));
		c.add(info1);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/lingardSchool.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// �ȳ���
		JLabel info2 = new JLabel("����� " + s.getEventLingardCost() + "���Դϴ�.");
		info2.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info2);

		// �౸�� ����
		JButton btnLearn = new JButton("�౸�� ����");
		c.add(btnLearn);
		btnLearn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s.SubSalary(s.getEventLingardCost());
				dispose();
				int r = rand.nextInt(2);
				if (r == 0)
					new HowToPlaySoccer();
				else
					new HowToDance();
			};
		});

		// ������
		JButton btnExit = new JButton("������");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ch.setVisible(true);
				ch.refreshSalary();
			};
		});
		setSize(650, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
