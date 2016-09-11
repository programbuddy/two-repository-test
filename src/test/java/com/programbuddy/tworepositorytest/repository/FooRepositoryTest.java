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
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
@SpringApplicationConfiguration(Application.class)
@Transactional
public class FooRepositoryTest {

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    @Autowired
    protected FooRepository fooRepositoryDatabase;

    protected FooRepository fooRepositoryMap;

    @Parameterized.Parameter(0)
    public String parameter0;

    private static final String DATABASE = "database";
    private static final String MAP = "map";

    @Parameterized.Parameters(name = "{0}")
    public static String[] parameter() {
        return new String[]{DATABASE, MAP};
    }

    public FooRepository getFooRepository() {
        if (parameter0.equals(DATABASE)) {
            return fooRepositoryDatabase;
        } else if (parameter0.equals(MAP)) {
            if (fooRepositoryMap == null) {
                fooRepositoryMap = new FooRepositoryMap();
            }
            return fooRepositoryMap;
        }
        throw new RuntimeException("Invalid parameter.");
    }

    @Test
    public void simple_test() throws Exception {
        getFooRepository().save(new Foo("1", "bar1"));
        assertThat(getFooRepository().findById("1")).isNotNull();
        assertThat(getFooRepository().findById("1").getBar()).isEqualTo("bar1");
    }
}