package com.test.springbootelasticsearch.esdao;

import com.test.springbootelasticsearch.doc.GirlInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface GirlDao extends ElasticsearchRepository<GirlInfo,Long> {
}
