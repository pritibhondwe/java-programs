import java.util.Scanner;

public class twoD 

{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("enter the values of rows and columns:");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int arr[][]=new int[rows][cols];
        System.out.println("enter the values of array:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}