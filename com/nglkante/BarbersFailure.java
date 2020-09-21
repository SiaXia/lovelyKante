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

public class BarbersFailure extends JFrame {
	Status s = new Status();

	BarbersFailure() {
		LeisterCity l = new LeisterCity();
		l.setVisible(false);
		
		Container c = getContentPane();
		setTitle("½ÇÆÐ...");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// »çÁø
		ImageIcon imageIcon = new ImageIcon("images/barbersFailure.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// ¾È³»¹®
		JLabel info = new JLabel("         Ä²Å×´Â ¸Ó¸®°¡ ¸¶À½¿¡ ¾Èµå´Â°¡ º¾´Ï´Ù        ");
		info.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
		c.add(info);

		// Èþ..
		JButton btnExit = new JButton("Èþ..");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				l.setVisible(true);
				l.refreshSalary();
			};
		});
		setSize(380, 460);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
