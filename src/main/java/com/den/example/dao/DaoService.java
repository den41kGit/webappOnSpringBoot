package com.den.example.dao;

import com.den.example.model.User;

import java.util.List;

/**
 * Интерфейс имитация БД с дженериком
 * @param <T>
 */
public interface DaoService<T> {
    /**
     * метод добавления элемента в БД
     *
     * @param element
     */
    long save(T element);

    /**
     * Удадение пользователя по ИД
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * Изменения данных элемента по ИД
     * @param element
     * @param id
     * @return
     */
    int update(T element, int id);

    /**
     * Выбор всех элементов
     * @return
     */
    List<User> selectAll();

     /**
     * Выбор элемента по ИД
     * @param id
     * @return
     */
    T selectById(int id);
}

