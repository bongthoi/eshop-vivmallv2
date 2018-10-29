package vivmallcn.domain;

import org.springframework.data.domain.Persistable;

public class DeliveryMethod  implements Persistable<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2005205143301464991L;
	private transient boolean persisted;
	
	
	private Integer  id;
	private String name;
	private String img;
	private String description;
	private Double fee;
	private int	status;
	
	
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
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public DeliveryMethod(Integer id, String name,String img, String description,Double fee,int status) {
		super();
		this.id = id;
		this.name = name;
		this.img=img;
		this.description = description;
		this.fee=fee;
		this.status=status;
		this.persisted = false;
	}
	public DeliveryMethod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
