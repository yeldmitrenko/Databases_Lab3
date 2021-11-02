package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Message;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO implements AbstractDAO<Message> {

    private static final String GET_ALL = "SELECT * FROM dmitrenko.message";
    private static final String GET_BY_ID = "SELECT * FROM dmitrenko.message WHERE id=?";
    private static final String CREATE = "INSERT dmitrenko.message" +
            "(`date`, `message`, `game_chat_id`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE dmitrenko.message" +
            "SET date=?, message=?, game_chat_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmitrenko.message WHERE id=?";

    @Override
    public List<Message> findAll() throws SQLException {
        List<Message> messages = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("date"),
                        resultSet.getString("message"),
                        resultSet.getInt("game_chat_id")
                );
                messages.add(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messages;
    }

    @Override
    public Message findById(Integer id) throws SQLException {
        Message message = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getInt("date"),
                        resultSet.getString("message"),
                        resultSet.getInt("game_chat_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void create(Message message) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(message.getDate()));
            statement.setString(2, String.valueOf(message.getMessage()));
            statement.setString(3, String.valueOf(message.getGameChatId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Message message) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, message.getDate());
            statement.setString(2, message.getMessage());
            statement.setInt(3, message.getGameChatId());
            statement.setInt(4, message.getId());
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
