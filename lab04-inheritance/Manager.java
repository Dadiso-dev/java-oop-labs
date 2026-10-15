public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
        System.out.println("Manager constructor: " + name);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }
}