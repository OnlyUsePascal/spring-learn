package org.example.IOC;

public class TestClass {
    // commend line at indent before methods , worked
    void testMethod(){
        // commend line at indent before method's lines , not work
        System.out.println(123);

        // commend line at indent between method's lines , worked
        System.out.println(234);
    //     commend line at indent after method's lines , not work

    }

    // comment line at indent between methods, worked
    void testMethod2(){

    }
//     commend line at indent after methods , not work
}

