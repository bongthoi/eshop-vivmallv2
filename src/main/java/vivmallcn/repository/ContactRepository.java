package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vivmallcn.domain.Contact;




import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class ContactRepository extends CustomizeRepository<Contact, Integer>{
	
	public ContactRepository(){
		super(ROW_MAPPER,ROW_UNMAPPER,"tb_contacts");
	}
	
	public static final RowMapper<Contact> ROW_MAPPER = new RowMapper<Contact>(){

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			return new Contact(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("subject"),
					rs.getString("content"),
					rs.getString("phone"),
					rs.getString("address"),
					rs.getTimestamp("create_date"),
					rs.getInt("status")
					);
	
		}
	};	
	
	private static final RowUnmapper<Contact> ROW_UNMAPPER = new RowUnmapper<Contact>() {
		@Override
		public Map<String, Object> mapColumns(Contact c) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", c.getId());
			mapping.put("name", c.getName());
			mapping.put("email", c.getEmail());
			mapping.put("subject", c.getSubject());
			mapping.put("content", c.getContent());
			mapping.put("phone", c.getPhone());
			mapping.put("address", c.getAddress());
			mapping.put("create_date",c.getCreateDate());
			mapping.put("status",c.getStatus());
			return mapping;
		}
	};	
	
	@Override
	protected <S extends Contact> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
	public Page<Contact> findByStatus(int status, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Contact> contacts=this.findQuery(" where status="+status,pageable);
		return contacts;
	}
	
	public Long getNewContactSize() {
		// TODO Auto-generated method stub
		
		Long count = this.getJdbcTemplate().queryForObject("select count(*) from " +this.getTable().getName() + " where status=0", Long.class);
		return count;
	}
}
