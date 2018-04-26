import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class login extends scode
{
	JTextField user;
	JPasswordField password;
	JButton login;
	login()
	{
		setSize(400,250);
		user=new JTextField(150);
		password=new JPasswordField(150);
		login=new JButton("LOGIN");
	}
	
	public void go()
	{
		panel.add(login);
		login.setBounds(250,150,100,20);
		
		JLabel uname=new JLabel("USERNAME:");
		panel.add(uname);
		uname.setBounds(20,20,100,20);
		panel.add(user);
		user.setBounds(150,20,150,20);
		
		JLabel pass=new JLabel("PASSWORD:");
		panel.add(pass);
		pass.setBounds(20,60,100,20);
		panel.add(password);
		password.setBounds(150,60,150,20);
		
		System.out.println(user.getText());
		System.out.println(password.getPassword());
		
		login.addActionListener(new loginlistener());
	}
	
	class loginlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String us=user.getText();
			char[] p=password.getPassword();
			String ps=new String(p);
			if((us.equals("gopesh")) && (ps.equals("123")))
			{
				JOptionPane.showMessageDialog(null,"login sucessfull","welcome",JOptionPane.INFORMATION_MESSAGE);
				selsub sb=new selsub();
				sb.go();
				dispose();
			}
			else
				JOptionPane.showMessageDialog(null,"invalid username or password","login failed",JOptionPane.INFORMATION_MESSAGE);
			
			
		}
	}
	public static void main(String[] args)
	{
		login lg=new login();
		lg.go();
		
	}
}
	