package com.zmags.interview.service.analysis;

import java.io.IOException;
import java.util.Map;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileAnalysisService.
 */
@Service("fileAnalysisService")
public interface FileAnalysisService {

    Map<String, Integer> analyzeFile(MultipartFile file) throws IOException;


}
