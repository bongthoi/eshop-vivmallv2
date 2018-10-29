package vivmallcn.layout.support.web;

import java.io.IOException;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class jspHelper {
	
	
	public static String toJson(Object value) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		  return mapper.writeValueAsString(value);
	}
	
}
