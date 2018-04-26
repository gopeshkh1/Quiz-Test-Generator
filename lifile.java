/**loading arraylist in file and contains static method load(quesset,file) */

import java.io.*;
import java.util.*;

public class lifile
{
	
	static void load(ArrayList<String[]> qlist,File f)
	{
		ArrayList<String[]> list=qlist;
		File file=f;
		
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter(file));
			bw.write("");
			bw.close();
			
			BufferedWriter bwriter=new BufferedWriter(new FileWriter(file,true));
			
			for(String[] s:list)
			{
				if(s.length==3)
					bwriter.write(s[0]+"/"+s[1]+"/"+s[2]);
				else
					bwriter.write(s[0]+"/"+s[1]);
				bwriter.newLine();
			}
			
			bwriter.close();
		}
		
		catch(IOException ex){}
	}
}