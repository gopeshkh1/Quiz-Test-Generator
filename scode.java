/**used to shorten code*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class scode extends JFrame
{
	JPanel panel;
	static Font bigfont;
	
	scode()
	{
		panel=new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700,500);
		bigfont=new Font("serif",Font.BOLD,24);
	}
}