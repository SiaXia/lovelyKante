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
		// ���̾ƿ�
		setTitle("�Ϳ��� Ĳ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		// ����
		ImageIcon imageIcon = new ImageIcon("images/jeonbuk.gif");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// �ȳ���
		JLabel info = new JLabel("Ĳ�״� ���Ͽ��� �ູ�ϰ� ������Ȱ�� �����߽��ϴ�");
		info.setFont(new Font("�������", Font.BOLD, 23));
		c.add(info);
		JLabel thanks = new JLabel("�÷������ּż� �����մϴ�!");
		thanks.setFont(new Font("�������", Font.BOLD, 15));
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
