/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import sun.security.util.Debug;

/**
 *
 * @author dean
 */
public class LindenmayerSystemJava {

    private static DataModel dataModel = new DataModel();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Debug.println("main","Staring program");
        
        dataModel.buildDebugData();
    }
    
    
}
