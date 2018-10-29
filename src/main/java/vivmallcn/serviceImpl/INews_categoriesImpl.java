package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.News_category;
import vivmallcn.repository.NewscategoryRepository;
import vivmallcn.service.INews_categories;

@Service
public class INews_categoriesImpl implements INews_categories {

	@Autowired
	NewscategoryRepository	newscategoryRepository;
	
	@Override
	public List<News_category> findAll() {
		// TODO Auto-generated method stub
		return newscategoryRepository.findAll();
	}

	@Override
	public News_category save(News_category nc) {
		// TODO Auto-generated method stub
		return newscategoryRepository.save(nc);
	}

	@Override
	public News_category findByid(Integer id) {
		// TODO Auto-generated method stub
		return newscategoryRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		newscategoryRepository.delete(id);
	}

	@Override
	public Page<News_category> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return newscategoryRepository.findAll(pageable);
	}

	@Override
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				newscategoryRepository.active(Integer.parseInt(arr_id[i]));
			}
		}
	}

	@Override
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				newscategoryRepository.disabled(Integer.parseInt(arr_id[i]));
			}
		}
	}

	@Override
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				newscategoryRepository.delete(Integer.parseInt(arr_id[i]));
			}
		}
	}

}
