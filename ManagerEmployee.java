class Employee {
    public void assignTask(Task task) {
        task.accept(new EmployeeTaskVisitor());
    }

    private class EmployeeTaskVisitor implements TaskVisitor {
        @Override
        public void visit(DesignTask task) {
            System.out.println("Design task assigned to employee.");
        }

        @Override
        public void visit(CodingTask task) {
            System.out.println("Coding task assigned to employee.");
        }
    }
}

class Engineer extends Employee {
    @Override
    public void assignTask(Task task) {
        task.accept(new EngineerTaskVisitor());
    }

    private class EngineerTaskVisitor implements TaskVisitor {
        @Override
        public void visit(DesignTask task) {
            System.out.println("Design task assigned to engineer.");
        }

        @Override
        public void visit(CodingTask task) {
            System.out.println("Coding task assigned to engineer.");
        }
    }
}

abstract class Task {
    public abstract void accept(TaskVisitor visitor);
}

class DesignTask extends Task {
    @Override
    public void accept(TaskVisitor visitor) {
        visitor.visit(this);
    }
}

class CodingTask extends Task {
    @Override
    public void accept(TaskVisitor visitor) {
        visitor.visit(this);
    }
}

interface TaskVisitor {
    void visit(DesignTask task);
    void visit(CodingTask task);
}

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
