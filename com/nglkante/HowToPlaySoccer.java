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

		// 레이아웃
		Container c = getContentPane();
		setTitle("축구를 배웠다!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
 
		// 사진
		int r = rand.nextInt(3);
		ImageIcon imageIcon[] = { new ImageIcon("images/dancingLingard1.gif"),
				new ImageIcon("images/dancingLingard2.gif"), new ImageIcon("images/dancingLingard3.gif") };
		JLabel imageLabel = new JLabel(imageIcon[r]);
		c.add(imageLabel);
		// 안내문
		s.addSkill(s.getEventLingardRand());
		JLabel info = new JLabel("           린가드에게 축구를 배워 댄스실력이 " + s.getEventLingardRand() + "오릅니다.          ");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);

		// 댄스 없인 못살지!
		JButton btnExit = new JButton("댄스 없인 못살지!");
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
