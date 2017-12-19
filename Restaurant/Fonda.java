package fonda;

public class Fonda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String E1=null,E2=null,E3=null,G1=null,G2=null,G3=null,G4=null,P1=null,P2=null,P3=null,PLATO=null,oe=null,og=null,op=null;
        int E,G,P;
        
        E e1=new E();
        E e3=new E();
        E e2=new E();
        
        G g1=new G();
        G g2=new G();
        G g3=new G();
        G g4=new G();
        
        P p1=new P();
        P p2=new P();
        P p3=new P();
        
        e1.setNombre("Sopa de fideos");
        e2.setNombre("Spaguetti");
        e3.setNombre("Sopa de tortilla");
        
        g1.setNombre("Chilaquiles");
        g2.setNombre("Chuleta Ahumada");
        g3.setNombre("Bistek");
        g4.setNombre("Tacos Dorados");
        
        p1.setNombre("Helado de chocolate");
        p2.setNombre("Flan napolitano");
        p3.setNombre("Pay de piña");
        
        E1=e1.getNombre();
        E2=e2.getNombre();
        E3=e3.getNombre();
        G1=g1.getNombre();
        G2=g2.getNombre();
        G3=g3.getNombre();
        G4=g4.getNombre();
        P1=p1.getNombre();
        P2=p2.getNombre();
        P3=p3.getNombre();
        
        
        do
        {
            oe=ventana.pedir("Quieres Entrada?\n1---->Si\n2----->No");
            if(oe==null)
            {
                do
                {
                    oe=ventana.pedir("Quieres Entrada?\n1---->Si\n2----->No");
                }while(oe==null || oe.equals(""));    
            }
        }while(oe.equals(""));
        E=Integer.parseInt(oe);
        if(E!=1 && E!=2)
          {
                ventana.mensaje("Solamente habian dos opciones. Intenta con los guisados");
          }
        if(E==1)
        {
            do
            {
                do{
                    ventana.mensaje("ENTRADAS:\n1---->"+E1+"\n2---->"+E2+"\n3---->"+E3);
                    oe=ventana.pedir("Elija una entrada:");
                    if(oe==null)
                    {
                        do
                        {
                            oe=ventana.pedir("Elija una entrada:");
                        }while(oe==null || oe.equals(""));
                    }
                   }while(oe.equals(""));
                E=Integer.parseInt(oe);
            }while((E!=1 && E!=2 && E!=3));
            
                switch(E)
                {
                    case 1:
                        Cocina.preparar(e1);
                        break;
                    case 2:
                        Cocina.preparar(e2);
                        break;
                    case 3:
                        Cocina.preparar(e3);
                        break;
                }
        }
        else
        {
            do
            {
                og=ventana.pedir("Quieres Guisado?\n1---->Si\n2----->No");
                if(og==null)
                {
                    do{
                        og=ventana.pedir("Quieres Guisado?\n1---->Si\n2----->No");
                    }while(og==null || og.equals(""));
                }
            }while(og.equals(""));
            G=Integer.parseInt(og);
            if(G!=1 && G!=2)
            {
                ventana.mensaje("La opcion no esvalida. Todavia puedes elegir una opcion VALIDA con los postres");
            }
            if(G==1)
            {
                do
                {
                 do{   
                    ventana.mensaje("GUISADOS:\n1---->"+G1+"\n2---->"+G2+"\n3---->"+G3+"\n4---->"+G4);
                    op=ventana.pedir("Elije un guisado:");
                    if(op==null)
                    {
                        do
                        {
                            ventana.mensaje("GUISADOS:\n1---->"+G1+"\n2---->"+G2+"\n3---->"+G3+"\n4---->"+G4);
                            op=ventana.pedir("Elije un guisado:");
                        }while(op==null || op.equals(""));
                    }
                    }while(op.equals(""));
                    G=Integer.parseInt(op);
                }while(G!=1 && G!=2 && G!=3 && G!=4);
                
                switch(G)
                {
                    case 1:
                        Cocina.preparar(g1);
                        break;
                    case 2:
                        Cocina.preparar(g2);
                        break;
                    case 3:
                        Cocina.preparar(g3);
                        break;
                    case 4:
                        Cocina.preparar(g4);
                }
            }
            else
            {
                do
                {
                    op=ventana.pedir("Quieres Postre?\n1---->Si\n2----->No");
                    if(op==null)
                    {
                        do
                        {
                            op=ventana.pedir("Quieres Postre?\n1---->Si\n2----->No");
                        }while(op==null || op.equals(""));
                    }
                }while(op.equals(""));
                P=Integer.parseInt(op);
                if(P!=1 && P!=2)
                {
                    ventana.mensaje("Tal vez cuando regreses a la fonda puedas elegir correctamente. Adios");
                }
                if(P==1)
                {
                    do
                    {
                        do{
                        ventana.mensaje("POSTRES:\n1---->"+P1+"\n2---->"+P2+"\n3---->"+P3);
                        op=ventana.pedir("Elije un postre:");
                        if(op==null)
                        {
                            do
                            {
                                ventana.mensaje("POSTRES:\n1---->"+P1+"\n2---->"+P2+"\n3---->"+P3);
                                op=ventana.pedir("Elije una opcion");
                            }while(op==null || op.equals(""));
                        }
                        }while(op==null || op.equals(""));
                        P=Integer.parseInt(op);
                    }while(P!=1 && P!=2 && P!=3);
                    
                    switch(P)
                    {
                    case 1:
                        Cocina.preparar(p1);
                        break;
                    case 2:
                        Cocina.preparar(p2);
                        break;
                    case 3:
                        Cocina.preparar(p3);
                        break;
                    }
                    if(P!=1 || P!=2 || P!=3)
                    {
                        
                    }
                }
                else
                {
                    ventana.mensaje("¿A que veniste a la fonda?");
                }
            }
        }
    }
}
	


