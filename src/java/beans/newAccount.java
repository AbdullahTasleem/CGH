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
public class newAccount {
    private userAccount ua;
    private boolean valid;
    private CachedRowSet crs = null;
    private String errorCode;
            
    private String username;
    private String password;
    private String bankaccountnumber;
    private String creditcardnumber;
    private String debitcardnumber;
    private String emailid;
    private String phonenumber;
    private String gender;
    private String name;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public void setDebitcardnumber(String debitcardnumber) {
        this.debitcardnumber = debitcardnumber;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean getValid() {
        return valid;
    }

    public CachedRowSet getCrs() {
        return crs;
    }

    public String getPassword() {
        return password;
    }

    public String getBankaccountnumber() {
        return bankaccountnumber;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public String getDebitcardnumber() {
        return debitcardnumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    
    
    public newAccount() {
        try {
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.setUrl("jdbc:derby://localhost:1527/55605_Project");
            crs.setUsername("abdullah");
            crs.setPassword("abdullah");          
        } catch (SQLException ex) {
            Logger.getLogger(newAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    
    public userAccount getUa() {
        return ua;
    }

    public void setUa(userAccount ua) {
        this.ua = ua;
    }
    
//    public boolean getMakeaccount()
//    {
//        
//        
//        
//        valid = false;
//        try {
//            crs.setCommand("select * from USERS where USERNAME = ?");
//            crs.setString(1, ua.getUsername());
//            crs.execute();
//            
//            if(crs.next())
//            {
//                errorCode = "Username Already Exists!";
//                return valid;
//            }
//            
//            Blob encr = null;
//            crs.setCommand("insert into Users (Username,Password,NumberOfReviews,BankAccountNumber,CreditCardNumber,DebitCardNumber,"
//                    + "ItemsSold,ItemsBought,MemberRating,EmailID,PhoneNumber,Gender,Name)\n" +
//            "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            crs.setString(1, ua.getUsername());
//            
//            MessageDigest dig = MessageDigest.getInstance("MD5");
//                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                    PrintWriter pw = new PrintWriter(bos);
//                    pw.print( ua.getPassword());
//                    byte[] r = dig.digest(bos.toByteArray());
//                    encr.setBytes(1, r);
//            crs.setBlob(2, encr);
//            //crs.setString(2, ua.getPassword());
//            
//            
//            
//            crs.setInt(3, ua.getNumberOfReviews());
//            crs.setString(4, ua.getBankAccountNumber());
//            crs.setString(5, ua.getCreditCardNumber());
//            crs.setString(6, ua.getDebitCardNumber());
//            crs.setInt(7, ua.getItemsSold());
//            crs.setInt(8, ua.getItemsBought());
//            crs.setFloat(6, ua.getMemberRating());
//            crs.setString(7, ua.getEmailID());
//            crs.setString(8, ua.getPhoneNumber());
//            crs.setString(7, ua.getGender());
//            crs.setString(8, ua.getName());
//            
//            crs.execute();
//        } catch (Exception e) {
//        }
//        return valid;
//    }
//}

    
     public boolean getMakeaccount()
    {
        valid = false;
        try {
            crs.setCommand("select * from USERS where USERNAME = ?");
            crs.setString(1, username);
            crs.execute();
            
            if(crs.next())
            {
                errorCode = "Username Already Exists!";
                return valid;
            }
            
            Blob encr = null;
            crs.setCommand("insert into Users (Username,Password,NumberOfReviews,BankAccountNumber,CreditCardNumber,DebitCardNumber,"
                    + "ItemsSold,ItemsBought,MemberRating,EmailID,PhoneNumber,Gender,Name)\n" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            crs.setString(1, username);
            
//            MessageDigest dig = MessageDigest.getInstance("MD5");
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            PrintWriter pw = new PrintWriter(bos);
//            pw.print( password);
//            byte[] r = dig.digest(bos.toByteArray());
//            encr.setBytes(1, r);
            
            Blob b = new javax.sql.rowset.serial.SerialBlob(password.getBytes());
            crs.setBlob(2, b);
            
            //crs.setString(2, ua.getPassword());
            
            
            crs.setInt(3, 0);
            crs.setString(4, bankaccountnumber);
            crs.setString(5, creditcardnumber);
            crs.setString(6, debitcardnumber);
            crs.setInt(7, 0);
            crs.setInt(8, 0);
            crs.setFloat(9, 0);
            crs.setString(10, emailid);
            crs.setString(11, phonenumber);
            crs.setString(12, gender);
            crs.setString(13, name);
            
            crs.execute();
            valid = true;
        } catch (Exception e) {
        }
        return valid;
    }
}