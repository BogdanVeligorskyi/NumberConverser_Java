package calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Dlg10to8 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg10to8 dialog = new Dlg10to8();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg10to8() {
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Conversion from 10x to 8x system");
		textField_1.setBounds(12, 147, 408, 45);
		textField.setBounds(12, 23, 408, 45);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Enter a number (in 10x system)");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(12, 0, 408, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblYourResultin = new JLabel("Your result (in 8x system)");
			lblYourResultin.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblYourResultin.setBounds(12, 126, 408, 23);
			contentPanel.add(lblYourResultin);
		}
	}

}
