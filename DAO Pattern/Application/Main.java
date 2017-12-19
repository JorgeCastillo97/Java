package Application;

import DAO.DataImpl;
import DAO_Interfaces.DBoperations;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Castillo
 */
public class Main {

    public static void main(String[] args) {
        
        Data Values1 = new Data();
        Values1.setId(200);
        Values1.setName("CASTILLO JIMENEZ JORGE");
        Values1.setAddress("unknown");
        Values1.setNumber("55-70-87-36-390");
        
        DBoperations op;
        List<Data> query = new ArrayList<>();
        try {
            op = new DataImpl();
            op.insert(Values1);
            query = op.saveQuery();
            System.out.println("DATA FROM THE QUERY: (1 NEW ROW ADD: 200...)");
            op.showQuery(query);
            System.out.println("---------------------------------");
            op.delete(Values1);
            System.out.println("DATA FROM THE QUERY: (ROW 200 DELETED!)");
            op.showQuery(op.saveQuery());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
}
