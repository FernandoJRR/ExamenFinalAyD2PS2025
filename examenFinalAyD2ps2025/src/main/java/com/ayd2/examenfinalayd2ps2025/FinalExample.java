package com.ayd2.examenfinalayd2ps2025;
import java.util.List;
import java.util.ArrayList;

public class FinalExample {

    public void processData(String input) {
        List<String> data = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts) {
            part = part.trim();
            if (part.length() > 0) {
                if (part.length() > 10) {
                    part = part.substring(0, 10);
                }
                if (part.matches("[a-zA-Z]+")) {
                    data.add(part.toUpperCase());
                }
            }
        }

        System.out.println("Data processed:");
        for (String item : data) {
            System.out.println("- " + item);
        }

        System.out.println("Total items:");
        for (String item : data) {
            System.out.println("- " + item);
        }
    }

    //Para crear un usuario igualmente es mejor usar el patron Builder
    //el patron builder nos va a permitir crear de manera mas fina a los User
    //tambien a tomar sus errores de manera mas centralizada y a medida
    public class UserBuilder {
        private String name;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String zip;

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public User getResult(){
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
            return new User(this.name, this.email, this.phone, this.address, this.city, this.zip);
        }
    }

    //Clase User para el Builder
    public class User {
        private String name;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String zip;

        public User(String name, String email, String phone,String address, String city, String zip) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.city = city;
            this.zip = zip;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }

        public String getZip() {
            return zip;
        }
    }

    public double calculateArea(String shape, double... dimensions) {
        switch (shape) {
            case "circle":
                return Math.PI * dimensions[0] * dimensions[0];
            case "rectangle":
                return dimensions[0] * dimensions[1];
            case "triangle":
                return dimensions[0] * dimensions[1] / 2;
            default:
                throw new IllegalArgumentException("Unknown shape");
        }
    }

    //Se usa el patron Builder para facilitar la creacion de Order
    //podemos manejar sus errores desde aqui
    //podemos manejar sus atributos de muchisima mejor manera
    public class OrderBuilder {
        private String customerName;
        private List<String> items;
        private double total;

        public void setCustomerName(String customerName){
            this.customerName = customerName;
        }

        public void setItems(List<String> items){
            this.items = items;
        }

        public void setTotal(double total){
            this.total = total;
        }

        public Order getResult() {
            return new Order(this.customerName, this.items, this.total);
        }
    }

    public class Order {
        private String customerName;
        private List<String> items;
        private double total;

        //Se crea un constructor para poder instanciar
        public Order(String customerName, List<String> items, double total) {
            this.customerName = customerName;
            this.items = items;
            this.total = total;
        }

        public void printOrderSummary() {
            ReportGenerator instance = new ReportGenerator().getInstance();

            instance.printHeader(customerName);
            for (String item : items) {
                instance.printLineItem(item);
            }
            instance.printTotal(total);
        }
    }

    //Report generator no muestra senales de necesitar varias instancias
    //usaremos un patron singleton para controlar su uso
    public class ReportGenerator {
        private ReportGenerator instance = null;

        public ReportGenerator getInstance(){
            if (this.instance == null) {
                this.instance = new ReportGenerator();
                return this.instance;
            } else {
                return this.instance;
            }
        }

        public static void printHeader(String customer) {
            System.out.println("Order for: " + customer);
        }

        public static void printLineItem(String item) {
            System.out.println(" - Item: " + item);
        }

        public static void printTotal(double total) {
            System.out.println("Total: $" + total);
        }
    }

}