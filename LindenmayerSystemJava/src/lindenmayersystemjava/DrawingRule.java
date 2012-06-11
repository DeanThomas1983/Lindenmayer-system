/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

/**
 *
 * @author Dean Thomas
 */
public class DrawingRule {
    private DrawingInstruction drawingIntruction;
    private int numberOfUnits;
    
    public DrawingRule()
    {
        this.drawingIntruction = DrawingInstruction.MoveForward;
        this.numberOfUnits = 1;
    }
    
    public DrawingRule(DrawingInstruction drawingInstruction, int numberOfUnits)
    {
        this();
        
        this.drawingIntruction = drawingInstruction;
        this.numberOfUnits = numberOfUnits;
    }
}
