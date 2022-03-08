package com.sapient.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Shape {

    private int x;
    private int y;
    private String color = "White";

    public void printInfo() {
        log.trace("This is an instance of type Shape");
    }

}
