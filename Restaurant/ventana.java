package fonda;

import javax.swing.JOptionPane;

public class ventana {

		public static String pedir(String str){
			return JOptionPane.showInputDialog(null,str);
			}

		public static void
			mensaje(String msg){
				JOptionPane.showMessageDialog(null, msg);
			}
}