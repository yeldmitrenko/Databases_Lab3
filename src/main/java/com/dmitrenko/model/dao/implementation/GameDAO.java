package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.HibernateUtil;
import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Game;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class GameDAO implements AbstractDAO<Game> {
    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Game> findAll() throws SQLException {
        List<Game> games = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            games = session.createQuery("from Game").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public Game findById(Integer id) throws SQLException {
        Game game = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            game = session.get(Game.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public void create(Game game) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(game);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Game game) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(game);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Game game = session.get(Game.class, id);
            if (game != null) {
                session.delete(game);
                session.getTransaction().commit();
                System.out.println("Game with ID = " + id + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
