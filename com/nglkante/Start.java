package com.nglkante;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends JFrame{
	private Container c=getContentPane();
	
	// ����
	public JFrame frame=new JFrame();
	private ImageIcon[] startIcon = {
			new ImageIcon("images/start.jpg"),
			new ImageIcon("images/pressed.jpg")};
	private JLabel imageLabel=new JLabel(startIcon[0]);
	
	public Start() {
		c.addMouseListener(new StartML());
		
		// ���̾ƿ�
		setTitle("����ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setLayout(new FlowLayout());
		c.setBackground(Color.WHITE);
		
		// ����
		ImageIcon title =new ImageIcon("images/title.jpg");
		JLabel titleLabel=new JLabel(title);
		c.add(titleLabel);
		c.add(imageLabel);

		// �ȳ���
		JLabel textLabel=new JLabel("�����Ϸ��� Ĳ�׸� �ٿ� �����ּ���");
		textLabel.setFont(new Font("�޸ո���ü",Font.PLAIN, 20));
		c.add(textLabel);
		
		setSize(450,600);
		setVisible(true);
	}
		class StartML implements MouseListener{
			@Override
			public void mousePressed(MouseEvent e) {
				imageLabel.setIcon(startIcon[1]);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				setVisible(false);
				new Main();
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}
}
