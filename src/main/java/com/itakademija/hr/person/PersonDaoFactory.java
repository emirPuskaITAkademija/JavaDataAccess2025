package com.itakademija.hr.person;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.csv.PersonCsvDao;
import com.itakademija.hr.person.json.PersonJsonDao;
import com.itakademija.hr.person.serializible.PersonSerializableDao;
import com.itakademija.hr.person.sql.PersonSqlDao;
import com.itakademija.hr.person.txt.PersonTxtDao;
import com.itakademija.hr.person.xml.PersonXmlDao;

import java.util.stream.Stream;

public enum PersonDaoFactory {
    XML(new PersonXmlDao()),
    JSON(new PersonJsonDao()),
    SER(new PersonSerializableDao()),
    TXT(new PersonTxtDao()),
    SQL(new PersonSqlDao()),
    CSV(new PersonCsvDao());

    private final PersonDao personDao;

    PersonDaoFactory(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonDao get() {
        return personDao;
    }

    public static PersonDao get(String persistenceFormat) throws DaoException {
        PersonDaoFactory[] values = PersonDaoFactory.values();
        PersonDaoFactory personDaoFactory = Stream.of(values)
                .filter(f -> f.name().equalsIgnoreCase(persistenceFormat))
                .findFirst()
                .orElseThrow(() -> new DaoException("Ne postoji persistence format '%s'".formatted(persistenceFormat)));
        return personDaoFactory.get();
    }
}
