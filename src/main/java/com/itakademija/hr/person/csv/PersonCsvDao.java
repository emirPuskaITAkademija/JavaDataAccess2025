package com.itakademija.hr.person.csv;

import com.itakademija.hr.person.txt.PersonTxtDao;
//Rješenje od našeg Faruka Hodžića
public class PersonCsvDao extends PersonTxtDao {
    public PersonCsvDao() {
        setFilename("person.csv");
    }
}
