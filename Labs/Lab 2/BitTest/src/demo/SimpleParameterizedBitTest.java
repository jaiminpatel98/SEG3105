package demo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import demo.Bit;

/**
 * Example of a parameterized test case.
 * </p>
 * <p>
 * Parameterized test cases are run multiple times with different data. Two
 * items are needed to set this up: a constructor for instances of this class
 * that assigns the parameters to instance variables, and a method with the
 * &#64;Parameters notation that returns a list of parameter arrays.
 * 
 */
@RunWith( Parameterized.class )
public class SimpleParameterizedBitTest
{
	/**
	 * Bit value for left side of binary operator
	 */
	private Bit firstBit;

	/**
	 * Bit value for right side of binary operator
	 */
	private Bit secondBit;

	/**
	 * Expected bit value for the result of AND
	 */
	private Bit expectedBit;

	/**
	 * Constructor for a parameterized test case.
	 * </p>
	 * <p>
	 * The constructor stores the parameters in instance variables for use by
	 * whichever test method is being run. Because we don't know exactly which
	 * method will be run (in general), the parameters have to be set up for all
	 * possible test methods for the set of values.
	 * 
	 * @param first
	 *            Bit value for left side of binary operator
	 * @param second
	 *            Bit value for right side of binary operator
	 * @param expected
	 *            Expected bit value for the result of AND
	 */
	public SimpleParameterizedBitTest( int first, int second, int expected )
	{
		this.firstBit = new Bit( first );
		this.secondBit = new Bit( second );
		this.expectedBit = new Bit( expected );
	}

	/**
	 * Set up parameters for the test cases.
	 * </p>
	 * <p>
	 * The parameters are for the binary operator 'and'. Set up all possible
	 * combinations of the two input values (firstBit and secondBit), and the
	 * expected result. Therefore, there should be three parameters for each
	 * case:
	 * </p>
	 * <ol>
	 * <li>The first input bit value</li>
	 * <li>The second input bit value</li>
	 * <li>The expected result for: firstBit.and( secondBit )</li>
	 * </ol>
	 * <p>
	 * The five parameters are stored in an integer array for each run of the
	 * test cases. Each array is then added as a list item.
	 * <p>
	 * With 4 combinations of values for a binary operator, there will be four
	 * arrays of parameters.
	 * 
	 * @return A list of integer arrays containing all 0-1 combination pairs for each test run.
	 */
	@Parameters
	public static List<Integer[]> data( )
	{
		List<Integer[]> params = new LinkedList<Integer[]>( );
		params.add( new Integer[] { 0, 0, 0 } );
		params.add( new Integer[] { 0, 1, 0 } );
		params.add( new Integer[] { 1, 0, 0 } );
		params.add( new Integer[] { 1, 1, 1 } );
		return params;
	}

	/**
	 * Test method for {@link demo.Bit#and(demo.Bit)}.
	 * </p>
	 * <p>
	 * The input and expected values are set by the constructor. Perform the
	 * operation to get the actual value, and assert that it is as expected.
	 */
	@Test
	public void testAnd( )
	{
		Bit actualBit = firstBit.and( secondBit );
		Assert.assertEquals( expectedBit, actualBit );
	}

}