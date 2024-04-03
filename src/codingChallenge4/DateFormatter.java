package codingChallenge4;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateFormatter 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        DateTimeFormatter inputFormatText = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        DateTimeFormatter inputFormatNumeric = DateTimeFormatter.ofPattern("M/d/yyyy");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) 
        {
            System.out.print("Date: ");
            String userInput = scan.nextLine();

            try 
            {
                LocalDate date;
                
                if (userInput.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) 
                {
                    date = LocalDate.parse(userInput, inputFormatNumeric);
                } 
                
                else if (userInput.matches("[a-zA-Z]+\\\\s+\\\\d{1,2}[a-z]{0,2}\\\\s*,\\\\s*\\\\d{4}"))
                {
                	date = LocalDate.parse(userInput, inputFormatText);
                }
                
                else 
                {
                    throw new DateTimeException("Invalid format. Please enter the date in either 'MM/DD/YYYY' or 'Month Day, Year' format." );
                }

                String formattedDate = date.format(outputFormat);
                System.out.println(formattedDate);
                break; 
                
            } catch (DateTimeException e) {
            	
            	//Displays specific error messages depending on the input format the user chooses
            	
            	// Catches invalid input for users who chose the MM/DD/YYYY format.
            	 if (userInput.matches("\\d+/\\d+/\\d{4}")) 
            	 {
            	 	System.out.println("Invalid input. Please use the correct format: MM/DD/YYYY (e.g. 09/14/2009)");
            	 } 
            	
            	 // Catches invalid input for users who chose the "Month Day, Year" format.
            	 else if (!userInput.matches("[a-zA-Z]+\\\\s+\\\\d{1,2}[a-z]{0,2}\\\\s*,\\\\s*\\\\d{4}")) 
            	 {
                     // Check if the Month Day, Year format is valid
                     if (userInput.matches("[a-zA-Z]+\\s+\\d{1,2}(st|nd|rd|th)?[,]?\\s+\\d{4}")) 
                     {
                         System.out.println("Invalid input. Please use the correct format: Month Day, Year (e.g., September 8, 1636)");
                     }
            	 }
            	 //Catches any other type of invalid input the user may enter.
            	 else
            	 {
                     System.out.println("Invalid input. Please enter a valid date.");
                 }
            }
        }

       
    }
}





/**					OUTPUT

		Test Case #1:			(when the users enters the MM/DD/YYYY format incorrectly
		
		Date: 31/01/2024
		Invalid input. Please use the correct format: MM/DD/YYYY (e.g. 09/14/2009)
		Date: 01/31/2024
		2024-01-31
		
		
		Test Case #2:			(when the user enters the Month Day, Year format incorrectly)
		
		Date: April 11th, 2003
		Invalid input. Please use the correct format: Month Day, Year (e.g., September 8, 1636)
		Date: April 11, 2003
		2003-04-11
		
		
		Test Case #3:			(when the user enters invalid input)
		
		Date: sdfghjkl
		Invalid input. Please enter a valid date.
		Date: 03/31/2024
		2024-03-31
		


*/