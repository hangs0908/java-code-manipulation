package me.whiteship;

import java.lang.annotation.Retention;

@MyAnnotation
public class Book {
//
//    private String a;
//
//    @MyAnnotation
//    private static String B = "Book";
//
//    private static final String C = "Book";
//
//    @MyAnnotation
//    public String d = "d";
//
//    protected String e = "e";
//
//    public Book() {
//    }
//
//    public Book(String a, String d, String e) {
//        this.a = a;
//        this.d = d;
//        this.e = e;
//    }
//
//    private void f() {
//        System.out.println("F");
//    }
//
//    public void g() {
//        System.out.println("g");
//    }
//
//    public int h() {
//        return 100;
//    }

    public static String A = "A";

    @MyAnnotation
    private String B = "B";


    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }

    public Book() {
    }

    public Book(String b) {
        B = b;
    }
}
