
import java.util.Scanner;
public class flight
 {
    public static void main(String[] args) 
    {
        boolean seats[][]={new boolean[5],new boolean[3],new boolean[2]};
        int classChoice,seatNo;
        while(true){
        System.out.println("Seat Availabilty");
        for(int i =0;i<seats.length;i++)
        {
            System.out.print("class"+(i+1)+":");
            for(boolean seat:seats[i])
            {
             System.out.print(seat?"[X]":"[]");
            }
            System.out.println();
        }
        System.out.println("Enter class(1-Economy,2-Bussiness,3-first,0 to Exit)");
        Scanner sc=new Scanner(System.in);
        classChoice=sc.nextInt();
        if(classChoice==0){
            break;
        }
        if(classChoice<1||classChoice>3){
            System.out.println("invalid choice please return the choice");
            continue;
        }
       
        System.out.println("Enter the seat number(1-"+ seats [classChoice-1].length+"):");
        seatNo=sc.nextInt();

        if(seatNo<1||seatNo>seats[classChoice-1].length)
        {
            System.out.println("Invalid seat no please enter the correct one");
            continue;
        }
        if(seats[classChoice-1][seatNo-1]){
            System.out.println("booked");
        }
        else
        {
            seats[classChoice-1][seatNo-1]=true;
            System.out.println("seats"+" "+seatNo+" "+"class"+" "+classChoice+"has booked ");
        }
       
         
    }
    System.out.println("Thank you for visiting portal....");
    
}  
}
 


