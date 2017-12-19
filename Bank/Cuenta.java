public class Cuenta
{
	
			private byte id=1;
			private double saldo=1500;
			private String nom=null, dir=null;
		

		public double getSaldo()
		{
			return saldo;
		}
	
	public void setSaldo(double sal)
		{
			saldo=saldo+sal;
		}

	public void retirarSaldo(double c)
		{
			saldo=saldo-c;
		}

	public void setNombre(String name)
		{
			nom=name;
		}

	public void setDireccion(String d)
		{
			dir=d;
		}


	public String getNombre()
		{
			return nom;
		}

	public String getDireccion()
		{
			return dir;
		}
}