import java.util.Scanner;

public class jaggedarr
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
        for(int i=0;i<jaggedArr.length;i++)
        {
            System.out.println("enter value for col for"+(i+1)+"rows");
            for(int j=0;j<jaggedArr[i].length;j++){
                jaggedArr[i][j]=sc.nextInt();
            }
        }
        System.out.println("values of array are");
        for(int i=0;i<jaggedArr.length;i++)
        {
            for(int j=0;j<jaggedArr[i].length;j++)
            {
                System.out.print(jaggedArr[i][j]);
            }
            System.out.println();
        }
    }
}
