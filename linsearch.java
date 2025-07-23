 import java.util.Scanner;
import java.util.stream.IntStream;

public class linsearch 
{
    public static void main(String[] args)
    {
       
      Scanner sc = new Scanner(System.in);
      System.out.println("enter no of elements:");
      int n =sc.nextInt();
      int arr[]=new int[n];
      System.out.println("enter the value for array:");
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
      }
      System.out.println("values from array"); 
      System.out.print("Enter the key to search: ");
        int key = sc.nextInt();
        //insteam-take int array and generate stream of array
       boolean res= IntStream.of(arr).anyMatch(x->x==key);
       System.out.println(res?"found":"not found");
       sc.close();
        
        
      
}
}
