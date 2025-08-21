import java.util.*;

class Student {
    int id;
    String name;
    int age;

  
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

 
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

public class StudentCRUD {
    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

  
    public static void createStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
        System.out.println("✅ Student Added Successfully!\n");
    }

   
    public static void readStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ No Students Found!\n");
            return;
        }
        System.out.println("📋 Student List:");
        for (Student s : students) {
            s.display();
        }
        System.out.println();
    }

   
    public static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                System.out.println("✅ Student Updated Successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student Not Found!\n");
    }

  
    public static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.id == id) {
                it.remove();
                System.out.println("🗑️ Student Deleted Successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student Not Found!\n");
    }

  
    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Student CRUD System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: createStudent(); break;
                case 2: readStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("👋 Exiting... Bye!"); System.exit(0);
                default: System.out.println("❌ Invalid Choice!\n");
            }
        }
    }
}

