package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frmCalculator;
	private GreetingView greetingView = null;
	private MainView mainView = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.getContentPane().setForeground(Color.ORANGE);
		frmCalculator.setBounds(100, 100, 450, 300);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("10 to 2");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dlg10to2 dialog = new Dlg10to2();
			dialog.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 136, 97, 25);
		frmCalculator.getContentPane().add(btnNewButton);
		
		JButton btnTo = new JButton("10 to 8");
		btnTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dlg10to8 dialog = new Dlg10to8();
			dialog.setVisible(true);
			}
		});
		btnTo.setBounds(110, 136, 97, 25);
		frmCalculator.getContentPane().add(btnTo);
		
		JButton btnTo_1 = new JButton("10 to 16");
		btnTo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dlg10to16 dialog = new Dlg10to16();
			dialog.setVisible(true);
			}
		});
		btnTo_1.setBounds(208, 136, 97, 25);
		frmCalculator.getContentPane().add(btnTo_1);
		
		JButton btnTo_2 = new JButton("2 to 10");
		btnTo_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTo_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Dlg2to10 dialog = new Dlg2to10();
			dialog.setVisible(true);
			}
		});
		btnTo_2.setBounds(307, 136, 97, 25);
		frmCalculator.getContentPane().add(btnTo_2);
		
		JLabel lblNewLabel = new JLabel("Choose your task");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 47, 408, 31);
		frmCalculator.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			mainView = new MainView();
			mainView.getFrame().setVisible(false);
			greetingView = new GreetingView();
			greetingView.getFrame().setVisible(true);
			}
		});
		btnBack.setBounds(161, 196, 97, 25);
		frmCalculator.getContentPane().add(btnBack);
	}
	
	public JFrame getFrame() {
		return frmCalculator;
	}

}
