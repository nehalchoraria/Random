import java.util.Scanner;

public class arm5 
{
	
     public static void main(String main[])
	{   
       int n ; int remainder ;
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter the limit for armstrong number : ");
       int limit = sc.nextInt();
	   for ( int i = 0 ; i < limit ; i++ )
	       {    n = i ;
	              int sum = 0 ;
	                while(n!=0)
	              {   remainder = n%10 ;
	                   sum = sum + (int)(Math.pow(remainder,String.valueOf(i).length())) ;
	                   n = n/10 ;
	              }
	         
	          if ( sum == i )
	          {  System.out.println("Armstrong is :"+i) ; } 
		   }
       
    }
}
