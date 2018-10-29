package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import vivmallcn.domain.Guide;

import com.nurkiewicz.jdbcrepository.RowUnmapper;


@Repository
public class GuideRepository extends CustomizeRepository<Guide, String>{

	
	public GuideRepository(){
		super(ROW_MAPPER, ROW_UNMAPPER,"tb_guide","id");
	}
	
	public static final RowMapper <Guide>ROW_MAPPER = new RowMapper<Guide>() {
		@Override
		public Guide mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Guide(rs.getString("id"),rs.getString("title"), rs.getString("description"),
					rs.getString("logo"), rs.getString("creator"),
					rs.getTimestamp("create_date"), rs.getString("content")

			);
		}
	};

	public static final RowUnmapper<Guide> ROW_UNMAPPER = new RowUnmapper<Guide>() {
		@Override
		public Map<String, Object> mapColumns(Guide g) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", g.getId());
			mapping.put("title", g.getTitle());
			mapping.put("description", g.getDescription());
			mapping.put("logo", g.getLogo());
			mapping.put("creator", g.getCreator());
			mapping.put("create_date", g.getCreateDate());
			mapping.put("content", g.getContent());
			return mapping;
		}
	};
	@Override
	protected <S extends Guide> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Guide> S postCreate(S entity, Number generatedId) {			
		entity.setPersisted(true);
		return entity;
	}
	

}
