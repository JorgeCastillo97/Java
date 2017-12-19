/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumafilas_multcolumnas;

/**
 *
 * @author cecyt-8
 */
import java.util.*;
public class summing_up_rows_mult_columns {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rnd=new Random();
        int sumaf[],multc[],f,c,i,j,A[][];
        System.out.println("Introduce el numero de filas:");
        f=sc.nextInt();
        System.out.println("Introduce el numero de columnas:");
        c=sc.nextInt();
        //Dimensionar matrices
        A=new int[f][c];
        sumaf=new int[f];
        multc=new int [c];

        //Lenado de matriz
        for(i=0;i<f;i++)
            for(j=0;j<c;j++)
            {
                A[i][j]=((int)(rnd.nextDouble()*49+50));
            }

        System.out.println("Arreglo con numeros aleatorios:");
        for(i=0;i<f;i++)
        {
            for(j=0;j<c;j++)
            {
                System.out.print(A[i][j]+"\t");
            }
            System.out.print("\n");
        }
        //Suma de filas
        for(i=0;i<f;i++)
           for(j=0;j<c;j++)
           {
                 sumaf[i]+=A[i][j];
           }
      System.out.println("La suma es:");
       for(i=0;i<f;i++)
       System.out.print(+sumaf[i]+"\n");

       //multiplicacion de columnas
       for (j=0;j<c;j++)
       {
           multc[j]=1;
           for(i=0;i<f;i++)
               multc[j]*=A[i][j];
       }
       //Impresion de multiplicación
       System.out.println("La multiplicacion es:");
       for(j=0;j<c;j++)
           System.out.print(+multc[j]+"\n");
    }
}
