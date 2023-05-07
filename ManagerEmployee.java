class Employee {
    public void assignTask(DesignTask task) {
        System.out.println("Design task assigned to employee.");
    }

    public void assignTask(CodingTask task) {
        System.out.println("Coding task assigned to employee.");
    }
}

class Engineer extends Employee {
    @Override
    public void assignTask(DesignTask task) {
        System.out.println("Design task assigned to engineer.");
    }

    @Override
    public void assignTask(CodingTask task) {
        System.out.println("Coding task assigned to engineer.");
    }
}

abstract class Task {}

class DesignTask extends Task {}

class CodingTask extends Task {}

public class ManagerEmployee {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Engineer engineer = new Engineer();
        Task designTask = new DesignTask();
        Task codingTask = new CodingTask();

        employee.assignTask(designTask); // prints "Design task assigned to employee."
        employee.assignTask(codingTask); // prints "Coding task assigned to employee."
        engineer.assignTask(designTask); // prints "Design task assigned to engineer."
        engineer.assignTask(codingTask); // prints "Coding task assigned to engineer."
    }
}
