package com.itakademija.gui;


import com.itakademija.hr.DaoException;
import com.itakademija.hr.person.PersonDao;
import com.itakademija.hr.person.PersonDaoFactory;
import com.itakademija.hr.person.PersonEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoMain {

    public static void main(String[] args) throws DaoException {
        /**
         * Pravimo zavisnost od dogovoreni INTERFEJSA
         */
        ArrayList<PersonEntity> personEntities = new ArrayList<>(List.of(
                new PersonEntity("123", "Tarik", "Fejzić", 23),
                new PersonEntity("456", "Ana", "Kovačević", 30),
                new PersonEntity("789", "Marko", "Jovanović", 27),
                new PersonEntity("101", "Elma", "Hodžić", 25),
                new PersonEntity("202", "Ivan", "Milić", 35),
                new PersonEntity("303", "Sara", "Nikolić", 29),
                new PersonEntity("404", "Petar", "Radić", 32),
                new PersonEntity("505", "Lana", "Stojanović", 26),
                new PersonEntity("606", "Nemanja", "Marić", 31),
                new PersonEntity("707", "Dino", "Vuković", 28)
        ));


        while (true) {
            //WRITE
            System.out.println("Unesi željeni format skladištenja podataka:");
            Scanner scanner = new Scanner(System.in);
            String userInputPersistence = scanner.nextLine();
            PersonDao personDaoWrite = PersonDaoFactory.get(userInputPersistence);
            personDaoWrite.persistElements(personEntities);


            //READ
            System.out.println("Unesi tip skladišta iz kojeg želiš pročitati podatke:");
            String userInputRead = scanner.nextLine();
            PersonDao personDaoRead = PersonDaoFactory.get(userInputRead);
            List<PersonEntity> elements = personDaoRead.readElements();
            for (PersonEntity personEntity : elements) {
                System.out.println(personEntity);
            }
        }
    }
}
