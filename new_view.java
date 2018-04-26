import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;

public class new_view extends scode
{
	public static void main(String[] args)
	{
		new_view view=new new_view("question.txt");
		view.go();
	}
	JButton prev;
	JButton generate;
	JButton modify;
	JButton add;
	JButton delete;
	ArrayList<String[]> quesset;
	Choice qchoice;
	JTextField qno;
	JTextField geno;
	Choice tchoice;
	File file;
	JButton view;
	new_view(String s)
	{
		prev=new JButton("<<");
		view=new JButton("View");	
		qno=new JTextField();
		geno=new JTextField();
		tchoice=new Choice();
		file=new File(s);
		modify=new JButton("modify");
		add=new JButton("add");
		delete=new JButton("delete");
		quesset=new ArrayList<String[]>();
		generate=new JButton("generate");
	}
	void go()
	{

		
		try
		{
			BufferedReader reader=new BufferedReader(new FileReader(file));
			
			String line=null;
			while((line=reader.readLine())!=null)
				quesset.add(line.split("/"));
			reader.close();
		}
		catch(IOException e){}
		
		setSize(450,450);
		Font font=new Font("serif",Font.BOLD,20);
		
		tchoice.add("true/false");
		tchoice.add("fill in the blanks");
		tchoice.add("multiple choice");
		JLabel ql=new JLabel("Q.NO. TO EDIT:");
		JLabel tl=new JLabel("TYPE TO ADD:");
		JLabel gl=new JLabel("NO. OF QUESTION TO GENERATE:");
		
		view.setFont(font);
		ql.setFont(font);
		tl.setFont(font);
		gl.setFont(font);
		
		tl.setBounds(10,30,200,40);
		tchoice.setBounds(10,90,100,40);
		add.setBounds(150,80,100,30);
		
		ql.setBounds(10,130,200,40);
		qno.setBounds(10,190,100,20);
		modify.setBounds(250,180,100,30);
		delete.setBounds(150,180,100,30);
		
		gl.setBounds(10,240,400,40);
		geno.setBounds(10,300,100,20);
		generate.setBounds(150,290,100,30);
	
		view.setBounds(20,360,80,30);
		prev.setBounds(10,0,50,20);
		panel.add(prev);
		panel.add(ql);
		panel.add(qno);
		panel.add(modify);
		panel.add(delete);
		panel.add(tl);
		panel.add(tchoice);
		panel.add(add);
		panel.add(gl);
		panel.add(geno);
		panel.add(generate);
		panel.add(view);
   
		prev.addActionListener(new prevlistener());
		modify.addActionListener(new modifylistener());
		add.addActionListener(new addlistener());
		delete.addActionListener(new deletelistener());
		generate.addActionListener(new generatelistener());
		view.addActionListener(new viewlistener());
	}
	class addlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			if(tchoice.getSelectedIndex()<2)
			{
				fibadd fa=new fibadd(file,tchoice.getSelectedIndex(),quesset);
				fa.go();
			}
			
			else
			{
				mcqadd mcq=new mcqadd(file,quesset);
				mcq.go();
			}
		
		}
		
	}
	
	class generatelistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{ 
			try
			{
				int i=Integer.parseInt(geno.getText());
				
				if(i==0)
					JOptionPane.showMessageDialog(null,"sorry we can't generate zero question","oops!!",JOptionPane.INFORMATION_MESSAGE);
				
				else if(i<=quesset.size())
				{
					generator gen=new generator(quesset,i);
					gen.go();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"sorry we have less question","oops!!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"sorry wrong argument","oops!!",JOptionPane.INFORMATION_MESSAGE);
			}
			geno.setText("");
		}
	}
		
	class modifylistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				int i=Integer.parseInt(qno.getText());
				
				if(i<=quesset.size())
				{
					String[] s=quesset.get(i-1);
					if((s[1].charAt(0)=='~') || (s.length==2))
					{
						modifyfib mf=new modifyfib(file,i-1,quesset);
						mf.go();
					}
					else
					{
						modifymcq mq=new modifymcq(file,i-1,quesset);
						mq.go();
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"sorry we have less question","oops!!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"sorry wrong argument","oops!!",JOptionPane.INFORMATION_MESSAGE);
			}
			qno.setText("");
			
		}
	}
	
	class deletelistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				int i=Integer.parseInt(qno.getText());
				if((i<=quesset.size()))
				{
					quesset.remove(i-1);
					lifile.load(quesset,file);
				}
				else{
					JOptionPane.showMessageDialog(null,"sorry we have less question","oops!!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null,"sorry wrong argument","oops!!",JOptionPane.INFORMATION_MESSAGE);
			}
			qno.setText("");
		}
	}
	
	class viewlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			tloader v=new tloader(quesset);
			v.go();
		}
	}
	class prevlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			selsub ss=new selsub();
			ss.go();
			dispose();
		}
	}
}
			
			
		