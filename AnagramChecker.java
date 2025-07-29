import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🔤 Anagram Checker");
        System.out.print("Enter first string: ");
        String str1 = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine().toLowerCase().replaceAll("\\s", "");

        boolean result = isAnagram(str1, str2);

        if (result) {
            System.out.println("✅ The strings are anagrams.");
        } else {
            System.out.println("❌ The strings are NOT anagrams.");
        }

        sc.close();
    }

    public static boolean isAnagram(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;

      
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    
        return Arrays.equals(arr1, arr2);
    }
}

