package com.programbuddy.tworepositorytest.repository;

import com.programbuddy.tworepositorytest.entity.Foo;

import java.util.HashMap;
import java.util.Map;

public class FooRepositoryMap implements FooRepository {

    private Map<String, Foo> map = new HashMap<>();

    @Override
    public Foo findById(String id) {
        return map.get(id);
    }

    @Override
    public void save(Foo foo) {
        map.put(foo.getId(),foo);
    }
}
