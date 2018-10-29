package vivmallcn.domain;

import java.math.BigDecimal;

import org.springframework.data.domain.Persistable;

public class OrdersDetail implements Persistable<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 431391682781497360L;
	private Integer id;
	private String ProductId;
	private String ProductName;
	private int Unit;
	private int Quantity;
	private BigDecimal Price;//price after discount
	private BigDecimal Price1;//before discount price
	private BigDecimal Amount;
	private String OrdersId;
	private int isDelete;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return (id == null || id == 0);
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getUnit() {
		return Unit;
	}
	public void setUnit(int unit) {
		Unit = unit;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public BigDecimal getPrice() {
		return Price;
	}
	public void setPrice(BigDecimal price) {
		Price = price;
	}
	public BigDecimal getAmount() {
		return Amount;
	}
	public void setAmount(BigDecimal amount) {
		Amount = amount;
	}
	public String getOrdersId() {
		return OrdersId;
	}
	public void setOrdersId(String ordersId) {
		OrdersId = ordersId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public BigDecimal getPrice1() {
		return Price1;
	}
	public void setPrice1(BigDecimal price1) {
		Price1 = price1;
	}
	public OrdersDetail(Integer id, String productId, String productName,
			int unit, int quantity, BigDecimal price,BigDecimal price1, BigDecimal amount,
			String ordersId) {
		super();
		this.id = id;
		ProductId = productId;
		ProductName = productName;
		Unit = unit;
		Quantity = quantity;
		Price = price;
		this.Price1=price1;
		Amount = amount;
		OrdersId = ordersId;
		this.isDelete=0;
		
	}
	public OrdersDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
