package com.itakademija.hr.person.csv;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.util.List;

public class PersonCsvDao implements PersonDao {
    @Override
    public List<PersonEntity> readElements() throws DaoException {
        return List.of();
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {

    }
}
