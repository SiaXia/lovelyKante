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
	LeisterCity l=new LeisterCity();
	BarbersFailure() {
		Container c = getContentPane();
		setTitle("����...");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/barbersFailure.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);
		
		// �ȳ���
		JLabel info = new JLabel("     Ĳ�״� �Ӹ��� ������ �ȵ�°� ���ϴ�     ");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);
		
		// ��..
		JButton btnExit = new JButton("��..");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("��..")) {
					dispose();
					l.c.setVisible(true);
				}
			};
		});
		
		setSize(350, 460);
		setVisible(true);
	}
}
