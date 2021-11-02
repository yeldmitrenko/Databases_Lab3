package com.dmitrenko.model.dao.implementation;

import com.dmitrenko.model.dao.AbstractDAO;
import com.dmitrenko.model.entity.Payment;
import com.dmitrenko.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements AbstractDAO<Payment> {
    private static final String GET_ALL = "SELECT * FROM student_project.payment";
    private static final String GET_BY_ID = "SELECT * FROM student_project.payment WHERE id=?";
    private static final String CREATE = "INSERT student_project.payment" +
            "(`card_number`, `expiration_date`, `cvc`, `name`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.payment" +
            "SET card_number=?, expiration_date=?, cvc=?, name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.payment WHERE id=?";

    @Override
    public List<Payment> findAll() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment(
                        resultSet.getInt("id"),
                        resultSet.getInt("card_number"),
                        resultSet.getInt("expiration_date"),
                        resultSet.getInt("cvc"),
                        resultSet.getString("name")
                );
                payments.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payments;
    }

    @Override
    public Payment findById(Integer id) throws SQLException {
        Payment payment = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                payment = new Payment(
                        resultSet.getInt("id"),
                        resultSet.getInt("card_number"),
                        resultSet.getInt("expiration_date"),
                        resultSet.getInt("cvc"),
                        resultSet.getString("name")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void create(Payment payment) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(payment.getCardNumber()));
            statement.setString(2, String.valueOf(payment.getExpirationDate()));
            statement.setString(3, String.valueOf(payment.getCvc()));
            statement.setString(4, String.valueOf(payment.getName()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Payment payment) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, payment.getCardNumber());
            statement.setInt(2, payment.getExpirationDate());
            statement.setInt(3, payment.getCvc());
            statement.setString(4, payment.getName());
            statement.setInt(5, payment.getId());
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)){
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
