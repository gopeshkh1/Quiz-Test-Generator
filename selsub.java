/**selecting database*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class selsub extends scode
{
	JRadioButton logic;
	JRadioButton disco;
	JRadioButton oop;
	JButton proceed;
	ButtonGroup bg;
	
	selsub()
	{
		logic=new JRadioButton(" Logic.txt");
		disco=new JRadioButton(" Disco.txt");
		oop=new JRadioButton(" Oop.txt");
		bg=new ButtonGroup();
		proceed=new JButton("proceed");
		setSize(500,400);
	}
	
	void go()
	{
		
		JLabel ql=new JLabel("Question Bank List:");
		bg.add(logic);
		panel.add(logic);
		bg.add(disco);
		panel.add(disco);
		bg.add(oop);
		panel.add(oop);
		
		panel.add(proceed);
		
		Font font=new Font("serif",Font.PLAIN,20);
		logic.setFont(font);
		disco.setFont(font);
		oop.setFont(font);
		
		ql.setBounds(20,70,400,40);
		logic.setBounds(40,130,150,50);
		disco.setBounds(40,190,150,50);
		oop.setBounds(40,250,150,50);
		proceed.setBounds(200,310,100,40);
		
		proceed.addActionListener(new proceedlistener());
		
		ql.setFont(bigfont);
		panel.add(ql);
	}
	
	class proceedlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(logic.isSelected())
			{
				new_view v=new new_view("logic.txt");
				v.go();
			}
			else if(oop.isSelected())
			{
				new_view v=new new_view("oop.txt");
				v.go();
			}
			else if(disco.isSelected())
			{
				new_view v=new new_view("disco.txt");
				v.go();
			}
			dispose();
		}
	}
		
	public static void main(String[] args)
	{
		selsub sb=new selsub();
		sb.go();
	}
}