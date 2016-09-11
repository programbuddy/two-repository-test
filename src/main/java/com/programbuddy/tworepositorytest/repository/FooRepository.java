package com.programbuddy.tworepositorytest.repository;

import com.programbuddy.tworepositorytest.entity.Foo;

public interface FooRepository {

    Foo findById(String id);

    void save(Foo foo);

}
