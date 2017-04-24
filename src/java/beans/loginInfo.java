/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
/**
 *
 * @author Abdullah
 */
@ManagedBean
@SessionScoped
public class loginInfo {

    private CachedRowSet crs = null;
    private String username;
    private String password;
    private boolean valid;

     public loginInfo() {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");
           
        } catch (SQLException ex) {
            Logger.getLogger(loginInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        
        this.password = password;
    }

    public boolean getIsvalid() {
        
        valid = false;
        try {
            crs.setCommand("select * from USERS where USERNAME = ?");
            Blob encr = null;
            crs.setString(1, username);
            crs.execute();
            while (crs.next()) {
                if (crs.getString("username").equals(username) && !valid)
                {
                    encr = crs.getBlob("password");

//                    MessageDigest dig = MessageDigest.getInstance("MD5");
//                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                    PrintWriter pw = new PrintWriter(bos);
//                    pw.print(password);
//                    byte[] r = dig.digest(bos.toByteArray());
                    //byte[] saved = encr.getBytes(0, (int) encr.length());
                    Blob b = new javax.sql.rowset.serial.SerialBlob(password.getBytes());
                    
                    //if(b.equals(encr))
                    if(b.equals(encr)) {
                        valid = true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}


