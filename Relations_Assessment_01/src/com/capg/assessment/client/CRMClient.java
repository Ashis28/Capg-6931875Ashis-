package com.capg.assessment.client;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capg.assessment.entities.Address;
import com.capg.assessment.serviceImpl.CustomerServiceImpl;
import com.capg.assessment.serviceImpl.LeadServiceImpl;
import com.capg.assessment.serviceImpl.OrderServiceImpl;
import com.capg.assessment.serviceImpl.ProductServiceImpl;
import com.capg.assessment.serviceImpl.ReportServiceImpl;
import com.capg.assessment.serviceImpl.TicketServiceImpl;
import com.capg.assessment.services.CustomerSerivce;
import com.capg.assessment.services.LeadService;
import com.capg.assessment.services.OrderService;
import com.capg.assessment.services.ProductService;
import com.capg.assessment.services.ReportService;
import com.capg.assessment.services.TickerService;

public class CRMClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

        CustomerSerivce customerService = new CustomerServiceImpl(em);
        LeadService leadService = new LeadServiceImpl(em);
        ProductService productService = new ProductServiceImpl(em);
        OrderService orderService = new OrderServiceImpl(em);
        TickerService ticketService = new TicketServiceImpl(em);
        ReportService reportService = new ReportServiceImpl(em);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead");
            System.out.println("5. Convert Lead");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Ticket");
            System.out.println("9. View Employee Performance");
            System.out.println("0. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name, email, phone:");
                    String name = sc.next();
                    String email = sc.next();
                    String phone = sc.next();
                    customerService.registerCustomer(name, email, phone);
                    break;
                case 2:
                    System.out.println("Enter customerId, city, state, pincode:");
                    Long custId = sc.nextLong();
                    String city = sc.next();
                    String state = sc.next();
                    String pincode = sc.next();
                    Address addr = new Address();
                    addr.setCity(city);
                    addr.setState(state);
                    addr.setPincode(pincode);
                    customerService.addAddressToCustomer(custId, addr);
                    break;
                case 3:
                    System.out.println("Enter lead name, source, contactInfo:");
                    String leadName = sc.next();
                    String source = sc.next();
                    String contactInfo = sc.next();
                    leadService.createLead(leadName, source, contactInfo);
                    break;
                case 4:
                    System.out.println("Enter leadId, employeeId:");
                    Long leadId = sc.nextLong();
                    Long empId = sc.nextLong();
                    leadService.assignLeadToEmployee(leadId, empId);
                    break;
                case 5:
                    System.out.println("Enter leadId:");
                    Long lId = sc.nextLong();
                    leadService.convertLeadToCustomer(lId);
                    break;
                case 6:
                    System.out.println("Enter product name, price:");
                    String pname = sc.next();
                    double price = sc.nextDouble();
                    productService.addProduct(pname, price);
                    break;
                case 7:
                    System.out.println("Enter customerId and productIds (comma separated):");
                    Long cId = sc.nextLong();
                    sc.nextLine();
                    String ids = sc.next();
                    List<Long> productIds = Arrays.stream(ids.split(","))
                                                  .map(Long::parseLong)
                                                  .collect(Collectors.toList());
                    orderService.placeOrder(cId, productIds);
                    break;
                case 8:
                    System.out.println("Enter orderId and issue description:");
                    Long oId = sc.nextLong();
                    String issue = sc.next();
                    ticketService.raiseTicket(oId, issue);
                    break;
                case 9:
                    System.out.println("Enter employeeId:");
                    Long eId = sc.nextLong();
                    System.out.println(reportService.getEmployeePerformance(eId));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    em.close();
                    emf.close();
                    return;
            }
        }
    }
}
