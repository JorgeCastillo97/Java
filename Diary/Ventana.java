/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda2;

import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class Ventana {
    public static String pedir(String s)
	{
		return JOptionPane.showInputDialog(null,s);
	}

	public static void mensaje(String s)
	{
		JOptionPane.showMessageDialog(null,s);
	}
}
