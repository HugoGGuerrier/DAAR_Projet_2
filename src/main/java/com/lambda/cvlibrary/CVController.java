package com.lambda.cvlibrary;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * This is the main constroller for the application, it handles all requests
 * 
 * @author Emilie SIAU
 * @author Hugo GUERRIER
 */
@RestController
@RequestMapping("/api/v1/cvlib")
public class CVController {

    // ========== Attributes ==========

    @Autowired
    private CVService cvService;


    // ========== Routes ==========

    /**
     * Search CVs with the wanted string inside
     * 
     * @param query The string to ook inside the CV
     * @return The list of CVs represented in JSON
     */
    @GetMapping("/")
    ResponseEntity<String> search(@RequestParam("q") String query) {

        try {
            // Get the cv list from the query
            List<CV> cvList = cvService.getCVByText(query);
            if(cvList == null) {
                cvList = new LinkedList<>();
            }

            // Create JSON object from the cv list
            ObjectMapper mapper = new ObjectMapper();
            String resJson = mapper.writeValueAsString(cvList);

            // Send the client the result of the search
            return ResponseEntity.ok().body(resJson);
        } catch(JsonProcessingException e) {
            // If the server is in dev env, log the error
            e.printStackTrace();

            // Send the user the error response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{result : \"error\"}");
        }

    }

    /**
     * Upload a CV in the CV library
     * 
     * @param file The file to upload
     * @return The success or failure
     */
    @PostMapping("/")
    ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

        try {
            // Try getting the text from the PDF
            String cvText = CVParser.getTextFromPDF(file);
            cvText = CVParser.replaceNewline(cvText);

            // Create a cv
            CV cv = new CV();
            cv.setText(cvText);

            // Store the cv in elastic search
            cvService.createCV(cv);

            // Return the success response to the client
            return ResponseEntity.ok().body("{result : \"success\"}");
        } catch (Exception e) {
            // If the server is in dev env, log the error
            e.printStackTrace();
            
            // Send the error to the client
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{result : \"error\"}");
        }

    }

    /**
     * Remove a CV from the library
     * 
     * @param id The CV id
     * @return The success
     */
    @DeleteMapping("/")
    ResponseEntity<String> delete(@RequestParam("id") String id) {
        // Remove the CV from the library
        cvService.removeCV(id);

        // Return the success because it cannot fail
        return ResponseEntity.ok().body("{result : \"success\"}");
    }

}
