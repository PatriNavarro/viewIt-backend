package com.patrinav.viewit.dao;

import com.patrinav.viewit.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<Product> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Product> query = getSession().createQuery("from Product");
        return query.getResultList();
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public List<Product> get(String type) {
        @SuppressWarnings("unchecked")
        TypedQuery<Product> query = getSession().createQuery("from Product where type=:type");
        query.setParameter("type",type);
        return query.getResultList();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product delete(Product product) {
        return null;
    }
}
