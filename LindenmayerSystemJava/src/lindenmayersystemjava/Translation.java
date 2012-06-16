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
    private ArrayList<Character> outputCharacter = new ArrayList<Character>();
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
        
        for(int i = 0; i < getOutputCharacter().size(); i++)
        {
            result += getOutputCharacter().get(i);
        }
        
        return result;
    }
    
    @Override
    public String toString()
    {
        String result = "";
        
        result += getInputCharacter();
        
        result += " > ";
        
        result += translate();
        
        return result;
    }

    /**
     * @return the inputCharacter
     */
    public char getInputCharacter() {
        return inputCharacter;
    }

    /**
     * @return the outputCharacter
     */
    public ArrayList<Character> getOutputCharacter() {
        return outputCharacter;
    }
}
