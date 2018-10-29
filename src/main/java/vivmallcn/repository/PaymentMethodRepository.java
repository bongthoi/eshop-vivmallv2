package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;







import vivmallcn.domain.PaymentMethod;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class PaymentMethodRepository extends JdbcRepository<PaymentMethod, Integer>{
	
	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	public PaymentMethodRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_payment_method");
	}

	public static final RowMapper<PaymentMethod> ROW_MAPPER = new RowMapper<PaymentMethod>(){

		@Override
		public PaymentMethod mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			PaymentMethod a= new PaymentMethod(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("description"),
					rs.getString("img"),
					rs.getString("account_name"),
					rs.getString("account_pass"),
					rs.getString("url"),
					rs.getString("merchant_site_code"),
					rs.getString("secure_pass"),
					rs.getString("return_url"),
					rs.getString("return_cancel"),
					rs.getString("receiver"),
					rs.getInt("status")
					);
			a.setPersisted(true);
			return a;
		}
	};	

	private static final RowUnmapper<PaymentMethod> ROW_UNMAPPER = new RowUnmapper<PaymentMethod>() {
		@Override
		public Map<String, Object> mapColumns(PaymentMethod a) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			
			mapping.put("id", a.getId());
			mapping.put("name", a.getName());
			mapping.put("description", a.getDescription());
			mapping.put("img",a.getImg());
			mapping.put("account_name",a.getAccount_name());
			mapping.put("account_pass", a.getAccount_pass());
			mapping.put("url", a.getUrl());
			mapping.put("merchant_site_code", a.getMerchant_site_code());
			mapping.put("secure_pass", a.getSecure_pass());
			mapping.put("return_url",a.getReturn_url());
			mapping.put("return_cancel", a.getReturn_cancel());
			mapping.put("receiver", a.getReceiver());
			mapping.put("status",a.getStatus());
			
			return mapping;
		}
	};	

	@Override
	protected <S extends PaymentMethod> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
	public List<PaymentMethod> findByActive() {
		// TODO Auto-generated method stub
			List<PaymentMethod> paymentMethod=this.jdbcTemplateObject.query("select * from  tb_payment_method  where status=1 ORDER BY id ASC",ROW_MAPPER);
			
			return paymentMethod;
		
	}
	
	public void active(Integer string) {
		String query="UPDATE "+this.getTable().getName() +""
				+ "   set status=1 where id=?";
		jdbcTemplateObject.update(query, new Object[]{string});
		
	}

	public void disabled(Integer string) {
		String query="UPDATE "+this.getTable().getName() +""
				+ "   set status=0 where id=?";
		jdbcTemplateObject.update(query, new Object[]{string});
		
	}

}
