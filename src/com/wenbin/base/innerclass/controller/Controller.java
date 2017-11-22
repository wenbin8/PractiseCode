//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package com.wenbin.base.innerclass.controller;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        // Make a copy so you're not modifying the list
        // while you're selecting the elements in it:
        while (eventList.size() > 0) {
            for (Event e : new ArrayList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }

    }
} ///:~
