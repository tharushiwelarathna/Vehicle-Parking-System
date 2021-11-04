package lk.ijse.VP.dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T ,ID> {

     boolean save(T t) throws Exception;

     boolean delete( ID id) throws Exception;

     boolean update(T t) throws Exception;

     ArrayList<T> getAll() throws Exception;

     T search(ID id) throws Exception;

     List<T> loadAll() ;



}
