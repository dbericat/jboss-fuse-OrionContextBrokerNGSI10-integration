
package ngisrequest;

import java.util.ArrayList;
import java.util.List;


public class ContextElement {


    private String type;
    private String isPattern;
   
    private String id;
   
    private List<Attribute> attributes = new ArrayList<Attribute>();

    /**
     * 
     * @return
     *     The type
     */
  
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
   
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The isPattern
     */
  
    public String getIsPattern() {
        return isPattern;
    }

    /**
     * 
     * @param isPattern
     *     The isPattern
     */
   
    public void setIsPattern(String isPattern) {
        this.isPattern = isPattern;
    }

    /**
     * 
     * @return
     *     The id
     */
    
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
   
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The attributes
     */
  
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
   
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

}
