package entity;
// Generated Aug 21, 2017 12:30:08 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private Integer productId;
     private SubCat subCat;
     private String productName;
     private int productQty;
     private double productPrice;
     private String productImg;
     private String productDesc;
     private Set orderDetailses = new HashSet(0);

    public Product() {
    }

	
    public Product(SubCat subCat, String productName, int productQty, double productPrice, String productImg, String productDesc) {
        this.subCat = subCat;
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.productImg = productImg;
        this.productDesc = productDesc;
    }
    public Product(SubCat subCat, String productName, int productQty, double productPrice, String productImg, String productDesc, Set orderDetailses) {
       this.subCat = subCat;
       this.productName = productName;
       this.productQty = productQty;
       this.productPrice = productPrice;
       this.productImg = productImg;
       this.productDesc = productDesc;
       this.orderDetailses = orderDetailses;
    }
   
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public SubCat getSubCat() {
        return this.subCat;
    }
    
    public void setSubCat(SubCat subCat) {
        this.subCat = subCat;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductQty() {
        return this.productQty;
    }
    
    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
    public double getProductPrice() {
        return this.productPrice;
    }
    
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductImg() {
        return this.productImg;
    }
    
    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
    public String getProductDesc() {
        return this.productDesc;
    }
    
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public Set getOrderDetailses() {
        return this.orderDetailses;
    }
    
    public void setOrderDetailses(Set orderDetailses) {
        this.orderDetailses = orderDetailses;
    }




}


