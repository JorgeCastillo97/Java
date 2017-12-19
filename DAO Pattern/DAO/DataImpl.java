/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Application.Data;
import DAO_Interfaces.DBoperations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author super
 */
public class DataImpl extends Connect implements DBoperations {

    @Override
    public void insert(Data d) throws SQLException, ClassNotFoundException {
        try {
            if(this.connect()) {
                PreparedStatement ins;
                ins = this.conn.prepareStatement("INSERT INTO socio VALUES(?,?,?,?)");
                ins.setInt(1, d.getId());
                ins.setString(2, d.getName());
                ins.setString(3, d.getAddress());
                ins.setString(4, d.getNumber());
                ins.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void update(Data d) throws SQLException, ClassNotFoundException {
        try {
            if(this.connect()) {
                PreparedStatement upd;
                upd = this.conn.prepareStatement("UPDATE socio SET idSocio=? WHERE idSocio=?");
                upd.setInt(1, (d.getId())+1);
                upd.setInt(2, d.getId());
                upd.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void delete(Data d) throws SQLException, ClassNotFoundException {
        try {
            if(this.connect()) {
                PreparedStatement del;
                del = this.conn.prepareStatement("DELETE FROM socio WHERE idSocio=?");
                del.setInt(1, d.getId());
                del.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public List<Data> saveQuery() throws SQLException, ClassNotFoundException {
        
        List<Data> Result = new ArrayList<>();
        
        try {
            if(this.connect()) {
                PreparedStatement sel;
                sel = this.conn.prepareStatement("SELECT * FROM socio;");
                ResultSet query;
                query = sel.executeQuery();
                
                while(query.next()) {
                    Data d = new Data();
                    d.setId(query.getInt("idSocio"));
                    d.setName(query.getString("nombre"));
                    d.setAddress(query.getString("direccion"));
                    d.setNumber(query.getString("tel"));
                    Result.add(d);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.closeConnection();
        }
        if(!Result.isEmpty())
            return Result;
        return null;
    }
    
    @Override
    public void showQuery(List<Data> Q) {
        Q.forEach((i) -> {
            System.out.println(i.getId() +"\t"+ i.getName() +"\t"+ i.getAddress() +"\t"+ i.getNumber());
        });
    }

}