package vivmallcn.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.News;
import vivmallcn.repository.NewsRepository;
import vivmallcn.service.INews;
@Service
public class INewsImpl implements INews {

	@Autowired
	NewsRepository	newsRepository;
	
	@Override
	public List<News> findAll() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();
	}

	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.exists(id);
	}

	@Override
	public News save(News news) {
		// TODO Auto-generated method stub
		return newsRepository.save(news);
	}

	@Override
	public News findByid(Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.findOne(id);
	}

	@Override
	@Transactional
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						newsRepository.active(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						newsRepository.disabled(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	@Transactional
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						newsRepository.delete(Integer.parseInt(arr_id[i]));
					}
				}
		
	}

	@Override
	public Page<News> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return newsRepository.findAll(pageable);
	}

	@Override
	public Page<News> findByCateID(Pageable pageable, Integer id) {
		// TODO Auto-generated method stub
		return newsRepository.findByCateID(id, pageable);
	}

}
