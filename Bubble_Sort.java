/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento_burbuja;

/**
 *
 * @author JC
 */
import java.util.*;
public class Bubble_Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A[][],i,i2,j,j2,f,c,tempcond;
        System.out.println("Indica el numero de filas de la matriz:");
        f=sc.nextInt();
        System.out.println("Indica el numero de columnas de la matriz:");
        c=sc.nextInt();
        A=new int [f][c];
        //LLENADO DE LA MATRIZ CON DATOS DEL USUARIO
        for(i=0;i<f;i++)
            for(j=0;j<c;j++)
            {
                System.out.print("A["+i+"]["+j+"]=");
                A[i][j]=sc.nextInt();
            }
        //IMPRESION DE LA MATRIZ ORIGINAL
        System.out.println("La matriz original es:");
        for(i=0;i<f;i++)
        {
            for(j=0;j<c;j++)
            {
                System.out.print(A[i][j]+"\t");
            }
            System.out.print("\n");
        }
        
        //ORDENAMIENTO DE LA MATRIZ
        for(i=0;i<f;i++)
        {
            for(j=0;j<c;j++)
            {
                for(i2=0;i2<f;i2++)
                {
                    for(j2=0;j2<c;j2++)
                    {
                        if(A[i][j]<A[i2][j2])
                        {
                            tempcond=A[i][j];
                            A[i][j]=A[i2][j2];
                            A[i2][j2]=tempcond;
                        }
                    }
                }
            }
        }
        System.out.println("La matriz ordenada es:");
        for(i=0;i<f;i++)
        {
            for(j=0;j<c;j++)
            {
            System.out.print(A[i][j]+"\t");    
            }
            System.out.print("\n");
        }
    }
    
}