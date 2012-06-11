/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import java.util.ArrayList;

/**
 *
 * @author Dean Thomas
 */
public class TranslationRuleList extends ArrayList<Translation> {
    
    public int indexOf(char searchChar)
    {
        int result = -1;
        
        for (int i = 0; i < this.size(); i++)
        {
            //  Search for the first match in the list with the desired 
            //  character
            if (this.get(i).getInputCharacter() == searchChar)
                return i;
        }
        
        return result;
    }
    
    public String getListOfRules()
    {
        String result = "\n";
        
        for (int i = 0; i < this.size(); i++)
        {
            result += this.get(i).toString();
            
            result += "\n";
        }
        
        return result;
    }
}
