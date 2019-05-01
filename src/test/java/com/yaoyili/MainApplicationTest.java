package com.yaoyili;

import com.yaoyili.dao.UserKcalTrendMapper;
import com.yaoyili.model.UserJoinClass;
import com.yaoyili.model.UserKcalTrend;
import com.yaoyili.service.SportService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTest {

    @Autowired
    SportService sportService;

    @Autowired
    private UserKcalTrendMapper userKcalTrendMapper;

    @Test
    public void test1() {
        List<Integer> res = sportService.getJoinedClasses(1);
        Assert.assertEquals(res.size(), 4);
    }

    @Test
    public void test2() {
        int res = sportService.getTotalKcal(1);
        Assert.assertEquals(res, 200);
    }

    @Test
    public void test3() {
        List<Integer> classList = new ArrayList<Integer>();
        classList.add(5);
        classList.add(6);
        classList.add(7);
        sportService.addClassToUser(1, classList);
    }

    @Test
    public void test4() {
        Assert.assertEquals(userKcalTrendMapper
                .selectbyKeys(
                        new UserKcalTrend(1, 0, new Date(System.currentTimeMillis()))), null);

    }
}
