public class CharFrequencySimple {
    public static void main(String[] args) {
        String input = "aabbccdde";
        int[] freq = new int[256];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (freq[ch] != 0) {
                System.out.print(ch + ":" + freq[ch] + " ");
                freq[ch] = 0; 
            }
        }
    }
}
