package entity;
// Generated Aug 21, 2017 12:30:08 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProductOrder generated by hbm2java
 */
public class ProductOrder  implements java.io.Serializable {


     private int orderId;
     private DeliveryCost deliveryCost;
     private User user;
     private int productId;
     private Date orderDate;
     private int orderQty;
     private double totalPrice;
     private String orderStatus;
     private Set orderDetailses = new HashSet(0);

    public ProductOrder() {
    }

	
    public ProductOrder(int orderId, DeliveryCost deliveryCost, User user, int productId, Date orderDate, int orderQty, double totalPrice, String orderStatus) {
        this.orderId = orderId;
        this.deliveryCost = deliveryCost;
        this.user = user;
        this.productId = productId;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
    public ProductOrder(int orderId, DeliveryCost deliveryCost, User user, int productId, Date orderDate, int orderQty, double totalPrice, String orderStatus, Set orderDetailses) {
       this.orderId = orderId;
       this.deliveryCost = deliveryCost;
       this.user = user;
       this.productId = productId;
       this.orderDate = orderDate;
       this.orderQty = orderQty;
       this.totalPrice = totalPrice;
       this.orderStatus = orderStatus;
       this.orderDetailses = orderDetailses;
    }
   
    public int getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public DeliveryCost getDeliveryCost() {
        return this.deliveryCost;
    }
    
    public void setDeliveryCost(DeliveryCost deliveryCost) {
        this.deliveryCost = deliveryCost;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public Date getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getOrderQty() {
        return this.orderQty;
    }
    
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Set getOrderDetailses() {
        return this.orderDetailses;
    }
    
    public void setOrderDetailses(Set orderDetailses) {
        this.orderDetailses = orderDetailses;
    }




}


