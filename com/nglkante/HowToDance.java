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


	HowToDance() {
		Chelsea ch = new Chelsea();
		ch.setVisible(false);
		
		Container c = getContentPane();
		setTitle("������ �����!");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/dancingKante.gif");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// �ȳ���
		JLabel info = new JLabel("     Ĳ�״� �����忡�� ������ ��� �Ѹ��� ������ϴ�.     ");
		info.setFont(new Font("��������", Font.PLAIN, 15));
		c.add(info);

		// �׷��� �Ϳ���
		JButton btnExit = new JButton("�׷��� �Ϳ���");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ch.setVisible(true);
			};
		});
		setSize(480, 380);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}