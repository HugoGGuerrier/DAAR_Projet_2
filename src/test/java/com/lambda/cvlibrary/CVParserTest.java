package com.lambda.cvlibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileInputStream;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class CVParserTest {

    @Test
    void testTextFromPDF() {
        try {

            FileInputStream inputStream = new FileInputStream(new File("./src/main/resources/Marmotte.pdf"));
            MultipartFile multipartFile = new MockMultipartFile("test.pdf", inputStream);
            System.out.println(CVParser.getTextFromPDF(multipartFile));
            assertEquals("Marmotte\n", CVParser.getTextFromPDF(multipartFile));

        } catch (Exception e) {
            fail(e);
        }
    }

}
