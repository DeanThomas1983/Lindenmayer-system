/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

/**
 *
 * @author dean
 */
public class DrawingRule {
    private DrawingInstruction drawingIntruction;
    private int numberOfUnits;
    
    public DrawingRule()
    {
        //this(DrawingInstruction.MoveForward, 1);
    }
    
    public DrawingRule(DrawingInstruction drawingInstruction, int numberOfUnits)
    {
        this.drawingIntruction = drawingInstruction;
        this.numberOfUnits = numberOfUnits;
    }
}
