public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();

        // Prepare a vegetarian pizza
        Dish pizza = new Pizza();
        DietVisitor vegetarianVisitor = new VegetarianVisitor();
        chef.prepareDish(pizza, vegetarianVisitor);

        // Prepare a vegan pasta
        Dish pasta = new Pasta();
        DietVisitor veganVisitor = new VeganVisitor();
        chef.prepareDish(pasta, veganVisitor);

        // Prepare a regular salad
        Dish salad = new Salad();
        DietVisitor regularVisitor = new RegularVisitor();
        chef.prepareDish(salad, regularVisitor);
    }
}

abstract class Dish {
    public abstract void accept(DietVisitor dietVisitor);
}

class Pizza extends Dish {
    @Override
    public void accept(DietVisitor dietVisitor) {
        dietVisitor.visit(this);
    }
}

class Pasta extends Dish {
    @Override
    public void accept(DietVisitor dietVisitor) {
        dietVisitor.visit(this);
    }
}

class Salad extends Dish {
    @Override
    public void accept(DietVisitor dietVisitor) {
        dietVisitor.visit(this);
    }
}

abstract class DietVisitor {
    public abstract void visit(Pizza pizza);
    public abstract void visit(Pasta pasta);
    public abstract void visit(Salad salad);
}

class VegetarianVisitor extends DietVisitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Cooking vegetarian pizza...");
    }

    @Override
    public void visit(Pasta pasta) {
        System.out.println("Cooking vegetarian pasta...");
    }

    @Override
    public void visit(Salad salad) {
        System.out.println("Making vegetarian salad...");
    }
}

class VeganVisitor extends DietVisitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Cooking vegan pizza...");
    }

    @Override
    public void visit(Pasta pasta) {
        System.out.println("Cooking vegan pasta...");
    }

    @Override
    public void visit(Salad salad) {
        System.out.println("Making vegan salad...");
    }
}

class RegularVisitor extends DietVisitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Cooking regular pizza...");
    }

    @Override
    public void visit(Pasta pasta) {
        System.out.println("Cooking regular pasta...");
    }

    @Override
    public void visit(Salad salad) {
        System.out.println("Making regular salad...");
    }
}

abstract class Diet {}

class Vegetarian extends Diet {}

class Vegan extends Diet {}

class Regular extends Diet {}

class Chef {
    public void prepareDish(Dish dish, DietVisitor dietVisitor) {
        dish.accept(dietVisitor);
    }
}
