package com.itakademija.hr.person.xml;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PersonXmlDao implements PersonDao {

    public static final String PERSONS_XML = "persons.xml";

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(PERSONS_XML));) {
            return (List<PersonEntity>) decoder.readObject();
        } catch (IOException e) {
            throw new DaoException("PersonXMLDao read: %s".formatted(e.getMessage()));

        }
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if (elements == null || elements.isEmpty()) {
            return;
        }
        //Philip Milne -> XMLEncoder
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(PERSONS_XML))) {
            encoder.writeObject(elements);
        } catch (IOException e) {
            throw new DaoException("PersonXMLDao write: %s".formatted(e.getMessage()));
        }
    }
}
