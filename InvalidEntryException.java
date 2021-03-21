/**
 * 
 * @author mr-as
 *
 */
public class InvalidEntryException extends Exception{

	public InvalidEntryException() 
	{
		super("You entered a wrong symbol. Please review"); 
	}
	
	public InvalidEntryException(String message) 
	{
		super(message); 
	}

}
