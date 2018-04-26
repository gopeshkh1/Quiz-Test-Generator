/**modify fib and true and false modifyfib(file,index,quesset)*/
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class modifyfib extends scode
{
	JButton ok;
	JTextArea question;
	JTextArea answer;
	File file;
	int i;
	ArrayList<String[]> quesset;
	String []st;
	
	modifyfib(File f,int index,ArrayList<String[]> qlist)
	{
		quesset=qlist;
		i=index;
		file=f;
		ok=new JButton("OK");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		st=quesset.get(i);
		
		if(st.length==2)
		{	
			question=new JTextArea(st[0]);
			answer=new JTextArea(st[1]);
		}
		
		else
		{
			question=new JTextArea(st[0]);
			answer=new JTextArea(st[2]);
		}
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
			if((!ques.equals(""))&&(!ans.equals("")))
			{
				if(st.length==2)
				{	
					String [] s={ques,ans};
					quesset.set(i,s);
				}
				else
				{
					String [] s={ques,st[1],ans};
					quesset.set(i,s);
				}
				lifile.load(quesset,file);
				dispose();
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
	
