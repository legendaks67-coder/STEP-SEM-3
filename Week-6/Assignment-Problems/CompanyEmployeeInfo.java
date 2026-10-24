public class CompanyEmployeeInfo {
    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Amit", 50000);
        Employee emp2 = new Employee("Priya", 60000);
        Employee emp3 = new Employee("Rohan", 55000);

        Employee.printCompanyInfo();
    }
}
