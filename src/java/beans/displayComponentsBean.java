/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Abdullah
 */
@ManagedBean(name="comp")
@SessionScoped
public class displayComponentsBean {
    
     private CachedRowSet crs = null;
     private int compid ; 
     private String compName;
     private String typename;
     private String typename2;
     
     private String typenameForGraph;
     private String typename2ForGraph;
     private double valueForGraph;
     private double value2ForGraph;
     private String graphlabel;
     
     private int typeid;
     private int typeid2;

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setGraphlabel(String graphlabel) {
        this.graphlabel = graphlabel;
    }

    public String getGraphlabel() {
       graphlabel = "in "+des.split(" ")[1];
       return graphlabel;
    }

    public void setTypename2ForGraph(String typename2ForGraph) {
        this.typename2ForGraph = typename2ForGraph;
    }

    public void setTypenameForGraph(String typenameForGraph) {
        this.typenameForGraph = typenameForGraph;
    }

    public void setValueForGraph(double valueForGraph) {
        this.valueForGraph = valueForGraph;
    }

    public void setValue2ForGraph(double value2ForGraph) {
        this.value2ForGraph = value2ForGraph;
    }

    public String getTypename2ForGraph() {
        return typename2ForGraph;
    }

    public String getTypenameForGraph() {
        return typenameForGraph;
    }

    public double getValue2ForGraph() {
        return value2ForGraph;
    }

    public double getValueForGraph() {
        return valueForGraph;
    }

    
    
    public int getTypeid() {
        return typeid;
    }

    public void setTypeid2(int typeid2) {
        this.typeid2 = typeid2;
    }

    public int getTypeid2() {
        return typeid2;
    }

    public void reload() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
}
    
    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from TYPE where typeid = ?");
            crs.setInt(1, typeid);
            crs.execute();
            while (crs.next()) {
                typename = crs.getString("name");
            }
            return typename;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return typename;
        }
    }

    public void setTypename2(String typename2) {
        this.typename2 = typename2;
    }
    
    
    public String getTypename2() {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from TYPE where typeid = ?");
            crs.setInt(1, typeid2);
            crs.execute();
            while (crs.next()) {
                typename = crs.getString("name");
            }
            return typename;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return typename;
        }
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    
    
    public String getCompName() {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from components where name = ?");
            crs.setInt(1, compid);
            crs.execute();
            while (crs.next()) {
                compName = crs.getString("name");
            }
            return compName;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return compName;
        }
    }
    
    public displayComponentsBean()
    {
        
    }

    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }
    private ArrayList<typeAttributeBean> forGraph = new ArrayList<>();

    public ArrayList<typeAttributeBean> getForGraph() {
        return forGraph;
    }

    public void setForGraph(ArrayList<typeAttributeBean> forGraph) {
        this.forGraph = forGraph;
    }
    
    private String des;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
    
    public ArrayList<typeAttributeBean> getTypesByComponent() {
        ArrayList<typeAttributeBean> al = new ArrayList<>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("select * from ABDULLAH.TYPEATTRIBUTE where TYPEID = ?");
            crs.setInt(1, typeid);
            crs.execute();
            crs.next();
            
                typeAttributeBean temp = new typeAttributeBean();
                temp.setAttdescription(crs.getString("attdescription"));
                temp.setAttributeid(crs.getInt("attributeid"));
                temp.setName(crs.getString("name"));
                temp.setValue(crs.getDouble("value"));
                al.add(temp);
                typenameForGraph = temp.getName();
                des = temp.getAttdescription();
                valueForGraph= temp.getValue();

                
            while (crs.next()) {
                temp = new typeAttributeBean();
                temp.setAttdescription(crs.getString("attdescription"));
                temp.setAttributeid(crs.getInt("attributeid"));
                temp.setName(crs.getString("name"));
                temp.setValue(crs.getDouble("value"));
                al.add(temp);
            }
            forGraph = al;
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(typeAttributeBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public ArrayList<typeAttributeBean> getTypesByComponent2() {
        ArrayList<typeAttributeBean> al = new ArrayList<>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("select * from ABDULLAH.TYPEATTRIBUTE where TYPEID = ?");
            crs.setInt(1, typeid2);
            crs.execute();
            crs.next();
            typeAttributeBean temp = new typeAttributeBean();
                temp.setAttdescription(crs.getString("attdescription"));
                temp.setAttributeid(crs.getInt("attributeid"));
                temp.setName(crs.getString("name"));
                temp.setValue(crs.getDouble("value"));
                al.add(temp);
            
             typename2ForGraph = temp.getName();

                value2ForGraph= temp.getValue();
            while (crs.next()) {
                temp = new typeAttributeBean();
                temp.setAttdescription(crs.getString("attdescription"));
                temp.setAttributeid(crs.getInt("attributeid"));
                temp.setName(crs.getString("name"));
                temp.setValue(crs.getDouble("value"));
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(typeAttributeBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public ArrayList<SelectItem> getComponents() {
        try {
            ArrayList<SelectItem> al = new ArrayList<>();
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from components");
            crs.execute();
            while (crs.next()) {
                SelectItem temp = new SelectItem();
                temp.setLabel(crs.getString("name"));
                temp.setValue(crs.getInt("compid"));
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<SelectItem> getTypes() {
        ArrayList<SelectItem> al = new ArrayList<>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from type where type.compid = ?");
            crs.setInt(1, compid);
            crs.execute();
            while (crs.next()) {
                SelectItem temp = new SelectItem();
//                temp.setAttdescription(crs.getString("typeattibute.attdescription"));
//                temp.setAttributeid(crs.getInt("typeattibute.attributeid"));
//                temp.setName(crs.getString("typeattibute.name"));
//                temp.setTypeattdescription(crs.getString("type.attdescription"));
//                temp.setTypeid(crs.getInt("typeid"));
//                temp.setTypename(crs.getString("type.name"));
//                temp.setValue(crs.getDouble("value"));
                
                temp.setLabel(crs.getString("name"));
                temp.setValue(crs.getInt("typeid"));
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(typeAttributeBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
}
