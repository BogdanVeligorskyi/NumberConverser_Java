package calculator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// class that shows greeting screen to user
public class GreetingView {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GreetingView window = new GreetingView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GreetingView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Number converter");
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMain = new JLabel("Number converter from one system to another");
		lblMain.setForeground(Color.BLUE);
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMain.setBounds(12, 38, 408, 57);
		frame.getContentPane().add(lblMain);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mainView = new MainView();
				frame.setVisible(false);
				mainView.getFrame().setVisible(true);
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnStart.setBounds(151, 121, 137, 25);
		frame.getContentPane().add(btnStart);

		JLabel lblAuthor = new JLabel("2021. Bogdan Veligorskyi");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAuthor.setBounds(12, 184, 408, 33);
		frame.getContentPane().add(lblAuthor);
	}

	public JFrame getFrame() {
		return frame;
	}
}
