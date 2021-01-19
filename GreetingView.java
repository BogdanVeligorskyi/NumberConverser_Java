package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// class that shows greeting screen to user
public class GreetingView {

	private JFrame frmV;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GreetingView window = new GreetingView();
					window.frmV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GreetingView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmV = new JFrame();
		frmV.setTitle("Calculator");
		frmV.getContentPane().setForeground(Color.ORANGE);
		frmV.setBounds(100, 100, 450, 300);
		frmV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmV.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transforming number from one system to another");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 38, 408, 57);
		frmV.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainView mainView = new MainView();
			frmV.setVisible(false);
			mainView.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(151, 121, 137, 25);
		frmV.getContentPane().add(btnNewButton);
	}
	
	public JFrame getFrame() {
		return frmV;
	}
}
