 import java.util.Arrays;
import java.util.Scanner;

public class binary2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of elements:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enter the value for array:");
        for (int i = 0; i < n; i++)
        {
        arr[i] = sc.nextInt();
        }
        System.out.println("values from array");
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();
        int result=Arrays.binarySearch(arr,key);
        System.out.println(result>=0?"key found":"key not found");
}
}