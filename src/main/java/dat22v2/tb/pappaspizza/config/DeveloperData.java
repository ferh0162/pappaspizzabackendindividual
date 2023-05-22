package dat22v2.tb.pappaspizza.config;

import dat22v2.tb.pappaspizza.entity.*;
import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import dat22v2.tb.pappaspizza.repository.*;

import dat22v2.tb.security.entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {

    IngredientRepository ingredientRepository;
    OrderRepository orderRepository;
    PizzaRepository pizzaRepository;
    DrinkRepository drinkRepository;
    ReceiptRepository receiptRepository;

    PizzaTypeRepository pizzaTypeRepository;

    BrandRepository brandRepository;

    DrinkSizeRepository drinkSizeRepository;

    AddressRepository addressRepository;

    UserRepository userRepository;

    public DeveloperData(IngredientRepository ingredientRepository, OrderRepository orderRepository, PizzaRepository pizzaRepository, DrinkRepository drinkRepository, ReceiptRepository receiptRepository, PizzaTypeRepository pizzaTypeRepository, BrandRepository brandRepository, DrinkSizeRepository drinkSizeRepository, AddressRepository addressRepository,UserRepository userRepository) {
        this.ingredientRepository = ingredientRepository;
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.drinkRepository = drinkRepository;
        this.receiptRepository = receiptRepository;
        this.pizzaTypeRepository = pizzaTypeRepository;
        this.brandRepository = brandRepository;
        this.drinkSizeRepository = drinkSizeRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientList();
        pizzaTypes();
        ferhatsPizzaList();
        drinkList();
        orderList();
        accountsAndAddresses();

    }

    public void accountsAndAddresses() {
        Address address = new Address();
        address.setId(1);
        address.setCity("Græsted");
        address.setZip("3230");
        address.setStreet("Wherever");
        addressRepository.save(address);

        User user = new User();
        user.setFirstName("Kristian");
        user.setLastName("Wede");
        user.setAddress(addressRepository.findById(1));
        user.setPhone("91826545");
        user.setEmail("kristianwede90@gmail.com");
        user.setUsername("Kristian");
        user.setPassword("Beaver");
        user.addRole(Role.ADMIN);

        userRepository.save(user);

        Address address2 = new Address();
        address2.setId(2);
        address2.setCity("Basicville");
        address2.setZip("6969");
        address2.setStreet("Wherever idk");
        addressRepository.save(address2);

        User user2 = new User();
        user2.setFirstName("Mark");
        user2.setLastName("Den store");
        user2.setAddress(addressRepository.findById(2));
        user2.setPhone("0850175");
        user2.setEmail("markKanGodt@gmail.com");
        user2.setUsername("Mark");
        user2.setPassword("Beaver");
        user2.addRole(Role.USER);
        userRepository.save(user2);
    }


    public void ferhatsPizzaList() {

        ArrayList<Pizza> pizzaList = new ArrayList<>(Arrays.asList(
            new Pizza(1, "Margherita", 68.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
            new Pizza(2, "Vesuvio", 70.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"))),
            new Pizza(3, "Hawaii", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"))),
            new Pizza(5, "Mix pizza", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
            new Pizza(6, "Capricciosa", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"))),
            new Pizza(7, "Denmark special", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Skinke"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
            new Pizza(8, "Napoli", 70.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"))),
            new Pizza(9, "Bolognese", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kødsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"))),
            new Pizza(10, "Kylling pizza", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
            new Pizza(11, "Romani", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"))),
            new Pizza(12, "Orient", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"))),
            new Pizza(13, "Pappas", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("æg"))),
            new Pizza(14, "Vegetaria", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
            new Pizza(15, "Feta", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"), ingredientRepository.findIngredientByNameIgnoreCase("Fetaost"))),
            new Pizza(16, "Husets pizza", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Salat dressing"), ingredientRepository.findIngredientByNameIgnoreCase("Dressing"))),
            new Pizza(17, "Spinaci", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Gorgonzola"), ingredientRepository.findIngredientByNameIgnoreCase("Tomatskiver"), ingredientRepository.findIngredientByNameIgnoreCase("Spinat"))),
            new Pizza(18, "Marmaris", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"))),
            new Pizza(19, "Lezzet", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Ananas"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Oliven"))),
            new Pizza(20, "Milano", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Paprika"), ingredientRepository.findIngredientByNameIgnoreCase("ærter"), ingredientRepository.findIngredientByNameIgnoreCase("Majs"))),
            new Pizza(21, "Kebab", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Champginon"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"))),
            new Pizza(22, "Memo speciale", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Kød"), ingredientRepository.findIngredientByNameIgnoreCase("Chili"), ingredientRepository.findIngredientByNameIgnoreCase("Grøn Peber"))),
            new Pizza(23, "Tuna", 80.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Tun"))),
            new Pizza(24, "Inca", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni"), ingredientRepository.findIngredientByNameIgnoreCase("Jalapenos"), ingredientRepository.findIngredientByNameIgnoreCase("Hvidløg"), ingredientRepository.findIngredientByNameIgnoreCase("Hakket Oksekød"), ingredientRepository.findIngredientByNameIgnoreCase("Tacosauce"))),
            new Pizza(26, "Matador", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Kødstrimler"), ingredientRepository.findIngredientByNameIgnoreCase("Stegt Løg"), ingredientRepository.findIngredientByNameIgnoreCase("Bearnaisesauce"))),
            new Pizza(27, "Calzone (indbagt)", 75.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"))),
            new Pizza(28, "Firat (indbagt)", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Champignon"), ingredientRepository.findIngredientByNameIgnoreCase("Shawarma"))),
            new Pizza(30, "Fatih", 85.0, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce"), ingredientRepository.findIngredientByNameIgnoreCase("Ost"), ingredientRepository.findIngredientByNameIgnoreCase("Bacon"), ingredientRepository.findIngredientByNameIgnoreCase("Kylling"), ingredientRepository.findIngredientByNameIgnoreCase("Kartofler"), ingredientRepository.findIngredientByNameIgnoreCase("Rosmarin")))
        ));

        pizzaRepository.saveAll(pizzaList);

    }


    public void drinkList() {

        Brand cocaCola = new Brand("Coca Cola");
        Brand cocaColaZero = new Brand("Coca Cola Zero");
        Brand faxeKondi = new Brand("Faxe Kondi");
        Brand kildeVand = new Brand("Kildevand");
        Brand ayran = new Brand("Ayran");
        Brand cocio = new Brand("Cocio");

        DrinkSize liters033 = new DrinkSize("0,33L");
        DrinkSize liters150 = new DrinkSize("1,50L");
        DrinkSize basic = new DrinkSize("");


        brandRepository.saveAll(Arrays.asList(cocaCola, cocaColaZero, faxeKondi, kildeVand, ayran,cocio));
        drinkSizeRepository.saveAll(Arrays.asList(liters150,liters033,basic));




        List<Drink> drinkList = new ArrayList<>(Arrays.asList(
                new Drink(cocaCola, liters033, 15.0),
                new Drink(cocaCola, liters150, 35.0),
                new Drink(cocaColaZero, liters033, 15.0),
                new Drink(cocaColaZero, liters150, 35.0),
                new Drink(faxeKondi, liters033, 15.0),
                new Drink(faxeKondi, liters150, 35.0),
                new Drink(kildeVand, basic, 15.0),
                new Drink(ayran, liters033, 15.0),
                new Drink(cocio, liters033, 25.0)
            ));

        drinkRepository.saveAll(drinkList);
    }

    public void pizzaTypes() {
        pizzaTypeRepository.save(PizzaType.builder().size("ALM").price(0.0).build());
        pizzaTypeRepository.save(PizzaType.builder().size("DEEP_PAN").price(45.0).build());
        pizzaTypeRepository.save(PizzaType.builder().size("FAM").price(90.0).build());
    }

    public void ingredientList(){
        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(new Ingredient(1, "Hvidløg", 3.00));
        ingredients.add(new Ingredient(2, "Chili", 4.00));
        ingredients.add(new Ingredient(3, "Rosmarin", 4.00));
        ingredients.add(new Ingredient(4, "ærter", 6.00));
        ingredients.add(new Ingredient(5, "Majs", 6.00));
        ingredients.add(new Ingredient(6, "Ananas", 7.00));
        ingredients.add(new Ingredient(7, "æg", 7.00));
        ingredients.add(new Ingredient(8, "Bearnaisesauce", 7.00));
        ingredients.add(new Ingredient(9, "Champginon", 7.00));
        ingredients.add(new Ingredient(10, "Champignon", 7.00));
        ingredients.add(new Ingredient(11, "Dressing", 7.00));
        ingredients.add(new Ingredient(12, "Grøn Peber", 7.00));
        ingredients.add(new Ingredient(13, "Jalapenos", 7.00));
        ingredients.add(new Ingredient(14, "Kartofler", 7.00));
        ingredients.add(new Ingredient(15, "Løg", 7.00));
        ingredients.add(new Ingredient(16, "Oliven", 7.00));
        ingredients.add(new Ingredient(17, "Paprika", 7.00));
        ingredients.add(new Ingredient(18, "Spinat", 7.00));
        ingredients.add(new Ingredient(19, "Stegt Løg", 7.00));
        ingredients.add(new Ingredient(20, "Tacosauce", 7.00));
        ingredients.add(new Ingredient(21, "Tomatsauce", 7.00));
        ingredients.add(new Ingredient(22, "Tomatskiver", 7.00));
        ingredients.add(new Ingredient(23, "Fetaost", 10.00));
        ingredients.add(new Ingredient(24, "Hakket Kød", 10.00));
        ingredients.add(new Ingredient(25, "Hakket Oksekød", 10.00));
        ingredients.add(new Ingredient(26, "Kylling", 10.00));
        ingredients.add(new Ingredient(27, "Ost", 10.00));
        ingredients.add(new Ingredient(28, "Pepperoni", 10.00));
        ingredients.add(new Ingredient(29, "Shawarma", 10.00));
        ingredients.add(new Ingredient(30, "Skinke", 10.00));
        ingredients.add(new Ingredient(31, "Spaghetti", 10.00));
        ingredients.add(new Ingredient(32, "Bacon", 13.00));
        ingredients.add(new Ingredient(33, "Gorgonzola", 13.00));
        ingredients.add(new Ingredient(34, "Kødsauce", 13.00));
        ingredients.add(new Ingredient(35, "Kødstrimler", 13.00));
        ingredients.add(new Ingredient(36, "Rejer", 13.00));
        ingredients.add(new Ingredient(37, "Salat dressing", 13.00));
        ingredients.add(new Ingredient(38, "Tun", 13.00));


        ingredientRepository.saveAll(ingredients);


    }

    public void orderList(){

        List<Order> orders = new ArrayList<>();
        List<OrderItem> orderItems = new ArrayList<>();

        Consumable pizza = pizzaRepository.findById(1);
        Consumable pizza2 = pizzaRepository.findById(2);
        Consumable drink = drinkRepository.findAll().get(1);
        Consumable cocacoladase = drinkRepository.findDrinkByBrand_BrandAndDrinkSize_Size("Coca Cola", "1,50L");
        System.out.println(drinkRepository.findAll().get(1));

        Order order = new Order();
        order.setCreationDate(LocalDateTime.now());
        order.setPhoneNumber("12 34 23 23");
        order.setName("Ferhat Baran");
        order.setAddress("Folehaven");
        order.setPostalCode("2500");
        order.setPickUpTime(LocalDateTime.now());
        order.setConfirmed(false);
        order.setStatus(OrderStatus.FRESH);
        order.setOrderItems(orderItems);

        //Set orderitem
        OrderItem pizzaItem = new OrderItem(order, pizza, 1, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni")), List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce")));
        OrderItem pizzaItem2 = new OrderItem(order, pizza2, 2, List.of(ingredientRepository.findIngredientByNameIgnoreCase("Pepperoni")), List.of(ingredientRepository.findIngredientByNameIgnoreCase("Tomatsauce")));
        pizzaItem.setPizzaType(pizzaTypeRepository.findPizzaTypeBySize("ALM"));
        pizzaItem2.setPizzaType(pizzaTypeRepository.findPizzaTypeBySize("ALM"));

        OrderItem drinkItem = new OrderItem();
        drinkItem.setOrder(order);
        drinkItem.setConsumable(cocacoladase);
        drinkItem.setQuantity(2);

        orderItems.add(pizzaItem);
        orderItems.add(pizzaItem2);
        orderItems.add(drinkItem);

        orders.add(order);
        orderRepository.saveAll(orders);
    }

}
