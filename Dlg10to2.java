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

public class Dlg10to2 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlg10to2 dialog = new Dlg10to2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlg10to2() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			converter();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		setTitle("Conversion from 10x to 2x system");
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
			JLabel lblYourResultin = new JLabel("Your result (in 2x system)");
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
			int bit = num %2;
			num /= 2;
			string_num = String.valueOf(bit) + string_num;
		}
		if (Integer.valueOf(textField.getText()) < 0) {
			string_num = converterMinus(num);
			textField_1.setText(string_num);
		}
		else if (string_num == "")
			textField_1.setText("0");
		else 
			textField_1.setText(string_num);
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
