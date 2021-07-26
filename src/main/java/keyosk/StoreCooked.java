package keyosk;

public class StoreCooked extends AbstractEvent {

    private Long orderId;
    private String orderStatus;


	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

    public StoreCooked(){
        super();
    }

}
