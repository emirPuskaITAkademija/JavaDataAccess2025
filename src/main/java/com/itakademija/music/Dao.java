package com.itakademija.music;

import java.util.List;

public interface Dao<E> {

    public List<E> findAll();

    public E findById(int id);

    public void save(E e);

    public void update(E e);

    public void delete(E e);
}
