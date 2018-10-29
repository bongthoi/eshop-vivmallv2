package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vivmallcn.domain.News_category;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;
@Repository
public class NewscategoryRepository extends	JdbcRepository<News_category, Integer> {

	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	
	public NewscategoryRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_news_categories", "id");
		// TODO Auto-generated constructor stub
	}

	public static final RowMapper<News_category> ROW_MAPPER = new RowMapper<News_category>(){

		@Override
		public News_category mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			News_category News_category= new News_category(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("image_feature"),
					rs.getString("description"),
					rs.getInt("ordered"),
					rs.getInt("status"));
			News_category.setPersisted(true);
			return News_category;
		}
	};
	
	public static final RowUnmapper<News_category> ROW_UNMAPPER = new RowUnmapper<News_category>(){

		@Override
		public Map<String, Object> mapColumns(News_category t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", t.getId());
			mapping.put("name",t.getName());
			mapping.put("image_feature", t.getImage_feature());
			mapping.put("description",t.getDescription());
			mapping.put("ordered",t.getOrdered());
			mapping.put("status",t.getStatus());
			return mapping;
		}
	};
	
	@Override
	protected <S extends News_category> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
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
