package converter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// class with opportunity to choose needed operation
public class MainView {

	private JFrame frame;
	private GreetingView greetingView = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Number converter");
		frame.getContentPane().setForeground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.ORANGE);

		JButton btn10to2 = new JButton("10 to 2");
		btn10to2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn10to2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlg10to2 dialog = new Dlg10to2();
				dialog.setVisible(true);
			}
		});
		btn10to2.setBounds(12, 136, 97, 25);
		frame.getContentPane().add(btn10to2);

		JButton btn10to8 = new JButton("10 to 8");
		btn10to8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn10to8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlg10to8 dialog = new Dlg10to8();
				dialog.setVisible(true);
			}
		});
		btn10to8.setBounds(110, 136, 97, 25);
		frame.getContentPane().add(btn10to8);

		JButton btn10to16 = new JButton("10 to 16");
		btn10to16.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn10to16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlg10to16 dialog = new Dlg10to16();
				dialog.setVisible(true);
			}
		});
		btn10to16.setBounds(208, 136, 97, 25);
		frame.getContentPane().add(btn10to16);

		JButton btn2to10 = new JButton("2 to 10");
		btn2to10.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn2to10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlg2to10 dialog = new Dlg2to10();
				dialog.setVisible(true);
			}
		});
		btn2to10.setBounds(307, 136, 97, 25);
		frame.getContentPane().add(btn2to10);

		JLabel lblMain = new JLabel("Choose your task");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMain.setBounds(12, 47, 408, 31);
		frame.getContentPane().add(lblMain);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				greetingView = new GreetingView();
				greetingView.getFrame().setVisible(true);
			}
		});
		btnBack.setBounds(161, 196, 97, 25);
		frame.getContentPane().add(btnBack);
	}

	public JFrame getFrame() {
		return frame;
	}

}
