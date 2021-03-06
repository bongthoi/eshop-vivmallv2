package vivmallcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.Contact;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.IContact;
import vivmallcn.service.IEmail;


@Controller
public class ContactController {
	
	@Autowired
	private IContact icontactImp;
	
	@Autowired
	private IEmail iEmailImpl;
	
	@RequestMapping(value="admin/contacts")
	private String index(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p) {
		
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/contacts");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Contact> s=icontactImp.findAll(pageRequest);
		PageWrapper<Contact> page = new PageWrapper<Contact>(s, uri.build().toString());
		model.addAttribute("contacts",page.getContent());
		
		model.addAttribute("headTitle", "Contacts");
		 model.addAttribute("page", page);

		return "admin/contacts/list";
	}
	
	@RequestMapping(value="admin/newcontacts")
	private String getNewContacts(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p) {
		
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/newcontacts");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Contact> s=icontactImp.findByStatus(0,pageRequest);
		PageWrapper<Contact> page = new PageWrapper<Contact>(s, uri.build().toString());
		model.addAttribute("contacts",page.getContent());
		
		model.addAttribute("headTitle", "Contacts");
		 model.addAttribute("page", page);

		return "admin/contacts/list";
	}
	
	@GetMapping("admin/contact/delete/{id}")
	public String deleteContact(Model model,@PathVariable("id") int id,RedirectAttributes redirect){
		
		icontactImp.delete(id);
		return "redirect:/admin/contacts";
	}
	
}
