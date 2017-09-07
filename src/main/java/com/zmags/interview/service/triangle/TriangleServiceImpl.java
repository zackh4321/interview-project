package com.zmags.interview.service.triangle;

/**
 * TriangleServiceImpl.
 */
public class TriangleServiceImpl implements TriangleService {

    private static final String EQUILATERAL = "Equilateral";
    private static final String ISOSCELES = "Isosceles";
    private static final String SCALENE = "Scalene";
    private static final String ERROR = "Error!";

    public String getTriangleType(Double a, Double b, Double c) {

        if (a >= b + c || b >= c + a || c >= b + a)
            return ERROR;
        else if (a <= 0 || b <= 0 || c <= 0)
            return ERROR;
        else if (a.compareTo(b) == 0 && b.compareTo(c) == 0)
            return EQUILATERAL;
        else if (a.compareTo(b) == 0 || b.compareTo(c) == 0 || c.compareTo(a) == 0)
            return ISOSCELES;
        else
            return SCALENE;
    }

}
