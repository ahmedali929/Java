package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA #123m is resolved")
    void basicTest() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForOnlyJava17() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testForOnlyJava13() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_23)
    void testForOnlyJava23() {
        //execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11,max=JRE.JAVA_23)
    void testOnlyForJavaRange() {
        //execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11)
    void testOnlyForJavaRangeMin() {
        //execute method and perform asserts
    }



}
