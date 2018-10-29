package vivmallcn.domain;

import org.springframework.data.domain.Persistable;

public class PaymentMethod  implements Persistable<Integer>{

	private static final long serialVersionUID = -6462281431909426114L;
	private transient boolean persisted;
	/**
	 * 
	 */

	private Integer  id;
	private String name;
	private String description;
	private String img;
	private String account_name;
	private String account_pass;
	private String url;
	private String merchant_site_code;
	private String secure_pass;
	private String return_url;
	private String return_cancel;
	private String receiver;
	private	int	status;
	
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
	/*@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return id == null || id == 0;
	}*/
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_pass() {
		return account_pass;
	}
	public void setAccount_pass(String account_pass) {
		this.account_pass = account_pass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMerchant_site_code() {
		return merchant_site_code;
	}
	public void setMerchant_site_code(String merchant_site_code) {
		this.merchant_site_code = merchant_site_code;
	}
	public String getSecure_pass() {
		return secure_pass;
	}
	public void setSecure_pass(String secure_pass) {
		this.secure_pass = secure_pass;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	public String getReturn_cancel() {
		return return_cancel;
	}
	public void setReturn_cancel(String return_cancel) {
		this.return_cancel = return_cancel;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PaymentMethod(Integer id, String name, String description,
			String img, String account_name, String account_pass, String url,
			String merchant_site_code, String secure_pass, String return_url,
			String return_cancel, String receiver,int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.img = img;
		this.account_name = account_name;
		this.account_pass = account_pass;
		this.url = url;
		this.merchant_site_code = merchant_site_code;
		this.secure_pass = secure_pass;
		this.return_url = return_url;
		this.return_cancel = return_cancel;
		this.receiver = receiver;
		this.status=status;
		this.persisted = false;
	}
	public PaymentMethod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
