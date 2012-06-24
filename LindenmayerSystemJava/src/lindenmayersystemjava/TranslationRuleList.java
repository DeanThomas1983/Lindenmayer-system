/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import java.util.ArrayList;

/**
 * @class TranslationRuleList
 * @author Dean Thomas
 */
public class TranslationRuleList extends ArrayList<Translation> {
    
    /**
     * Find the Index of a particular character in the rule list
     * @param searchChar the character to search for
     * @return integer; the index of the character in the array
     */
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
    
    /**
     * Get the List of rules as a string, which can be displayed in the console
     * @return String - the list as a formatted string
     */
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
