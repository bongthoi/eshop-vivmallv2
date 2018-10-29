package vivmallcn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;






import vivmallcn.domain.Product;

import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class ProductRepository extends CustomizeRepository<Product, String> {
	
	public ProductRepository() {
		super(ROW_MAPPER, ROW_UNMAPPER, "tb_product", "id");
		// TODO Auto-generated constructor stub
	}
	public static final RowMapper<Product> ROW_MAPPER = new RowMapper<Product>(){

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {	//mapper when select
			
			Product t= new Product(
					rs.getString("id"),
					rs.getString("FeatureImage"),
					rs.getString("ProductName"),
					rs.getString("ProductDes"),
					rs.getString("ProductGuide"),
					rs.getString("ProductInfo"),
					rs.getInt("Unit"),
					rs.getInt("BigUnit"),
					rs.getBigDecimal("CostPrice"),
					rs.getBigDecimal("SellPrice"),
					rs.getBigDecimal("SellPrice1"),
					rs.getBigDecimal("SellPrice2"),
					rs.getString("SupplierId"),
					rs.getInt("CategoryId"),
					rs.getInt("BusinessType"),
					rs.getTimestamp("CreateDate"),
					rs.getTimestamp("UpdateDate"),
					rs.getString("CreateUser"),
					rs.getString("UpdateUser"),
					rs.getInt("enabled"));
			t.setPersisted(true);
			return t;
		}
		
	};

	public static final RowUnmapper<Product> ROW_UNMAPPER = new RowUnmapper<Product>(){

		@Override
		public Map<String, Object> mapColumns(Product t) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", t.getId());
			mapping.put("FeatureImage", t.getFeatureImage());
			mapping.put("ProductName", t.getProductName());
			mapping.put("ProductDes", t.getProductDes());
			mapping.put("ProductGuide",t.getProductGuide());
			mapping.put("ProductInfo",t.getProductInfo());
			mapping.put("Unit", t.getUnit());
			mapping.put("BigUnit",t.getBigUnit());
			mapping.put("CostPrice",t.getCostPrice());
			mapping.put("SellPrice", t.getSellPrice());
			mapping.put("SellPrice1", t.getSellPrice1());
			mapping.put("SellPrice2", t.getSellPrice2());
			mapping.put("SupplierId", t.getSupplierId());
			mapping.put("CategoryId", t.getCategoryId());
			mapping.put("BusinessType", t.getBusinessType());
			mapping.put("CreateDate", t.getCreateDate());
			mapping.put("UpdateDate", t.getUpdateDate());
			mapping.put("CreateUser", t.getCreateUser());
			mapping.put("UpdateUser", t.getUpdateUser());
			mapping.put("enabled", t.getEnabled());
			return mapping;
		}
		
	};
	@Override
	protected <S extends Product> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Product> S postCreate(S entity, Number generatedId) {			
		entity.setPersisted(true);
		return entity;
	}

	public String GenarateBarcodeWithoutCheckSum(){
		String sql="select getNextProductBarcodeWithoutChecksumDigit() as barcode ";
		return this.getJdbcTemplate().queryForObject(sql, String.class);
	}
	
	public List<Product> findByCateID(Integer id,Integer limit){
		
			List<Product> products=this.getJdbcTemplate().query("select * from  tb_product  where enabled=1 and CategoryId="+id +" limit "+limit,ROW_MAPPER);
			
			return products;
		
	}
	public Page<Product> findByCateID(Integer id,Pageable pageable){
		
		Page<Product> products=this.findQuery(" where enabled=1 and CategoryId="+id,pageable);
			
			return products;
		
	}
	public List<Product> findByProductID(String id,Integer limit){
		List<Product> products=this.getJdbcTemplate().query("select * from  tb_product  where enabled=1 and CategoryId=(select CategoryId from tb_product where id='"+id +"') limit "+limit,ROW_MAPPER);
		return products;
	
	}
	public List<Product> findContainName(String name,Integer limit){
		List<Product> products=this.getJdbcTemplate().query("select * from  tb_product  where enabled=1 and ProductName like '%"+name+"%' limit "+limit,ROW_MAPPER);
		return products;
	
	}
	
	public Page<Product> findLikeName(String name,Pageable pageable){
		Page<Product> products=this.findQuery(" where enabled=1 and ProductName like '%"+name+"%'",pageable);
		return products;
	
	}
}
