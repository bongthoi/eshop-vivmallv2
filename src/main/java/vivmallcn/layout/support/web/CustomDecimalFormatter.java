package vivmallcn.layout.support.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CustomDecimalFormatter {

	
	public static String format(BigDecimal value, String pattern, char decimalSeparator, char groupingSeparator) {
		
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        
        otherSymbols.setDecimalSeparator(decimalSeparator);
        otherSymbols.setGroupingSeparator(groupingSeparator);
        DecimalFormat df = new DecimalFormat(pattern, otherSymbols);
        return df.format(value);
    }
	public static String thymeleafFormatCurrentcy(BigDecimal value){
		return CustomDecimalFormatter.format(value,"#,##0.00",',','.');
	}
	
	public static String convertToDecimal(double doubleValue)  {
		DecimalFormat df = new DecimalFormat("###,##0.#");
        return df.format(doubleValue);
    }
}
