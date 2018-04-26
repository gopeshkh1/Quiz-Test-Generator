import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

class modifymcq extends scode
{	
	JButton ok;
	JTextField op1;
	JTextField op2;
	JTextField op3;
	JTextField op4;
	JTextArea question;
	JTextArea answer;
	File file;
	int i;
	ArrayList<String[]> quesset;
	String []st;
	
	modifymcq(File f,int index,ArrayList<String[]> qlist)
	{
		quesset=qlist;
		i=index;
		file=f;
		ok=new JButton("OK");
		st=quesset.get(i);
		String []s=st[1].split("\\s{3,}");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		question=new JTextArea(st[0]);
		op1=new JTextField(s[0]);
		op2=new JTextField(s[1]);
		op3=new JTextField(s[2]);
		op4=new JTextField(s[3]);
		answer=new JTextArea(st[2]);
		
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
		
		JLabel ol1=new JLabel("a.)");
		JLabel ol2=new JLabel("b.)");
		JLabel ol3=new JLabel("c.)");
		JLabel ol4=new JLabel("d.)");

		ol1.setBounds(0,180,20,20);
		ol2.setBounds(0,200,20,20);
		ol3.setBounds(0,220,20,20);
		ol4.setBounds(0,240,20,20);
		
		panel.add(ol1);
		panel.add(ol2);
		panel.add(ol3);
		panel.add(ol4);
		
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
			
			
			if((!o1.equals("")) &&(!o2.equals("")) &&(!o3.equals(""))&&(!o4.equals(""))&&(!ans.equals(""))&&(!ques.equals("")))
			{
				if((!o1.equals(o2))&&(!o1.equals(o3))&&(!o1.equals(o4))&&(!o2.equals(o3))&&(!o2.equals(o4))&&(!o3.equals(o4)))
				{
				if((ans.equals(o1))||(ans.equals(o2))||(ans.equals(o3))||(ans.equals(o4)))
				{
				String [] s={ques,o1+"   "+o2+"   "+o3+"   "+o4,ans};
				quesset.set(i,s);
			
				lifile.load(quesset,file);
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
	
	/*public static void main(String[] args)
	{
		File f=new File("logic.txt");
		modifymcq mm=new modifymcq(f,0,load.getlist(f));
	}*/
}