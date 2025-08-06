public class ReverseWord {
    public static void main(String[] args) {
        String input = "Hello World";
        String[] words = input.split(" ");

        for (String word : words) {
            System.out.print(new StringBuilder(word).reverse().toString() + " ");
        }
    }
}


