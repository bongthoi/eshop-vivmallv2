package vivmallcn.domain;

import java.util.List;

import org.springframework.data.domain.Persistable;

import vivmallcn.layout.support.web.SeoUtils;

public class News_category implements Persistable<Integer> {

	private static final long serialVersionUID = 7944702452622141286L;
	private transient boolean persisted;
	private transient String friendlyurl;
	
	private	Integer	id;
	private	String	name;
	private	String	image_feature;
	private	String	description;
	private	Integer	ordered;
	private	int	status;
	private	List<News>	NewsList;
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage_feature() {
		return image_feature;
	}
	public void setImage_feature(String image_feature) {
		this.image_feature = image_feature;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrdered() {
		return ordered;
	}
	public void setOrdered(Integer order) {
		this.ordered = order;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getFriendlyurl() {
		return friendlyurl;
	}
	public void setFriendlyurl(String friendlyurl) {
		this.friendlyurl = friendlyurl;
	}
	
	public List<News> getNewsList() {
		return NewsList;
	}
	public void setNewsList(List<News> newsList) {
		NewsList = newsList;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public News_category(Integer id, String name, String image_feature,String description,Integer	ordered,int	status) {
		super();
		this.id = id;
		this.name = name;
		this.image_feature = image_feature;
		this.description = description;
		this.ordered=ordered;
		this.status=status;
		this.persisted=false;
		this.friendlyurl=SeoUtils.getSeoUrl(name);
	}
	
	public News_category() {
		super();
		// TODO Auto-generated constructor stub
	}

}
