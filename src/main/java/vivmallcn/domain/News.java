package vivmallcn.domain;

import java.util.Date;

import org.springframework.data.domain.Persistable;

import vivmallcn.layout.support.web.SeoUtils;

public class News implements Persistable<Integer> {

	private static final long serialVersionUID = 7944702452622141286L;
	private transient boolean persisted;
	private transient String friendlyurl;
	
	private	Integer	id;
	private	String title;
	private	String image_feature;
	private	String	content;
	private	int	status;
	private	String creator;
	private	Date	create_date;
	
	private	Integer category_id;
	
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
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public	void	setId(Integer	id){
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage_feature() {
		return image_feature;
	}
	public void setImage_feature(String image_feature) {
		this.image_feature = image_feature;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getFriendlyurl() {
		return friendlyurl;
	}
	public void setFriendlyurl(String friendlyurl) {
		this.friendlyurl = friendlyurl;
	}
	public News(Integer id, String title, String image_feature, String content,
			int status, String creator, Date create_date,Integer	category_id) {
		super();
		this.id = id;
		this.title = title;
		this.image_feature = image_feature;
		this.content = content;
		this.status = status;
		this.creator = creator;
		this.create_date = create_date;
		this.category_id=category_id;
		this.persisted=false;
		this.friendlyurl=SeoUtils.getSeoUrl(title);
	}
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}


}
