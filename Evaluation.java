import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Evaluation {

	 // used operators
	// + - / * ^ ( ) 
	
	
	
	public Evaluation() {}
	
	public static String eval(String expr) throws InvalidEntryException, UnsupportedOperationException
	{
		
		String reExpressed = reExpressInfix(expr);
		String postfixExpr = toPostfix(reExpressed); 
		String resultStr = evaluatePostfix(postfixExpr); 
		//double result = 0; 
		
		if(resultStr.contains("E"))
		{
			return resultStr; 
		}
		else if(isInt(expr, resultStr))
		{
			return toIntString(resultStr);   
		}
		else
		{
			return resultStr; 
		}
		
	}

	public static String toPostfix(String infix) throws InvalidEntryException 
	{
	
		// contains operators 
		Stack<Character> s = new Stack<Character>(); 
		
		// contains numbers and operators 
		Queue<Character> q = new LinkedList<Character>(); 
	
		
		for(int i = 0; i < infix.length(); i++) 
		{
		
			// easier for coding and debugging 
			char scannedChar = infix.charAt(i); 
			
			if(isDigit(scannedChar))
			{
				
				if(i == infix.length() - 1)   // the digit at the end
				{
					q.add(scannedChar);
					q.add(' ');
				}
				else if(isOp(infix.charAt(i + 1)))    // the next char is an operator  
				{
					q.add(scannedChar);
					q.add(' ');
				}	
				else
				{
					q.add(scannedChar);
				}
				
			}
			else if(scannedChar == '(')
			{
				s.push('(');
			}
			else if(infix.charAt(i) == ')') 
			{
				
				if(!s.contains('('))
				{
					throw new InvalidEntryException(); 
				}
				else
				{
					
					// pop all the operators until you reach the '(' 
					while(s.peek() != '(')
					{
						q.add(s.pop());
						q.add(' '); 
					}
					
					s.pop(); 					
					
				}
			}
			else if(isOpNoPerenthasis(scannedChar)) 
			{
				
				if(isNegativePositive(infix,i)) 
				{
					q.add(scannedChar);
					continue;
				}
				else
				{
					
					if(s.isEmpty()) 
					{
						s.push(scannedChar); 
					}
					else if(prec(scannedChar) > prec(s.peek()))
					{
						s.push(scannedChar);
					}
					else if(prec(scannedChar) <= prec(s.peek()))
					{
						
						while(!s.isEmpty() && prec(scannedChar) <= prec(s.peek()))
						{	
							q.add(s.pop());
							q.add(' '); 
						}
						
						s.push(scannedChar); 
						
					}
					else
					{
						s.push(scannedChar);
					}
					
				}
				
			}
			
		}
		
		
		
		while(!s.isEmpty())
		{
			q.add(s.pop());
		}
	
		return qToString(q); 
		
		
	}

//	public static String reExpressPostfix(String exp) {
//		
//		// this method is to add a space after every operator
//		
//		Queue<Character> newExp = new LinkedList<Character>();
//		
//		for(int i = 0; i < exp.length(); i++)
//		{
//			
//			char scanned = exp.charAt(i);
//			
//			if(isOpNoPerenthasis(scanned))
//			{
//				
//				if(isNegativePositive(exp, i))
//				{
//					newExp.add(scanned);
//				}
//				else
//				{
//					newExp.add(scanned);
//					newExp.add(' ');
//				}
//			}
//			else
//			{
//				newExp.add(scanned);
//			}
//			
//		}
//		
//		return qToString(newExp); 
//	}
	
	public static String evaluatePostfix(String exp) throws InvalidEntryException, UnsupportedOperationException
	{
		
		Stack<String> numbers = new Stack<String>(); 
		Queue<Character> oneNum = new LinkedList<Character>();
		
		for(int i = 0; i < exp.length(); i++)
		{
			
			char scanned = exp.charAt(i); 
			
			if(scanned == ' ') 
			{
				
				if(oneNum.isEmpty())
					continue; 
				else
				{
					numbers.push(qToString(oneNum));
					oneNum.clear();
				}
				
			}
			else if(isDigit(scanned)) 
			{
				oneNum.add(scanned); 
			}
			else if(isOpNoPerenthasis(scanned))
			{
			
				if(isNegativePositivePostfix(exp, i))
				{
					oneNum.add(scanned); 
					continue; 
				}
				else if(numbers.size() < 2) 
				{
					throw new InvalidEntryException();
				}
				else 
				{
					
					String right = numbers.pop(); 
					double rightDouble = Double.parseDouble(right); 
					
					String left = numbers.pop();  
					double leftDouble = Double.parseDouble(left); 
					
					double result = applyOp(leftDouble, scanned, rightDouble); 
					
					numbers.push(String.valueOf(result)); 
					
				}
				
			}
			
		}
		
		if (numbers.size() == 1) 
		{
			return numbers.peek(); 
		}
		else
		{
			throw new InvalidEntryException();
		}
		
	}

	public static String reExpressInfix(String exp) throws InvalidEntryException 
	{
		
		Queue<Character> newExpr = new LinkedList<Character>(); 
		
		for(int i = 0; i < exp.length(); i++)
		{
			
			char scanned = exp.charAt(i); 
			
			if(scanned == ')')
			{
				
				if(i == exp.length() - 1)
				{
					newExpr.add(scanned); 
					continue; 
				}
				else if(exp.charAt(i + 1) == '(' || isDigit(exp.charAt(i + 1)))
				{
					newExpr.add(scanned);
					newExpr.add('*'); 
				}
				else
				{
					newExpr.add(scanned); 
				}
				
				
			}
			else if(scanned == '-' || scanned == '+') 
			{
				
				if(i == exp.length() - 1)
				{
					throw new InvalidEntryException(); 
				}
				else if(exp.charAt(i + 1) == '(')
				{
					newExpr.add(scanned);
					newExpr.add('1'); 
					newExpr.add('*'); 
				}
				else
				{
					newExpr.add(scanned); 
				}
				
			}
			else if(isDigitNoPoint(scanned))
			{
				
				if(i == exp.length() - 1)
				{
					newExpr.add(scanned);
					continue;
				}
				else if(exp.charAt(i + 1) == '(')
				{
					newExpr.add(scanned); 
					newExpr.add('*');
				}
				else
				{
					newExpr.add(scanned); 
				}
				
			}
			else
			{
				newExpr.add(scanned);
			}
			
		}
		
		return qToString(newExpr);
	}
	

	private static int prec(char given) throws InvalidEntryException 
	{
		
		if (isOp(given) == false)
			throw new InvalidEntryException(); 
		else
		{ 
			switch (given) 
	        {
	        case '+': 
	        case '-': 
	            return 1; 
	       
	        case '*': 
	        case '/': 
	            return 2; 
	       
	        case '^': 
	            return 3; 
	        } 
	        return -1; 
	        
		}

	}
	
	public static boolean isOp(char op) 
	{
		
		String usedOp = "+-/*^()"; 
		
		if(usedOp.contains(String.valueOf(op)))
			return true;
		else
			return false; 
	}
	
	public static boolean isOpNoPerenthasis(char op) 
	{
		
		String usedOp = "+-/*^"; 
		
		if(usedOp.contains(String.valueOf(op)))
			return true;
		else
			return false; 
	}
	
	private static double applyOp(double x, char op, double y) throws InvalidEntryException
	{
		
		switch(op)
		{
		
		case '+':
			return x + y; 
			
		case '-':
			return x - y; 
			
		case '/':
			
			if(y == 0)
				throw new UnsupportedOperationException("Cannot Divide By Zero");
			else
				return x / y; 
			
		case '*':
			return x * y; 
			
		case '^':
			return Math.pow(x, y);
			
		default:
			throw new InvalidEntryException();
				
		}

	}
	
	public static boolean isDigit(char a)
	{
		if((a >= '0' && a <= '9') || a == '.')
			return true;  
		else
			return false; 	
	}
	
	private static boolean isDigitNoPoint(char a)
	{
		if(a >= '0' && a <= '9')
			return true; 
		else
			return false; 	
	}
	
	private static boolean isDigitNoPointNoZero(char a)
	{
		if(a >= '1' && a <= '9')
			return true; 
		else
			return false; 	
	}
	
	private static boolean isInt(String exp, String num) throws InvalidEntryException 
	{
		if(exp.contains("."))
			return false;
		else if(!isDoubleAnswer(num))
			return true;
		else if(exp.contains("/"))
			return false; 
		else 
			return false;
	}
	
	public static boolean isDoubleAnswer(String num) throws InvalidEntryException
	{
		
		try 
		{
			double givenNum = Double.parseDouble(num); 
			
			if(givenNum % 1 == 0)		// The mod of any integer is 0; otherwise, it's double
				return false; 
			else
				return true;
		}
		catch(NumberFormatException e)
		{
			throw new InvalidEntryException(); 
		}
		
	}

	public static String toIntString(String a)
	{
		double valueAsDouble = Double.parseDouble(a); 
		
		if(a.contains("E"))
		{
			return a; 
		}
		else
		{
			long valueAsInt = (long) valueAsDouble;
			return String.valueOf(valueAsInt);
		}
		
		 	
	}
	
	private static boolean isNegativePositive(String exp, int index)
	{
		
		if(exp.charAt(index) != '-' && exp.charAt(index) != '+')
		{
			return false; 
		}
		else
		{
			
			if(index == 0)
				return true; 
			else if(isOpNoPerenthasis(exp.charAt(index - 1)))
				return true; 
			else
				return false;
			
		}
		
		 
	}
	
	
	private static boolean isNegativePositivePostfix(String exp, int index)
	{
		
		if(exp.charAt(index) != '-' && exp.charAt(index) != '+')
		{
			return false; 
		}
		else
		{
			
			if(index == exp.length() - 1)
				return false; 
			else if(isDigit(exp.charAt(index + 1)))
				return true;
			else
				return false;
			
		}
		
		 
	}
	
	private static String qToString(Queue<Character> e) 
	{
		String str = "";
		int i = 0; 
		
		while(e.size() != 0) 
		{
			str += e.poll(); 
			
		}
		
		return str; 
	}
	
	private static double round(String number)
	{
		return 0;
	}

}
