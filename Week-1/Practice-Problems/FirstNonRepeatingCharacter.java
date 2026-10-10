public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        
        return '\0'; // Return null character if no non-repeating character exists
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        
        for (String test : tests) {
            char result = findFirstNonRepeatingChar(test);
            if (result == '\0') {
                System.out.printf("Input: \"%s\" | Output: No Non-Repeating Character Found\n", test);
            } else {
                System.out.printf("Input: \"%s\" | Output: First Non-Repeating Character: '%c'\n", test, result);
            }
        }
    }
}
