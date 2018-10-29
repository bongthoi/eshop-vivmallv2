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

import vivmallcn.domain.Category;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class CategoryRepository   extends JdbcRepository<Category, Integer>{

	@Autowired
	private  JdbcTemplate jdbcTemplateObject;
	
	public CategoryRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_category", "id");
		// TODO Auto-generated constructor stub
	}
	public static final RowMapper<Category> ROW_MAPPER = new RowMapper<Category>(){

		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			Category Category= new Category(
					rs.getInt("id"),
					rs.getString("CategoryName"),
					rs.getString("CategoryDes"),
					rs.getString("CategoryImg"),
					rs.getString("IndustryId"),
					rs.getTimestamp("CreateDate"),
					rs.getTimestamp("UpdateDate"),
					rs.getString("CreateUser"),
					rs.getString("UpdateUser"),
					rs.getInt("enabled"),
					rs.getInt("CategoryOrder"));
			Category.setPersisted(true);
			return Category;
		}
		
	};

	public static final RowUnmapper<Category> ROW_UNMAPPER = new RowUnmapper<Category>(){

		@Override
		public Map<String, Object> mapColumns(Category t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", t.getId());
			mapping.put("CategoryName", t.getCategoryName());
			mapping.put("CategoryDes", t.getCategoryDes());
			mapping.put("CategoryImg",t.getCategoryImg());
			mapping.put("IndustryId", t.getIndustryId());
			mapping.put("CreateDate", t.getCreateDate());
			mapping.put("UpdateDate", t.getUpdateDate());
			mapping.put("CreateUser", t.getCreateUser());
			mapping.put("UpdateUser", t.getUpdateUser());
			mapping.put("enabled", t.getEnabled());
			mapping.put("CategoryOrder",t.getCategoryOrder());
			return mapping;
		}
		
	};
	@Override
	protected <S extends Category> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Category> S postCreate(S entity, Number generatedId) {			
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
	
	public List<Category> findByActive(){
		
		List<Category> categories=this.jdbcTemplateObject.query("select * from  tb_category  where enabled=1",ROW_MAPPER);
		
		return categories;
	
	}

	public List<Category> findAllByInstryID(Integer id) {
		// TODO Auto-generated method stub\
		List<Category> categories=this.jdbcTemplateObject.query("select * from  tb_category  where enabled=1 and IndustryId="+id +" ORDER BY CategoryOrder ASC",ROW_MAPPER);
		return categories;
	}
}
