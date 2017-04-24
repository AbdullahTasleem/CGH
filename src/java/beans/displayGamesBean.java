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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
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
@ManagedBean(name="allgames")
@SessionScoped
public class displayGamesBean {
    
    private CachedRowSet crs = null;
    private String gamename;
    private gameBean gb;

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }
    
    
    public displayGamesBean()
    {
        
    }
     public ArrayList<gameBean> getGames() {
        ArrayList<gameBean> al = new ArrayList<gameBean>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from GAMES,ITEMS where GAMES.PRODUCTID = ITEMS.PRODUCTID");
            crs.execute();
            while (crs.next()) {
                gameBean temp = new gameBean();
                temp.setGameType(crs.getString("gametype"));
                temp.setImageFile(crs.getString("imagefile"));
                temp.setName(crs.getString("NAME"));
                temp.setPrice(crs.getDouble("price"));
                temp.setProductID(crs.getInt("productid"));
                temp.setCondition(crs.getString("condition"));
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public ArrayList<gameBean> getGamesbyName() {
        ArrayList<gameBean> al = new ArrayList<gameBean>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from GAMES,ITEMS where GAMES.PRODUCTID = ITEMS.PRODUCTID AND name like ?");
            crs.setString(1, gamename);
            crs.execute();
            while (crs.next()) {
                gameBean temp = new gameBean();
                temp.setGameType(crs.getString("gametype"));
                temp.setImageFile(crs.getString("imagefile"));
                temp.setName(crs.getString("NAME"));
                temp.setPrice(crs.getDouble("price"));
                temp.setProductID(crs.getInt("productid"));
                temp.setCondition(crs.getString("condition"));
                gb =temp;
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public ArrayList<reviewBean> getReviewByName() {
        ArrayList<reviewBean> al = new ArrayList<reviewBean>();
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            crs.setCommand("Select * from review re,reviewsitem r where re.REVIEWNUMBER = r.REVIEWNUMBER and r.PRODUCTID = ?");
            crs.setInt(1, gb.getProductID());
            crs.execute();
            while (crs.next()) {
                reviewBean temp = new reviewBean();
                temp.setDescription(crs.getString("description"));
                temp.setRating(crs.getDouble("rating"));
                temp.setRecommendation(crs.getString("recommendation"));
                //temp.setReviewNumber(crs.getInt("reviewnu"));
                temp.setType(crs.getString("type"));
                temp.setUsername(crs.getString("username"));
                al.add(temp);
            }
            return al;
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void reload() throws IOException {
         try {  
             crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            
            crs2 = RowSetProvider.newFactory().createCachedRowSet();
            crs2.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs2.setUsername("abdullah");
            crs2.setPassword("abdullah");
            crs2.setCommand("insert into REVIEW (description, rating, recommendation,type,username) values (?,?,?,?,?)");
            crs2.setString(1, description);
            crs2.setDouble(2, rating);
            crs2.setString(3, recommendation);
            crs2.setString(4, type);
            crs2.setString(5,username);
            crs2.execute();
            crs2.close();
            crs.setCommand("Select * from REVIEW");
            crs.execute();
            crs.last();
            int last = crs.getInt("reviewnumber");
            crs2.setCommand("insert into reviewsitem (reviewnumber, productid) values (?, ?)");
            crs2.setInt(1, last);
            crs2.setInt(2, gb.getProductID());
            crs2.execute();
           
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
}

    private String description;
    private double rating;
    private String recommendation;
    private int reviewNumber;
    private String type;
    private String username;
    private int productid;
    private CachedRowSet crs2 = null;

    public void setCrs(CachedRowSet crs) {
        this.crs = crs;
    }

    public void setGb(gameBean gb) {
        this.gb = gb;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public void setReviewNumber(int reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    
    
    
    public CachedRowSet getCrs() {
        return crs;
    }

    public gameBean getGb() {
        return gb;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public int getReviewNumber() {
        return reviewNumber;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public int getProductid() {
        return productid;
    }
    
    
    
    
}
