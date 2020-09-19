package com.nglkante;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
	private Container c=getContentPane();
	
	public Main(){
		// 레이아웃
		setTitle("메인화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
				
		c.setLayout(new FlowLayout());
		
		// 제목
		JLabel youth = new JLabel("유스시절");
		youth.setFont(new Font("맑은고딕", Font.BOLD, 30));
		c.add(youth);
		
		// 안내문
		JLabel info = new JLabel("급여 100￡, 실력 10 이상 다음단계");
		info.setFont(new Font("맑은고딕", Font.PLAIN, 15));
		c.add(info);
		
		// 사진
		ImageIcon[] startIcon = {
				new ImageIcon("images/youth.jpg")};
		JLabel imageLabel=new JLabel(startIcon[0]);
		c.add(imageLabel);
		
		Status s=new Status();
		
		// 급여
		JLabel salary = new JLabel("급여: 0￡");
		c.add(salary);
		
		// 실력
		JLabel skill = new JLabel("실력: 0");
		c.add(skill);
		
		// 시즌경기
		JButton btnMatch = new JButton("시즌경기");
		btnMatch.setLocation(450,100);
			c.add(btnMatch);
			btnMatch.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton b=(JButton)e.getSource();
					if(b.getText().equals("시즌경기")) {
						s.AddSalary();
						salary.setText("급여: "+s.salary()+"￡");
					}
				};
			});
				
		// 훈련
		JButton btnTraining = new JButton("훈련");
		btnTraining.setLocation(450,100);
		c.add(btnTraining);
		btnTraining.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(b.getText().equals("훈련")) {
					if(s.tranning()) {
						skill.setText("실력: "+s.skill());
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