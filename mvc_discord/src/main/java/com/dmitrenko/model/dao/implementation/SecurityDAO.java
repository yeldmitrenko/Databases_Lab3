package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Security;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SecurityDAO implements AbstractDAO<Security> {

    private static final String GET_ALL = "SELECT * FROM student_project.security";
    private static final String GET_BY_LOGIN = "SELECT * FROM student_project.security WHERE login=?";
    private static final String CREATE = "INSERT student_project.security" +
            "(`login`, `password`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE student_project.security" +
            "SET password=? WHERE login=?";
    private static final String DELETE = "DELETE FROM student_project.security WHERE login=?";

    @Override
    public List<Security> findAll() throws SQLException {
        List<Security> securities = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Security security = new Security(
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                securities.add(security);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return securities;
    }

    @Override
    public void create(Security security) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(security.getLogin()));
            statement.setString(2, String.valueOf(security.getPassword()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Security findByLogin(String login) throws SQLException {
        Security security = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_LOGIN)) {
            statement.setString(1, login);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                security = new Security(
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return security;
    }

    @Override
    public void update(String login, Security security) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, security.getLogin());
            statement.setString(2, security.getPassword());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String login) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, login);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
