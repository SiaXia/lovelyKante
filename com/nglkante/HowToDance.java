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

public class HowToDance extends JFrame {
	LeisterCity l=new LeisterCity();
	HowToDance() {
		Container c = getContentPane();
		setTitle("´í½º¸¦ ¹è¿ü´Ù!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// »çÁø
		ImageIcon imageIcon = new ImageIcon("images/dancingKante.gif");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);
		
		// ¾È³»¹®
		JLabel info = new JLabel("Ä²Å×´Â ¸°°¡µå¿¡°Ô ´í½º¸¦ ¹è¿ö °Ñ¸ÚÀÌ µé¾ú½À´Ï´Ù.");
		info.setFont(new Font("¸¼Àº°íµñ", Font.PLAIN, 15));
		c.add(info);
		
		// ±×·¡µµ ±Í¿©¿ö
		JButton btnExit = new JButton("±×·¡µµ ±Í¿©¿ö");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("±×·¡µµ ±Í¿©¿ö")) {
					dispose();
					l.c.setVisible(true);
				}
			};
		});
		
		setSize(400, 460);
		setVisible(true);
	}
}