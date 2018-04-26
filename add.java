/**contains two class fibadd for true and false(file,flag=0 t/f,) and mcqadd(file)*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class fibadd extends scode
{
	
	JButton ok;
	JTextArea question;
	JTextArea answer;
	File file;
	int flag;
	ArrayList<String[]> quesset;
	
	fibadd(File f,int i,ArrayList<String[]> qset)
	{
		quesset=qset;
		flag=i;
		file=f;
		ok=new JButton("OK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		question=new JTextArea();
		answer=new JTextArea();
	}
	
	public void go()
	{
		
		JLabel qlabel=new JLabel("QUESTION");
		qlabel.setFont(bigfont);
		qlabel.setBounds(0,0,150,30);
		panel.add(qlabel);
		
		panel.add(question);
		question.setBounds(0,40,700,80);
		JLabel alabel=new JLabel("ANSWER");
		alabel.setFont(bigfont);
		alabel.setBounds(0,150,150,30);
		panel.add(alabel);
		answer.setBounds(0,190,700,80);
		panel.add(answer);
		ok.setBounds(0,350,100,30);
		panel.add(ok);
		
		ok.addActionListener(new oklistener());
	}
	
	class oklistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String ques=question.getText();
			String ans=answer.getText();
			if((!ques.equals("")) && (!ans.equals("")))
			{
				
				try
				{
					BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
					if(flag==1)
					{
						bw.write(question.getText()+"/"+answer.getText());
						String [] s={question.getText(),answer.getText()};
						quesset.add(s);
						bw.newLine();
						bw.close();
						dispose();
					}
					else
					{
						if(answer.getText().equals("true")||answer.getText().equals("false"))
						{
							bw.write(question.getText()+"/~true   false/"+answer.getText());
							String [] s={question.getText(),"~true   false",answer.getText()};
							quesset.add(s);
							bw.newLine();
							bw.close();
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"answer should be either true or false","oops!!",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				
					
				}
				catch(IOException ex){}
				
			}
			else
				JOptionPane.showMessageDialog(null,"text area left blank","oops!!",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/*public static void main(String[] args)
	{
		File f=new File("question.txt");
		fibadd fa=new fibadd(f,0);
		fa.go();
	}*/
}

class mcqadd extends scode
{
	JButton ok;
	JTextField op1;
	JTextField op2;
	JTextField op3;
	JTextField op4;
	JTextArea question;
	JTextArea answer;
	File file;
	ArrayList<String[]> quesset;
	
	mcqadd(File f,ArrayList<String[]> qset)
	{
		file=f;
		ok=new JButton("OK");
		quesset=qset;
		question=new JTextArea();
		op1=new JTextField();
		op2=new JTextField();
		op3=new JTextField();
		op4=new JTextField();
		answer=new JTextArea();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void go()
	{
		
		JLabel qlabel=new JLabel("QUESTION");
		qlabel.setFont(bigfont);
		qlabel.setBounds(0,0,150,30);
		panel.add(qlabel);
		
		panel.add(question);
		question.setBounds(0,40,700,80);
		JLabel olabel=new JLabel("options");
		olabel.setFont(bigfont);
		olabel.setBounds(0,140,150,30);
		panel.add(olabel);
		panel.add(op1);
		panel.add(op2);
		panel.add(op3);
		panel.add(op4);

		JLabel o1=new JLabel("a.)");
		JLabel o2=new JLabel("b.)");
		JLabel o3=new JLabel("c.)");
		JLabel o4=new JLabel("d.)");
		panel.add(o1);
		panel.add(o2);
		panel.add(o3);
		panel.add(o4);		
		
		o1.setBounds(0,180,20,20);
		o2.setBounds(0,200,20,20);
		o3.setBounds(0,220,20,20);
		o4.setBounds(0,240,20,20);
		
		op1.setBounds(20,180,300,20);
		op2.setBounds(20,200,300,20);
		op3.setBounds(20,220,300,20);
		op4.setBounds(20,240,300,20);
		
		JLabel alabel=new JLabel("ANSWER");
		alabel.setFont(bigfont);
		alabel.setBounds(0,280,150,30);
		panel.add(alabel);
		answer.setBounds(0,320,700,80);
		panel.add(answer);
		ok.setBounds(0,420,100,30);
		panel.add(ok);
		
		ok.addActionListener(new oklistener());
	}
	
	class oklistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			String o1=op1.getText();
			String o2=op2.getText();
			String o3=op3.getText();
			String o4=op4.getText();
			String ans=answer.getText();
			String ques=question.getText();
			if((!ans.equals(""))&&(!o1.equals(""))&&(!o2.equals(""))&&(!o3.equals(""))&&(!o4.equals(""))&&(!ques.equals("")))
			{
				if((!o1.equals(o2))&&(!o1.equals(o3))&&(!o1.equals(o4))&&(!o2.equals(o3))&&(!o2.equals(o4))&&(!o3.equals(o4)))
				{
				if((ans.equals(o1))||(ans.equals(o2))||(ans.equals(o3))||(ans.equals(o4)))
				{
				
				try
				{
					BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
					bw.write(ques+"/"+o1+"   "+o2+"   "+o3+"   "+o4+"/"+ans);
					bw.newLine();
					bw.close();
				
		
					String [] s={question.getText(),op1.getText()+"   "+op2.getText()+"   "+op3.getText()+"   "+op4.getText(),answer.getText()};
					quesset.add(s);
				}
				catch(IOException ex){}
				dispose();}
				else
				{
					JOptionPane.showMessageDialog(null,"answer is not matching any options","oops!!",JOptionPane.INFORMATION_MESSAGE);
				}
				}
				else
					JOptionPane.showMessageDialog(null,"same options","oops!!",JOptionPane.INFORMATION_MESSAGE);
			}
			
			else
					JOptionPane.showMessageDialog(null,"text area left blank","oops!!",JOptionPane.INFORMATION_MESSAGE);

		}
	}
	
/*	public static void main(String[] args)
	{
		File f=new File("question.txt");
		mcqadd fa=new mcqadd(f);
		fa.go();
	}*/
}