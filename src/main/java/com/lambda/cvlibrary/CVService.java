package com.lambda.cvlibrary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is the service for the cv library, it helps store and search cvs
 * 
 * @author Emilie SIAU
 * @author Hugo GUERRIER
 */
@Service
public class CVService {

    // =========== Attributes ==========

    @Autowired
    private CVRepository cvRepository;


    // ========== Repository methods ==========

    public List<CV> getCVByText(String text) {
        return cvRepository.findByTextLike(text);
    }

    public void createCV(CV cv) {
        cvRepository.save(cv);
    }

    public void removeCV(String id) {
        cvRepository.deleteById(id);
    }

}
