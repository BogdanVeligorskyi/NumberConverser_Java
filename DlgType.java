package calculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgType extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JTextField textField_1;
	protected JButton btnNewButton = new JButton("Calculate");
	protected JButton btnOk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgType dialog = new DlgType();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgType() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnNewButton.setBounds(168, 90, 97, 25);
			contentPanel.add(btnNewButton);
		}
		{
			textField = new JTextField();
			textField.setBounds(12, 24, 408, 45);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(12, 144, 408, 45);
			contentPanel.add(textField_1);
		}
		{
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnOk.setBounds(358, 215, 62, 25);
			contentPanel.add(btnOk);
		}
	}
}
