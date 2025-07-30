import java.util.Scanner;

public class CountWordCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        
        String[] words = input.trim().split("\\s+");

        int wordCount = (input.trim().isEmpty()) ? 0 : words.length;
        int charCount = input.replaceAll("\\s+", "").length(); 

        System.out.println("Total words: " + wordCount);
        System.out.println("Total characters (excluding spaces): " + charCount);

        sc.close();
    }
}
