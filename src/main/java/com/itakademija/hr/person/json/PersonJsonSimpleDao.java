package com.itakademija.hr.person.json;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonJsonSimpleDao implements PersonDao {

    public static final String PERSONS_JSON = "persons.json";

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        try (FileReader fileReader = new FileReader(PERSONS_JSON)) {
            List<PersonEntity> persons = new ArrayList<>();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String nin = jsonObject.get("nin") != null ? jsonObject.get("nin").toString() : null;
                String surname = jsonObject.get("surname").toString();
                String name = jsonObject.get("name").toString();
                int age = Integer.parseInt(jsonObject.get("age").toString());
                PersonEntity person = new PersonEntity(nin, surname, name, age);
                persons.add(person);
            }
            return persons;
        } catch (ParseException | IOException e) {
            throw new DaoException("PersonJsonDao read: %s ".formatted(e.getMessage()));
        }
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if (elements == null || elements.isEmpty()) {
            return;
        }
        JSONArray jsonArray = new JSONArray();
        for (PersonEntity person : elements) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nin", person.getNationalIdentificationNumber());
            jsonObject.put("name", person.getName());
            jsonObject.put("surname", person.getSurname());
            jsonObject.put("age", person.getAge());
            jsonArray.add(jsonObject);
        }
        String jsonString = jsonArray.toJSONString();
        try (FileWriter out = new FileWriter(PERSONS_JSON)) {
            out.write(jsonString);
        } catch (IOException e) {
            throw new DaoException("PersonJsonDao persist: %s ".formatted(e.getMessage()));
        }
    }
}
