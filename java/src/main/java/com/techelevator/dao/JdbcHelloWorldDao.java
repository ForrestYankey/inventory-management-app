package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.HelloWorld;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcHelloWorldDao implements HelloWorldDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcHelloWorldDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HelloWorld fetchHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        String sql = "SELECT string FROM hello";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                helloWorld.setHelloWorld(results.getString("string"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return helloWorld;
    }
}
