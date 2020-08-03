package com.sharfine.validate.controller;

import com.sharfine.validate.annotation.DataSource;
import com.sharfine.validate.dao.HrDao;
import com.sharfine.validate.enums.DatabaseType;
import com.sharfine.validate.model.Hr;
import com.sharfine.validate.validator.stereotype.ParamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Sharfine
 * @createTime: 2020/7/30 17:41
 */
@RestController
public class ValidController {
    @Autowired
    private HrDao hrDao;


    @GetMapping("/")
    @ParamValidator
    public String test(int id) {
        Hr hr = hrDao.get();
        System.out.println("hr");
        return "hr";
    }

    @GetMapping("/master")
    @DataSource(name = DatabaseType.DATA_SOURCE_MASTER)
    public String getMaster(int id) {
        Hr one = hrDao.get();
        return one.toString();
    }

    @GetMapping("/slave")
    @DataSource(name = DatabaseType.DATA_SOURCE_SLAVE)
    public String getSlave(int id) {
        Hr one = hrDao.get();
        return one.toString();
    }
}
