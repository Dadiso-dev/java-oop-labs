public class Intern extends Employee {

    public Intern(String name, double stipend) {
        super(name, stipend);
    }

    @Override
    public double calculatePay() {
        return Math.min(baseSalary, 800.0);
    }
}