/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.departamental;

/**
 *
 * @author super
 */
public class Electrodomestico extends Producto{
    
    private boolean garantia;
    public Electrodomestico(int i, String n, String m, double p, int e)
    {
        super(i,n,m,p,e);
    }
    //Inventario hacer downcast para llamar a los metodos de garantia
    public boolean getGarantia()
    {
        return garantia;
    }
    
    public void setGarantia(boolean b)
    {
        garantia=b;
    }
}