package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nurkiewicz.jdbcrepository.RowUnmapper;

import vivmallcn.domain.OrdersDetail;

@Repository
public class OrdersDetailRepository extends CustomizeRepository<OrdersDetail, Integer>{
	
	public  OrdersDetailRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_orders_detail");
	}

	public static final RowMapper<OrdersDetail> ROW_MAPPER = new RowMapper<OrdersDetail>(){

		@Override
		public  OrdersDetail mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			 OrdersDetail a= new  OrdersDetail(
					rs.getInt("id"),
					rs.getString("ProductId"),
					rs.getString("ProductName"),
					rs.getInt("Unit"),
					rs.getInt("Quantity"),
					rs.getBigDecimal("Price"),
					rs.getBigDecimal("Price1"),
					rs.getBigDecimal("Amount"),
					rs.getString("OrdersId")
					);
			return a;
		}
	};	

	private static final RowUnmapper<OrdersDetail> ROW_UNMAPPER = new RowUnmapper<OrdersDetail>() {
		@Override
		public Map<String, Object> mapColumns( OrdersDetail a) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", a.getId());
			mapping.put("ProductId", a.getProductId());
			mapping.put("ProductName",a.getProductName());
			mapping.put("Unit",a.getUnit());
			mapping.put("Quantity",a.getQuantity());
			mapping.put("Price", a.getPrice());
			mapping.put("Price1", a.getPrice1());
			mapping.put("Amount",a.getAmount());
			mapping.put("OrdersId", a.getOrdersId());
			return mapping;
		}
	};	

	@Override
	protected <S extends  OrdersDetail> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}
	/*public List<OrdersDetailReport> findByGoodsDeliveriedId(String id){
		String query="select t1.*,t2.name as UnitName from "
				+ " (SELECT * FROM tb_goods_deliveried_note_detail  where GoodsDeliveriedNoteId='"+id+"') as t1,tb_unit as t2  "
				+ " where t2.id = t1.Unit;";
		return this.getJdbcTemplate().query(query, OrdersDetailReport.ROW_MAPPER);
		
	}*/
}