package dao;

import java.util.List;

public interface CRUD<T> {
    T save(T entity); // persiste um entidade no banco de dados e retorna com um id gerado
    List<T> findAll(); //retorna uma lista genérica, e não recebe nada por parâmetro
    T findById(int id); // retorna uma entidade do banco a partir de um id informado;
    void deleteById(int id); // delete uma entidade salva no banco;
}
