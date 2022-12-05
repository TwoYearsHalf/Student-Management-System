package com.google.service;

import com.google.model.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.util.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentService {

    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public static ArrayList<Student> selectAll() {
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from info";

            preparedStatement = connection.prepareStatement(sql);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                arrayList.add(new Student(res.getInt(1), res.getString(2), res.getInt(3)));
            }

            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static Student selectById(int id) {

        try {
            Student student = new Student();
            connection = JDBCUtils.getConnection();

            String sql = "select * from info where id=?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                student.setId(res.getInt(1));
                student.setName(res.getString(2));
                student.setAge(res.getInt(3));
            }

            return student;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean delete(int id) {

        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from info where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int res = preparedStatement.executeUpdate();
            if (res > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean update(int id, String name, int age) {

        try {
            connection = JDBCUtils.getConnection();

            String sql = "update info set name=?,age=? where id=?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);

            int res = preparedStatement.executeUpdate();

            if (res > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean updateName(int id, String name) {
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update info set name=? where id=?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            int res = preparedStatement.executeUpdate();

            if (res > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}