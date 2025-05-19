package com.itakademija.hr.person.sql;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.itakademija.gui.DemoMain.pass;

/**
 * Imamo nekoliko pristupa interakcije s bazom:
 * <li>1. otvori connection , kreiraj SQL statement, obradi rezultat i close connection</li>
 * <li>2. nemoj otvarat i zatvara konekciju uvijek..kreiraj pool connection objekata .... kreiraj
 * SQL statement korištenjem connection iz pool, obradi rezultat i vrati u pool</li>
 * <li>3. ORM Hibernate</li>
 * <li>4. ORM JPA (Hibernate, EclipseLink, MyBatis...)</li>
 */
public class PersonSqlDao implements PersonDao {
    String url = "jdbc:mysql://localhost:3308/persons";
    String user = "root";
    String password = pass;

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        List<PersonEntity> persons = new ArrayList<>();
        //1. Connection DG: url, username i password
        //2. PreparedStatement -> SQL
        //3. ResultSet
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM persons");) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                PersonEntity person = new PersonEntity();
                person.setNationalIdentificationNumber(resultSet.getString("nin"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                persons.add(person);
            }
            return persons;
        } catch (SQLException e) {
            throw new DaoException("SQL: " + e.getMessage());
        }
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if (elements == null || elements.isEmpty()) {
            return;
        }

        String sql = "INSERT INTO persons (nin, name, surname, age) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            for (PersonEntity person : elements) {
                statement.setString(1, person.getNationalIdentificationNumber() + UUID.randomUUID().toString());
                statement.setString(2, person.getName());
                statement.setString(3, person.getSurname());
                statement.setInt(4, person.getAge());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            throw new DaoException("SQL persist: " + e.getMessage());
        }
    }
}
