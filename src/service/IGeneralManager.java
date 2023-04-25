package service;

import java.io.Serializable;

public interface IGeneralManager<T> extends Serializable {
    void add(T type);
    void remove();
    void edit();
    void display();

}
