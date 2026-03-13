package com.capg.app.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capg.entity.Category;
import com.capg.entity.FoodItem;
import com.capg.entity.Order;
import com.capg.service.CategoryService;
import com.capg.service.FoodService;
import com.capg.service.OrderService;
import com.capg.serviceImpl.CategoryServiceImpl;
import com.capg.serviceImpl.FoodServiceImpl;
import com.capg.serviceImpl.OrderServiceImpl;

public class FoodManagementApp {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring.xml");

        Scanner sc = new Scanner(System.in);

        CategoryService cs = ctx.getBean(CategoryService.class);
        FoodService fs = ctx.getBean(FoodService.class);
        OrderService os = ctx.getBean(OrderService.class);

        System.out.println("Welcome to Food Management System!");

        boolean flag = true;

        while (flag) {

            System.out.println("\nChoose below option!");
            System.out.println("1. Add Category");
            System.out.println("2. Add Food Item");
            System.out.println("3. Remove Food Item");
            System.out.println("4. Get Items By Category");
            System.out.println("5. Place Order");
            System.out.println("6. Calculate Order Total");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Category Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Description: ");
                        String des = sc.nextLine();

                        Category category = cs.addCategory(name, des);

                        System.out.println("Category Added Successfully! ID: "
                                + category.getId());
                        break;

                    case 2:

                        System.out.println("\nAvailable Categories:\n");

                        List<Category> list = cs.getAllCategories();
                        list.forEach(System.out::println);

                        System.out.print("Enter Category Id: ");
                        Long cid = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Enter Food Name: ");
                        String fname = sc.nextLine();

                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();

                        FoodItem item = fs.addFoodItem(cid, fname, price);

                        System.out.println("Food Item Added Successfully! ID: "
                                + item.getId());
                        break;

                    case 3:

                        System.out.print("Enter Food Item Id To Remove: ");
                        Long foodId = sc.nextLong();

                        fs.removeFoodItem(foodId);

                        System.out.println("Food Item Removed Successfully!");
                        break;

                    case 4:

                        System.out.println("\nAvailable Categories:\n");

                        List<Category> categories = cs.getAllCategories();
                        categories.forEach(System.out::println);

                        System.out.print("\nEnter the Category Id: ");
                        Long id = sc.nextLong();

                        List<FoodItem> items =
                                fs.getItemsByCategory(id);

                        System.out.println("\nFood Items in Selected Category:");

                        items.forEach(System.out::println);
                        break;

                    case 5:

                        List<Long> ids = new ArrayList<>();

                        System.out.print("Enter your name: ");
                        String customername = sc.nextLine();

                        System.out.print("Enter number of items to order: ");
                        int num = sc.nextInt();

                        System.out.println("Enter Food Item IDs:");

                        for (int i = 0; i < num; i++) {
                            ids.add(sc.nextLong());
                        }

                        Order order = os.placeOrder(ids, customername);

                        System.out.println("Order placed successfully! Order ID: "
                                + order.getId());
                        break;

                    case 6:

                        System.out.print("Enter your Order ID: ");
                        Long orderId = sc.nextLong();

                        double bill = os.calculateTotal(orderId);

                        System.out.println("Your Total Bill: " + bill);
                        break;

                    case 7:

                        System.out.println("Exiting Application...");
                        flag = false;
                        break;

                    default:
                        System.out.println("Please choose correct option!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Application Closed.");
    }
}