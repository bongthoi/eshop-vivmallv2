package vivmallcn.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.domain.Persistable;

public class Orders implements Persistable<String>{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1429863679600832326L;
	private transient boolean persisted;
	
	private String id;
	
	@NotEmpty
	@Email
	private String Email;
	
	@NotEmpty
	private String Name;
	
	@NotEmpty
	private String Address;
	
	@NotEmpty
	private String Phone;
	
	private	DeliveryMethod	DeliveryMethod;
	private	PaymentMethod	PaymentMethod;
	/*@Min(1)
	private int PaymentMethod;
	
	@Min(1)
	private int DeliveryMethod;*/
	
	private int TotalQuantity;
	private BigDecimal TotalAmount;
	private Date CreateDate;
	private String Note;
	private int IsCheck;
	private List<OrdersDetail> ordersDetails;
	

	/*private String PaymentMethodName;//optimal
	private String DeliveryMethodName;//optimal
*/	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return !persisted;
	}
	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}
	
	public boolean isPersisted() {
		return persisted;
	}
	@Override
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public int getTotalQuantity() {
		return TotalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		TotalQuantity = totalQuantity;
	}
	public BigDecimal getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		TotalAmount = totalAmount;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	public int getIsCheck() {
		return IsCheck;
	}
	public void setIsCheck(int isCheck) {
		IsCheck = isCheck;
	}
	
	public List<OrdersDetail> getOrdersDetails() {
		return ordersDetails;
	}
	public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}
	public DeliveryMethod getDeliveryMethod() {
		return DeliveryMethod;
	}
	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		DeliveryMethod = deliveryMethod;
	}
	public PaymentMethod getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	/*public String getPaymentMethodName() {
		return PaymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		PaymentMethodName = paymentMethodName;
	}
	public String getDeliveryMethodName() {
		return DeliveryMethodName;
	}
	public void setDeliveryMethodName(String deliveryMethodName) {
		DeliveryMethodName = deliveryMethodName;
	}*/
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(String id, String email, String name, String address,
			String phone, PaymentMethod paymentMethod, DeliveryMethod deliveryMethod,
			int totalQuantity, BigDecimal totalAmount, Date createDate,
			String note, int isCheck) {
		super();
		this.id = id;
		Email = email;
		Name = name;
		Address = address;
		Phone = phone;
		PaymentMethod=paymentMethod;
		DeliveryMethod=deliveryMethod;
		TotalQuantity = totalQuantity;
		TotalAmount = totalAmount;
		CreateDate = createDate;
		Note = note;
		IsCheck = isCheck;
		this.persisted = false;
	}
	
	
}
