package com.lambda.cvlibrary;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CVRepository extends ElasticsearchRepository<CV, String> {
    List<CV> findByTextLike(String text);
}