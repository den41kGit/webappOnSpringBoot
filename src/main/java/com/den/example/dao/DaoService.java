package com.den.example.dao;

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
    T save(T element);

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
     * Методо добавления нескольких элементов в БД
     * @param list
     */
    //List<T> saveMultiple(List<T> list);

     /**
     * Выбор элемента по ИД
     * @param id
     * @return
     */
    //T selectById(int id);

    /**
     * Выбор всех элементов
     * @return
     */
    //List<T> selectAll();
}

