package com.itakademija.hr;

import java.util.List;

public interface Dao<E> {

    /**
     * Ova methoda treba da učita elemente trajno snimljene u neki medij.
     * Element može biti Person, Order ili nešto slično...
     *
     * @return elements
     * @throws DaoException
     */
    List<E> readElements() throws DaoException;

    /**
     * Ova metofa trebada snimi elemente koji se nalaze u tranzijentnoj memoriji
     * i da ih prebaci u perzistentno stranje...
     *
     * @param elements
     * @throws DaoException
     */
    void persistElements(List<E> elements) throws DaoException;
}
