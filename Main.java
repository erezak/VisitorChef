public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();

        // Prepare a pizza
        Dish pizza = new Pizza();
        chef.prepareDish(pizza);

        // Prepare a pasta
        Dish pasta = new Pasta();
        chef.prepareDish(pasta);

        // Prepare a salad
        Dish salad = new Salad();
        chef.prepareDish(salad);
    }
}

abstract class Dish {
    public abstract void cook();
}

class Pizza extends Dish {
    @Override
    public void cook() {
        System.out.println("Cooking Pizza...");
    }
}

class Pasta extends Dish {
    @Override
    public void cook() {
        System.out.println("Cooking Pasta...");
    }
}

class Salad extends Dish {
    @Override
    public void cook() {
        System.out.println("Making Salad...");
    }
}

class Chef {
    public void prepareDish(Dish dish) {
        dish.cook();
    }
}
