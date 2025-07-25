 import java.util.*;
public class product {

	public static void main(String[] args)
	{
        for(int i=1;i<=3;i++)
        {
		int pid,qty;
		String pname;
		float price,total;
		
		float discount=0,totaldiscount=0;
        float finalbill=0;
        float finalbilldiscount=0;
         {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter product id:");
		pid=sc.nextInt();
		System.out.println("enter product name:");
		pname =sc.next();
		System.out.println("enter product price:");
        price=sc.nextFloat();
        System.out.println("enter product qty");
        qty=sc.nextInt();
        
        total=(price*qty);
        
        if(total>10000)
        {
            discount=10f;
            totaldiscount=total*0.1f;

        }
        else if(total>8000)
        {
            discount=8f;
            totaldiscount=total*0.08f;
        }
        else if(total>7000)
        {
            discount=7f;
            totaldiscount=total*0.07f;
        }
        else
        {
            discount=0f;
        }
        
        System.out.println("--------Total Bill----------");
        System.out.println("pname:"+pname);
        System.out.println("total:"+total);
        System.out.println("discount:"+discount+"%");
        System.out.println("amount to pay:"+(total-totaldiscount));
        
        System.out.println("-------------------------");


        
	    }
    }
}
} 