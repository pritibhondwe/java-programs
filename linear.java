
import java.util.Scanner;

public class linear  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        System.out.println("Enter the values for the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();
        boolean flag =false;
        for(int x:arr)
        {
            if(x==key)
            {
                flag=true;
                break;
            }
        }
        if(flag)
        {
            System.out.println("key found");
        }
        else
        {
            System.out.println("key not found");

        }
        
        
    }
}


