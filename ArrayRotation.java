 import java.util.Scanner;

public class ArrayRotation {

    static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d %= n; // in case d > n
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[(i + d) % n];
        }

        System.out.print("Array after left rotation: ");
        printArray(temp);
    }

    
    static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        d %= n; // in case d > n
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + d) % n] = arr[i];
        }

        System.out.print("Array after right rotation: ");
        printArray(temp);
    }

    static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

     
        System.out.print("Enter number of positions to rotate: ");
        int d = sc.nextInt();

        leftRotate(arr, d);
        rightRotate(arr, d);

        sc.close();
    }
}
 