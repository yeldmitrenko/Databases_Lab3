package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.GameChat;
import com.dmitrenko.persistant.ConnectionManager;

import java.rmi.ConnectIOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameChatDAO implements AbstractDAO<GameChat> {

    private static final String GET_ALL = "SELECT * FROM student_project.game_chat";
    private static final String GET_BY_ID = "SELECT * FROM student_project.game_chat WHERE id=?";
    private static final String CREATE = "INSERT student_project.game_chat" +
            "(`name`, `game_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE student_project.game_chat" +
            "SET name=?, game_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.game_chat WHERE id=?";

    @Override
    public List<GameChat> findAll() throws SQLException {
        List<GameChat> chats = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                GameChat gameChat = new GameChat(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("game_id")
                );
                chats.add(gameChat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chats;
    }

    @Override
    public GameChat findById(Integer id) throws SQLException {
        GameChat gameChat = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gameChat = new GameChat(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("game_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameChat;
    }

    @Override
    public void create(GameChat gameChat) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(gameChat.getName()));
            statement.setString(2, String.valueOf(gameChat.getGameId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, GameChat gameChat) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, gameChat.getName());
            statement.setInt(2, gameChat.getGameId());
            statement.setInt(3, gameChat.getId());
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
