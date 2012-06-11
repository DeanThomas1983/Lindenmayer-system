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
public class Translation {
    private char inputCharacter;
    private ArrayList<Character> outputCharacter = new ArrayList<>();
    private DrawingRule drawingRule;
    
    public Translation()
    {
        
    }
    
    public Translation(char inputCharacter, 
            ArrayList<Character> outputCharacter,
            DrawingRule drawingRule)
    {
        this();
        
        this.inputCharacter = inputCharacter;
        this.outputCharacter = outputCharacter;
        this.drawingRule = drawingRule;
    }
    
    public String translate()
    {
        String result = "";
        
        for(int i = 0; i < outputCharacter.size(); i++)
        {
            result += outputCharacter.get(i);
        }
        
        return result;
    }
    
    @Override
    public String toString()
    {
        String result = "";
        
        result += inputCharacter;
        
        result += " > ";
        
        result += translate();
        
        return result;
    }
}
