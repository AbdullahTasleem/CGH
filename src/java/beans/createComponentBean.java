/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Abdullah
 */
@ManagedBean(name="createcomp")
@SessionScoped
public class createComponentBean {
    private int compid;
    private String newname;
    private String temp;
    private String newTypename;
    private String newTypeDescription;
    private ArrayList<String> atts= new ArrayList<>(); 
    private ArrayList<String> attsLabels= new ArrayList<>();
    private CachedRowSet crs = null;
      private CachedRowSet crs2 = null;
      private CachedRowSet crs3 = null;
      private boolean valid=false;
      private boolean validNew=false;
      private int num;
      private String tempLabel;
      private String tempValue;
      private String tempDes;
      private ArrayList<String> attsNEW= new ArrayList<>(); 
    private ArrayList<String> attsLabelsNEW= new ArrayList<>();
    private ArrayList<String> attsDesNEW= new ArrayList<>();

    public String getTempLabel() {
        return tempLabel;
    }

    public void setTempDes(String tempDes) {
        attsDesNEW.add(tempDes);
    }

    public void setAttsDesNEW(ArrayList<String> attsDesNEW) {
        this.attsDesNEW = attsDesNEW;
    }

    public String getTempDes() {
        return tempDes;
    }

    public ArrayList<String> getAttsDesNEW() {
        return attsDesNEW;
    }

    public void setValidNew(boolean validNew) {
        this.validNew = validNew;
    }

    public boolean isValidNew() {
        return validNew;
    }

    public ArrayList<String> getAttsLabels() {
        return attsLabels;
    }

    public ArrayList<String> getAttsLabelsNEW() {
        return attsLabelsNEW;
    }

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        attsNEW.add(tempValue);
    }

    
    public ArrayList<String> getAttsNEW() {
        return attsNEW;
    }

    public void setAttsLabels(ArrayList<String> attsLabels) {
        this.attsLabels = attsLabels;
    }

    public void setAttsLabelsNEW(ArrayList<String> attsLabelsNEW) {
        this.attsLabelsNEW = attsLabelsNEW;
    }

    public void setAttsNEW(ArrayList<String> attsNEW) {
        this.attsNEW = attsNEW;
    }

    
    
    public void setTempLabel(String tempLabel) {
        attsLabelsNEW.add(tempLabel);
    }
      
      

    public ArrayList<String> getAtts() {
        return atts;
    }

    public boolean isValid() {
        return valid;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setNewTypeDescription(String newTypeDescription) {
        this.newTypeDescription = newTypeDescription;
    }

    public String getNewTypeDescription() {
        return newTypeDescription;
    }

    public void setNewTypename(String newTypename) {
        this.newTypename = newTypename;
    }

    public String getNewTypename() {
        return newTypename;
    }

    public void setTemp(String temp) {
        atts.add(temp);
    }

    public String getTemp() {
        return temp;
    }

    public void setAtts(ArrayList<String> atts) {
        this.atts = atts;
    }
    public void setAttibutes(String atts) {
       this.atts.add(atts);
    }
            
   
    public createComponentBean()
    {}

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }
    
    
    
   public ArrayList<String> getOldTypeAttributes()
   {
        ArrayList<String> al = new ArrayList<>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
           
            crs2 = RowSetProvider.newFactory().createCachedRowSet();
            crs2.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs2.setUsername("abdullah");
            crs2.setPassword("abdullah");
            crs2.setCommand("select typeid from type where compid = ?");
            crs2.setInt(1, compid);
            crs2.execute();
            int typeid = 0;
            if(crs2.next())
            {
               typeid= crs2.getInt("typeid");
            }
            
            
            crs.setCommand("select typeattribute.\"NAME\" from type,typeattribute where type.typeid = ? AND type.typeid =typeattribute.typeid  AND compid = ?");
            crs.setInt(1, typeid);
            crs.setInt(2, compid);
            crs.execute();
            
            while(crs.next()){
                String temp;
                temp = crs.getString("name");
                al.add(temp);
            }
            attsLabels =al;
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(createComponentBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
    
    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
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
    
    
     public void saveComponent() throws IOException {
        try {  
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            
            crs.setCommand("insert into TYPE (compid,name,attdescription) values (?,?,?)");
            crs.setInt(1, compid);
            crs.setString(2, newTypename);
            crs.setString(3, newTypeDescription);
            crs.execute();
            
            
            crs2 = RowSetProvider.newFactory().createCachedRowSet();
            crs2.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs2.setUsername("abdullah");
            crs2.setPassword("abdullah");
            crs2.setCommand("select typeid from type where type.name = ? AND compid = ?");
            crs2.setString(1, newTypename);
            crs2.setInt(2, compid);
            crs2.execute();
            int typeid = 0;
            if(crs2.next())
            {
               typeid= crs2.getInt("typeid");
            }
            
             crs3 = RowSetProvider.newFactory().createCachedRowSet();
            crs3.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs3.setUsername("abdullah");
            crs3.setPassword("abdullah");
             
             
             for(int i =0; i <atts.size();i++)
            {
                crs3.setCommand("insert into typeattribute (typeid,attributeid,name,attdescription,value) values (?,?,?,?,?)");
                crs3.setInt(1, typeid);
                crs3.setInt(2, i+1);
                crs3.setString(3, attsLabels.get(i));
                crs3.setString(4, atts.get(i));
                crs3.setDouble(5, Double.parseDouble(atts.get(i)));
                crs3.execute();
                crs3.close();
            }
            valid = true;
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("faces/verifyOldComponent.xhtml");
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        valid = false;
        FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("faces/errorComponent.xhtml");
    }
     

 public boolean newComponent() {
        try {  
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");

            crs.setCommand("select * from components");
            crs.execute();
            crs.last();
            compid = crs.getInt("compid") + 1;
            crs.close();
            
            crs.setCommand("insert into COMPONENTS (compid,name) values (?,?)");
            crs.setInt(1, compid);
           crs.setString(2,newname );
            crs.execute();
            
            crs.close();
            crs.setCommand("insert into TYPE (compid,name,attdescription) values (?,?,?)");
            crs.setInt(1, compid);
            crs.setString(2, newTypename);
            crs.setString(3, newTypeDescription);
            crs.execute();
            
            
             crs2 = RowSetProvider.newFactory().createCachedRowSet();
            crs2.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs2.setUsername("abdullah");
            crs2.setPassword("abdullah");
            crs2.setCommand("select typeid from type where type.name = ? AND compid = ?");
            crs2.setString(1, newTypename);
            crs2.setInt(2, compid);
            crs2.execute();
            int typeid = 0;
            if(crs2.next())
            {
               typeid= crs2.getInt("typeid");
            }
            
             crs3 = RowSetProvider.newFactory().createCachedRowSet();
            crs3.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs3.setUsername("abdullah");
            crs3.setPassword("abdullah");
             
             
             for(int i =0; i <attsNEW.size();i++)
            {
                crs3.setCommand("insert into typeattribute (typeid,attributeid,name,attdescription,value) values (?,?,?,?,?)");
                crs3.setInt(1, typeid);
                crs3.setInt(2, i+1);
                crs3.setString(3, attsLabelsNEW.get(i));
                crs3.setString(4, attsNEW.get(i)+" "+attsDesNEW.get(i));
                crs3.setDouble(5, Double.parseDouble(attsNEW.get(i)));
                crs3.execute();
                crs3.close();
            }

            validNew = true;
            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("faces/options.xhtml");
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(createComponentBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        validNew = false;
        return false;
        
    }
     
     
}


    

