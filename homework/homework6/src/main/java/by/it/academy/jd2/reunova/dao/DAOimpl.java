package by.it.academy.jd2.reunova.dao;

import by.it.academy.jd2.reunova.JDBCUtils;
import by.it.academy.jd2.reunova.entity.MyColumn;
import by.it.academy.jd2.reunova.entity.MyTable;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class DAOimpl<T> implements DAO<T> {
    private String table = null;
    private Map<Field, String> columns = new HashMap<>();
    private Map<String, Object> values = new HashMap<>();

    public void getValuesEntity(T t) {
        Class<?> type = t.getClass();

        if (type.isAnnotationPresent(MyTable.class)) {
            table = type.getAnnotation(MyTable.class).name();
        }

        if (table != null) {
            for (Field field : type.getDeclaredFields()) {
                if (field.isAnnotationPresent(MyColumn.class)) {
                    columns.put(field, field.getAnnotation(MyColumn.class).name());
                }
            }

            for (Map.Entry<Field, String> column : columns.entrySet()) {
                column.getKey().setAccessible(true);
                try {
                    values.put(column.getValue(), column.getKey().get(t));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void select(T t) {
        Connection connection;
        Statement statement;
        getValuesEntity(t);

        String sql = "select * from " + table;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int columnSelect = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnSelect; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(T t, String nameColumn, String newValue, int id) {
        Connection connection;
        Statement statement;
        getValuesEntity(t);

        String column = values.keySet()
                .stream()
                .filter(s -> s.equals(nameColumn))
                .findFirst()
                .orElse(null);

        String valueUpdate = "'" + newValue + "'";

        String sql = "update " + table + " set " + column + " =  " + valueUpdate + " where identifier = " + id;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(T t, int id) {
        Connection connection;
        Statement statement;
        getValuesEntity(t);

        String sql = "delete from " + table + " where identifier = " + id;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insert(T t) {
        Connection connection;
        Statement statement;
        getValuesEntity(t);

        String insertedValues = values.values()
                .stream()
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(",", "(", ")"));

        String sql = "insert into " + table + "(" + String.join(", ", values.keySet()) + ") " + "values " + insertedValues;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
