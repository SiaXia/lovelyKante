package com.nglkante;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Barbers extends JFrame {
	private Random rand = new Random();

	Barbers() {
		LeisterCity l = new LeisterCity();
		l.setVisible(false);

		// 레이아웃
		Status s = new Status();
		Container c = getContentPane();
		setTitle("미용실에 간 캉요미");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel barbers = new JLabel("미용실");
		barbers.setFont(new Font("맑은고딕", Font.BOLD, 20));
		c.add(barbers);
		// 사진
		ImageIcon imageIcon = new ImageIcon("images/barbers.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// 안내문
		JLabel info = new JLabel("미용실에 간 캉테는 머리를 자르려 합니다");
		info.setFont(new Font("맑은고딕", Font.BOLD, 17));
		c.add(info);
		JLabel info2 = new JLabel("비용은 " + s.currencyFormat(s.getEventBarberCost()) + "￡입니다.");
		info2.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info2);

		// 자른다
		JButton btnCut = new JButton("자른다");
		c.add(btnCut);
		btnCut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				s.SubSalary(s.getEventBarberCost());
				dispose();
				int r = rand.nextInt(2);
				if (r == 0)
					new BarbersSuccess();
				else
					new BarbersFailure();
			};
		});

		// 나간다
		JButton btnExit = new JButton("나간다");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				l.setVisible(true);
			};
		});
		setSize(350, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
