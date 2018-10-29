package vivmallcn.domain;


import java.util.Date;



import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Persistable;

public class Emailfeedback implements Persistable<Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3156667151522499944L;

	
	private Integer id; 
	private Integer contact_id;
	private String userID;
	@NotEmpty
	private String subject;
	private String content;
	private Date senddate;
	private String from_email;
	private String to_email;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return id == null || id == 0;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getContact_id() {
		return contact_id;
	}
	public void setContact_id(Integer contact_id) {
		this.contact_id = contact_id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	public Date getSenddate() {
		return senddate;
	}
	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	public String getFrom_email() {
		return from_email;
	}
	public void setFrom_email(String from_email) {
		this.from_email = from_email;
	}
	public String getTo_email() {
		return to_email;
	}
	public void setTo_email(String to_email) {
		this.to_email = to_email;
	}
	
	

	public Emailfeedback( Integer id, Integer contact_id,
			String userID, String subject, String content, Date senddate,
			String from_email, String to_email) {
		super();
		this.id = id;
		this.contact_id = contact_id;
		this.userID = userID;
		this.subject = subject;
		this.content = content;
		this.senddate = senddate;
		this.from_email = from_email;
		this.to_email = to_email;
	}
	public Emailfeedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emailfeedback id=" + id
				+ ", contact_id=" + contact_id + ", userID=" + userID
				+ ", subject=" + subject + ", content=" + content
				+ ", senddate=" + senddate + ", from_email=" + from_email
				+ ", to_email=" + to_email + "]";
	}
	
	
	
	
}
