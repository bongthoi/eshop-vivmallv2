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

import vivmallcn.domain.Industry;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class IndustryRepository  extends JdbcRepository<Industry, Integer> {
	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	
	public IndustryRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_industry", "id");
		// TODO Auto-generated constructor stub
	}
	public static final RowMapper<Industry> ROW_MAPPER = new RowMapper<Industry>(){

		@Override
		public Industry mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			Industry Industry= new Industry(
					rs.getInt("id"),
					rs.getString("IndustryName"),
					rs.getString("IndustryDes"),
					rs.getString("IndustryImg"),
					rs.getInt("enabled"),
					rs.getInt("IndustryOrder"),
					rs.getString("Icon"),
					rs.getString("ColorBackground"));
			Industry.setPersisted(true);
			return Industry;
		}
		
	};

	public static final RowUnmapper<Industry> ROW_UNMAPPER = new RowUnmapper<Industry>(){

		@Override
		public Map<String, Object> mapColumns(Industry t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", t.getId());
			mapping.put("IndustryName", t.getIndustryName());
			mapping.put("IndustryDes", t.getIndustryDes());
			mapping.put("IndustryImg", t.getIndustryImg());
			mapping.put("enabled", t.getEnabled());
			mapping.put("IndustryOrder", t.getIndustryOrder());
			mapping.put("Icon", t.getIcon());
			mapping.put("ColorBackground", t.getColorBackground());
			return mapping;
		}
		
	};
	@Override
	protected <S extends Industry> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Industry> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
	
	public void active(Integer string) {
		String query="UPDATE "+this.getTable().getName() +""
				+ "   set enabled=1 where id=?";
		jdbcTemplateObject.update(query, new Object[]{string});
		
	}

	public void disabled(Integer string) {
		String query="UPDATE "+this.getTable().getName() +""
				+ "   set enabled=0 where id=?";
		jdbcTemplateObject.update(query, new Object[]{string});
		
	}

	public List<Industry> findByActive() {
		// TODO Auto-generated method stub
			List<Industry> industries=this.jdbcTemplateObject.query("select * from  tb_industry  where enabled=1 ORDER BY IndustryOrder ASC",ROW_MAPPER);
			
			return industries;
		
	}
	
	
}
