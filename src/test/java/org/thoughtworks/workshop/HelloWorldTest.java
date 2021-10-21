package org.thoughtworks.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HelloWorldTest {
    @Test
    public void testPrintHello(){
        HelloWorld helloWorld = new HelloWorld();
        Assertions.assertEquals(helloWorld.printHelloWorld(),"Hello World!");
    }
}
