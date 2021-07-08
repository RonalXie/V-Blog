package com.xsy.service;

import com.xsy.domain.Type;

import java.util.List;

public interface TypeService {

    public List<Type> getType();

    public int typeSum();

    public void updateType(Type type);

    public void deleteType(Type type);

    int addType(Type type);
}
