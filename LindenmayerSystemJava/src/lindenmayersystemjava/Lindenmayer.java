/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import java.util.ArrayList;
import sun.security.util.Debug;

/**
 *
 * @author dean
 */
public final class Lindenmayer {
    private String inputString;
    private ArrayList<Translation> rules = new ArrayList<>();
    
    public Lindenmayer()
    {
        buildDebugData();
    }
    
    public Lindenmayer(ArrayList rules, 
            String inputString)
    {
        this();
        
        this.rules = rules;
        this.inputString = inputString;
    }
    
    public void buildDebugData()
    {
        final String METHOD_NAME = "buildDebugData";
        
        Debug.println(METHOD_NAME, "Creating debug data set");
        
        //  Input
        this.inputString = "A";
        
        //  Ruleset number 1
        ArrayList<Character> ruleSet1 = new ArrayList<>();
        ruleSet1.add('A');
        ruleSet1.add('B');
        ruleSet1.add('D');
        Translation t1 = new Translation('A',ruleSet1,new DrawingRule());
        rules.add(t1);
        
        //  Ruleset number 2
        ArrayList<Character> ruleSet2 = new ArrayList<>();
        ruleSet2.add('B');
        ruleSet2.add('D');
        Translation t2 = new Translation('B',ruleSet2,new DrawingRule());
        rules.add(t2);
        
        //  Ruleset number 3
        ArrayList<Character> ruleSet3 = new ArrayList<>();
        ruleSet3.add('A');
        Translation t3 = new Translation('C',ruleSet3,new DrawingRule());
        rules.add(t3);
        
        Debug.println(METHOD_NAME,
                "Translation rules: " + rules.size());
        
        Debug.println(METHOD_NAME, this.getListOfRules());
        
        Debug.println(METHOD_NAME, this.listLevels(0));
    }
    
    public String getListOfRules()
    {
        String result = "";
        
        for (int i = 0; i < rules.size(); i++)
        {
            result += rules.get(i).toString();
            
            result += "\n";
        }
        
        return result;
    }
    
    public String listLevels(int maximumLevel)
    {
        String result = "\n";
        
        for (int i = 0; i <= maximumLevel; i++)
        {
            result += "Level " + i + ": ";
            
            result += getLevel(i);
            
            result += "\n";
        }
        
        return result;
    }
    
    public String getLevel(int level)
    {
        String result = inputString;           
        
        if (level > 0)
        {
            for (int i = 0; i < level; i++)
            {
                String input = result;
                result = "";
                
                for (int j = 0; j < input.length(); j++)
                {
                    
                    
                    //result +=
                }
            }   
        }
        
        return result;
    }
}