package keyosk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;


@Entity
@Table(name="Store_table")
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long orderId;
    private Long menuId;
    private Integer menuCount;
    private Integer totalPrice;
    private Integer rejectCode;
    private String rejectDetail;
    private Long cookStatus;
    private String orderStatus;

    @PostPersist
    public void onPostPersist(){

        if(this.orderStatus=="ORDER ACCEPT"){

            StoreOrderAccepted storeOrderAccepted = new StoreOrderAccepted();
            BeanUtils.copyProperties(this, storeOrderAccepted);

            storeOrderAccepted.setOrderId(this.orderId);
            storeOrderAccepted.setOrderStatus(this.orderStatus);

            storeOrderAccepted.publishAfterCommit();

        }else if(this.orderStatus=="ORDER REJECT"){

            StoreOrderRejected storeOrderRejected = new StoreOrderRejected();
            BeanUtils.copyProperties(this, storeOrderRejected);

            storeOrderRejected.setOrderId(this.orderId);
            storeOrderRejected.setOrderStatus(this.orderStatus);
     
            storeOrderRejected.publishAfterCommit();
    
        }else if(this.orderStatus=="ORDER COOK"){

            StoreCooked storeCooked = new StoreCooked();
            BeanUtils.copyProperties(this, storeCooked);

            storeCooked.setOrderId(this.orderId);
            storeCooked.setOrderStatus(this.orderStatus);

            storeCooked.publishAfterCommit();            
    
        }

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Integer getMenuCount() {
        return menuCount;
    }

    public void setMenuCount(Integer menuCount) {
        this.menuCount = menuCount;
    }
    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Integer getRejectCode() {
        return rejectCode;
    }

    public void setRejectCode(Integer rejectCode) {
        this.rejectCode = rejectCode;
    }
    public String getRejectDetail() {
        return rejectDetail;
    }

    public void setRejectDetail(String rejectDetail) {
        this.rejectDetail = rejectDetail;
    }
    public Long getCookStatus() {
        return cookStatus;
    }

    public void setCookStatus(Long cookStatus) {
        this.cookStatus = cookStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
	public String toString() {
		return "Store [orderId=" + orderId + ", menuId=" + menuId + ", menuCount=" + menuCount + ", totalPrice="
				+ totalPrice + ", rejectCode=" + rejectCode + ", rejectDetail=" + rejectDetail + ", cookStatus="
				+ cookStatus + ", orderStatus=" + orderStatus + "]";
	}



}
