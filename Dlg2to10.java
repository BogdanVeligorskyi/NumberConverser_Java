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

// class, which converts 2x number to 10x
public class Dlg2to10 extends DlgType {

	private final JPanel contentPanel = super.contentPanel;

	public static void main(String[] args) {
		try {
			Dlg2to10 dialog = new Dlg2to10();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dlg2to10() {
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
		setTitle("Converting from 2x to 10x system");
		textFieldOutput.setBounds(12, 147, 408, 45);
		textFieldInput.setBounds(12, 23, 408, 45);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblInput = new JLabel("Enter a number (in 2x system)");
			lblInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblInput.setBounds(12, 0, 408, 23);
			contentPanel.add(lblInput);
		}
		{
			JLabel lblOutput = new JLabel("Your result (in 10x system)");
			lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOutput.setBounds(12, 126, 408, 23);
			contentPanel.add(lblOutput);
		}
	}

	// converter for positive numbers and "0"
	@Override
	public String converter() throws Exception {
		String num_string = textFieldInput.getText();
		String[] arr_string = num_string.split("");
		for (int i = 0; i < arr_string.length; i++) {
			System.out.println(arr_string[i]);
			if (arr_string[i].equals("1") == false && arr_string[i].equals("0") == false)
				throw new Exception("Incorrect input data!");
		}
		Integer[] arr_num = new Integer[num_string.length()];
		for (int i = 0; i < arr_num.length; i++) {
			arr_num[i] = Integer.parseInt(arr_string[i]);
		}
		int num = 0;
		for (int j = 0; j < arr_num.length; j++) {
			int product = (int) (arr_num[j] * Math.pow(2, arr_num.length - j - 1));
			num = num + product;
		}
		textFieldOutput.setText(String.valueOf(num));
		return String.valueOf(num);
	}

}
