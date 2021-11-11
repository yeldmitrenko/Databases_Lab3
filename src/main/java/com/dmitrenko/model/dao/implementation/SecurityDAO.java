package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.HibernateUtil;
import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Security;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class SecurityDAO implements AbstractDAO<Security> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Security> findAll() throws SQLException {
        List<Security> securities = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            securities = session.createQuery("from Security ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securities;
    }

    @Override
    public void create(Security security) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(security.getLogin(), security);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Security findByLogin(String login) throws SQLException {
        Security security = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            security = session.get(Security.class, login);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return security;
    }

    @Override
    public void update(String login, Security security) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(security);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String login) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Security security = session.get(Security.class, login);
            if (security != null) {
                session.delete(security);
                session.getTransaction().commit();
                System.out.println("Account with login: " + login + "was deleted\n");
            }
            else  {
                System.out.println("Nothing to delete");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
