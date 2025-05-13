package com.itakademija.hr.person.serializible;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <li>byte</li>
 * <li>char</li>
 * <li>line</li>
 * <li>objekat serijalizujemo</li>
 */
public class PersonSerializableDao implements PersonDao {

    public static final String PERSON_SER = "person.ser";

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PERSON_SER))) {
            return (List<PersonEntity>) ois.readObject();
        }catch (Exception e){
            throw new DaoException("PersonSerializableDAO read: %s".formatted(e.getMessage()));
        }
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if(elements==null || elements.isEmpty()){
            return;
        }
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(PERSON_SER))){
            ous.writeObject(elements);
        }catch (IOException e){
            throw new DaoException("PersonSerializableDAO persistence: %s".formatted(e.getMessage()));
        }
    }
}
