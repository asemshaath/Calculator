import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EvaluationTest {

	@BeforeEach
	void setUp() throws Exception 
	{
		
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		
	}
	
	@Test
	void testSimpleAdditions() 
	{
		
		try 
		{
			
			//System.out.println(Evaluation.eval("1-10"));
			assertEquals("2", Evaluation.eval("1+1"));
			assertEquals("11", Evaluation.eval("6+5"));
			assertEquals("7", Evaluation.eval("7+0"));
			assertEquals("10", Evaluation.eval("6+4"));
			//System.out.println(Evaluation.eval("8*(2)"));
			
		} 
		catch (InvalidEntryException e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
		
	}
	
	@Test
	void testSimpleSubtractions() 
	{
		
		try 
		{
			
			assertEquals("0", Evaluation.eval("1-1"));
			assertEquals("-15", Evaluation.eval("-6-9"));
			assertEquals("4", Evaluation.eval("7-3"));
			assertEquals("2", Evaluation.eval("6-4"));
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
	}
	
	@Test
	void testSimpleMultiplications() 
	{
		try 
		{
			
			assertEquals("0", Evaluation.eval("5*0"));
			assertEquals("-18", Evaluation.eval("-6*3"));
			assertEquals("-21", Evaluation.eval("-7*3"));
			assertEquals("24", Evaluation.eval("6*4"));
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
	}
	
	
	@Test
	void testSimpleDivisions() 
	{
		
		try 
		{
			
			//System.out.println(Evaluation.eval("-7/2"));
			
			assertEquals("5", Evaluation.eval("5/1"));
			assertEquals("-2", Evaluation.eval("-6/3"));
			assertEquals("-3.5", Evaluation.eval("-7/2"));
			assertEquals("1.5", Evaluation.eval("6/4"));
			assertEquals("4", Evaluation.eval("16/4"));
			assertEquals("-2", Evaluation.eval("-10/5"));
			assertEquals("1", Evaluation.eval("7/7"));
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
	}
	
	@Test
	void testSimplePowers() 
	{
		try 
		{
			
			//System.out.println(Evaluation.eval("4^(1/2)"));
			
			assertEquals("5", Evaluation.eval("5^1"));
			assertEquals("1", Evaluation.eval("6^0"));
			assertEquals("4", Evaluation.eval("2^2"));
			assertEquals("36", Evaluation.eval("6^2"));
			assertEquals("16", Evaluation.eval("4^2"));
			assertEquals("0.25", Evaluation.eval("4^-1"));
			assertEquals("7", Evaluation.eval("7^1"));
			assertEquals("2.0", Evaluation.eval("4^(0.5)"));		// sqrt(4)
			assertEquals("2", Evaluation.eval("4^(1/2)"));		// sqrt(4)
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
	}
	
	@Test
	void testComplexAdditions() 
	{
		
		try 
		{
			
			//System.out.println(Evaluation.eval("4^(1/2)"));
			
			assertEquals("7", Evaluation.eval("5+1+-8+9"));
			assertEquals("168", Evaluation.eval("6+0+7+55+100"));
			assertEquals("19", Evaluation.eval("2+2+10-9+14"));
			
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
	}
	
	@Test
	void testComplexSubtractions() 
	{
		
		try 
		{
			
			//System.out.println(Evaluation.eval("5-1--8-9"));
			
			assertEquals("3", Evaluation.eval("5-1--8-9"));
			assertEquals("25", Evaluation.eval("100-7-8-10-50"));
			assertEquals("19", Evaluation.eval("2+2+10-+9+14"));
			
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
	}
	
	@Test
	void testComplexMultiplications() 
	{
		
		try 
		{
			
			//System.out.println(Evaluation.eval("5-1--8-9"));
			
			assertEquals("-360", Evaluation.eval("5*-1*-8*-9"));
			assertEquals("-1000000", Evaluation.eval("1000*100*10*-1"));
			assertEquals("7200", Evaluation.eval("20*10*9*4"));
			
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
	}
	
	@Test
	void testSimpleEquations() 
	{
		
		
		try 
		{
			
			//System.out.println(Evaluation.eval("5-1--8-9"));
			
			assertEquals("15", Evaluation.eval("3(5)"));
			assertEquals("-10", Evaluation.eval("-(3+7)"));
			assertEquals("20", Evaluation.eval("20(2/2)"));
			
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
		
	}
	
	@Test
	void testComplexEquations() 
	{
		
		
		try 
		{
			
			System.out.println(Evaluation.eval("1234567890123"));
			
			assertEquals("78", Evaluation.eval("2(5)(7)+8"));
			assertEquals("0", Evaluation.eval("(7+3)-(3+7)"));
			assertEquals("320", Evaluation.eval("20(2+2)*4"));
			assertEquals("28", Evaluation.eval("((3+2)^2+3)-9+3^2"));
			assertEquals("536", Evaluation.eval("(18/3)^2+((13+7)*5^2)"));
			assertEquals("32", Evaluation.eval("2*(1+(4*(2+1)+3))"));
			
			
			
		} 
		catch (Exception e) 
		{
			assertTrue(false, "There is no Exception supposed to be thrown"); 
		} 
		
		
	}
	
	
	@Test
	void testDivByZero() 
	{
		
		try 
		{
			Evaluation.eval("7/0");
		} 
		catch (UnsupportedOperationException e) 
		{
			assertTrue(true, "This is a divison by zero");
		} 
		catch (InvalidEntryException e) 
		{
			assertTrue(false, "This the wrong exception");
		}
		catch(Exception e)
		{
			assertTrue(false, "Some wrong exception has been thrown");
		}
		
	}
	
	@Test
	void testInvalidEntryException() 
	{
		
		try 
		{
			Evaluation.eval("1+8)");
		} 
		catch (UnsupportedOperationException e) 
		{
			assertTrue(false, "This the wrong exception");
		} 
		catch (InvalidEntryException e) 
		{
			assertTrue(true, "This the Invalid Entry Exception");
		}
		catch(Exception e)
		{
			assertTrue(false, "Some wrong exception has been thrown");
		}
		
	}
	

}
