package vivmallcn.layout.support.web;

import java.text.Normalizer;
import java.util.regex.Pattern;


public class SeoUtils {

	private static final int TITLE_IN_URL_MAX_LENGTH = 100;
    /**
     * Bo dau 1 chuoi
     * 
     * @param s
     * @return
     */
    public static String removeAccent(String s) {
    	try {
    	       String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    	       Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    	       return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll("đ", "d");
    	   } catch (Exception e) {
    		   return "error";
    	   }
    }
    
	public static String getSeoUrl(String title) {
		String removeAccentTitle=removeAccent(title);
		
		String titleInUrl = removeAccentTitle.trim().replaceAll("[^a-zA-Z0-9\\-\\s\\.]", "");
		titleInUrl = titleInUrl.replaceAll("[\\-| |\\.]+", "-");
		
		if (titleInUrl.length() > TITLE_IN_URL_MAX_LENGTH) {
			return	titleInUrl.substring(0,
					TITLE_IN_URL_MAX_LENGTH);
		} else {
			return	titleInUrl;
		}
	}
}
