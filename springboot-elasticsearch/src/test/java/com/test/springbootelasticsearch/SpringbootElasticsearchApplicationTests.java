package com.test.springbootelasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {
    private TransportClient client = null;

    @Test
    public void contextLoads() {
        SearchResponse response = client.prepareSearch()
                .setIndices("girl")//索引
                .setTypes("info")//类型
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)//精确搜索
                .setQuery(QueryBuilders.termQuery("id", "1"))
                .execute()
                .actionGet();
        SearchHits hits = response.getHits();
        System.out.println("查询总条数：" + hits.totalHits);
        for(SearchHit hit:hits){
            System.out.println("{name:"+hit.getSourceAsMap().get("name")+"}");
        }
    }

    @Before
    public void beforeSearch() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name","my-application")//集群名称，在es的配置文件中查看
                .build();
        client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));

    }

    @After
    public void afterSearch(){
        if (this.client != null){
            this.client.close();
        }
    }

}

