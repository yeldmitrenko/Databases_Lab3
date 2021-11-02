package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Media;
import com.dmitrenko.model.entity.Message;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaDAO implements AbstractDAO<Media> {

    private static final String GET_ALL = "SELECT * FROM student_project.media";
    private static final String GET_BY_ID = "SELECT * FROM student_project.media WHERE id=?";
    private static final String CREATE = "INSERT student_project.media" +
            "(`name`, `size`, `date`, `game_chat_id`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.media" +
            "SET name=?, size=?, date=?, game_chat_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.media WHERE id=?";

    @Override
    public List<Media> findAll() throws SQLException {
        List<Media> mediaList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Media media = new Media(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("size"),
                        resultSet.getInt("date"),
                        resultSet.getInt("game_chat_id")
                );
                mediaList.add(media);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaList;
    }

    @Override
    public Media findById(Integer id) throws SQLException {
        Media media = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                media = new Media(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("size"),
                        resultSet.getInt("date"),
                        resultSet.getInt("game_chat_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return media;
    }

    @Override
    public void create(Media media) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(media.getName()));
            statement.setString(2, String.valueOf(media.getSize()));
            statement.setString(3, String.valueOf(media.getDate()));
            statement.setString(4, String.valueOf(media.getGameChatId()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Media media) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, media.getName());
            statement.setDouble(2, media.getSize());
            statement.setInt(3, media.getDate());
            statement.setInt(4, media.getGameChatId());
            statement.setInt(5, media.getId());
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
