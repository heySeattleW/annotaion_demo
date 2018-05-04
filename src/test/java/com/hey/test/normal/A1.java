package com.hey.test.normal;

/**
 * Created by heer on 2018/5/4.
 */
public class A1 {

    int a = 10;
    int b;

    B1 b1 = new B1(3,4);

    public A1(int a,int b){
        this.a = a;
        this.b = b;
        b1.a = b;
    }

    public static void main(String[] args) {
        A1 a1 = new A1(3,4);
        System.out.println(a1);
    }


}

class B1{
    int a = 10;
    int b;
    A1 a1 = new A1(3,4);
    public B1(int a,int b){
        this.a = a;
        this.b = b;
        a1.a = a;
    }
}
