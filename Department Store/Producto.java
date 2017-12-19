
package tienda.departamental;

/**
 *
 * @author super
 */
public class Producto {
    protected int id;
    protected String nombre;
    protected String marca;
    protected double precio;
    protected int existencias;
    
    //Constructor
    public Producto(int ID, String name, String tmark, double price, int amount)
    {
        id=ID;
        nombre=name;
        marca=tmark;
        precio=price;
        existencias=amount;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public int getExistencias(){
        return existencias;
    }
    
    public void setId(int i)
    {
        id=i;
    }
    
    public void setNombre(String N)
    {
        nombre=N;
    }
    
    public void setMarca(String M)
    {
        marca=M;
    }
    
    public void setPrecio(double d)
    {
        precio=d;
    }
    
    public void setExistencias(int newA)
    {
        existencias=newA;
    }
}