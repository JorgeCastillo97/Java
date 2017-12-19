import javax.swing.*;

public class ventana
{
	public static String     //Tipo de dato que regresa la funcion
	pedir(String s)
	{
		return JOptionPane.showInputDialog(null,s);
	}

	public static void mensaje(String s)
	{
		JOptionPane.showMessageDialog(null,s);
	}
}