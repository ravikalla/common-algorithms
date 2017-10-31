// CYCOMETIC complexity
import java.io.*;

public class complexity
{
	static int substr(String s1, String s2)	// returns no. of times 's2' is present in 's1'
	{
		int cnt = 0, i, j;
		for (i = 0, j = 0; i < s1.length(); i++)
		{
			for (j = 0; j < s2.length(); j++)
			{
				if (((i + j) == s1.length()) || (s1.charAt(i + j) != s2.charAt(j)))
				{
					i += j;
					break;
				}
				else if (j == (s2.length() - 1))
				{
					cnt++;
					break;
				}
			}
		}
		/*if (cnt != 0)
		{
			System.out.println("###\n" + s1.trim());
			System.out.println("@@@\n" + s2.trim());
			System.out.println("@@@\n" + cnt + "\n###");
		}
		*/
		return (cnt);
	}
	public static void main(String args[]) throws Exception
	{
		int if_counter = 0, switch_counter = 0, temp;
		try
		{
			FileReader filereader = new FileReader("temp1.java");
			BufferedReader bufferedreader = new BufferedReader(filereader);
			String instring;
			while ((instring = bufferedreader.readLine()) != null)
			{
				if ((temp = substr(instring, "else if")) != 0)
				{
					if_counter += temp;
					System.out.println("*******\nHere for ELSE IF\n*******");
				}
				else if ((temp = substr(instring, "if")) != 0)
				{
					if_counter += temp;
					System.out.println("*******\nHere for IF\n*******");
				}
				else if ((temp = substr(instring, "else")) != 0)
				{
					if_counter += temp;
					System.out.println("*******\nHere for ELSE\n*******");
				}
				else if ((temp = substr(instring, "case ")) != 0)
				{
					switch_counter += temp;
					System.out.println("*******\nHere for CASE\n*******");
				}
				else if ((temp = substr(instring, "default ")) != 0 || (temp = substr(instring, "default:")) != 0)
				{
					switch_counter++;
					System.out.println("*******\nHere for DEFAULT\n*******");
				}
				System.out.println(instring.trim());
			}
			filereader.close();
			System.out.println("*********************************************");
			System.out.println("Cyclometic complexity of the program is : " + (if_counter + switch_counter));
			System.out.println("*********************************************");
			System.in.read();
		}
		catch (IOException e)
		{
			System.out.println("ERROR(21) : " + e);
			System.in.read();
		}
	}
}
