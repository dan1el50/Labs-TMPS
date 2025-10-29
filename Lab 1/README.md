# Creational Design Patterns


## Author: Daria Ratteeva

----

## Objectives:

* Get familiar with the Creational Design Patterns;
* Choose a specific domain;
* Implement at least 3 Creational Design Patterns for the specific domain;


## Used Design Patterns:

* Singleton Pattern
* Factory Method Pattern
* Builder Pattern


## Implementation

### Singleton Pattern

The Singleton pattern is implemented in the RestaurantOrderSystem class to ensure that only one instance of the order management system exists throughout the application. The implementation uses a private static variable to hold the single instance, a private constructor to prevent external instantiation, and a public static getInstance() method that provides global access to the instance using lazy initialization. This approach guarantees that all parts of the restaurant application access the same order system, maintaining consistent order history, revenue tracking, and statistics, which is essential for preventing data fragmentation and ensuring accurate business operations.

**RestaurantOrderSystem:**
```
public class RestaurantOrderSystem {

    // Static instance variable
    private static RestaurantOrderSystem instance;

    // Order management
    private List<Meal> orderHistory;
    private int totalOrders;
    private double totalRevenue;

    // Private constructor
    private RestaurantOrderSystem() {
        this.orderHistory = new ArrayList<>();
        this.totalOrders = 0;
        this.totalRevenue = 0.0;
    }

    // Static method to get the single instance
    public static RestaurantOrderSystem getInstance() {
        if (instance == null) {
            instance = new RestaurantOrderSystem();
        }
        return instance;
    }
}

```

---

### Factory Method Pattern

The Factory Method pattern is implemented through an abstract MealFactory class and its concrete subclasses (ItalianMealFactory, AmericanMealFactory, HealthyMealFactory) to create different types of meals without specifying their exact classes. Each concrete factory overrides the abstract createMeal() method to instantiate specific meal types (Pizza, Pasta, Burger, Salad) based on the cuisine type. This implementation follows the Open-Closed Principle, allowing new cuisine types and meal varieties to be added without modifying existing code, while the orderMeal() template method ensures consistent meal preparation and serving across all factories.

**MealFactory (Abstract Creator):**
```
public abstract class MealFactory {
    // Factory Method
    public abstract Meal createMeal();
    // Template method that uses the factory method
    public Meal orderMeal() {
        Meal meal = createMeal();
        meal.prepare();
        meal.serve();
        return meal;
    }
}
```

**ItalianMealFactory (Concrete Creator):**
```
public class ItalianMealFactory extends MealFactory {
    private String mealType;
    public ItalianMealFactory(String mealType) {
        this.mealType = mealType;
    }
    @Override
    public Meal createMeal() {
        if (mealType.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (mealType.equalsIgnoreCase("pasta")) {
            return new Pasta();
        }
        return null;
    }
}
```
**AmericanMealFactory (Concrete Creator):**
```
public class AmericanMealFactory extends MealFactory {
    @Override
    public Meal createMeal() {
        return new Burger();
    }
}
```

**HealthyMealFactory (Concrete Creator):**
```
public class HealthyMealFactory extends MealFactory {
    @Override
    public Meal createMeal() {
        return new Salad();
    }
}

```
**Usage in Main.java:**
```
MealFactory italianFactory = new ItalianMealFactory("pizza");
        Meal pizza = italianFactory.orderMeal();
        orderSystem.placeOrder(pizza);
```
---

### Builder Pattern

The Builder pattern is implemented through the MealBuilder interface and its concrete implementations (PizzaBuilder, BurgerBuilder, SaladBuilder) to construct complex meal objects step-by-step with multiple optional parameters. Each builder provides methods for setting different meal components (base, protein, vegetables, sauce, toppings, sides) that return the builder itself, enabling method chaining for a fluent and readable API. This approach solves the problem of creating objects with numerous optional parameters by allowing clients to specify only the desired components in any order, resulting in more maintainable code compared to constructors with multiple parameters.
    
**MealBuilder.java (Builder Interface):**
```
public interface MealBuilder {
    MealBuilder setBase(String base);
    MealBuilder addProtein(String protein);
    MealBuilder addVegetables(String vegetables);
    MealBuilder addSauce(String sauce);
    MealBuilder addToppings(String toppings);
    MealBuilder addSides(String sides);
    Meal build();
}
```

**Usage Example:**
```
System.out.println("Building custom Margherita Pizza...");
        Meal customPizza = new PizzaBuilder()
                .setBase("Thin Crust")
                .addSauce("Tomato Sauce")
                .addToppings("Mozzarella, Basil, Olive Oil")
                .addSides("Garlic Bread")
                .build();
        customPizza.prepare();
        customPizza.serve();
        customPizza.displayInfo();
        orderSystem.placeOrder(customPizza);
```


## Conclusions

This laboratory work successfully implemented three Gang of Four creational design patterns in a food ordering system domain. The **Singleton pattern** ensures centralized management of system configuration and order tracking, preventing multiple instances and providing consistent global access. The **Factory Method pattern** delegates object creation to subclasses, allowing new food types to be added without modifying existing client code, demonstrating the Open/Closed principle. The **Builder pattern** separates complex object construction from representation, supporting both fluent custom meal building and Director-controlled predefined configurations.

The project structure follows proper separation of concerns with distinct packages: `client` for the main application, `factory` for Factory Method classes, `builder` for Builder pattern implementations, `singleton` for Singleton classes, and `models` for domain entities. This modular organization makes the codebase maintainable and clearly demonstrates where each pattern is applied.

The implementation proves that creational patterns are not isolated solutions but work harmoniously together—factories create objects, builders assemble them into complex structures, and singletons manage shared state. Future extensions could easily add new food types through additional factory subclasses, new meal combinations through director methods, or new global services as singletons, all without breaking existing functionality. This demonstrates the core value of design patterns: creating flexible, maintainable, and extensible software architectures.

## Screenshots
![img.png](factory_method.png)

![img.png](builder_method.png)

![img.png](singleton_pattern.png)

![img.png](order_history.png)