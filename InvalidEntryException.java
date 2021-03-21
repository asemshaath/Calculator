/**
 * 
 * This is an excpetion class that will be thrown when the infix expression is incorrect
 * @author Asem Shaath
 *
 */
public class InvalidEntryException extends Exception {

	public InvalidEntryException() 
	{
		super("You entered a wrong symbol. Please review"); 
	}
	
	public InvalidEntryException(String message) 
	{
		super(message); 
	}

}
