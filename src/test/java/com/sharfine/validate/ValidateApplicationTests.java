package com.sharfine.validate;

import com.sharfine.validate.dao.HrDao;
import com.sharfine.validate.model.Hr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidateApplicationTests {

    @Autowired
    private HrDao hrDao;

    @Test
    void contextLoads() {
        Hr hr = hrDao.get();
        System.out.println(hr.toString());
    }

}
