package vivmallcn.layout.support.web;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vivmallcn.domain.Industry;
import vivmallcn.service.Iindustry;

@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Service("industry_menu")
@Transactional
public class Industrylist {
	@Autowired
	private Iindustry iindustry;
	
	public Collection<Industry> getItems() {
		return iindustry.findAllContainCategory();
	}
}
