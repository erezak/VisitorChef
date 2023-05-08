//The Memento class

import java.util.Stack;

class CalculatorMemento {
    private final int state; //the state to be saved

    public CalculatorMemento(int state) {
        this.state = state;
    }

    public int getSavedState() {
        return state;
    }
}

//The Originator class
class Calculator {
    private int result; //the current state

    public void add(int operand) {
        result += operand; //perform addition
    }

    public void subtract(int operand) {
        result -= operand; //perform subtraction
    }

    public int getResult() {
        return result;
    }

    public CalculatorMemento save() {
        return new CalculatorMemento(result); //create a memento with the current state
    }

    public void restore(CalculatorMemento memento) {
        result = memento.getSavedState(); //restore the state from the memento
    }
}

//The Caretaker class
class CalculatorCaretaker {
    private final Stack<CalculatorMemento> mementos = new Stack<>(); //a stack of mementos

    public void save(Calculator calculator) {
        mementos.push(calculator.save()); //push a memento from the calculator to the stack
    }

    public void undo(Calculator calculator) {
        if (!mementos.isEmpty()) {
            calculator.restore(mementos.pop()); //pop a memento from the stack and restore the calculator
        }
    }
}

//The main class
public class CalculatorMemory {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(); //create a calculator object
        CalculatorCaretaker caretaker = new CalculatorCaretaker(); //create a caretaker object

        calculator.add(10); //add 10 to the result
        System.out.println("Result = " + calculator.getResult()); //print the result

        caretaker.save(calculator); //save the current state

        calculator.add(5); //add 5 to the result
        System.out.println("Result = " + calculator.getResult()); //print the result

        caretaker.save(calculator); //save the current state

        calculator.subtract(3); //subtract 3 from the result
        System.out.println("Result = " + calculator.getResult()); //print the result

        caretaker.undo(calculator); //undo the last operation
        System.out.println("Result = " + calculator.getResult()); //print the result

        caretaker.undo(calculator); //undo the last operation
        System.out.println("Result = " + calculator.getResult()); //print the result
    }
}