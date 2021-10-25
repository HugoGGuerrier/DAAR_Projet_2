package com.lambda.cvlibrary;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is a custom error controller to keep a trace of activity on the server
 * 
 * @author Emilie SIAU
 * @author Hugo GUERRIER
 */
@RestController
public class CVErrorController implements ErrorController  {

    // ========== Routes ==========

    /**
     * The not found error route
     * 
     * @return A message to infor client that the page were not found
     */
    @RequestMapping("/error")
    public ResponseEntity<String> handleError() {
        // TODO : Log the request

        // Return the response
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Page not found...");
    }

}