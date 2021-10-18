package com.lambda.cvlibrary;

import org.springframework.web.multipart.MultipartFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class CVParser {

    public static String getTextFromPDF(MultipartFile multipartFile) throws Exception {
        PDDocument doc = PDDocument.load(multipartFile.getInputStream());
        return new PDFTextStripper().getText(doc);
    }
    
}
