package graphics;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class Loggin extends JPanel {
	private JTextField textField;
	private JLabel textLoggin;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Loggin() {
		setLayout(null);
		setBounds(0,0,400,200);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buttonClicked(textField, passwordField))
					printText("Correcto");
				else
					printText("Error");
				
			}
		});
		btnNewButton.setBounds(168, 140, 173, 39);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(168, 53, 173, 33);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 96, 173, 33);
		add(passwordField);
		
		textLoggin = new JLabel();
		textLoggin.setBounds(168, 189, 173, 33);
		add(textLoggin);

	}
	
	private boolean buttonClicked (JTextField textField, JPasswordField passwordField) {
		Scanner br = null;
		try {
			br = new Scanner(new File("Loggins/loggin.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (br.hasNext()) {
			String line = br.nextLine();
			String[] usus = line.split(" ");
			System.out.println("usu: " + usus[0] + " con p: " + usus[1]);
			if (textField.getText().equals(usus[0]) && passwordField.getText().equals(usus[1]))
				return true;
		}
		return false;
	}
	
	private void printText(String text) {
		textLoggin.setText(text);
	}
}
