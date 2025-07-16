 import java.util.*;

public class arrayOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the values for the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("1.linear search\n2.max\n3.min\n4.sum\n5.avg\n6.binary\n7.sort");
        System.out.println("enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:

                System.out.print("Enter the key to search: ");
                int key = sc.nextInt();
                boolean flag = false;
                for (int x : arr) {
                    if (x == key) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("key found");
                } else {
                    System.out.println("key not found");

                }
                break;
            case 2:
                int max;
                max = arr[0];
                for (int x : arr) {
                    if (max < x) {
                        max = x;
                    }
                }
                System.out.println("max:" + max);
                break;
            case 3:
                int min;
                min = arr[0];
                for (int x : arr) {
                    if (min > x) {
                        min = x;
                    }
                }
                System.out.println("min:" + min);
                break;
            case 4:
                int sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                System.out.println("sum:" + sum);
                break;
            case 5:
                int sum1 = 0;
                for (int num : arr) {
                    sum1 += num;

                }
                double average = (double) sum1 / n;
                System.out.println("average:" + average);
                break;
            case 6:
                System.out.println("values from array");
                System.out.print("Enter the key to search: ");
                int key = sc.nextInt();
                int left = 0, right = arr.length - 1;
                int result = -1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] == key) {
                        result = mid;
                        break;
                    }
                    if (arr[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                }
                System.out.println(result >= 0 ? "key found" : "key not found");
            case 7:
                int a[];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (a[j] > a[j + 1]) {
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                        }
                    }
                }
            default:
                System.out.println("invalid choice");

        }

        // Double avg = arrays.stream(arr).average().getAsDouble();
        // System.out.println("avg:"+avg);
        // int key=12;
        // boolean rs= intstream.of(arr).anyMatch(x->x==key)

    }
}
 