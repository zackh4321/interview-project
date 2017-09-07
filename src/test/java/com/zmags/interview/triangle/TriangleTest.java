package com.zmags.interview.triangle;

import com.zmags.interview.service.triangle.TriangleServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TriangleTest.
 */
public class TriangleTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    TriangleServiceImpl triangleService = (TriangleServiceImpl) context.getBean("triangleService");


    @Test
    public void testTriangle() {


        //Test for EQUILATERAL. All sides equal
        String triangleType = triangleService.getTriangleType(2.0, 2.0, 2.0);
        Assert.assertEquals(triangleType, "Equilateral");

        //Test for ISOSCELES
        triangleType = triangleService.getTriangleType(4.0, 4.0, 2.0);
        Assert.assertEquals(triangleType, "Isosceles");

        //Test for ISOSCELES
        triangleType = triangleService.getTriangleType(6.0, 12.0, 14.0);
        Assert.assertEquals(triangleType, "Scalene");

        //Test for ISOSCELES
        triangleType = triangleService.getTriangleType(6.5, 11.5, 14.0);
        Assert.assertEquals(triangleType, "Scalene");

        //Test for invalid triangle
        triangleType = triangleService.getTriangleType(0.0, 0.0, 0.0);
        Assert.assertEquals(triangleType, "Error!");

        //Test for invalid triangle
        triangleType = triangleService.getTriangleType(-1.0, -3.0, 2.0);
        Assert.assertEquals(triangleType, "Error!");




    }


}
