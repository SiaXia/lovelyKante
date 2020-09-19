package com.nglkante;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
	private Container c=getContentPane();
	
	public Main(){
		// ���̾ƿ�
		setTitle("����ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
				
		c.setLayout(new FlowLayout());
		
		// ����
		JLabel youth = new JLabel("��������");
		youth.setFont(new Font("�������", Font.BOLD, 30));
		c.add(youth);
		
		// �ȳ���
		JLabel info = new JLabel("�޿� 100��, �Ƿ� 10 �̻� �����ܰ�");
		info.setFont(new Font("�������", Font.PLAIN, 15));
		c.add(info);
		
		// ����
		ImageIcon[] startIcon = {
				new ImageIcon("images/youth.jpg")};
		JLabel imageLabel=new JLabel(startIcon[0]);
		c.add(imageLabel);
		
		Status s=new Status();
		
		// �޿�
		JLabel salary = new JLabel("�޿�: 0��");
		c.add(salary);
		
		// �Ƿ�
		JLabel skill = new JLabel("�Ƿ�: 0");
		c.add(skill);
		
		// ������
		JButton btnMatch = new JButton("������");
		btnMatch.setLocation(450,100);
			c.add(btnMatch);
			btnMatch.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton b=(JButton)e.getSource();
					if(b.getText().equals("������")) {
						s.AddSalary();
						salary.setText("�޿�: "+s.salary()+"��");
					}
				};
			});
				
		// �Ʒ�
		JButton btnTraining = new JButton("�Ʒ�");
		btnTraining.setLocation(450,100);
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(b.getText().equals("�Ʒ�")) {
					if(s.tranning()) {
						skill.setText("�Ƿ�: "+s.skill());
					}
				}
			};
		});
		
		setSize(450,600);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Start();
	}
}