package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.HibernateUtil;
import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Media;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked"})
public class MediaDAO implements AbstractDAO<Media> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Media> findAll() throws SQLException {
        List<Media> mediaList = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            mediaList = session.createQuery("from Media ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaList;
    }

    @Override
    public Media findById(Integer id) throws SQLException {
        Media media = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            media = session.get(Media.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return media;
    }

    @Override
    public void create(Media media) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(media);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Media media) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(media);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Media media = session.get(Media.class, id);
            if (media != null) {
                session.delete(media);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
