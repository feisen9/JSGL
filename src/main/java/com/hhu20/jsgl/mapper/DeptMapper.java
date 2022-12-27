package com.hhu20.jsgl.mapper;

import com.hhu20.jsgl.pojo.Dept;

import java.util.List;
import java.util.Map;

public interface DeptMapper {
    List<Dept> selectDept();
    List<Map> selectAll();
    String selectDnameForDno(String dname);
}
