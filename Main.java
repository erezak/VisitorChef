public class Main {
    public static void main(String[] args) {
        TakeoutVisitor takeoutVisitor = new TakeoutVisitor();
        // Prepare a vegetarian pizza
        Dish pizza = new Pizza();
        DishVisitor vegetarianVisitor = new VegetarianVisitor();
        pizza.accept(vegetarianVisitor);
        pizza.accept(takeoutVisitor);

        // Prepare a vegan pasta
        Dish pasta = new Pasta();
        DishVisitor veganVisitor = new VeganVisitor();
        pasta.accept(veganVisitor);
        pasta.accept(takeoutVisitor);

        // Prepare a regular salad
        Dish salad = new Salad();
        DishVisitor regularVisitor = new RegularVisitor();
        salad.accept(regularVisitor);
        salad.accept(takeoutVisitor);

        // Prepare a kosher dish
        Dish kosherDish = new Pasta();
        DishVisitor kosherVisitor = new KosherVisitor();
        kosherDish.accept(kosherVisitor);
        kosherDish.accept(takeoutVisitor);
    }
}

abstract class Dish {
    public abstract void accept(DishVisitor dishVisitor);
}

class Pizza extends Dish {
    @Override
    public void accept(DishVisitor dishVisitor) {
        dishVisitor.visit(this);
    }
}

class Pasta extends Dish {
    @Override
    public void accept(DishVisitor dishVisitor) {
        dishVisitor.visit(this);
    }
}

class Salad extends Dish {
    @Override
    public void accept(DishVisitor dishVisitor) {
        dishVisitor.visit(this);
    }
}

abstract class DishVisitor {
    public abstract void visit(Pizza pizza);
    public abstract void visit(Pasta pasta);
    public abstract void visit(Salad salad);
}

class VegetarianVisitor extends DishVisitor {
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

class VeganVisitor extends DishVisitor {
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

class RegularVisitor extends DishVisitor {
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

class KosherVisitor extends DishVisitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Cooking kosher pizza...");
    }

    @Override
    public void visit(Pasta pasta) {
        System.out.println("Cooking kosher pasta...");
    }

    @Override
    public void visit(Salad salad) {
        System.out.println("Making kosher salad...");
    }
}

abstract class Diet {}

class Vegetarian extends Diet {}

class Vegan extends Diet {}

class Regular extends Diet {}

class Kosher extends Diet {}

class TakeoutVisitor extends DishVisitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Packing pizza in a box...");
    }

    @Override
    public void visit(Pasta pasta) {
        System.out.println("Putting pasta in a container...");
    }

    @Override
    public void visit(Salad salad) {
        System.out.println("Wrapping salad in a bag...");
    }
}