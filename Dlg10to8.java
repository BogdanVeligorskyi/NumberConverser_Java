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

// class, which converts 10x number to 8x
public class Dlg10to8 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;

	public static void main(String[] args) {
		try {
			Dlg10to8 dialog = new Dlg10to8();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dlg10to8() {
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
		setTitle("Converting from 10x to 8x system");
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
			JLabel lblOutput = new JLabel("Your result (in 8x system)");
			lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOutput.setBounds(12, 126, 408, 23);
			contentPanel.add(lblOutput);
		}
	}

	// converter for positive numbers and "0"
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
			int bit = num % 8;
			num /= 8;
			string_num = String.valueOf(bit) + string_num;
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

	// converter for negative numbers
	private String converterMinus(int num) {
		String string_num = "";
		double log = (Math.log10(Math.abs(num)) / Math.log10(8.0));
		double n = Math.ceil(log);
		int num10th = (int) (Math.pow(8.0, n) - Math.abs(num));
		while (num10th > 0) {
			int bit = num10th % 8;
			String bit_string = String.valueOf(bit);
			num10th /= 8;
			string_num = bit_string + string_num;
		}
		string_num = "7" + string_num;
		return string_num;
	}

}
