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

		// 레이아웃
		Status s = new Status();
		Container c = getContentPane();
		setTitle("린가드의 교실");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// 안내문
		JLabel info1 = new JLabel("어서오세요 린가드의 축구교실입니다. 성함이 어떻게 되시죠?");
		info1.setFont(new Font("맑은고딕", Font.BOLD, 20));
		c.add(info1);

		// 사진
		ImageIcon imageIcon = new ImageIcon("images/lingardSchool.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// 안내문
		JLabel info2 = new JLabel("비용은 " + s.getEventLingardCost() + "￡입니다.");
		info2.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info2);

		// 축구를 배운다
		JButton btnLearn = new JButton("축구를 배운다");
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

		// 나간다
		JButton btnExit = new JButton("나간다");
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
