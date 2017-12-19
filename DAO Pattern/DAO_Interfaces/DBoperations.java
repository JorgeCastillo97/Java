package DAO_Interfaces;

import Application.Data;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jorge Castillo
 */
public interface DBoperations {
    
    public void insert(Data d) throws Exception;
    public void update(Data d) throws Exception;
    public void delete(Data d) throws Exception;
    public List<Data> saveQuery() throws Exception;
    public void showQuery(List<Data> Q) throws Exception;
}