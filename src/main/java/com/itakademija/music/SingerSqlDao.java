package com.itakademija.music;


import java.util.ArrayList;
import java.util.List;
//SQL
public class SingerSqlDao implements Dao<SingerEntity> {

    @Override
    public List<SingerEntity> findAll() {
        List<SingerEntity> singers = new ArrayList<>();
        return singers;
    }

    @Override
    public SingerEntity findById(int id) {
        return null;
    }

    @Override
    public void save(SingerEntity s) {
        //TODO:
    }

    @Override
    public void update(SingerEntity s) {
        //TODO:
    }


    public void delete(SingerEntity s) {
        //TODO:
    }
}
