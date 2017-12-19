package agenda2;

/**
 *
 * @author Alumno
 */
public class Agenda2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dirContacto[] direcciones=new dirContacto[10];
        int var1,op;
        long ph;
        String S=null,N=null;
        
        dirContacto d0= new dirContacto("Blvd. Zacatecas No. 112 Nte Fracc. Comercial Galerias");
        dirContacto d1= new dirContacto("Av. Pedro de Loyola #397 Esq. Calle Hierro");
        dirContacto d2= new dirContacto("Blvd. Benito Juárez #2398 Col. Sánchez Taboada Mexicalli");
        dirContacto d3= new dirContacto("Via Rápida #14631 Pte. Esq. con Blvd. Lázaro Cárdenas Col. Los Santos Tijuana");
        dirContacto d4= new dirContacto("Carretera Transpeninsular Km. 6.5 Fracc. Cabo Bello Cabo San Lucas, BCS");
        dirContacto d5= new dirContacto("Libramineto Sur Pte. #2991 Col. Teran Tuxtla Gutierrez, Chiapas");
        dirContacto d6= new dirContacto("Periferico de la Juventud #6100 Sector 35 Col. Hacienda del Valle Cd. Chihuahua, Chihuahua");
        dirContacto d7= new dirContacto("Constitución #850 Col. Barrial Cd. Juárez, Chihuahua");
        dirContacto d8= new dirContacto("Av. Henequen #1181 Col. Salvacar Cd. Juárez, Chihuahua");
        dirContacto d9= new dirContacto("Calz del Hueso @670 Col. Los Robles Delegación Coyoacan, México DF.");
        
        direcciones[0]=d0;
        direcciones[1]=d1;
        direcciones[2]=d2;
        direcciones[3]=d3;
        direcciones[4]=d4;
        direcciones[5]=d5;
        direcciones[6]=d6;
        direcciones[7]=d7;
        direcciones[8]=d8;
        direcciones[9]=d9;
        
        Contacto[] Agenda=new Contacto[10];
        
        Contacto c0= new Contacto("Juan Lopez",70569834,"juancho@gamil.com");
        Contacto c1= new Contacto("Irving Guerra",63472587,"tsukune@japanmail.com");
        Contacto c2= new Contacto("Guadalupe Fernández",69785402,"lupefer@gmail.com");
        Contacto c3= new Contacto("Rodolfo Ruiz",45325858,"rodoreno@gmail.com");
        Contacto c4= new Contacto("Karla Juárez",12580368,"karjua@hotmail.com");
        Contacto c5= new Contacto("Andrea Muñoz",63574120,"andym@outlook.com");
        Contacto c6= new Contacto("Daniela Castellanos",36541200,"dannmc@gmail.com");
        Contacto c7= new Contacto("David Cruz",30256344,"cruzdav@yahho.mx");
        Contacto c8= new Contacto("Jimena Gómez",23658139,"mellark@gmail.com");
        Contacto c9= new Contacto("Jennifer Hernández",32472901,"jenn_hdz@hotmail.com");
        
        Agenda[0]=c0;
        Agenda[1]=c1;
        Agenda[2]=c2;
        Agenda[3]=c3;
        Agenda[4]=c4;
        Agenda[5]=c5;
        Agenda[6]=c6;
        Agenda[7]=c7;
        Agenda[8]=c8;
        Agenda[9]=c9;
        
        
        do
        {
        
        do{
            try {
            S=Ventana.pedir("BUSQUEDA POR NOMBRE---> 1\nBUSQUEDA POR NÚMERO DE TELEFONO--->2\nSALIR--->3");
            
            } catch (NumberFormatException e) {
            e.getMessage();
            }
        }while(S.equals("") || S==null || !S.equals("1") && !S.equals("2") && !S.equals("3"));
        var1=Integer.parseInt(S);
        switch(var1)
        {
            case 1:
                do
                {
                    N=Ventana.pedir("Introduce el nombre:");
                }while(N.equals("") || N==null);
                buscarNombre(N,Agenda,direcciones);
                break;
            case 2:
                do
                {
                    N=Ventana.pedir("Introduce el telefono:");
                    ph=Long.parseLong(N);
                }while(N.equals("") || N==null || ph<0);
                buscarTel(ph,Agenda,direcciones);
                break;
            case 3:
                System.exit(0);
            default:
                Ventana.mensaje("Opción Errónea!!");
        }
        }while(var1!=3);
            
    }
    
    public static void buscarNombre(String N, Contacto[] Agenda, dirContacto[] direcciones)
    {
        int a,aux=0;
        
        for(a=0;a<Agenda.length;a++)
        {
            if(Agenda[a].getNombre().equals(N))
            {
                Ventana.mensaje("Contacto "+(a+1)+":\n"+Agenda[a].getNombre()+"\n"+direcciones[a].getDireccion()+"\n"+Agenda[a].getTelefono()+"\n"+Agenda[a].getCorreo());
                aux=1;
                break;
            }
        }
        if(aux==0)
        {
            Ventana.mensaje("No hay coincidencias :(");
        }
    }
    
    public static void buscarTel(long ph, Contacto Agenda[], dirContacto direcciones[])
    {
        int a,aux=0;
        
        for(a=0;a<Agenda.length;a++)
        {
            if(Agenda[a].getTelefono()==ph)
            {
                Ventana.mensaje("Contacto "+(a+1)+":\n"+Agenda[a].getNombre()+"\n"+direcciones[a].getDireccion()+"\n"+Agenda[a].getTelefono()+"\n"+Agenda[a].getCorreo());
                aux=1;
                break;
            }
        }
        if(aux==0)
        {
            Ventana.mensaje("No hay coincidencias :(");
        }
    }
    
}