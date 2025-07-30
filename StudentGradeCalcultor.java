import java.util.Scanner;
public class StudentGradeCalcultor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String studentName;
        int[] marks = new int[5];
        int total = 0;
        double average;
        char grade;

        
        System.out.print("Enter student name: ");
        studentName = sc.nextLine();

        
        System.out.println("Enter marks for 5 subjects (out of 100):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

          
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println(" Invalid mark entered. Must be between 0 and 100.");
                return;
            }

            total += marks[i];
        }

     
        average = total / 5.0;

        
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

       
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Name        : " + studentName);
        System.out.println("Total Marks : " + total + "/500");
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);

        if (grade == 'F') {
            System.out.println("Status      : Fail");
        } else {
            System.out.println("Status      : Pass");
        }

        sc.close();
    }
}