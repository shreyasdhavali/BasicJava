package com.sand.java;

public class ExceptionHandling {

    {
        System.out.println("without main method execution");
    }

    public static void main(String[] args) {

        try {
            try{
                try{
                    System.out.println("Hello ");
                    System.out.println("Hello ");
                    System.out.println("Hello ");
                    System.out.println("Hello ");
                    System.out.println(test());
                } finally {
                    System.out.println("Inside finaly ");

                }

            } finally {
                System.out.println("Inside finaly ");

            }
            ExceptionHandling exceptionHandling = new ExceptionHandling();
            System.out.println("divide by zero " + exceptionHandling.hashCode());
            exceptionHandling = null;
            System.gc();
            System.out.println(Runtime.getRuntime().maxMemory()/1000000 + "MB");
        } finally {
            System.out.println("We can use finally with try. Try alone cannot be used");
        }
    }

    protected void finalize() {
        System.out.println("Finalize usage");
    }

    private static String test() {
        try{
            return "Return string";
        } finally {
            System.out.println("Inside finaly ");
        }
    }
}
