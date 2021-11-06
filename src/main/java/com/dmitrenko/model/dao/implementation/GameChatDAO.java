package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.HibernateUtil;
import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.GameChat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class GameChatDAO implements AbstractDAO<GameChat> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<GameChat> findAll() throws SQLException {
        List<GameChat> chats = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            chats = session.createQuery("from GameChat ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chats;
    }

    @Override
    public GameChat findById(Integer id) throws SQLException {
        GameChat gameChat = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            gameChat = session.get(GameChat.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameChat;
    }

    @Override
    public void create(GameChat gameChat) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(gameChat);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, GameChat gameChat) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(gameChat);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            GameChat gameChat = session.get(GameChat.class, id);
            if (gameChat != null) {
                session.delete(gameChat);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
