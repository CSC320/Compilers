import java.util.*;

public class Antler_Command_Parser 
{
	int _numberOfCommands; 
	List<Antler_Commands> userCommands;
	
	Antler_Command_Parser(String _string)
	{
		this._numberOfCommands = getNumberOfCommands(_string); 
		this.userCommands = new LinkedList<Antler_Commands>(); 
		this.parseInput(_string);
		
	}
	
	private void parseInput(String _string)
	{
		String workingString = _string; 
		char[] workingData = _string.toCharArray(); 
				
		for(int i = 0; i < this._numberOfCommands; i++)
		{
			if(i == 0)
			{
				// Obtain the index values used for parsing 
				int spaceIndex = workingString.indexOf(" "); System.out.println("Space Index: " + spaceIndex);
				int colinIndex = workingString.indexOf(":"); System.out.println("Colin Index: " + colinIndex);
				int endOfCommand = workingString.indexOf("-"); System.out.println("End Index: " + endOfCommand);
				
				// Parse the corressponding id and data from the user input 
				String idString = workingString.substring(spaceIndex + 1, colinIndex);
				String idData = workingString.substring(colinIndex + 1, endOfCommand); 
				
				// Append the user command referencing the id string and it's coressponding data 
				this.userCommands.add(new Antler_Commands(idString, idData));
				
				// Overwrite previous index values 
				workingData[colinIndex] = '&';
				workingData[endOfCommand] = '&';
				
				// Save any string manipulations 
				workingString = new String(workingData);
			}
			else
			{
				// Obtain the index values used for parsing 
				int ampersandIndex = workingString.indexOf("&");
				int colinIndex = workingString.indexOf(":");
				int endOfCommand = workingString.indexOf("-");
				
				// Parse the corressponding id and data from the user input
				String idString = workingString.substring(ampersandIndex + 1, colinIndex);
				String idData = workingString.substring(colinIndex + 1, endOfCommand); 
				
				// Append the user command referencing the id string and it's coressponding data 
				this.userCommands.add(new Antler_Commands(idString, idData));

				// Overwrite previous index values 
				workingData[colinIndex] = '&';
				workingData[endOfCommand] = '&';
				
				// Save any string manipulations 
				workingString = new String(workingData);
			}
		}
	}

	private int getNumberOfCommands(String _string)
	{
		int numberOfCommands = 0; 
		for(int i = 0; i < _string.length(); i++)
		{
			System.out.println("Char at " + i + " is " + _string.charAt(i));
			if(_string.charAt(i) == '-') numberOfCommands++; 
		}
		
		return numberOfCommands; 
	}

	public static void main(String[] args) 
	{
		String testString = "FIND TL:WHATEVER-IP:10.0.0.0-";
		Antler_Command_Parser commandParser = new Antler_Command_Parser(testString); 
	}
}

