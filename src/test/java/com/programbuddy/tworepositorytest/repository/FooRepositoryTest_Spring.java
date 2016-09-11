package com.programbuddy.tworepositorytest.repository;

import com.programbuddy.tworepositorytest.Application;
import com.programbuddy.tworepositorytest.entity.Foo;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class FooRepositoryTest_Spring {
    @Autowired
    protected FooRepository fooRepositoryDatabase;

    public FooRepository getFooRepository() {
        return fooRepositoryDatabase;
    }

    @Test
    public void simple_test() throws Exception {
        getFooRepository().save(new Foo("1", "bar1"));
        assertThat(getFooRepository().findById("1")).isNotNull();
        assertThat(getFooRepository().findById("1").getBar()).isEqualTo("bar1");
    }
}