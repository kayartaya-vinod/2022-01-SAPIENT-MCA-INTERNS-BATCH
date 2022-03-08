package com.sapient.programs;

import com.sapient.entity.Circle;
import com.sapient.entity.Rectangle;
import com.sapient.entity.ShapeMetrics;
import com.sapient.entity.Triangle;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateShapes {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(12., 13.);
        Circle c1 = new Circle(34.56);
        Triangle t1 = new Triangle(12., 13.);

        log.trace("r1 instanceof Rectangle is {}", r1 instanceof Rectangle);
        log.trace("c1 instanceof Circle is {}", c1 instanceof Circle);
        log.trace("r1 instanceof ShapeMetrics is {}", r1 instanceof ShapeMetrics);
        log.trace("c1 instanceof ShapeMetrics is {}\n", c1 instanceof ShapeMetrics);

        printShapeMetrics(t1);
        printShapeMetrics(r1);
        printShapeMetrics(c1);

    }

    // this is an example of polymorphic method; can be invoked by passing any
    // object as long as the object implements ShapeMetrics
    static void printShapeMetrics(ShapeMetrics sm) {
        try {
            log.trace("Got an object of type {}", sm.getClass().getName());
            log.trace("Area  = {}", sm.getArea());
            log.trace("Perimeter = {}\n", sm.getPerimeter());
        } catch (Exception e) {
            log.warn("There was an exception", e);
        }
    }
}
