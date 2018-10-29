package vivmallcn.layout.support.web;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vivmallcn.domain.Slide;
import vivmallcn.service.ISlide;

@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Service("slider")
@Transactional
public class Sliders {
	@Autowired
	private ISlide slideService;
	
	public Collection<Slide> getItems() {
		return  (Collection<Slide>) slideService.findAll();
	}
}
