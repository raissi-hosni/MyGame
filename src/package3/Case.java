
package package3;

import java.util.HashMap;
import java.util.Map;

public class Case {
    
    private int side;
    private String type;
    private String color;
    private Map<String, Integer> position;
    
    public Case(int x, int y, String color, String type, int side){
        this.side = side;
        this.type  = type;
        this.color = color;
        this.position = new HashMap<>();
        position.put("x", x);
        position.put("y", y);
    }
    public void setPosition(int x, int y){
        this.position.put("x", x);
        this.position.put("y", y);
    }
    public Map<String, Integer> getPosition(){
        return this.position;
    }
    
}
