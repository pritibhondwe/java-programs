import java.util.Scanner;

public class array2 {
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter the values for the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        
        int max=arr[0];
        int min=arr[0] ;

        
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
            if (x < min) {
                min = x;
            }
        }

        
        System.out.println("Maximum value: " + max);
        System.out.println("Minimum value: " + min);
    }
}


