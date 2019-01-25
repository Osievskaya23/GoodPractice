package patterns.factory;

import java.util.ArrayList;

abstract class PizzaStore {

    Pizza orderPizza(String typeOfPizza) {
        Pizza pizza = createPizza(typeOfPizza);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza (String typeOfPizza);
}

class NYStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String typeOfPizza) {
        switch (typeOfPizza) {
            case "cheese": return new NYStyleCheesePizza();
            case "pepperoni": return new NYStylePepperoni();
            case "clam": return new NYStyleClam();
            case "veggie": return new NYStyleVeggie();
        }
        return null;
    }
}

class ChicagoStylePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String typeOfPizza) {
        switch (typeOfPizza) {
            case "cheese": return new ChicagoStyleCheesePizza();
            case "pepperoni": return new ChicagoStylePepperoni();
            case "clam": return new ChicagoStyleClam();
            case "veggie": return new ChicagoStyleVeggie();
        }
        return null;
    }
}

abstract class Pizza {

    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare() {
        System.out.println("Preparing " + name + "\n" +
                "Tossing dough...\nAdding sauce...\nAdding toppings: " );
        for (Object t: toppings) {
            System.out.println(t + " ");
        }
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350 degrees.");
    }

    void cut() {
        System.out.println("Cut the pizza into diagonal slices.");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    String getName() {
        return name;
    }
}

class NYStyleCheesePizza extends Pizza {
    NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }
}

class NYStylePepperoni extends Pizza {
}

class NYStyleClam extends Pizza {
}

class NYStyleVeggie extends Pizza {
}

class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish and Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cut the pizza into square slices.");
    }
}

class ChicagoStylePepperoni extends Pizza {
}

class ChicagoStyleClam extends Pizza {
}

class ChicagoStyleVeggie extends Pizza {
}

class Test {
    public static void main(String[] args) {
        PizzaStore nyStylePizzaStore = new NYStylePizzaStore();
        PizzaStore chicagoStylePizzaStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStylePizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + ".\n");

        pizza = chicagoStylePizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + ".\n");
    }
}


