
package ngisrequest;

import java.util.ArrayList;
import java.util.List;


public class NgisRequest {

   
    private List<ContextElement> contextElements = new ArrayList<ContextElement>();
   
    private String updateAction;

    /**
     * 
     * @return
     *     The contextElements
     */
   
    public List<ContextElement> getContextElements() {
        return contextElements;
    }

    /**
     * 
     * @param contextElements
     *     The contextElements
     */
   
    public void setContextElements(List<ContextElement> contextElements) {
        this.contextElements = contextElements;
    }

    /**
     * 
     * @return
     *     The updateAction
     */
   
    public String getUpdateAction() {
        return updateAction;
    }

    /**
     * 
     * @param updateAction
     *     The updateAction
     */
   
    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
    }

}
