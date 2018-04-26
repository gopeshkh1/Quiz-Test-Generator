import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sbcode extends JFrame
{
	JPanel panel;
	static Font bigfont;
	
	sbcode()
	{
		panel=new JPanel();
		getContentPane().add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		bigfont=new Font("serif",Font.BOLD,24);
	}
}