/**
 * from wikipedia
 * <p>The Builder design pattern is one of the twenty-three well-known GoF design patterns[1] that describe how to solve recurring design problems in object-oriented software.

 <p>The Builder design pattern solves problems like:[2]

 <p>How can a class (the same construction process) create different representations of a complex object?
 <p>How can a class that includes creating a complex object be simplified?
 Creating and assembling the parts of a complex object directly within a class is inflexible. It commits the class to creating a particular representation of the complex object and makes it impossible to change the representation later independently from (without having to change) the class.

 <p>The Builder design pattern describes how to solve such problems:

 <p>Encapsulate creating and assembling the parts of a complex object in a separate Builder object.
 <p>A class delegates object creation to a Builder object instead of creating the objects directly.
 <p>A class (the same construction process) can delegate to different Builder objects to create different representations of a complex object.
 */
package com.jiangjian.study.java.designpattern.creational.builder;