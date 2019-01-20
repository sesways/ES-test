package com.test.springbootelasticsearch.controller;

import com.test.springbootelasticsearch.doc.GirlInfo;
import com.test.springbootelasticsearch.esdao.GirlDao;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GirlInfoController {
    @Autowired
    private GirlDao girlDao;

    /**
     * 保存一个文档到ES
     * @return
     */
    @RequestMapping("/saveOne")
    public Boolean saveOne(){
        GirlInfo girlInfo = new GirlInfo("张三", 24, new Date(), "zhangshan@qq.com");
        girlInfo.setId(1l);
        GirlInfo save = girlDao.save(girlInfo);
        if (null != save){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    /**
     * 查询全部文档信息
     * @return
     */
    @RequestMapping("/getAll")
    public List<GirlInfo> getAll(){
        Iterable<GirlInfo> all = girlDao.findAll();
        Iterator<GirlInfo> iterator = all.iterator();
        List<GirlInfo> girlInfos = IteratorUtils.toList(iterator);
        return girlInfos;
    }

    /**
     * 根据id查询一个文档
     * @param id
     * @return
     */
    @RequestMapping("/getOne")
    public GirlInfo getOne(Long id){
        Optional<GirlInfo> girlInfo = girlDao.findById(id);
        return  girlInfo.get();
    }
}
