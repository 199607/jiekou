package com.nufe.grain.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface GraphMapper {

    @Select("SELECT company_name as name,count(company_name) as value FROM `grain_testing_record` r group by r.company_name")
    List<Map<String,Object>> getCompanyTestingNum();
}
