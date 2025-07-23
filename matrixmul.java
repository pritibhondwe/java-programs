import java.util.Scanner;

public class matrixmul {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("enter the values of rows and columns:");
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        int arr1[][]=new int[rows][cols];
        int arr2[][]=new int[rows][cols];
        int mul[][]=new int [rows][cols];
        System.out.println("enter the values of  1st array:");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr1[i][j]=sc.nextInt();
            }
        }
        System.out.print("enter the values of  2nd array:");
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr2[i][j]=sc.nextInt();
            }
        }
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                for(int k=0;k<rows;k++)
                {
                    mul[i][j]+=arr1[i][k]*arr2[k][j];

                }
            }
             
            } 
            System.out.println("mul of two arrays");
            for(int i=0;i<rows;i++)
            {
            for(int j=0;j<cols;j++)
            {
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
            }
            
        }
        

    }

 
