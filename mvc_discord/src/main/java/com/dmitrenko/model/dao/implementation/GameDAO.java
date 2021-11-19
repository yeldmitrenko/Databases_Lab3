package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Game;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements AbstractDAO<Game> {
    private static final String GET_ALL = "SELECT * FROM dmitrenko.game";
    private static final String GET_BY_ID = "SELECT * FROM dmitrenko.game WHERE id=?";
    private static final String CREATE = "INSERT dmitrenko.game" +
            "(`name`, `price`, `category`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE dmitrenko.game" +
            "SET name=?, price=?, category=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmitrenko.game WHERE id=?";

    @Override
    public List<Game> findAll() throws SQLException {
        List<Game> games = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Game game = new Game(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("category")
                );
                games.add(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public Game findById(Integer id) throws SQLException {
        Game game = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                game = new Game(
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("category")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public void create(Game game) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(game.getName()));
            statement.setString(2, String.valueOf(game.getPrice()));
            statement.setString(3, String.valueOf(game.getCategory()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Game game) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, game.getName());
            statement.setInt(2, game.getPrice());
            statement.setString(3, game.getCategory());
            statement.setInt(4, game.getId());
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
