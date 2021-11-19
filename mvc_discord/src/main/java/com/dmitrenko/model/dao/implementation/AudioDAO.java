package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Audio;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AudioDAO implements AbstractDAO<Audio> {

    private static final String GET_ALL = "SELECT * FROM dmitrenko.audio";
    private static final String GET_BY_ID = "SELECT * FROM dmitrenko.audio WHERE id=?";
    private static final String CREATE = "INSERT dmitrenko.audio" +
            "(`duration`, `game_chat_id`) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE dmitrenko.audio" +
            "SET duration=?, game_chat_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmitrenko.audio WHERE id=?";

    @Override
    public List<Audio> findAll() throws SQLException {
        List<Audio> audioList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Audio audio = new Audio(
                        resultSet.getInt("id"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("game_chat_id")
                );
                audioList.add(audio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioList;
    }

    @Override
    public Audio findById(Integer id) throws SQLException {
        Audio audio = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                audio = new Audio(
                        resultSet.getInt("id"),
                        resultSet.getInt("duration"),
                        resultSet.getInt("game_chat_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audio;
    }

    @Override
    public void create(Audio audio) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(audio.getDuration()));
            statement.setString(2, String.valueOf(audio.getGameChatId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Audio audio) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, audio.getDuration());
            statement.setInt(2, audio.getGameChatId());
            statement.setInt(3, audio.getId());
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
