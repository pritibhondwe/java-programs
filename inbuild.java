 import java.util.*;
import java.util.stream.IntStream;

public class inbuild
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter the values for the array:");
        for (int i = 0; i < n; i++) 
        {
        arr[i] = sc.nextInt();
        }
    
    System.out.println("1.linear search\n2.max\n3.min\n4.sum\n5.avg\n6.binary\n7.sort");
    System.out.println("enter your choice");
    int choice = sc.nextInt();
    switch(choice)
    {
    case 1:
       System.out.println("values from array"); 
       System.out.print("Enter the key to search: ");
       int key = sc.nextInt();
        
        boolean res= IntStream.of(arr).anyMatch(x->x==key);
        System.out.println(res?"found":"not found");
        break;
        case 2:
        int max=Arrays.stream(arr).max().getAsInt();
        System.out.println("max:"+max);
        break;
        case 3:
        int min=Arrays.stream(arr).min().getAsInt();
        System.out.println("min:"+min);
        break;
        case 4:
        int sum=Arrays.stream(arr).sum();
        System.out.println("sum:"+sum);
        break;
        case 5:
        double avg=Arrays.stream(arr).average().getAsDouble();
        System.out.println("avg:"+avg);
        break;
        case 6:
        int result=Arrays.binarySearch(arr,key);
        System.out.println(result>=0?"key found":"key not found");
        case 7:
        Arrays.sort(arr);
        for(int x:arr){
            System.out.println(x);
        }
        default:
        System.out.println("invalid choice");

    }
    }
}



    

 