package com.zmags.interview.service.analysis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * FileAnalysisServiceImpl.
 */
public class FileAnalysisServiceImpl implements FileAnalysisService{


   public Map<String, Integer> analyzeFile(MultipartFile file) throws IOException {

       Map<String, Integer> dupeMap = new HashMap<>();

       String text = new String(file.getBytes());
       //Splitting words by any character other than a-z, A-Z, 0-9
       String[] words = text.split("[^a-zA-Z0-9']+");

       for (String word : words) {

           //Does character case matter in comparison? If yes, take this out. I was unsure on the directions.
           word = word.toLowerCase();

           //If the word has already been counted, update the count for that word.
           //Else, add the word with a count of 1
           if (dupeMap.containsKey(word)) {
               Integer count = dupeMap.get(word);
               dupeMap.replace(word, count + 1);
           } else {
               dupeMap.put(word, 1);
           }
       }

       return dupeMap;
   }
}
