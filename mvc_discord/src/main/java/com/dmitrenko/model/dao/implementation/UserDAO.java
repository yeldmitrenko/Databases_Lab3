package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.User;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractDAO<User> {

    private static final String GET_ALL = "SELECT * FROM dmitrenko.user";
    private static final String GET_BY_ID = "SELECT * FROM dmitrenko.user WHERE id=?";
    private static final String CREATE = "INSERT dmitrenko.user" +
            "(`name`, `surname`, `username`, `phone_number`, `inform`, `game_chat_id`, `payment_id`, `security_login`)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE dmitrenko.user" +
            "SET name=?, surname=?, username=?, phone_number=?, inform=?, game_chat_id=?, payment_id=?, security_login=?" +
            "WHERE id=?";
    private static final String DELETE = "DELETE FROM dmitrenko.user WHERE id=?";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("username"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("inform"),
                        resultSet.getInt("game_chat_id"),
                        resultSet.getInt("payment_id"),
                        resultSet.getString("security_login")
                );
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("username"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("inform"),
                        resultSet.getInt("game_chat_id"),
                        resultSet.getInt("payment_id"),
                        resultSet.getString("security_login")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(user.getName()));
            statement.setString(2, String.valueOf(user.getSurname()));
            statement.setString(3, String.valueOf(user.getUsername()));
            statement.setString(4, String.valueOf(user.getPhoneNumber()));
            statement.setString(5, String.valueOf(user.getInform()));
            statement.setString(6, String.valueOf(user.getGameChatId()));
            statement.setString(7, String.valueOf(user.getPaymentId()));
            statement.setString(8, String.valueOf(user.getSecurityLogin()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, User user) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getInform());
            statement.setInt(6, user.getGameChatId());
            statement.setInt(7, user.getPaymentId());
            statement.setString(8, user.getSecurityLogin());
            statement.setInt(9, user.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
