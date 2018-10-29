var base = document.getElementsByTagName('base')[0]; 
	if (base && base.href && (base.href.length > 0)) 
		{ 
			base = base.href; 
		} 
	else 
		{ 
			base = document.URL; 
		} 
	var baseurl=base.substr(0, base.indexOf("/", base.indexOf("/", base.indexOf("//") + 2)))+"/";
