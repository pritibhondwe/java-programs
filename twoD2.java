import java.util.Scanner;

public class twoD2
{
   public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("enter the values of rows and columns:");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        System.out.println("enter the values of  1st array:");
        int arr[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print("enter the values of  2nd array:");
        int arr1[][]=new int [rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr1[i][j]=sc.nextInt();
            }
        }
        System.out.println("values for 1st array");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr[i][j] + " " );
            }
            System.out.println();
        }
        System.out.println("values for 2st array");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        int sumArray[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
             sumArray[i][j]= arr[i][j] + arr1[i][j];
            }
        }
        System.out.println("sum of two arrays");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(sumArray[i][j] + " ");
            }
            System.out.println();
        }
        int subArray[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                subArray[i][j]= arr[i][j] - arr1[i][j];
            }
            
        }
        System.out.println("sub of two arrays");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(subArray[i][j] + " ");
            }
            System.out.println();
        }
        int mulArray[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                mulArray[i][j]= arr[i][j] * arr1[i][j];
            }
            
        }
        System.out.println("mul of two arrays");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                System.out.print(mulArray[i][j] + " ");
            }
            System.out.println();
        }
        int divArray[][]=new int[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                divArray[i][j]= arr[i][j] / arr1[i][j];
            }
        }
        System.out.println("div of two arrays");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {

                System.out.print(divArray[i][j] + " ");
            }
            System.out.println();
        }
    
   }
}

