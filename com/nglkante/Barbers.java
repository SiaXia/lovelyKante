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
import javax.swing.JOptionPane;

public class Barbers extends JFrame {
	private Random rand = new Random();

	Barbers() {
		// ���̾ƿ�
		Status s = new Status();
		Container c = getContentPane();
		setTitle("�̿�ǿ� �� Ĳ���");
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);

		JLabel barbers = new JLabel("�̿��");
		barbers.setFont(new Font("�������", Font.BOLD, 20));
		c.add(barbers);
		// ����
		ImageIcon imageIcon = new ImageIcon("images/barbers.jpg");
		JLabel imageLabel = new JLabel(imageIcon);
		c.add(imageLabel);

		// �ȳ���
		JLabel info = new JLabel("-�̿�ǿ� �� Ĳ�״� �Ӹ��� �ڸ��� �մϴ�-");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);
		JLabel info2 = new JLabel("����� 10���Դϴ�.");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info2);

		// �ڸ���
		JButton btnCut = new JButton("�ڸ���");
		c.add(btnCut);
		btnCut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("�ڸ���")) {
					s.SubSalary(10);
					dispose();
					int r = rand.nextInt(2);
					if (r == 0)
						new BarbersSuccess();
					else
						new BarbersFailure();
				}
			};
		});

		// ������
		JButton btnExit = new JButton("������");
		c.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if (b.getText().equals("������")) {
					dispose();
				}
			};
		});
		setSize(350, 500);
		setVisible(true);
	}
}
