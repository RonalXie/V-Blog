package com.xsy.service.Impl;

import com.xsy.domain.Type;
import com.xsy.mapper.TypeMapper;
import com.xsy.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> getType() {
        return typeMapper.getType();
    }
}
