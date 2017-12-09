//: annotations/Testable.java
package com.wenbin.base.annotations;

import com.wenbin.base.myutil.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~
