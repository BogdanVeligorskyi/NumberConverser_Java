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

public class Dlg10to2 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;
	
	public static void main(String[] args) {
		try {
			Dlg10to2 dialog = new Dlg10to2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dlg10to2() {
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
		setTitle("Converting from 10x to 2x system");
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
			JLabel lblOutput = new JLabel("Your result (in 2x system)");
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
			int bit = num %2;
			num /= 2;
			string_num = String.valueOf(bit) + string_num;
		}
		if (Integer.valueOf(textFieldInput.getText()) < 0) {
			string_num = converterMinus(num);
			textFieldOutput.setText(string_num);
		}
		else if (string_num == "")
			textFieldOutput.setText("0");
		else 
			textFieldOutput.setText(string_num);
		return string_num;
	}
	
	public String converterMinus(int num) {
		String string_num = "";
		int abs_num = Math.abs(num);
		while (abs_num > 0) {
			int bit = abs_num %2;
			abs_num /= 2;
			string_num = String.valueOf(bit) + string_num;
		}
		System.out.println("2): " + string_num);
		String[] string_bits = string_num.split("");
		string_num = "";
		for(String s : string_bits) {
			System.out.println("s: " + s);
			if (s.compareTo("1") == 0)
				s = "0";
			else if (s.compareTo("0") == 0)
				s = "1";
		string_num = string_num + s;
		}
		System.out.println("3) inversed: " + string_num);
		int length = string_num.length();
		String [] arr_string = string_num.split("");
		Integer[] arr_num = new Integer[string_num.length()];
		for (int i = 0; i < arr_num.length; i++) {
			arr_num[i] = Integer.parseInt(arr_string[i]);
		}
		int num_10th = 0;
		for (int j = 0; j < arr_num.length; j++) {
			int product = (int) (arr_num[j] * Math.pow(2, arr_num.length -j -1));
			num_10th = num_10th + product;
		}
		num_10th+=1;
		string_num = "";
		while (num_10th > 0) {
			int bit = num_10th %2;
			num_10th /= 2;
			string_num = String.valueOf(bit) + string_num;
		}
		while (string_num.length() < length) {
			string_num = "0" + string_num;
		}
		System.out.println("4): " + string_num);
		string_num = "1" + string_num;
		return string_num;
	}
	
}
