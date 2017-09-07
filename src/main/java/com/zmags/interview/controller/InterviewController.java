package com.zmags.interview.controller;

import java.io.IOException;
import java.util.Map;

import com.zmags.interview.service.analysis.FileAnalysisServiceImpl;
import com.zmags.interview.service.triangle.TriangleServiceImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * DemoController.
 */
@RestController
public class InterviewController {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    TriangleServiceImpl triangleService = (TriangleServiceImpl) context.getBean("triangleService");
    FileAnalysisServiceImpl fileAnalysisService = (FileAnalysisServiceImpl) context.getBean("fileAnalysisService");


    @RequestMapping(value = "/api/triangle", method = RequestMethod.GET)
    public ResponseEntity<?> getTriangle(
            @RequestParam("a") Double a,
            @RequestParam("b") Double b,
            @RequestParam("c") Double c) {

        //I made the return type a String instead of an Integer (PDF directions)
        //so it would be more clear on which type of triangle is it.
        return new ResponseEntity(triangleService.getTriangleType(a, b, c), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/textAnalysis", method = RequestMethod.POST)
    public ResponseEntity<?> getWordCount(
            @ApiParam(value = "Text file (.txt) to be analyzed.", required = true)
            @RequestParam("file") MultipartFile file) {

        Map<String, Integer> wordAnalysis;

        //If not a text file, throw 400
        if (!file.getOriginalFilename().split("\\.")[1].equalsIgnoreCase("txt")) {
            return new ResponseEntity("Please submit a text file (.txt)", HttpStatus.BAD_REQUEST);
        }

        try {
            wordAnalysis = fileAnalysisService.analyzeFile(file);
        } catch (IOException e) {
            System.out.println("IOException in DemoController" + e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return new ResponseEntity(wordAnalysis, HttpStatus.OK);
    }

}
