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

public class HowToPlaySoccer extends JFrame {
	private Random rand = new Random();

	HowToPlaySoccer() {
		Status s = new Status();
		Chelsea ch = new Chelsea();
		ch.setVisible(false);

		// ���̾ƿ�
		Container c = getContentPane();
		setTitle("�౸�� �����!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
 
		// ����
		int r = rand.nextInt(3);
		ImageIcon imageIcon[] = { new ImageIcon("images/dancingLingard1.gif"),
				new ImageIcon("images/dancingLingard2.gif"), new ImageIcon("images/dancingLingard3.gif") };
		JLabel imageLabel = new JLabel(imageIcon[r]);
		c.add(imageLabel);
		// �ȳ���
		s.addSkill(s.getEventLingardRand());
		JLabel info = new JLabel("           �����忡�� �౸�� ��� ���Ƿ��� " + s.getEventLingardRand() + "�����ϴ�.          ");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// �� ���� ������!
		JButton btnExit = new JButton("�� ���� ������!");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ch.setVisible(true);
				ch.refreshSalary();
				ch.refreshSkill();
			};
		});

		setSize(500, 380);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
