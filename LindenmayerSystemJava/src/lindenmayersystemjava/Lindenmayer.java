/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lindenmayersystemjava;

import java.util.ArrayList;
import sun.security.util.Debug;

/**
 *
 * @author Dean Thomas
 */
public final class Lindenmayer {
    private ArrayList<String> cachedData = new ArrayList();
    
    private String inputString;
    
    private TranslationRuleList translationRuleList = new TranslationRuleList();
    
    public Lindenmayer()
    {
        buildDebugData();
    }
    
    public Lindenmayer(TranslationRuleList translationRuleList, 
            String inputString)
    {
        this();
        
        this.translationRuleList = translationRuleList;
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
        ruleSet1.add('A');
        Translation t1 = new Translation('A',ruleSet1,new DrawingRule());
        translationRuleList.add(t1);
        
        //  Ruleset number 2
        ArrayList<Character> ruleSet2 = new ArrayList<>();
        ruleSet2.add('B');
        ruleSet2.add('B');
        Translation t2 = new Translation('B',ruleSet2,new DrawingRule());
        translationRuleList.add(t2);
        
        //  Ruleset number 3
        ArrayList<Character> ruleSet3 = new ArrayList<>();
        ruleSet3.add('A');
        Translation t3 = new Translation('C',ruleSet3,new DrawingRule());
        translationRuleList.add(t3);
        
        Debug.println(METHOD_NAME, 
                "Rules are " + this.translationRuleList.getListOfRules());
        
        Debug.println(METHOD_NAME,
                "Translation rule count is " + translationRuleList.size());
        
        //  Build a 10 level cache to begin with
        this.cacheLevels(10);
        
        //this.dumpCacheToConsole();
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
                    //  Looks a bit messy but works
                    result += translationRuleList.get(
                            this.translationRuleList.indexOf(
                            input.charAt(j))).translate();
                }
            }   
        }
        
        return result;
    }
    
    /**
     * Speed up access to higher levels
     * 
     * To speed up access to high levels cache the results and store in an
     * array.
     * 
     * @param maximumLevel calculate levels 1 to this value, higher values will
     * require additional processing time
     */
    public void cacheLevels(int maximumLevel)
    {
        final String METHOD_NAME = "cacheLevels";
        
        Debug.println(METHOD_NAME,"Building cache");
        
        cachedData.clear();
        
        //  Level zero
        cachedData.add(inputString);
        
        //  Levels 1 - maximumLevel
        for (int i = 1; i < maximumLevel; i++)
        {
            Debug.println(METHOD_NAME, "" + i);
            
            cachedData.add(getLevel(i));
        }
    }
    
    public void dumpCacheToConsole()
    {
        for (int i = 0; i < cachedData.size(); i++)
        {
            Debug.println("dumpCacheToConsole:", "\n" + cachedData.get(i));
        }
    }
}
