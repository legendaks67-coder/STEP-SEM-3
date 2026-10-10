public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Strings must be of equal length.");
            return;
        }
        
        int matchCount = 0;
        int firstMismatchIndex = -1;
        
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }
        
        double accuracy = ((double) matchCount / original.length()) * 100;
        
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", matchCount, original.length(), accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
                    matchCount, original.length(), accuracy, firstMismatchIndex, original.charAt(firstMismatchIndex), typed.charAt(firstMismatchIndex));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
