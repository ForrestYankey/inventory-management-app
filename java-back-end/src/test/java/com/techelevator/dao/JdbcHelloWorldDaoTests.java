package com.techelevator.dao;

import com.techelevator.model.HelloWorld;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcHelloWorldDaoTests extends BaseDaoTests{

    private static final HelloWorld TEST_HELLO_WORLD = new HelloWorld("Hello, World!");
    private JdbcHelloWorldDao sut;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcHelloWorldDao(jdbcTemplate);
    }

    @Test
    public void fetchHelloWord_returns_HelloWorld(){
        HelloWorld helloWorld = sut.fetchHelloWorld();

        Assert.assertEquals("Hello, World!", helloWorld.getHelloWorld());
    }
}
