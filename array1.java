 import java.util.*;
public class array1 
{
    public static void main(String[] args)
    {
       
      Scanner sc = new Scanner(System.in);
      System.out.println("enter no of elements:");
      int n =sc.nextInt();
      int arr[]=new int[5];
      System.out.println("enter the value for array:");
      for(int i=0;i<n;i++)
      {
        arr[i]=sc.nextInt();
      }
      System.out.println("values from array"); 
      //normal for loop
      //for(int i=0;i<n;i++)
     // {
      //  System.out.println(arr[i]);
      //}
      //foreach loop use in iterable 
      for(int x:arr)
      {
        System.out.println(x);
      }
    }
}
 