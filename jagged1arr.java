import java.util.Scanner;

public class jagged1arr
 {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        
        System.out.println("enter value for rows");
        int row=sc.nextInt();
        int jaggedArr[][]=new int[row][];
        for(int i=0;i<jaggedArr.length;i++)
        {
            System.out.println("enter col value  for rows:"+(i+1));
            jaggedArr[i]=new int[sc.nextInt()];
        }
        System.out.println("enter value for array");
      
        for(int x[]:jaggedArr)
        {
            for(int a:x)
            {
                System.out.print(a +" ");
            }
            System.out.println();
        }
    }
}

