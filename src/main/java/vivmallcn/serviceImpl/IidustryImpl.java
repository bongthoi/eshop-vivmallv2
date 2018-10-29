package vivmallcn.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Category;
import vivmallcn.domain.Industry;
import vivmallcn.domain.Product;
import vivmallcn.repository.CategoryRepository;
import vivmallcn.repository.IndustryRepository;
import vivmallcn.service.IProduct;
import vivmallcn.service.Iindustry;

@Service
public class IidustryImpl implements Iindustry{
	@Value("${PRODUCT_PER_CATE_INDUSTRY}")
	private int PRODUCT_PER_CATE_INDUSTRY;
	
	@Autowired
	private IndustryRepository industryRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private IProduct productService;
	
	@Override
	public List<Industry> findAll() {
		// TODO Auto-generated method stub
		return industryRepository.findAll();
	}

	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return industryRepository.exists(id);
	}

	@Override
	public Industry findByid(Integer id) {
		// TODO Auto-generated method stub
		return industryRepository.findOne(id);
	}


	@Override
	public Industry save(Industry Industry) {
		// TODO Auto-generated method stub
		return industryRepository.save(Industry);
	}

	

	@Override
	@Transactional
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						industryRepository.active(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						industryRepository.disabled(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						industryRepository.delete(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	public Page<Industry> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return industryRepository.findAll(pageable);
	}

	@Override
	public List<Industry> findAllContainCategoryAndProduct(Integer product_limit) {
		// TODO Auto-generated method stub
		
		List<Industry> industries=industryRepository.findByActive();
		
		for (int i=0;i<industries.size();i++) {
			List<Product> firstcate_prods=new ArrayList<Product>();
			List<Category> categories=categoryRepository.findAllByInstryID(industries.get(i).getId());
			
			for (int j=0;j<categories.size();j++) {
				List<Product> products=productService.findByCateID(categories.get(j).getId(),PRODUCT_PER_CATE_INDUSTRY);
				firstcate_prods.addAll(products);
				
				if(firstcate_prods.size()<=product_limit){
					categories.get(0).setProductlist(firstcate_prods);
				}else{
					categories.get(0).setProductlist(firstcate_prods.subList(0, product_limit));
				}
				
			}
			industries.get(i).setCategorylist(categories);
			
		}
		return industries;
	}

	@Override
	public List<Industry> findAllContainCategory() {
		// TODO Auto-generated method stub
		List<Industry> industries=industryRepository.findByActive();
		for (int i=0;i<industries.size();i++) {
			
			List<Category> categories=categoryRepository.findAllByInstryID(industries.get(i).getId());
			industries.get(i).setCategorylist(categories);
			
		}
		return industries;
	}

	
}
