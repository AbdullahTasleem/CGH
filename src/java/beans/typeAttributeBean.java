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
public class typeAttributeBean {
    private int typeid;
    private int attributeid;
    private String name;
    private String attdescription;
    private double value;
    private String typename;
    private String typeattdescription;
    
      public typeAttributeBean ()
      {
          
      }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setTypeattdescription(String typeattdescription) {
        this.typeattdescription = typeattdescription;
    }

    public String getTypeattdescription() {
        return typeattdescription;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setAttributeid(int attributeid) {
        this.attributeid = attributeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttdescription(String attdescription) {
        this.attdescription = attdescription;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getTypeid() {
        return typeid;
    }

    public int getAttributeid() {
        return attributeid;
    }

    public String getName() {
        return name;
    }

    public String getAttdescription() {
        return attdescription;
    }

    public double getValue() {
        return value;
    }
      
      
}
