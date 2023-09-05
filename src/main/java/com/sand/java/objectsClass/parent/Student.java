package com.sand.java.objectsClass.parent;

/*
public - to entire project
protected - within this package and only to child instance
private - only to this class
default - only this package
class - Collection of objects having similar properties like a blueprint.
 */
public class Student extends Person {

    /*
    No constructor - compiler assigns default constructor to the class
    It is called when the instance(Object) of a class is created
    No return type, but it returns instance of the class
    Use of constructor is to provide default values to the instance variables
     */

    /*
    static - All the objects of the class has same property as example given below
    All students have same college name.
    stored in class area and has memory allocated once
     */
    public static String COLLEGE = "RVCE";
    int a;
    String b;
    int rollNo;
    String name;

    /*
    invoked at the time of class loading before main execution starts.
     */
    static {
        System.out.println(COLLEGE);
    }
    public Student() {
        super();
    }

    public static void testing() {

    }

    /*
    Constructor overloading
     */
    public Student(int rollNo) {
        super();
        Student.testing();
        Person person = new Person("d", "pri", "pro", "pub");
         System.out.println(person.defaultName); // default inside same package
        // System.out.println(person.privateName); private so cannot access
        // System.out.println(person.protectedName); cannot access
        System.out.println(super.protectedName); // can access and its child of person
        System.out.println(super.publicName);
        System.out.println(super.defaultName); // can access as its same package
        System.out.println(person.publicName); // only public can be accessed
        this.rollNo = rollNo;
    }

    public Student(int rollNo, String name) {
        this(rollNo); // used to refer current instance of a class, invoke current class constructor and
        // this () has to be at the top.
        this.name = name;
        display(); // both mean the same.
        this.display();
    }

    public void display () {
        System.out.println("Hello Display from student " + name);
    }

    /*
    no need to create any instance to call this method.
     */
    public static void changeCollege(String college) {
        COLLEGE = college;
    }

    public static void main(String[] args) {
        /*
        Object s, s1,s2 are stored in stack memory
        Heap memory stores values of objects s, s1, s2
        Class memory stores static values only once
         */
        Student s = new Student(), s1 = new Student(10, "Joseph");
        System.out.println("Hello main");
        System.out.println(s.a + " " + s.b);
        System.out.println(Student.COLLEGE);
        Student.changeCollege("RV College of Engineering");
        System.out.println(Student.COLLEGE);
        s1.display();
    }


}
