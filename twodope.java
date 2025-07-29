import java.util.Scanner;

public class twodope{

    public static void sumArray(int arr1[][], int arr2[][], int rows, int cols) {
        int sum[][] = new int[rows][cols];
        System.out.println("Sum of arrays:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void subArray(int arr1[][], int arr2[][], int rows, int cols) {
        int sub[][] = new int[rows][cols];
        System.out.println("Subtraction of arrays:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sub[i][j] = arr1[i][j] - arr2[i][j];
                System.out.print(sub[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void multiplyArray(int arr1[][], int arr2[][], int rows, int cols) {
        int mul[][] = new int[rows][cols];
        System.out.println("Multiplication of arrays:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mul[i][j] = arr1[i][j] * arr2[i][j];
                System.out.print(mul[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transposeArray(int arr1[][],int arr2[][] ,int rows, int cols) {
        int trans[][] = new int[cols][rows];
        System.out.println("Transpose of the first array:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                trans[i][j] = arr1[j][i];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Transpose of the 2nd  array:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                trans[i][j] = arr2[j][i];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
    }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int arr1[][] = new int[rows][cols];
        int arr2[][] = new int[rows][cols];

        System.out.println("Enter the values of 1st array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the values of 2nd array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }

        System.out.println("1. Sum of array\n2. Subtraction of array\n3. Multiplication of array\n4. Transpose of first array");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                sumArray(arr1, arr2, rows, cols);
                break;
            case 2:
                subArray(arr1, arr2, rows, cols);
                break;
            case 3:
                multiplyArray(arr1, arr2, rows, cols);
                break;
            case 4:
                transposeArray(arr1,arr2, rows, cols);
                break;
            default:
                System.out.println("Invalid choice!");
        }

       
    }
}

