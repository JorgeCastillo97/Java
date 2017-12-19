import javax.swing.*;
import java.util.*;

class p1{
	public static void main(String args[])
	{
		String M=null, N=null, R=null,S=null,A=null,D=null;
		Scanner sc=new Scanner(System.in);
		Cuenta c=new Cuenta();
		
		double sld,monto,retiro;
		char ch=13;

		do
		{
			N=ventana.pedir("Introduce el nombre del propietario de la cuenta");
		}while(N.equals(""));
		c.setNombre(N);

		do
		{
			D=ventana.pedir("Introduce la direccion");
		}while(D.equals(""));
		
		c.setDireccion(D);
		ventana.mensaje("Propietario de la cuenta: "+ N);
		ventana.mensaje("Direccion: "+ D);
		//R=ventana.pedir("Introduce el saldo");
		//sld=Double.parseDouble(R);
		

		int i=0;

		do
		{
			M=JOptionPane.showInputDialog(null, "Selecciona una opcion \n1)Ver saldo \n 2)Depositar \n 3) Retirar una cantidad \n 4)Salir", "BAXICO", JOptionPane.INFORMATION_MESSAGE);
			if(M==null || M.equals(""))
			{
				ventana.mensaje("Elige una opcion valida!!");
			}
			else
			{
				i=Integer.parseInt(M);
			}
			
			switch (i)
			{
			case 1:
				sld=c.getSaldo();
				ventana.mensaje("Su saldo es: $"+ sld);
				break;
			case 2:
				S=ventana.pedir("Introduce la cantidad");
				monto=Double.parseDouble(S);

				if(monto>0)
				{
					ventana.mensaje("OK");
					c.setSaldo(monto);
				}
				else
				{
					ventana.mensaje("Valor no aceptado");
				}
				break;
			case 3:
				A=ventana.pedir("Introduce la cantidad");
				retiro=Double.parseDouble(A);
				if(retiro>0)
				{
					sld=c.getSaldo();
					ventana.mensaje("Saldo actual en la cuenta: $"+sld);
					if(sld>=1000)
					{
						if(sld>=retiro)
						{
							c.retirarSaldo(retiro);
							sld=c.getSaldo();
						}
						else
						{
							ventana.mensaje("Saldo insuficiente");
						}
					}
					else
					{
						if((sld-retiro)>30.50)
						{
							ventana.mensaje("Se cobrara comision por manejo de cuenta");
						}
						else
						{
							ventana.mensaje("Saldo insuficiente");
						}
					}
				}
				else
				{
					ventana.mensaje("Valor no aceptado");
				}
				break;
			}
		}while(i!=4);
	}
	
}