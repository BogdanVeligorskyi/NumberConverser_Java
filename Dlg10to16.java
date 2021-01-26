package calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dlg10to16 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg10to16 dialog = new Dlg10to16();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg10to16() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				converter();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Conversion from 10x to 16x system");
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
			JLabel lblYourResultin = new JLabel("Your result (in 16x system)");
			lblYourResultin.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblYourResultin.setBounds(12, 126, 408, 23);
			contentPanel.add(lblYourResultin);
		}
	}

	@Override
	public String converter() {
		int num = Integer.valueOf(textField.getText());
		String string_num = "";
		while (num > 0) {
			int bit = num % 16;
			String bit_string = String.valueOf(bit);
			num /= 16;
			switch (bit) {
				case 10: bit_string = "A";
				break;
				case 11: bit_string = "B";
				break;
				case 12: bit_string = "C";
				break;
				case 13: bit_string = "D";
				break;
				case 14: bit_string = "E";
				break;
				case 15: bit_string = "F";
				break;
			}
			string_num = bit_string + string_num;
		}
		if (string_num.equals("") == false)
			textField_1.setText(string_num);
		else if (Integer.valueOf(textField.getText()) < 0) {
			string_num = converterMinus(num);
			textField_1.setText(string_num);
		} else
			textField_1.setText("0");
		return string_num;
	}

	private String converterMinus(int num) {
		String string_num = "";
		double log = (Math.log10(Math.abs(num)) / Math.log10(16.0));
		double n = Math.ceil(log);
		int num10th = (int) (Math.pow(16.0, n) - Math.abs(num));
		while (num10th > 0) {
			int bit = num10th % 16;
			String bit_string = String.valueOf(bit);
			num10th /= 16;
			switch (bit) {
				case 10: bit_string = "A";
				break;
				case 11: bit_string = "B";
				break;
				case 12: bit_string = "C";
				break;
				case 13: bit_string = "D";
				break;
				case 14: bit_string = "E";
				break;
				case 15: bit_string = "F";
				break;
			}
			string_num = bit_string + string_num;
		}
		string_num = "F" + string_num;
		return string_num;	
	}

}
