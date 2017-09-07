package com.zmags.interview.analysis;

import java.io.IOException;
import java.util.Map;

import com.zmags.interview.service.analysis.FileAnalysisServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileAnalysisTest.
 */
public class FileAnalysisTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    FileAnalysisServiceImpl fileAnalysisService = (FileAnalysisServiceImpl) context.getBean("fileAnalysisService");


    @Test
    public void testAnalysis() {

        Map<String, Integer> dupeMap;

        //Mock file string
        String mockFile = "Foo bar bar Foo FOO BaZ Zab BAZ CAt";

        //Creating a MOCK Multipart file for testing purposes
        MultipartFile result = new MockMultipartFile("text.txt", "text.txt", "text/plain", mockFile.getBytes());

        try {
            //Testing word count found in the file
            dupeMap = fileAnalysisService.analyzeFile(result);
            Assert.assertEquals(dupeMap.get("foo"), Integer.valueOf(3));
            Assert.assertEquals(dupeMap.get("bar"), Integer.valueOf(2));
            Assert.assertEquals(dupeMap.get("baz"), Integer.valueOf(2));
            Assert.assertEquals(dupeMap.get("zab"), Integer.valueOf(1));
            Assert.assertEquals(dupeMap.get("cat"), Integer.valueOf(1));
        } catch (IOException e) {
            System.out.print("IOException during analysis test" + e);
        }




    }





}
