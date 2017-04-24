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
public class reviewBean {
    private String description;
    private double rating;
    private String recommendation;
    private int reviewNumber;
    private String type;
    private String username;
    private int productid;

    public reviewBean() {
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
    
    
}
