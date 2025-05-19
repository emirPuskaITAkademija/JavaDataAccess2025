package com.itakademija.music;

import java.time.Year;
import java.util.StringJoiner;
//SingerEntity <-> singers
public class SingerEntity {
    private int id;
    private String name;
    private String surname;
    private SingerType type;
    private Year foundationYear;
    private Year endYear;
    private String site;

    public SingerEntity() {
    }

    public SingerEntity(int id, String name, String surname, SingerType type, Year foundationYear, Year endYear, String site) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.foundationYear = foundationYear;
        this.endYear = endYear;
        this.site = site;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SingerType getType() {
        return type;
    }

    public void setType(SingerType type) {
        this.type = type;
    }

    public Year getFoundationYear() {
        return foundationYear;
    }

    public void setFoundationYear(Year foundationYear) {
        this.foundationYear = foundationYear;
    }

    public Year getEndYear() {
        return endYear;
    }

    public void setEndYear(Year endYear) {
        this.endYear = endYear;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SingerEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("type=" + type)
                .add("foundationYear=" + foundationYear)
                .add("endYear=" + endYear)
                .add("site='" + site + "'")
                .toString();
    }
}
