package com.example.user_service.commonadapter;

import java.util.List;

public interface usercommonadapter<E,M>{

    M save(E e);
    M getById(long ID);
    List<M> getAll();
    M update(E e);
    List<M> saveAll(List<E> e);
    void delete(Long Id);
}
