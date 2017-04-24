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
public class gameBean {
    private String name;
    private String imageFile;
    private double price;
    private String gameType;
    private int productID;
    private String Condition;
    
    public String getCondition() {
        return Condition;
    }

    public void setCondition(String Condition) {
        this.Condition = Condition;
    }
    
    
    
   public gameBean(){
            
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

    
    
    
}
