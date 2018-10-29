package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nurkiewicz.jdbcrepository.RowUnmapper;

import vivmallcn.domain.DeliveryMethod;
import vivmallcn.domain.Orders;
import vivmallcn.domain.PaymentMethod;




@Repository
public class OrdersRepository extends CustomizeRepository<Orders, String>{
	
	
	public OrdersRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_orders", "id");
		// TODO Auto-generated constructor stub
	}
	public static final RowMapper<Orders> ROW_MAPPER = new RowMapper<Orders>(){

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			Orders t= new Orders(
					rs.getString("id"),
					rs.getString("Email"),
					rs.getString("Name"),
					rs.getString("Address"),
					rs.getString("Phone"),
					new PaymentMethod(rs.getInt("PaymentMethod"),"","","","","","","","","","","",0),
					new DeliveryMethod(rs.getInt("DeliveryMethod"),"","","",null,0),
					rs.getInt("TotalQuantity"),
					rs.getBigDecimal("TotalAmount"),
					rs.getTimestamp("CreateDate"),
					rs.getString("Note"),
					rs.getInt("IsCheck"));
			t.setPersisted(true);
			return t;
		}
		
	};

	public static final RowUnmapper<Orders> ROW_UNMAPPER = new RowUnmapper<Orders>(){

		@Override
		public Map<String, Object> mapColumns(Orders t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", t.getId());
			mapping.put("Email", t.getEmail());
			mapping.put("Name",t.getName());
			mapping.put("Address", t.getAddress());
			mapping.put("Phone",t.getPhone());
			mapping.put("PaymentMethod",t.getPaymentMethod().getId());
			mapping.put("DeliveryMethod",t.getDeliveryMethod().getId());
			mapping.put("TotalQuantity", t.getTotalQuantity());
			mapping.put("TotalAmount",t.getTotalAmount());
			mapping.put("CreateDate", t.getCreateDate());
			mapping.put("Note", t.getNote());
			mapping.put("IsCheck", t.getIsCheck());
			return mapping;
		}
		
	};
	@Override
	protected <S extends Orders> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Orders> S postCreate(S entity, Number generatedId) {			
		entity.setPersisted(true);
		return entity;
	}

	public String GenarateId(){
		String sql="select getNextCustomSeq('OD-ID', 'OD') as id ";
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}

	/*public Orders findByidOnInfoPage(String id) {
		String sql="select t1.*,t2.name as DeliveryMethodName,t3.name as PaymentMethodName "
				+ " from (select * from tb_orders where id=?) t1,"
				+ " tb_delivery_method t2,tb_payment_method t3"
				+ " where t1.PaymentMethod=t3.id and t1.DeliveryMethod=t2.id";
		return this.getJdbcTemplate().queryForObject(sql,new Object[] {id},BeanPropertyRowMapper.newInstance( Orders.class) );
	}*/
	
	public Page<Orders> findByUserID(String id,Pageable pageable){
		Page<Orders> orders=this.findQuery(" where Email='"+id+"'",pageable);
		
		return orders;
	}

	public Page<Orders> findByIsCheck(int status, Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Orders> orders=this.findQuery(" where IsCheck="+status,pageable);
		return orders;
	}

	public Long getNewOrderSize() {
		// TODO Auto-generated method stub
		
		Long count = this.getJdbcTemplate().queryForObject("select count(*) from " +this.getTable().getName() + " where IsCheck=0", Long.class);
		return count;
	}
	
}
