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

import vivmallcn.domain.DeliveryMethod;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class DeliveryMethodRepository  extends JdbcRepository<DeliveryMethod, Integer>{
	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	
	public DeliveryMethodRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_delivery_method");
	}

	public static final RowMapper<DeliveryMethod> ROW_MAPPER = new RowMapper<DeliveryMethod>(){

		@Override
		public DeliveryMethod mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			DeliveryMethod a= new DeliveryMethod(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("img"),
					rs.getString("description"),
					rs.getDouble("fee"),
					rs.getInt("status"));
			a.setPersisted(true);
			return a;
		}
	};	

	private static final RowUnmapper<DeliveryMethod> ROW_UNMAPPER = new RowUnmapper<DeliveryMethod>() {
		@Override
		public Map<String, Object> mapColumns(DeliveryMethod a) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", a.getId());
			mapping.put("name", a.getName());
			mapping.put("img", a.getImg());
			mapping.put("description", a.getDescription());
			mapping.put("fee",a.getFee());
			mapping.put("status",a.getStatus());
			
			return mapping;
		}
	};	

	@Override
	protected <S extends DeliveryMethod> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
	
	public List<DeliveryMethod> findByActive() {
		// TODO Auto-generated method stub
			List<DeliveryMethod> deliverymethod=this.jdbcTemplateObject.query("select * from  tb_delivery_method  where status=1 ORDER BY id ASC",ROW_MAPPER);
			
			return deliverymethod;
		
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