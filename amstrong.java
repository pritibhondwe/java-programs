import java.util.*;
public class amstrong 
{
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter one number");
        int num = sc.nextInt();
        int temp=num;
        int cnt=(num +"").length();
        int result=0;
        while(num>0)
        {
            int digit =  num%10;
            result+=Math.pow(digit,cnt);
            num/=10;

        }  
        String res=(temp==result)?"armstrong num":"not a amstrong num";
        System.out.println(res);
    }
}

