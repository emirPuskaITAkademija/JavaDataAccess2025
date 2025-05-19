package com.itakademija.hr.person.sql;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.util.List;

public class PersonSqlDao implements PersonDao {
    @Override
    public List<PersonEntity> readElements() throws DaoException {
        throw new UnsupportedOperationException("SQL Not supported yet.");
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        throw new UnsupportedOperationException("SQL Not supported yet.");
    }
}
