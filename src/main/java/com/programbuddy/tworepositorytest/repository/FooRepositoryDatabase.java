package com.programbuddy.tworepositorytest.repository;

import com.programbuddy.tworepositorytest.entity.Foo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FooRepositoryDatabase implements FooRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Foo findById(String id) {
        return entityManager
                .createQuery("SELECT f FROM Foo f WHERE f.id = :id", Foo.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public void save(Foo foo) {
        entityManager.persist(foo);
    }
}
