/**generate qp generator(quesset,no)*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class generator extends scode
{
	
	JButton export;
	ArrayList<String[]> quesset;
	ArrayList<String[]> qlist;
	int no;
	generator (ArrayList<String[]> list,int n)
	{
		no=n;
		quesset=list;
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		export=new JButton("export");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,300);
	}
	
	void go()
	{
		qlist=generate(no);
		
		int j=0;
		for(String[] s:qlist)
		{
			
			j++;
			JLabel q=new JLabel("Q"+j+".)"+s[0]);
			panel.add(q);
			
			if(s.length==3)
			{
				String[] st=s[1].split("\\s{3,}");
				
				for(int i=0;i<st.length;i++)
				{
					int k=i+1;
					JLabel l=new JLabel("    ("+k+".)"+st[i]);
					panel.add(l);
				}
			}
		}
		panel.add(export);
		export.addActionListener(new exportlistener());
	}
	
	
	ArrayList<String[]> generate(int n)
	{
		ArrayList<String[]> newset=new  ArrayList<String[]>();
	
		Random random=new Random();
		
		HashSet<Integer> in=new HashSet<Integer>();
		while(in.size()!=n)
			in.add(random.nextInt(quesset.size()));
		
		for(int i:in)
			newset.add(quesset.get(i));
		
		return newset;
	}
	
	class exportlistener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
				BufferedWriter bwq=new BufferedWriter(new FileWriter(new File("generate_question.txt")));
				BufferedWriter bwa=new BufferedWriter(new FileWriter(new File("generate_answer.txt")));
				int j=0;
				for(String[] s:qlist)
				{
					j++;
					bwq.write(j+".)"+s[0]);
					bwq.newLine();
					if(s.length==3)
					{
						String st[]=s[1].split("\\s{3,}");
						for(int i=0;i<st.length;i++)
							bwq.write("  ("+(i+1)+")"+st[i]);
					}
					
					int len=s.length;
					bwa.write(j+".)"+s[len-1]);
					bwq.newLine();
					bwa.newLine();
				}
				bwq.close();
				bwa.close();
			}
			catch(Exception e){}
		}
		
	}
	
	public static void main(String[] args)
	{
		generator g=new generator(load.getlist(new File("question.txt")),4);
		g.go();
	}
}