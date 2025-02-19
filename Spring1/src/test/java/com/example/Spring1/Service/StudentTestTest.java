package com.example.Spring1.Service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTestTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void toCompareValues() {
        StudentTest studentTest = new StudentTest();
        assertEquals(10, studentTest.toCompareValues(10, 5), "10 should be returned as it is greater");
        assertEquals(7, studentTest.toCompareValues(3, 7), "7 should be returned as it is greater");
        assertEquals(5, studentTest.toCompareValues(5, 5), "Both values are equal, so 5 should be returned");
    }
}