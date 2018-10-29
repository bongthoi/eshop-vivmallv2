package vivmallcn.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;

import vivmallcn.layout.support.web.SeoUtils;

public class Category implements Persistable<Integer>{


	/**
	 * 
	 */
	private static final long serialVersionUID = -332660684008750284L;

	private transient boolean persisted;
	private transient String friendlyurl;
	
	private Integer id;
	
	@NotEmpty
	private String CategoryName;
	
	private String CategoryDes;
	
	private String CategoryImg;
	
	
	@NotEmpty
	private String IndustryId;
	
	private Date CreateDate;
	private Date UpdateDate;
	
	private String CreateUser;
	private String UpdateUser;
	private int enabled;
	@NotNull
	private Integer CategoryOrder;
	
	private List<Product> productlist;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
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
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryDes() {
		return CategoryDes;
	}
	public void setCategoryDes(String categoryDes) {
		CategoryDes = categoryDes;
	}
	public String getCategoryImg() {
		return CategoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		CategoryImg = categoryImg;
	}
	public String getIndustryId() {
		return IndustryId;
	}
	public void setIndustryId(String industryId) {
		IndustryId = industryId;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	public String getCreateUser() {
		return CreateUser;
	}
	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}
	public String getUpdateUser() {
		return UpdateUser;
	}
	public void setUpdateUser(String updateUser) {
		UpdateUser = updateUser;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Integer getCategoryOrder() {
		return CategoryOrder;
	}
	public void setCategoryOrder(Integer categoryOrder) {
		CategoryOrder = categoryOrder;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public String getFriendlyurl() {
		return friendlyurl;
	}
	public void setFriendlyurl(String friendlyurl) {
		this.friendlyurl = friendlyurl;
	}
	
	public Category() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String categoryName,
			String categoryDes,String categoryImg, String industryId, Date createDate,
			Date updateDate, String createUser, String updateUser, int enabled,Integer categoryOrder) {
		this.id = id;
		CategoryName = categoryName;
		CategoryDes = categoryDes;
		CategoryImg = categoryImg;
		IndustryId = industryId;
		CreateDate = createDate;
		UpdateDate = updateDate;
		CreateUser = createUser;
		UpdateUser = updateUser;
		this.enabled = enabled;
		CategoryOrder=categoryOrder;
		this.persisted = false;
		this.friendlyurl=SeoUtils.getSeoUrl(categoryName);
	}
	
	
}
	
