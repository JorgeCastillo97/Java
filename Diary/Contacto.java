/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda2;

/**
 *
 * @author Alumno
 */
public class Contacto {
    private String nombre=null;
    //private String direccion=null;
    private  long telefono;
    private String correo=null;
    
    public Contacto(String name, long tel, String mail)
    {
        this.nombre=name;
        this.telefono=tel;
        this.correo=mail;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public long getTelefono()
    {
        return telefono;
    }
    
    public String getCorreo()
    {
        return correo;
    }
}