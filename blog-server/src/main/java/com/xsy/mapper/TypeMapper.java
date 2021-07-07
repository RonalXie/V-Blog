package com.xsy.mapper;

import com.xsy.domain.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TypeMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Type record);


    int insertSelective(Type record);


    Type selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Type record);


    int updateByPrimaryKey(Type record);
    List<Type> getType();
}