package com.itakademija.hr.person.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersonJsonGsonDao implements PersonDao {

    public static final String PERSONS_JSON = "persons.json";
    private final Gson gson = new Gson();

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        try (FileReader fileReader = new FileReader(PERSONS_JSON)) {
            Type listType = new TypeToken<List<PersonEntity>>() {}.getType();
            return gson.fromJson(fileReader, listType);
        } catch (IOException e) {
            throw new DaoException("PersonJsonDao read: %s ".formatted(e.getMessage()));
        }
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if (elements == null || elements.isEmpty()) {
            return;
        }
        try (FileWriter out = new FileWriter(PERSONS_JSON)) {
            gson.toJson(elements, out);
        } catch (IOException e) {
            throw new DaoException("PersonJsonDao persist: %s ".formatted(e.getMessage()));
        }
    }
}
