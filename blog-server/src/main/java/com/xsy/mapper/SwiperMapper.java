package com.xsy.mapper;

import com.xsy.domain.Swiper;

public interface SwiperMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Swiper record);


    int insertSelective(Swiper record);


    Swiper selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Swiper record);

    int updateByPrimaryKey(Swiper record);
}