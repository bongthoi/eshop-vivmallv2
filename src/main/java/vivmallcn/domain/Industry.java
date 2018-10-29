package vivmallcn.domain;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;

import vivmallcn.layout.support.web.SeoUtils;

public class Industry implements Persistable<Integer> {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6726288239471743833L;
	private transient boolean persisted;
	private transient String friendlyurl;
	
	private Integer id;
	
	@NotEmpty
	private String IndustryName;
	private String IndustryDes;
	
	
	private String IndustryImg;
	private String Icon;
	private String ColorBackground;
	
	private int enabled;
	@NotNull
	
	private Integer IndustryOrder;
	private List<Category> Categorylist;
	
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
	public String getIndustryName() {
		return IndustryName;
	}
	public void setIndustryName(String industryName) {
		IndustryName = industryName;
	}
	public String getIndustryDes() {
		return IndustryDes;
	}
	public void setIndustryDes(String industryDes) {
		IndustryDes = industryDes;
	}
	public String getIndustryImg() {
		return IndustryImg;
	}
	public void setIndustryImg(String industryImg) {
		IndustryImg = industryImg;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public Integer getIndustryOrder() {
		return IndustryOrder;
	}
	public void setIndustryOrder(Integer industryOrder) {
		IndustryOrder = industryOrder;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Category> getCategorylist() {
		return Categorylist;
	}
	public void setCategorylist(List<Category> categorylist) {
		Categorylist = categorylist;
	}
	public String getFriendlyurl() {
		return friendlyurl;
	}
	public void setFriendlyurl(String friendlyurl) {
		this.friendlyurl = friendlyurl;
	}
	
	public String getIcon() {
		return Icon;
	}
	public void setIcon(String icon) {
		Icon = icon;
	}
	public String getColorBackground() {
		return ColorBackground;
	}
	public void setColorBackground(String colorBackground) {
		ColorBackground = colorBackground;
	}
	public Industry(Integer id, String industryName,
			String industryDes, String industryImg, int enabled,Integer industryOrder,String icon,String colorBackground) {
		super();
		
		this.id = id;
		IndustryName = industryName;
		IndustryDes = industryDes;
		IndustryImg = industryImg;
		this.enabled = enabled;
		IndustryOrder=industryOrder;
		this.persisted = false;
		this.friendlyurl=SeoUtils.getSeoUrl(industryName);
		this.Icon=icon;
		this.ColorBackground=colorBackground;
	}
	
	public Industry(){}
}
