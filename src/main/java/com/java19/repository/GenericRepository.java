package com.java19.repository;


import com.java19.mapper.RowMapper;

import java.util.List;

public interface GenericRepository<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    boolean insert(String sql, Object... parameters);
    void update(String sql, Object... parameters);
}
