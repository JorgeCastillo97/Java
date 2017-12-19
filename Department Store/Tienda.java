/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.departamental;

import java.util.Arrays;

/**
 *
 * @author super
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op, sub, i, prod, aux = 6, prodcar = 0;
        int EXRESP[] = new int[10];            //Regresar las existencias a su estado original
        String P = "", SUB = "", TIPO = "";
        Producto[] Inventario = new Producto[10];
        Producto[] Carrito = new Producto[10];

        //Datos precargados
        Inventario[0] = new Abarrote(1, "Crema", "Lala", 14.50, 30);
        Inventario[1] = new Electrodomestico(2, "PlayStation 4", "Sony", 8000, 20);
        Inventario[2] = new Electrodomestico(3, "Xbox One", "Microsoft", 7000, 18);
        Inventario[3] = new Abarrote(4, "Galletas", "Marinela", 12, 40);
        Inventario[4] = new Electrodomestico(5, "Microondas", "Daewoo", 2700, 18);
        Inventario[5] = new Electrodomestico(6, "Lavadora", "Samsung", 6000, 25);

        //DownCast para insertar garantia a electrodomesticos
        ((Electrodomestico) Inventario[1]).setGarantia(true);
        ((Electrodomestico) Inventario[2]).setGarantia(true);
        ((Electrodomestico) Inventario[4]).setGarantia(false);
        ((Electrodomestico) Inventario[5]).setGarantia(false);

        EXRESP = RespaldarExistencias(EXRESP, Inventario);

        do {
            do {
                P = Ventana.pedir("\t\tTIENDA DEPARTAMENTAL\nSeleccione una opcion:\n1)Dar de alta un producto\n2)Ir al menu de compras\n3)Salir");
            } while (P == null || P.equals("") || (!P.equals("1") && !P.equals("2") && !P.equals("3")));
            op = Integer.parseInt(P);

            switch (op) {
                case 1: {
                    if (aux < 10) {
                        do {
                            TIPO = Ventana.pedir("Seleccione el tipo de producto que desea dar de alta\n1)Abarrote\n2)Electrodomestico");
                        } while (TIPO == null || TIPO.equals("") || (!TIPO.equals("1") && !TIPO.equals("2")));
                        prod = Integer.parseInt(TIPO);

                        switch (prod) {
                            case 1: {
                                RegistrarAbarrote(Inventario, aux);
                                EXRESP = RespaldarExistencias(EXRESP, Inventario);
                                break;
                            }
                            case 2: {
                                RegistrarElectrodomestico(Inventario, aux);
                                EXRESP = RespaldarExistencias(EXRESP, Inventario);
                                break;
                            }
                        }
                        aux++;
                        if ((10 - aux) == 0) {
                            Ventana.mensaje("Inventario lleno!");
                        } else {
                            Ventana.mensaje("Aun puedes registrar " + (10 - aux) + " producto(s)");
                        }
                    } else {
                        Ventana.mensaje("El inventario esta lleno!");
                    }
                    break;
                }
                case 2: {
                    do {
                        do {
                            SUB = Ventana.pedir("Seleccione una opcion\n1)Mostrar productos\n2)Comprar producto\n3)Mostrar carrito de compras\n4)Vaciar carrito\n5)Generar ticket de compra\n6)Verificar garantia\n7)Regresar al menu principal");
                        } while (SUB == null || SUB.equals("") || (!SUB.equals("1") && !SUB.equals("2") && !SUB.equals("3") && !SUB.equals("4") && !SUB.equals("5") && !SUB.equals("6") && !SUB.equals("7")));
                        sub = Integer.parseInt(SUB);

                        switch (sub) {
                            case 1: {
                                MostrarProductos(Inventario);
                                break;
                            }
                            case 2: {
                                Ventana.mensaje("Productos en Stock:");
                                MostrarProductos(Inventario);
                                ComprarProducto(Inventario, Carrito, prodcar);
                                prodcar++;
                                break;
                            }
                            case 3: {
                                if (prodcar > 0) {
                                    MostrarProductos(Carrito);
                                } else {
                                    Ventana.mensaje("Carrito de Compras Vacio");
                                }
                                break;
                            }
                            case 4: {
                                //VaciarCarritoDeCompras(Carrito);
                                CargarExistencias(Inventario, EXRESP);
                                prodcar = 0;
                                Ventana.mensaje("OK");
                                break;
                            }
                            case 5: {
                                if (prodcar > 0) {
                                    GenerarTicket(Carrito);
                                } else {
                                    Ventana.mensaje("Carrito de Compras Vacio");
                                }
                                break;
                            }
                            case 6: {
                                VerificarGarantia(Inventario, Carrito);
                                break;
                            }
                        }
                    } while (sub != 7);
                    break;
                }
            }
        } while (op != 3);
        Ventana.mensaje("Vuelva pronto!!");
    }

    public static int[] RespaldarExistencias(int[] ex, Producto[] inv) {
        int i;

        try {
            for (i = 0; i < inv.length; i++) {
                ex[i] = inv[i].getExistencias();
            }
        } catch (Exception e) {
        }

        return ex;
    }

    public static void RegistrarAbarrote(Producto[] Inventario, int x) {
        String nom = null, marca = null, COST = null, EX = null;
        do {
            nom = Ventana.pedir("Introduce el nombre del producto");
            marca = Ventana.pedir("Introduce la marca");
            COST = Ventana.pedir("Introduce el costo");
            EX = Ventana.pedir("Introduce las existencias");
        } while (nom == null || nom.equals("") || marca == null || marca.equals("") || COST == null || COST.equals("") || EX == null || EX.equals(""));

        Inventario[x] = new Abarrote((x + 1), nom, marca, Double.parseDouble(COST), Integer.parseInt(EX));
    }

    public static void RegistrarElectrodomestico(Producto[] Inventario, int x) {
        String nom = null, marca = null, COST = null, EX = null, G = null;

        nom = Ventana.pedir("Introduce el nombre del producto");
        marca = Ventana.pedir("Introduce la marca");
        COST = Ventana.pedir("Introduce el costo");
        EX = Ventana.pedir("Introduce las existencias");
        G = Ventana.pedir("Tendra garantia: (Si/No)");

        Inventario[x] = new Electrodomestico((x + 1), nom, marca, Double.parseDouble(COST), Integer.parseInt(EX));

        if (G.equals("Si") || G.equalsIgnoreCase("si") || G.equals("SI")) {
            ((Electrodomestico) Inventario[x]).setGarantia(true);
        } else {
            ((Electrodomestico) Inventario[x]).setGarantia(false);
        }
    }

    public static void MostrarProductos(Producto[] Inventario) {
        int i = 0;
        try {
            while (Inventario[i] != null) {
                Ventana.mensaje("Producto: " + (i + 1) + "\nID: " + Inventario[i].getId() + "\nNombre: " + Inventario[i].getNombre() + "\nMarca: " + Inventario[i].getMarca() + "\nPrecio: " + Inventario[i].getPrecio() + "\nExistencias: " + Inventario[i].getExistencias());
                i++;
            }
        } catch (Exception e) {
        }
    }

    public static void ComprarProducto(Producto[] Inventario, Producto[] Carrito, int prodcar) {
        int i, z, aux = 0, e, newex, aux01, aux02;
        String C = "", E = "";
        String N = null;
        String M = null;
        double precio;

        C = Ventana.pedir("Seleccione el nombre del producto que desea comprar");
        try {
            for (i = 0; i < Inventario.length; i++) {
                if (C.equals(Inventario[i].getNombre())) {
                    aux = 1;
                    if (Inventario[i].getExistencias() > 0) {
                        E = Ventana.pedir("Cuantos productos desea comprar?");
                        z = Integer.parseInt(E);
                        if (z <= Inventario[i].getExistencias() && z != 0) {

                            N = Inventario[i].getNombre();
                            M = Inventario[i].getMarca();
                            precio = Inventario[i].getPrecio();

                            if (Inventario[i] instanceof Electrodomestico) {
                                Carrito[prodcar] = new Electrodomestico(Inventario[i].getId(), Inventario[i].getNombre(), Inventario[i].getMarca(), Inventario[i].getPrecio(), z);
                                ((Electrodomestico) Carrito[prodcar]).setGarantia(((Electrodomestico) Inventario[i]).getGarantia());
                            } else if (Inventario[i] instanceof Abarrote) {
                                Carrito[prodcar] = new Abarrote(Inventario[i].getId(), Inventario[i].getNombre(), Inventario[i].getMarca(), Inventario[i].getPrecio(), z);
                            }

                            //Actualización de las existencias
                            e = Inventario[i].getExistencias();
                            newex = e - z;
                            Inventario[i].setExistencias(newex);
                            break;
                        } else if (z == 0) {
                            Ventana.mensaje("No eligio ningun producto.");
                            break;
                        } else {
                            Ventana.mensaje("No hay suficientes productos en inventario.\nPor favor elija una menor cantidad.");
                            break;
                        }
                    } else {
                        Ventana.mensaje("Ya no hay existencias en el inventario");
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            
        }

        if (aux == 0) {
            Ventana.mensaje("Producto no encontrado!");
        }
    }

    public static void VaciarCarritoDeCompras(Producto[] Carrito) {
        int m;

        try {
            for (m = 0; m < Carrito.length; m++) {
                Carrito[m] = null;
                if (Carrito[m] instanceof Electrodomestico) {
                    if (((Electrodomestico) Carrito[m]).getGarantia() == true) {
                        ((Electrodomestico) Carrito[m]).setGarantia(false);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static void CargarExistencias(Producto[] inv, int[] ex) {
        try {
            for (int i = 0; i < inv.length; i++) {
                inv[i].setExistencias(ex[i]);
            }
        } catch (Exception e) {
        }
    }

    public static void GenerarTicket(Producto[] Carrito) {
        String s[] =new String[10];

        int i = 0,total=0;

        s=ObtenerDatos(Carrito);
        
        while(Carrito[i]!=null)
        {
            total+=(Carrito[i].existencias*Carrito[i].precio);
            i++;
        }
        System.out.println(total);
        
        Ventana.mensaje("NOMBRE   MARCA   PRECIO UNITARIO  SUBTOTAL\n"
        + s[0]
        + s[1]
        + s[2]
        + s[3]
        + s[4]
        + s[5]
        + s[6]
        + s[7]
        + s[8]
        + s[9]
        +"                                              TOTAL"+total
        );
    }

    public static void VerificarGarantia(Producto[] inventario, Producto[] carrito) {
        String c = null;
        int id;
        Ventana.mensaje("Productos en Inventario aplicables para garantia:");
        for (int x = 0; x < inventario.length; x++) {
            if (inventario[x] instanceof Electrodomestico) {
                if (((Electrodomestico) inventario[x]).getGarantia() == true) {
                    Ventana.mensaje("Producto: " + (x + 1) + "\nID: " + inventario[x].getId() + "\nNombre: " + inventario[x].getNombre() + "\nMarca: " + inventario[x].getMarca() + "\nPrecio: " + inventario[x].getPrecio() + "\nExistencias: " + inventario[x].getExistencias());
                }
            }
        }

        do {
            c = Ventana.pedir("Selecciona el producto a reeemplazar por  el ID");
        } while (c == null || c.equals(""));

        id = Integer.parseInt(c);
        try {
            if (id == inventario[id - 1].getId()) {
                Ventana.mensaje("Su producto ha sido reemplazado!");
            } else {
                Ventana.mensaje("La garantia no es aplicable.");
            }
        } catch (Exception e) {
        }
    }

    public static String [] ObtenerDatos(Producto[] carro) {
        int i=0;
        String data[] = new String[10];
        
        for(int j=0;j<10;j++)
        {
            data[j]="";
        }
        
        try {
            while (carro[i] != null) {
                data[i]+= carro[i].nombre +"   "+ carro[i].marca +"   "+ carro[i].precio +"   "+ (carro[i].precio * carro[i].existencias);
                data[i]+="\n";
                i++;
            }
        } catch (Exception e) {
        }
        return data;
    }
}