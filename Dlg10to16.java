package calculator;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dlg10to16 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;

	public static void main(String[] args) {
		try {
			Dlg10to16 dialog = new Dlg10to16();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dlg10to16() {
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					converter();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Converting from 10x to 16x system");
		textFieldOutput.setBounds(12, 147, 408, 45);
		textFieldInput.setBounds(12, 23, 408, 45);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInput = new JLabel("Enter a number (in 10x system)");
			lblInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblInput.setBounds(12, 0, 408, 23);
			contentPanel.add(lblInput);
		}
		{
			JLabel lblOutput = new JLabel("Your result (in 16x system)");
			lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOutput.setBounds(12, 126, 408, 23);
			contentPanel.add(lblOutput);
		}
	}

	@Override
	public String converter() throws Exception {
		String string_check = textFieldInput.getText();
		String[] chars_check = string_check.split(""); 
		for (int i = 0; i < chars_check.length; i++) {
			if (Character.isDigit(string_check.charAt(i)) == false && chars_check[i].equals("-") == false)
				throw new Exception("Incorrect input data!");
		}
		int num = Integer.valueOf(textFieldInput.getText());
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
			textFieldOutput.setText(string_num);
		else if (Integer.valueOf(textFieldInput.getText()) < 0) {
			string_num = converterMinus(num);
			textFieldOutput.setText(string_num);
		} else
			textFieldOutput.setText("0");
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
