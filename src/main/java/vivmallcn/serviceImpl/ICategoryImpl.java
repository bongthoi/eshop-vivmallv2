package vivmallcn.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Category;
import vivmallcn.domain.Product;
import vivmallcn.repository.CategoryRepository;
import vivmallcn.service.ICategory;
import vivmallcn.service.IProduct;



@Service
public class ICategoryImpl implements ICategory{
	@Autowired
	private CategoryRepository categoryRepository;
	

	
	@Autowired
	private IProduct productService;
	
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.exists(id);
	}

	@Override
	public Category save(Category Category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(Category);
	}

	@Override
	public Category findByid(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOne(id);
	}

	@Override
	@Transactional
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						categoryRepository.active(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						categoryRepository.disabled(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						categoryRepository.delete(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAllContainProducts(Integer IndustryID,Integer product_limit) {
		// TODO Auto-generated method stub
		
	    	List<Category> categories=categoryRepository.findAllByInstryID(IndustryID);
			
			for (int i=0;i<categories.size();i++) {
				
				List<Product> products=productService.findByCateID(categories.get(i).getId(),product_limit);
				categories.get(i).setProductlist(products);
			}
			return categories;
		}
	
	@Override
	public List<Category> findAllByIndustryID(Integer id) {
		// TODO Auto-generated method stub
		
	    	List<Category> categories=categoryRepository.findAllByInstryID(id);
			
			return categories;
		}

}
