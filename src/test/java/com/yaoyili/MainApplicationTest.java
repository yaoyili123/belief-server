package com.yaoyili;

import com.yaoyili.model.UserJoinClass;
import com.yaoyili.service.SportService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTest {

    @Autowired
    SportService sportService;

    @Test
    public void test1() {
        List<UserJoinClass> res = sportService.getJoinedClasses(1);
        Assert.assertEquals(res.size(), 4);
    }
}
