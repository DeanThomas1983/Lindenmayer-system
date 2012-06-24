/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import java.util.ArrayList;



/**
 * @class Translation
 * @author Dean Thomas
 */
public class Translation {
    private char inputCharacter;
    private ArrayList<Character> outputCharacter = new ArrayList<Character>();
    
    //  TODO: this should probably be moved to View class
    private DrawingRule drawingRule;
    
    /**
     * Default constructor
     */
    public Translation()
    {
        
    }
    
    /**
     * Create a new translation rule
     * @param inputCharacter the alphanumeric character on which to perform the
     * transformation
     * @param outputCharacter the resultant string generated when the input
     * character is transformed
     * @param drawingRule provides storage for how to draw the particular
     * instructor (should be moved to View class)
     */
    public Translation(char inputCharacter, 
            ArrayList<Character> outputCharacter,
            DrawingRule drawingRule)
    {
        this();
        
        this.inputCharacter = inputCharacter;
        this.outputCharacter = outputCharacter;
        this.drawingRule = drawingRule;
    }
    
    /**
     * Perform a translation rule on the input character to replace it with
     * the output string
     * @return String; the string with which to replace the character
     */
    public String translate()
    {
        String result = "";
        
        //  TODO: could be performed with just a simple swap from input to
        //  output?
        for(int i = 0; i < getOutputCharacter().size(); i++)
        {
            result += getOutputCharacter().get(i);
        }
        
        return result;
    }
    
    /**
     * Provide a formatted representation of the rule
     * @return String; the rule formatted for console output etc
     */
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
     * Access method for the inputCharacter private variable
     * @return char; the character to be translated from
     */
    public char getInputCharacter() {
        return inputCharacter;
    }

    /**
     * Access method for the outputCharacter private variable
     * @return ArrayList<char>; a list of the character to be output by the
     * translation
     */
    public ArrayList<Character> getOutputCharacter() {
        return outputCharacter;
    }
}
