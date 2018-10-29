package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vivmallcn.domain.Emailfeedback;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;


@Repository
public class EmailRepository extends JdbcRepository<Emailfeedback,Integer> {
	


	public EmailRepository(){
		super(ROW_MAPPER,ROW_UNMAPPER,"tb_emailfeedback","id");
	}
	

	public static final RowMapper<Emailfeedback> ROW_MAPPER= new RowMapper<Emailfeedback>() {
		
		@Override
		public Emailfeedback mapRow(ResultSet rs , int rowNum) throws SQLException{
		
			return new Emailfeedback(
				rs.getInt("id"),
				rs.getInt("contact_id"),
				rs.getString("user_id"),
				rs.getString("subject"),
				rs.getString("content"),
				rs.getTimestamp("senddate"),
				rs.getString("from_email"),
				rs.getString("to_email")
				);
		}
		
	};
	
	private static final RowUnmapper<Emailfeedback> ROW_UNMAPPER = new RowUnmapper<Emailfeedback>() {
		@Override
		public Map<String, Object> mapColumns(Emailfeedback c) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", c.getId());
			mapping.put("contact_id", c.getContact_id());
			mapping.put("user_id", c.getUserID());
			mapping.put("subject", c.getSubject());
			mapping.put("content", c.getContent());
			mapping.put("senddate", c.getSenddate());
			mapping.put("from_email", c.getFrom_email());
			mapping.put("to_email",c.getTo_email());
			return mapping;
		}
	};	
	


	@Override
	protected <S extends Emailfeedback> S postCreate(S entity, Number generatedId) {			
		entity.setId(generatedId.intValue());
		return entity;
	}
}
