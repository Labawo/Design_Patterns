package com.company;

import Builder.Meal;
import Builder.MealBuilder;
import Factory.Notification;
import Factory.NotificationFactory;
import Observer.BinaryObserver;
import Observer.HexaObserver;
import Observer.OctalObserver;
import Observer.Subject;
import Singleton.Singleton;
import AbstractFactory.FactoryProducer;
import AbstractFactory.AbstractFactory;
import AbstractFactory.Shape;
import Strategy.Context;
import Strategy.OperationAdd;
import Strategy.OperationMultiply;
import Strategy.OperationSubstract;


public class Main {

    public static void main(String[] args) {
	// write your code here
        //https://www.geeksforgeeks.org/singleton-class-java/
        Singleton x= Singleton.getInstance();

        //https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();

        //https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();

        //https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

        //https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

        //https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());


    }
}
