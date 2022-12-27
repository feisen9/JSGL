package com.hhu20.jsgl.mapper;

import java.util.List;
import java.util.Map;

public interface MajorMapper {
    List<Map> selectAll();
    String selectMnameForMno(String mname);
}
