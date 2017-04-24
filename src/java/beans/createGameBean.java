/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.rowset.CachedRowSetImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author Abdullah
 */

@ManagedBean(name="creategame")
@SessionScoped
public class createGameBean {
    private String name;
    private String imageFile;
    private double price;
    private String gameType;
    private int productID;
    private String Condition;
    private String username;
    private CachedRowSet crs = null;
    private CachedRowSet crs2 = null;
    private CachedRowSet crs3 = null;
    
    public createGameBean()
    {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
            
            crs2 = RowSetProvider.newFactory().createCachedRowSet();
            crs2.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs2.setUsername("abdullah");
            crs2.setPassword("abdullah");
            
            crs3 = RowSetProvider.newFactory().createCachedRowSet();
            crs3.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs3.setUsername("abdullah");
            crs3.setPassword("abdullah");
            
        } catch (SQLException ex) {
            Logger.getLogger(createGameBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public void saveGame() throws IOException {
        try {  
            crs2.setCommand("insert into ITEMS (username, condition) values (?, ?)");
            crs2.setString(1, username);
            crs2.setString(2, Condition);
            crs2.execute();
            crs.setCommand("Select * from ITEMS where username = ?");
            crs.setString(1, username);
            crs.execute();
            crs.last();
            int last = crs.getInt("productid");
            crs3.setCommand("insert into GAMES (name, imagefile,price,gametype,productid) values (?, ?,?,?,?)");
            crs3.setString(1, name);
            crs3.setString(2, imageFile);
            crs3.setDouble(3, price);
            crs3.setString(4, gameType);
            crs3.setInt(5, last);
            crs3.execute();
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.sendRedirect("faces/gamesHomePage.xhtml");
        } catch (SQLException ex) {
            Logger.getLogger(displayGamesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    
    
    
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setCondition(String Condition) {
        this.Condition = Condition;
    }

    
    public String getName() {
        return name;
    }

    public String getImageFile() {
        return imageFile;
    }

    public double getPrice() {
        return price;
    }

    public String getGameType() {
        return gameType;
    }

    public int getProductID() {
        return productID;
    }

    public String getCondition() {
        return Condition;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
