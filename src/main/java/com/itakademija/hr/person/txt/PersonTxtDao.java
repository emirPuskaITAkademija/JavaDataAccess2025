package com.itakademija.hr.person.txt;

import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonEntity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PersonTxtDao implements PersonDao {

    public static final String FILE_NAME = "persons.txt";

    @Override
    public List<PersonEntity> readElements() throws DaoException {
        List<PersonEntity> elements = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line= br.readLine())!=null) {

                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String surname = tokenizer.nextToken();
                String nin = tokenizer.nextToken();
                int age = Integer.parseInt(tokenizer.nextToken());

                PersonEntity entity = new PersonEntity();
                entity.setName(name);
                entity.setSurname(surname);
                entity.setNationalIdentificationNumber(nin);
                entity.setAge(age);
                elements.add(entity);
            };
        }catch (IOException e) {
            throw new DaoException("Person TXT DAO read: '%s'".formatted(e.getMessage()));
        }
        return elements;
    }

    @Override
    public void persistElements(List<PersonEntity> elements) throws DaoException {
        if (elements == null || elements.isEmpty()) {
            return;
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            /**
             * Format čuvanja persona
             * name;surname;nin;age
             * name2;surname;nin;age
             * ....
             */
            for (PersonEntity person : elements) {
                String formattedPerson = """
                        %s;%s;%s;%s
                        """.
                        formatted(person.getName(),
                                person.getSurname(),
                                person.getNationalIdentificationNumber(),
                                person.getAge());
                out.print(formattedPerson);
            }
        } catch (IOException e) {
            throw new DaoException("Person TXT DAO write: '%s'".formatted(e.getMessage()));
        }
    }
}
