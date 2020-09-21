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

public class BarbersSuccess extends JFrame {
	private Random rand = new Random();
	Status s = new Status();

	BarbersSuccess() {
		LeisterCity l = new LeisterCity();
		l.setVisible(false);

		Container c = getContentPane();
		setTitle("성공!!!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// 사진
		int r = rand.nextInt(4);
		ImageIcon imageIcon[] = { new ImageIcon("images/hair1.jpg"), new ImageIcon("images/hair2.jpg"),
				new ImageIcon("images/hair3.jpg"), new ImageIcon("images/hair4.jpg") };
		JLabel imageLabel = new JLabel(imageIcon[r]);
		c.add(imageLabel);

		// 안내문
		s.addSkill(s.getEventBarberRand());
		JLabel info = new JLabel("캉테는 새로 자른 머리를 좋아합니다. 실력이 " + s.getEventBarberRand() + "오릅니다.");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);

		// 신난다!
		JButton btnExit = new JButton("신난다!");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				l.setVisible(true);
				l.refreshSalary();
				l.refreshSkill();
			};
		});
		setSize(380, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
