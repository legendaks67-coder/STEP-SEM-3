public class BankTransactionValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) return null;
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed; // Not enough characters to uppercase 3
        
        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return firstThree + rest;
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }
        
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        
        String bankCode = reference.substring(0, 3);
        String datePart = reference.substring(3, 9);
        String seqPart = reference.substring(9, 14);
        
        String formattedDate = datePart.substring(0, 2) + "/" + datePart.substring(2, 4) + "/" + datePart.substring(4, 6);
        
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(formattedDate).append(" | ");
        sb.append("SEQ: ").append(seqPart);
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = " hdf03022600042 ";
        String normalized1 = normalizeReference(input1);
        System.out.println(validateAndFormat(normalized1));
        
        String input2 = "12F03022600042";
        String normalized2 = normalizeReference(input2);
        System.out.println(validateAndFormat(normalized2));
    }
}
