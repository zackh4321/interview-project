package com.zmags.interview.service.triangle;

import org.springframework.stereotype.Service;

/**
 * TriangleService.
 */
@Service("triangleService")
public interface TriangleService {

    String getTriangleType(Double a, Double b, Double c);
}
