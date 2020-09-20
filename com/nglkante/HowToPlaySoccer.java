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
	Chelsea ch = new Chelsea();

	HowToPlaySoccer() {
		Status s = new Status();
		// Status s = new Status();
		Container c = getContentPane();
		setTitle("�౸�� �����!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		int r1 = rand.nextInt(4);
		int r2 = rand.nextInt(10);
		
		// ����
		ImageIcon imageIcon[] = {new ImageIcon("images/dancingLingard1.gif"),
				new ImageIcon("images/dancingLingard2.gif"),
				new ImageIcon("images/dancingLingard3.gif"),
				new ImageIcon("images/dancingLingard4.gif")
				};
		JLabel imageLabel = new JLabel(imageIcon[r1]);
		c.add(imageLabel);
		// �ȳ���
		s.addSkill(r2);
		JLabel info = new JLabel("�����忡�� �౸�� ��� ���Ƿ��� " + r2 + "�����ϴ�.");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);

		// ��ȣ!
		JButton btnExit = new JButton("��ȣ!");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("��ȣ!")) {
					dispose();
					ch.c.setVisible(true);
				}
			};
		});

		setSize(450, 460);
		setVisible(true);
	}
}
