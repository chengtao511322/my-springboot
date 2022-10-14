package com.ct.service;

import java.util.List;

public interface IService<T> {

    T getById();

    List<T> getAll();
}
