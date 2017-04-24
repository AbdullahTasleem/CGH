/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Blob;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Abdullah
 */
@ManagedBean
@SessionScoped
public class userAccount {
    private String username;
    private String password;
    private int NumberOfReviews;
    private String BankAccountNumber;
    private String CreditCardNumber;
    private String DebitCardNumber;
    private int ItemsSold;
    private int ItemsBought;
    private float MemberRating;
    private String EmailID;
    private String PhoneNumber;
    private String Gender;
    private String Name;

    public userAccount() {
        NumberOfReviews = 0;
        BankAccountNumber = null;
        CreditCardNumber = null;
        DebitCardNumber = null;
        ItemsSold = 0;
        ItemsBought = 0;
        MemberRating = 0;
    }

    public String getBankAccountNumber() {
        return BankAccountNumber;
    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    public String getDebitCardNumber() {
        return DebitCardNumber;
    }

    public String getEmailID() {
        return EmailID;
    }

    public String getGender() {
        return Gender;
    }

    public int getItemsBought() {
        return ItemsBought;
    }

    public int getItemsSold() {
        return ItemsSold;
    }

    public float getMemberRating() {
        return MemberRating;
    }

    public String getName() {
        return Name;
    }

    public int getNumberOfReviews() {
        return NumberOfReviews;
    }

    public String getPassword() {//shouldnt be accessible?
        return password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setBankAccountNumber(String BankAccountNumber) {
        this.BankAccountNumber = BankAccountNumber;
    }

    public void setCreditCardNumber(String CreditCardNumber) {
        this.CreditCardNumber = CreditCardNumber;
    }

    public void setDebitCardNumber(String DebitCardNumber) {
        this.DebitCardNumber = DebitCardNumber;
    }

    public void setEmailID(String EmailID) {
        this.EmailID = EmailID;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setItemsBought(int ItemsBought) {
        this.ItemsBought = ItemsBought;
    }

    public void setItemsSold(int ItemsSold) {
        this.ItemsSold = ItemsSold;
    }

    public void setMemberRating(float MemberRating) {
        this.MemberRating = MemberRating;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNumberOfReviews(int NumberOfReviews) {
        this.NumberOfReviews = NumberOfReviews;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
}
