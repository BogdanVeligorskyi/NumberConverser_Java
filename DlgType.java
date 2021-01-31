package calculator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public abstract class DlgType extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldInput;
	protected JTextField textFieldOutput;
	protected JButton btnConvert = new JButton("Convert");
	protected JButton btnOk;
	
	public DlgType() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnConvert.setBounds(168, 90, 97, 25);
			contentPanel.add(btnConvert);
		}
		{
			textFieldInput = new JTextField();
			textFieldInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldInput.setBounds(12, 24, 408, 45);
			contentPanel.add(textFieldInput);
			textFieldInput.setColumns(10);
		}
		{
			textFieldOutput = new JTextField();
			textFieldOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textFieldOutput.setColumns(10);
			textFieldOutput.setBounds(12, 144, 408, 45);
			contentPanel.add(textFieldOutput);
		}
		{
			btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnOk.setBounds(358, 215, 62, 25);
			contentPanel.add(btnOk);
		}
	}
	
	public abstract String converter() throws Exception;
}
