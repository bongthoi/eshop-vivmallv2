package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vivmallcn.domain.News;
import com.nurkiewicz.jdbcrepository.RowUnmapper;
@Repository
public class NewsRepository extends CustomizeRepository<News, Integer> {

	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	
	public NewsRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_news", "id");
		// TODO Auto-generated constructor stub
	}

	public static final RowMapper<News> ROW_MAPPER = new RowMapper<News>(){
		@Override
		public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			News	news= new	News(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("image_feature"),
					rs.getString("content"),
					rs.getInt("status"),
					rs.getString("creator"),
					rs.getDate("create_date"),
					rs.getInt("category_id"));
			news.setPersisted(true);
			
			return news;
		}
		
	};
	
	public static final RowUnmapper<News> ROW_UNMAPPER = new RowUnmapper<News>(){
		@Override
		public Map<String, Object> mapColumns(News t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			
			mapping.put("id", t.getId());
			mapping.put("title", t.getTitle());
			mapping.put("image_feature", t.getImage_feature());
			mapping.put("content", t.getContent());
			mapping.put("status", t.getStatus());
			mapping.put("creator",t.getCreator());
			mapping.put("create_date", t.getCreate_date());
			mapping.put("category_id", t.getCategory_id());
			
			return mapping;	
		}
		
	};
	
	@Override
	protected <S extends News> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends News> S postCreate(S entity, Number generatedId) {			
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
	
	public Page<News> findByCateID(Integer id,Pageable pageable){
		Page<News> news=this.findQuery(" where status=1 and category_id="+id,pageable);
			
		return news;
	}
}
