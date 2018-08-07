package com.patrinav.viewit.dao;

import com.patrinav.viewit.entities.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public List<Movie> getAll() {
        //HQL que seria "SELECT * FROM movie" en SQL
        @SuppressWarnings("unchecked")
        TypedQuery<Movie> query = getSession().createQuery("from Movie");
        return query.getResultList();
    }

    @Override
    public Movie get(Long id) {
        @SuppressWarnings("unchecked")
        String hql = "from Movie where movieId=:id";

        Query<Movie> query = getSession().createQuery(hql);
        query.setParameter("id",id);
        return query.list().get(0);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        getSession().save(movie);
        getSession().getTransaction().commit();
        return null;
    }

    @Override
    public Movie delete(Movie movie) {
        return null;
    }
}
