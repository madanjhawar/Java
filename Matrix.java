import java.util.Scanner;

public class Matrix
{
	public double [][] Submatrix(double a[][],int ra,int ca,int r,int c)
	{
		if(r<0 || c <0 || r>=ra || c>=ca)
			throw new IllegalArgumentException("Give correct row and column no\n");
		
		double b[][] = new double[ra-1][ca-1];
		int i,j,k=-1,l;
		for(i=0;i<ra;i++)
		{
			if(i==r)
				continue;
			k++;l=-1;
			for(j=0;j<ca;j++)
			{
				if(j==c)
					continue;
				b[k][++l]=a[i][j];
			}
				
		}
		return b;
	}
	
	public double Determinant(double a[][],int n,int m)
	{
		if(m!=n)
		{
			throw new IllegalArgumentException("rows should be equal to column\n");
		}
		else
		{
		int i,j,k;
		double d=0.0;
		if(n==1)
		{
			d=a[0][0];
			return d;
		}
		if(n==2)
		{
			d=a[0][0]*a[1][1]-a[0][1]*a[1][0];
			return d;
		}
		for(i=0;i<n;i++)
		{
			double b[][] = new double [n-1][n-1];
			for(j=1;j<n;j++)
			{
				for (k=0;k<n;k++)
				{

                    if(k<i)
                    {
                            b[j-1][k]=a[j][k];
                    }
                    else if(k>i)
                    {
                            b[j-1][k-1]=a[j][k];
                    }
				}

			}
			d+=a[0][i]*Math.pow(-1,(int)i)*Determinant(b,n-1,n-1);
        	}
		return d;
		}
	}
	public  void gaussian(double a[][],int index[])
	{
		    int n=index.length,i,j,l;
		    double c[] = new double[n];
		
		    for(i=0;i<n;i++) 
		    	index[i] = i;
		
		    for(i=0;i<n;i++)
		    {
		      double c1=0;
		      for(j=0;j<n;j++)
		      {
		        double c0 = Math.abs(a[i][j]);
		        if (c0>c1)
		        	c1=c0;
		      }
		      c[i]=c1;
		    }
		
		    int k=0;
		    for(j=0;j<n-1;j++)
		    {
		      double pi1=0;
		      for(i=j;i<n;i++)
		      {
		        double pi0 = Math.abs(a[index[i]][j]);
		        pi0/= c[index[i]];
		        if(pi0 > pi1)
		        {
		          pi1 = pi0;k = i;
		        }
		      }

		 
		      int itmp=index[j];
		      index[j]=index[k];
		      index[k]=itmp;
		      for(i=j+1;i<n;i++)
		      {
		        double pj = a[index[i]][j]/a[index[j]][j];
		        a[index[i]][j] = pj;
		  
		        for (l=j+1;l<n;l++)
		          a[index[i]][l]-=pj*a[index[j]][l];
		      }
		    }
	}
	public  double[][] Inverse(double a[][],int n,int m)
	{
		if(n!=m)
			throw new IllegalArgumentException("Give proper matrix\n");
		double det=Determinant(a,n,n);
		if(det==0)
			throw new IllegalArgumentException("Give proper matrix\n");
	    double x[][] = new double[n][n];
	    double b[][] = new double[n][n];
	    int index[] = new int[n];
	    for (int i=0;i<n;i++)
	    	b[i][i] = 1;
	    gaussian(a, index);
	    for (int i=0;i<n-1;i++)
	        for (int j=i+1;j<n;j++)
	          for (int k=0;k<n;k++)
	            b[index[j]][k]-=a[index[j]][i]*b[index[i]][k];
	    for (int i=0;i<n;i++)
	    {
	        x[n-1][i]=b[index[n-1]][i]/a[index[n-1]][n-1];
	        for (int j=n-2;j>=0;j--) {
	          x[j][i] = b[index[j]][i];
	          for (int k=j+1;k<n;k++) {
	            x[j][i]-=a[index[j]][k]*x[k][i];
	          }
	          x[j][i]/=a[index[j]][j];
	        }
	      }
	    return x;

	}
	public double[][] Multiply(double a[][],double b[][])
	{
		int i,j,k;
		if(a[0].length!=b.length)
			throw new IllegalArgumentException("Both should have same order to Multiply");
		double c[][] = new double[3][3];
		for(i=0;i<3;i++)
			for(j=0;j<3;j++)
				for(k=0;k<3;k++)
					 c[i][j]+=a[i][k]*b[k][j];
		return c;
	}
	public static void main(String args[])
	{
	/*	int ra,ca,rb,cb,i,j;
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Size of Matrix A");
		ra=s.nextInt();
		ca=s.nextInt();
		double a[][] = new double[ra][ca];

		double c[][] = new double[ra][ca];
		double d;
		System.out.println("Enter Matrix A");
		for(i=0;i<ra;i++)
		{
			for(j=0;j<ca;j++)
				a[i][j]=s.nextDouble();
		}
	
		s.close();
	
		for(i=0;i<ra-1;i++)
		{
			for(j=0;j<ca-1;j++)
				System.out.print(c[i][j]+" ");
			System.out.println();
		}
		System.out.println("INVERSE OF A"); */
		
		
	}
}
