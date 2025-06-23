/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.generic;

import java.util.List;

/**
 *
 * @author Docente
 * @param <T>
 */
public interface IGeneric<T> {
    int create(T t);
    int update(T t);
    int delete(int id);
    T read(int id);
    List<T> readAll();
    
}
