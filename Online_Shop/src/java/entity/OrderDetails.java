package entity;
// Generated Aug 21, 2017 12:30:08 AM by Hibernate Tools 4.3.1



/**
 * OrderDetails generated by hbm2java
 */
public class OrderDetails  implements java.io.Serializable {


     private int orderDetailsId;
     private Product product;
     private ProductOrder productOrder;
     private int proOrderQty;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsId, Product product, ProductOrder productOrder, int proOrderQty) {
       this.orderDetailsId = orderDetailsId;
       this.product = product;
       this.productOrder = productOrder;
       this.proOrderQty = proOrderQty;
    }
   
    public int getOrderDetailsId() {
        return this.orderDetailsId;
    }
    
    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public ProductOrder getProductOrder() {
        return this.productOrder;
    }
    
    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }
    public int getProOrderQty() {
        return this.proOrderQty;
    }
    
    public void setProOrderQty(int proOrderQty) {
        this.proOrderQty = proOrderQty;
    }




}


