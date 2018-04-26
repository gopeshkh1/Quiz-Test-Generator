import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

class tloader extends sbcode
{
	DefaultTableModel model ;
	JScrollPane pane;
	JTable table;
	ArrayList<String[]> quesset;
	
	tloader(ArrayList<String[]> qset)
	{
		quesset=qset;
		model=new DefaultTableModel();
		pane=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		table = new JTable();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		pane.setViewportView(table);
	}
	
	
	void go()
	{
		table.setModel(model);
		
		
		model.addColumn("s.no.");
		model.addColumn("question");
		model.addColumn("option1");
		model.addColumn("option2");
		model.addColumn("option3");
		model.addColumn("option4");
		
	
		table.setRowHeight(20);	 

		JLabel qlabel=new JLabel("QUESTION:");
		qlabel.setFont(new Font("serif",Font.BOLD,15));
		int i=0;
		for(String[] s:quesset)
		{
			i++;
			if(s.length==2)
			{
				String []row={i+"",s[0],"","","",""};
				model.addRow(row);
			}
			else
			{
				String []st=s[1].split("\\s{3,}");
				if(st[0].charAt(0)=='~')
				{
					String []row={i+"",s[0],st[0],st[1],"",""};
					model.addRow(row);
				}
				else
				{
					String []row={i+"",s[0],st[0],st[1],st[2],st[3]};
					model.addRow(row);
				}
			}
		}
		panel.add(pane);

	}
	
}