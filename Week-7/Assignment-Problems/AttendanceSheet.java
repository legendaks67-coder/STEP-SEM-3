public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String studentName) {
        if (studentName == null) return;
        if (isPresent(studentName)) {
            return;
        }
        if (count < presentStudents.length) {
            presentStudents[count++] = studentName;
        } else {
            System.out.println("Class size limit reached. Cannot mark present: " + studentName);
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String studentName) {
        if (studentName == null) return false;
        for (int i = 0; i < count; i++) {
            if (studentName.equals(presentStudents[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("sheet.getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("sheet.isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("sheet.isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
