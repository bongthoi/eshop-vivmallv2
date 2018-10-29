package vivmallcn.domain;

import java.util.Date;

import org.springframework.data.domain.Persistable;

public class Products_Seller implements Persistable<Integer>{
	
	private static final long serialVersionUID = 4886592322593759450L;
	private int id;
	private String name;		
	private String description;		
	private String image;		
	private String unit;			
	private Float cost_price;	
	private Float sell_price;
	private int quantity;
	private String sellerID;
	private int categoryID;		
	private String createDate;	
	private int priority;
	private int enabled;
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getCost_price() {
		return cost_price;
	}
	public void setCost_price(Float cost_price) {
		this.cost_price = cost_price;
	}
	public Float getSell_price() {
		return sell_price;
	}
	public void setSell_price(Float sell_price) {
		this.sell_price = sell_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSellerID() {
		return sellerID;
	}
	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}


	
}
