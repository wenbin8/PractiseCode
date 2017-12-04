package com.wenbin.base.io;//: io/OSExecuteDemo.java
// Demonstrates standard I/O redirection.

import net.mindview.util.OSExecute;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap /Users/wenbin/code/PractiseCode/out/com/wenbin/base/io/OSExecuteDemo.class");
    }
} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
    public OSExecuteDemo();
    public static void main(java.lang.String[]);
}
*///:~
