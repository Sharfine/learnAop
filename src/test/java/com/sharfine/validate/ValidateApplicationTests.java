package com.sharfine.validate;

import com.sharfine.validate.dao.HrDao;
import com.sharfine.validate.model.BaseBlock;
import com.sharfine.validate.model.EthBlock;
import com.sharfine.validate.model.Hr;
import com.sharfine.validate.utils.PageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import com.sharfine.validate.utils.*;

import java.util.List;

@SpringBootTest
class ValidateApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private HrDao hrDao;

    @Test
    void contextLoads() {
        Hr hr = hrDao.get();
        System.out.println(hr.toString());
    }

    @Test
    void query() {
        int pageSize = 30;
        int pageNum = -1;

        Query query = new Query();

        query.with(Sort.by("height"));

        PagingInfo<Long> longPagingInfo = PageUtil.mongoQuery(mongoTemplate,
                query,
                EthBlock.class,
                BaseBlock::getHeight,
                pageNum,
                pageSize
        );

        System.out.println(longPagingInfo);
    }

}
