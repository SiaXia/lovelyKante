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

public class Ending extends JFrame {
	Container c = getContentPane();

	Ending() {
		// 레이아웃
		setTitle("귀여운 캉요미");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// 사진
		ImageIcon imageIcon = new ImageIcon("images/jeonbuk.gif");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// 안내문
		JLabel info = new JLabel("캉테는 전북에서 행복하게 선수생활을 마감했습니다");
		info.setFont(new Font("맑은고딕", Font.BOLD, 23));
		c.add(info);
		JLabel thanks = new JLabel("플레이해주셔서 감사합니다!");
		thanks.setFont(new Font("맑은고딕", Font.BOLD, 15));
		c.add(thanks);

		// gg
		JButton btnExit = new JButton("Game Over");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("Game Over")) {
					System.exit(0);
				}
			};
		});

		setSize(630, 480);
		setVisible(true);
	}
}
