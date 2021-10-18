package com.lambda.cvlibrary;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CVService {

    private CVRepository cvRepository;

    public void createCV(CV cv) {
        cvRepository.save(cv);
    }

    public List<CV> getCvByText(String text) {
        return cvRepository.findByTextLike(text);
    }

}
