package com.lambda.cvlibrary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * This class helps to parse and get information in CVs
 * 
 * @author Emilie SIAU
 * @author Hugo GUERRIER
 */
public class CVParser {

    /**
     * Get the text from a PDF file
     * 
     * @param multipartFile The input file provided by the client
     * @return The text of the PDF in a string
     * @throws IOException If the PDF file is unreadable or unparsable
     */
    public static String getTextFromPDF(MultipartFile multipartFile) throws IOException {
        PDDocument doc = PDDocument.load(multipartFile.getInputStream());
        return new PDFTextStripper().getText(doc);
    }

    /**
     * Replace the new line character by space from the source and return the result
     * 
     * @param src The source string
     * @return The result after replacing new line
     */
    public static String replaceNewline(String src) {
        return src.replaceAll("[\r\n|\n|\r]", " ");
    }
    
}
