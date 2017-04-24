/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Abdullah
 */
public class typeBean {
    private int typeid;
    private int compid;
    private String typename;
    private String attdescription;
    
    
    public typeBean()
    {
        
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setAttdescription(String attdescription) {
        this.attdescription = attdescription;
    }

    public int getTypeid() {
        return typeid;
    }

    public int getCompid() {
        return compid;
    }

    public String getTypename() {
        return typename;
    }

    public String getAttdescription() {
        return attdescription;
    }
    
    
    
}
