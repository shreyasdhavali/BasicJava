package com.sand.java.objectsClass.parent;

public class Person {

    protected static Person.De De;

    public static void testing() {

    }

    public static class De {
        
        public void display () {
            System.out.println("static class display");
        }
        
    }
    String defaultName;
    private String privateName;
    public String publicName;
    protected String protectedName;

    public Person() {
    }

    //sum of two numbers
    public int sum(int a, int b) {
        return a + b;
    }

    public void stringReverse() {
        String str = "Hello World";
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        System.out.println(reverse);
    }

    // email pattern
    //email address validate

    // validate email address
    public void emailValidate() {
        String email = "jamesgosling@gmailcom";
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        System.out.println(email.matches(regex));
    }

    public void phoneValidate() {
        String phone = "1234567890";
        String regex = "^[0-9]{10}$";
        System.out.println(phone.matches(regex));
    }

    public void fibonacci() {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < 10; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    public void factorial() {
        int n = 5;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println(fact);
    }

    public void prime() {
        int n = 5;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }

    public Person(String a, String b, String c, String d){
        this.defaultName = a;
        this.privateName = b;
        this.protectedName = c;
        this.publicName = d;
    }

    public void display() {
        String n = "name";
        System.out.println(defaultName + " " + privateName + " " + protectedName + " " + publicName);
    }
}
