/**loading in arraylist the file data*/

import java.io.*;
import java.util.*;


class load
{

	public static ArrayList<String[]> getlist(File file)
	{
		ArrayList<String[]>quesset=new ArrayList<String[]>();
		try
		{
			BufferedReader reader=new BufferedReader(new FileReader(file));
			
			String line=null;
			while((line=reader.readLine())!=null)
				quesset.add(line.split("/"));
			reader.close();
		}
		catch(IOException e){}
		
		return quesset;
	}
	
}

