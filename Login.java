package DoAn;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;;

public class Login extends JFrame implements ActionListener{
	JLabel userlb,passlb;
	JTextField user;
	JPasswordField pass;
	JButton savebt,cancelbt;
	
	public Login() {
		Container cont = this.getContentPane();
		cont.setLayout(null);
		
		userlb = new JLabel("Username: ");
		userlb.setBounds(30, 60, 140, 40);
		user = new JTextField();
		user.setBounds(100, 60, 200, 40);
		cont.add(userlb);
		cont.add(user);
		
		passlb = new JLabel("Password: ");
		passlb.setBounds(30, 120, 140, 40);
		pass = new JPasswordField(10);
		pass.setBounds(100, 120, 200, 40);
		cont.add(passlb);
		cont.add(pass);
		
		savebt = new JButton("Save");
		savebt.addActionListener(this);
		savebt.setBounds(30, 200, 80, 40);
		cont.add(savebt);
		cancelbt = new JButton("Cancel");
		cancelbt.addActionListener(this);
		cancelbt.setBounds(210, 200, 90, 40);
		cont.add(cancelbt);
		
		this.setVisible(true);
		this.setSize(350,300);
		this.setLocation(500,450);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == savebt) {
			/*Neu user hoac pass chua nhap thi bao loi*/
			if(user.getText().equals("")) {
				JOptionPane.showMessageDialog(Login.this, "Nhap User","ERROR!",JOptionPane.ERROR_MESSAGE);
			} else if(pass.equals("")) {
				JOptionPane.showMessageDialog(Login.this, "Nhap password","ERROR!",JOptionPane.ERROR_MESSAGE);
			} else {
				this.dispose();
			}
		}
		if(e.getSource() == cancelbt) {
			this.dispose();
		}
	}
	
	
	public static void main(String[] args) {
		new Login();
	}
}
