import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class mytest {


	  @BeforeClass
	  public static void testSetup() {
	  }

	  @AfterClass
	  public static void testCleanup() {
	    // Teardown for data used by the unit tests
	  }

	  @Test

	  public void Det() 
	  {
	
		double[][] a = new double[3][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		a[2][0]=7.0;
		a[2][1]=8.0;
		a[2][2]=9.0;

		double out=0.0;

		Matrix tester = new Matrix();
		
		assertEquals("checking determinant",out,tester.Determinant(a,3,3),0.0);
	}

	 @Test(expected = IllegalArgumentException.class)

	  public void DetException() {
	    Matrix tester = new Matrix();
	    double[][] a = new double[2][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		
		
		double out=1.0;
	    
		tester.Determinant(a,2,3);
	  }

	 @Test

	  public void Sub() 
	  {
	
		double[][] a = new double[3][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		a[2][0]=7.0;
		a[2][1]=8.0;
		a[2][2]=9.0;

		double[][] b = new double[2][2];

		b[0][0]=1.0;
		b[0][1]=2.0;
		b[1][0]=4.0;
		b[1][1]=5.0;
		

		Matrix tester = new Matrix();
		
		assertArrayEquals("checking determinant",b,tester.Submatrix(a,3,3,2,2));
	}
	
	 @Test(expected = IllegalArgumentException.class)

	  public void SubException() 
	  {
	
		double[][] a = new double[3][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		a[2][0]=7.0;
		a[2][1]=8.0;
		a[2][2]=9.0;

		

		Matrix tester = new Matrix();
		
		tester.Submatrix(a,3,3,-1,1);
	}
		
	@Test

	public void Inv() 
	{

		double[][] a = new double[3][3];
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=1;
		a[1][0]=2;
		a[1][1]=2;
		a[1][2]=3;
		a[2][0]=1;
		a[2][1]=1;
		a[2][2]=2;

		double[][] b = new double[3][3];
		b[0][0]=-1;
		b[0][1]=3;
		b[0][2]=-4;
		b[1][0]=1;
		b[1][1]=-1;
		b[1][2]=1;
		b[2][0]=0;
		b[2][1]=-1;
		b[2][2]=2;

		Matrix tester = new Matrix();
		
		assertArrayEquals("checking inverse",b,tester.Inverse(a,3,3));
	}
	
	@Test(expected = IllegalArgumentException.class)

	  public void InvException1() 
	 {
		double[][] a = new double[3][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		a[2][0]=7.0;
		a[2][1]=8.0;
		a[2][2]=9.0;

		Matrix tester = new Matrix();
		tester.Inverse(a,3,3);
	}

	@Test(expected = IllegalArgumentException.class)

	  public void InvException2() 
	 {
		double[][] a = new double[2][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		

		Matrix tester = new Matrix();
		tester.Inverse(a,2,3);
	}

	@Test

	public void Mul() 
	{

		double[][] a = new double[3][3];
		a[0][0]=1;
		a[0][1]=2;
		a[0][2]=1;
		a[1][0]=2;
		a[1][1]=2;
		a[1][2]=3;
		a[2][0]=1;
		a[2][1]=1;
		a[2][2]=2;

		double[][] b = new double[3][3];
		b[0][0]=1;
		b[0][1]=0;
		b[0][2]=0;
		b[1][0]=0;
		b[1][1]=1;
		b[1][2]=0;
		b[2][0]=0;
		b[2][1]=0;
		b[2][2]=1;

		double[][] c = new double[3][3];
		c[0][0]=1;
		c[0][1]=2;
		c[0][2]=1;
		c[1][0]=2;
		c[1][1]=2;
		c[1][2]=3;
		c[2][0]=1;
		c[2][1]=1;
		c[2][2]=2;

		Matrix tester = new Matrix();
		
		assertArrayEquals("checking inverse",c,tester.Multiply(a,b));
	}

	@Test(expected = IllegalArgumentException.class)

	  public void MulException() 
	 {
		double[][] a = new double[3][3];

		a[0][0]=1.0;
		a[0][1]=2.0;
		a[0][2]=3.0;
		a[1][0]=4.0;
		a[1][1]=5.0;
		a[1][2]=6.0;
		a[2][0]=7.0;
		a[2][1]=8.0;
		a[2][2]=9.0;

		double[][] b = new double[2][3];
		b[0][0]=1;
		b[0][1]=0;
		b[0][2]=0;
		b[1][0]=0;
		b[1][1]=1;
		b[1][2]=0;
		

		Matrix tester = new Matrix();
		tester.Multiply(a,b);
	}

}

