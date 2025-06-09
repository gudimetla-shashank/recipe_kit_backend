package com.example.recipekit.commons;

import java.util.List;

public interface recipeadaptercommon<E,M> {

    M save(E e);
    M getById(long id);
    List<M> getAll();
    M update(E e);
    List<M> addAll(List<E> e);
    void delete(long id);
    List<M> getbetween(Double start, Double end);

}
