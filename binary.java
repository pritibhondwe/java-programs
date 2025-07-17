import java.util.Scanner;

public class binary {
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
        int left = 0, right = arr.length - 1;
        int result=-1;
        while (left <= right)
        {
        int mid = left + (right - left) / 2;
        if(arr[mid]==key)
        {
        result=mid;
        break;
        }
        if(arr[mid]<key)
        {
            left=mid+1;
        }
        else{
            right=mid-1;
        }

        }
        System.out.println(result>=0?"key found":"key not found");

        sc.close();

    }
} 