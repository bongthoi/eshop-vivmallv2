package vivmallcn.layout.support.web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class URLUtils {

	@Value("${domain.name}")
	public  String DOMAIN_NAME;
	
	public String getBaseURl(HttpServletRequest request) {
		/*System.out.println("LocalName="+ request.getRequestURL().toString());*/
		System.out.print("host="+request.getHeader("Host"));
	    String scheme = request.getScheme();
	    String serverName = request.getServerName();
	    int serverPort = request.getServerPort();
	    String contextPath = request.getContextPath();
	    StringBuffer url =  new StringBuffer();
	    url.append(scheme).append("://").append(serverName);
	    if ((serverPort != 80) && (serverPort != 443)) {
	        url.append(":").append(serverPort);
	    }
	    url.append(contextPath);
	    if(url.toString().endsWith("/")){
	    	url.append("/");
	    }
	    /*System.out.println("LocalName1="+ getURLBase(request));*/
	    return url.toString();
	}
	
	public	String getURLBase(HttpServletRequest request){

		System.out.print("host="+request.getHeader("Host"));
	    URL requestURL = null;
	    String port = null;
		try {
			
			requestURL = new URL(request.getRequestURL().toString());
			port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return requestURL.getProtocol() + "://" + requestURL.getHost() + port;

	}
	
	public	String getDomainName() {
		
	    return DOMAIN_NAME;
	}
	
	public String test(HttpServletRequest request) {
		/*System.out.println("LocalName="+ request.getRequestURL().toString());*/
	    String scheme = request.getScheme();
	    System.out.println("scheme="+scheme);
	    String serverName = request.getServerName();
	    System.out.println("serverName="+serverName);
	    int serverPort = request.getServerPort();
	    System.out.println("serverPort="+serverPort);
	    String contextPath = request.getContextPath();
	    System.out.println("contextPath="+contextPath);
	    StringBuffer url =  new StringBuffer();
	    url.append(scheme).append("://").append(serverName);
	    if ((serverPort != 80) && (serverPort != 443)) {
	        url.append(":").append(serverPort);
	    }
	    url.append(contextPath);
	    if(url.toString().endsWith("/")){
	    	url.append("/");
	    }
	    System.out.println("LocalName1="+ request.getHeader("Host"));
	    return request.getHeader("Host");
	}
}
