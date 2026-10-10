public class BMICalculatorForTeam {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        System.out.println("------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d | %.2f m     | %.1f kg     | %.2f | %s\n", 
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.90, 1.70, 1.55, 1.85, 1.78, 1.68};
        double[] weights = {70.0, 90.0, 75.0, 55.0, 110.0, 68.0, 45.0, 85.0, 72.0, 65.0};
        
        printWellnessReport(heights, weights);
    }
}
