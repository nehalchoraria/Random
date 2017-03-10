import java.net.UnknownHostException;
import java.util.Scanner;


public class Quickfind 
{
	
	public static void main(String[] args) throws UnknownHostException 
	{
		int arr[][] = {{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8},{9,9}};
		System.out.println();
		int ch;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int m ,n ;
		do
		{	
		System.out.println("Choose : 1. Connect 2. Disconnect 3. View Connections 4.Exit");
		ch=sc.nextInt();
		
		switch(ch)
		{
		case 1: 
		System.out.println("Enter values: ");
		m=sc.nextInt(); n= sc.nextInt();
		connect(m,n,arr);
		break;
		case 2: System.out.println("Enter number: ");
		m=sc.nextInt();
			disconnect(m,arr);
		break;
		case 3:  view(arr);
			break;
		case 4: System.out.println("Exited");
		break;
		
		default:System.out.println("Enter correct number");
		}
		}while(ch!=4);
		
	}
	static void connect(int m,int n,int arr[][])
	{
	   int id= 0 ; int id2=0 ;
	   if(arr[n][1]==arr[m][1])
	   {
		   System.out.println("Both are already connected");
	   }
	   else
	   {
		   id=arr[m][1];
		   id2=arr[n][1];
		   
		   if(id>id2)
		   {
			   for(int c=0 ; c<=9;c++)
					
			   {  
				    	  if(id2==arr[c][1])
				    	  {
				    		  arr[c][1]=id;
				    	  }
				}
				   System.out.println("Numbers Connected!!"); 
		   }
			  // 3<8 --- 9  m.n
			   
	       else
			{  
				for(int c=0 ; c<=9;c++)
			
			   {  
				    	  if(id==arr[c][1])
				    	  {
				    		  arr[c][1]=id2;
				    	  }
				}
				   System.out.println("Numbers Connected!");   
		    }
			
	   } 
	}
	
	static void view(int arr[][])
			{
		
		      int count = 0  ; boolean flag=false;
		      for(int inc=0 ; inc<=9 ; inc++)
		      {
		    	  count=0 ;
		    	  for(int c=0 ; c<=9;c++)
			      {  
			    	  if(inc==arr[c][1])
			    	  {
			    		  count++;
			    	  }
			      }
			      
			     if(count>=2)
			     {
			    	 for(int k = 0 ; k<=9 ; k++)
			    	 {
			    		 if(arr[k][1]==inc)
			    		 {
			    			 System.out.print(arr[k][0]+" ");
			    		 }
			    	 }
			    	 flag = true;
			    	 System.out.println("are connected!");
			     }
		      }
		      
		      if(flag==false)
		      {
		    	  System.out.println("No connections present!");
		      }
		
			}
	
	static void disconnect(int m,int arr[][])
	{
	    int id=arr[m][1]; int temp = 0;
		if(id>m)
		{
			arr[m][1]=m;
		    System.out.println("Number Disconnected!");
		}
		else
		{
		    for(int i=0 ; i<=9 ; i++)
		    {
			   if(id==arr[i][1] && m!=i)
			   {
				 if (arr[i][0]>=temp)
				 {
					 temp=arr[i][0];
				 }
			   }
		    }
		  
		    for(int i=0 ; i<=9 ; i++)
		    {
			   if(id==arr[i][1] && m!=i)
			   {
				   arr[i][1]=temp ;
			   }
		    }
		    System.out.println("Number Disconnected!");

		}
	}

}
