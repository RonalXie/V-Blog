package com.xsy.mapper;

import com.xsy.domain.Music;

public interface MusicMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Music record);


    int insertSelective(Music record);


    Music selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Music record);


    int updateByPrimaryKey(Music record);
}