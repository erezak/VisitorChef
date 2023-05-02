public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();

        // Prepare a vegetarian pizza
        Dish pizza = new Pizza();
        Diet vegetarian = new Vegetarian();
        chef.prepareDish(pizza, vegetarian);

        // Prepare a vegan pasta
        Dish pasta = new Pasta();
        Diet vegan = new Vegan();
        chef.prepareDish(pasta, vegan);

        // Prepare a regular salad
        Dish salad = new Salad();
        Diet regular = new Regular();
        chef.prepareDish(salad, regular);
    }
}

abstract class Dish {
    public abstract void cook(Diet diet);
}

class Pizza extends Dish {
    @Override
    public void cook(Diet diet) {
        if (diet instanceof Vegetarian) {
            System.out.println("Cooking vegetarian pizza...");
        } else if (diet instanceof Vegan) {
            System.out.println("Cooking vegan pizza...");
        } else {
            System.out.println("Cooking regular pizza...");
        }
    }
}

class Pasta extends Dish {
    @Override
    public void cook(Diet diet) {
        if (diet instanceof Vegetarian) {
            System.out.println("Cooking vegetarian pasta...");
        } else if (diet instanceof Vegan) {
            System.out.println("Cooking vegan pasta...");
        } else {
            System.out.println("Cooking regular pasta...");
        }
    }
}

class Salad extends Dish {
    @Override
    public void cook(Diet diet) {
        if (diet instanceof Vegetarian) {
            System.out.println("Making vegetarian salad...");
        } else if (diet instanceof Vegan) {
            System.out.println("Making vegan salad...");
        } else {
            System.out.println("Making regular salad...");
        }
    }
}

abstract class Diet {}

class Vegetarian extends Diet {}

class Vegan extends Diet {}

class Regular extends Diet {}

class Chef {
    public void prepareDish(Dish dish, Diet diet) {
        dish.cook(diet);
    }
}
