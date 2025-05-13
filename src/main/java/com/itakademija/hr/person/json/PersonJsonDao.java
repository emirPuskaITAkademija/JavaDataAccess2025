package com.itakademija.hr.person.json;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersonJsonDao implements PersonDao {

    public static final String PERSONS_JSON = "persons.json";

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        return List.of();
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if(elements == null || elements.isEmpty()){
            return;
        }
        JSONArray jsonArray = new JSONArray();
        for(PersonEntity person : elements){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nin", person.getNationalIdentificationNumber());
            jsonObject.put("name", person.getName());
            jsonObject.put("surname", person.getSurname());
            jsonObject.put("age", person.getAge());
            jsonArray.add(jsonObject);
        }
        String jsonString = jsonArray.toJSONString();
        try(FileWriter out = new FileWriter(PERSONS_JSON)){
            out.write(jsonString);
        }catch (IOException e){
            throw new DaoException("PersonJsonDao persist: %s ".formatted(e.getMessage()));
        }
    }
}
