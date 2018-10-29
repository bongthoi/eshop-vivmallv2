package vivmallcn.layout.support.web;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
 






import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Creates a request to reCaptcha 2
 * https://www.google.com/recaptcha/api/siteverify
 * Throws an exception if it can't connect to reCaptcha
 * returns true or false if validation has passed
 * @author carlsamson
 *
 */
@Component("recaptcha")
public class ReCAPTCHAUtils {
	@Value("${SITE.VERIFY.URL}")
    private String SITE_VERIFY_URL;
 
	@Value("${SITE.KEY}")
    private String SITE_KEY;
	
	@Value("${SECRET.KEY}")
    private String SECRET_KEY;
	
    public boolean verify(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.length() == 0) {
            return false;
        }
 
        try {
            URL verifyUrl = new URL(SITE_VERIFY_URL);
 
            // Mở một kết nối (Connection) tới URL trên.
            HttpsURLConnection conn = (HttpsURLConnection) verifyUrl.openConnection();
 
            // Thêm các thông tin Header vào Request chuẩn bị gửi tới server.
            conn.setRequestMethod("POST");
            /*conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");*/
 
            // Dữ liệu sẽ gửi tới Server.
            String postParams = "secret=" + SECRET_KEY //
                    + "&response=" + gRecaptchaResponse;
 
            // Send Request
            conn.setDoOutput(true);
 
            // Lấy Output Stream (Luồng đầu ra) của kết nối tới Server.
            // Ghi dữ liệu vào Output Stream, có nghĩa là gửi thông tin đến Server.
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
 
            outStream.flush();
            outStream.close();
 
            // Mã trả lời được trả về từ Server.
            /*int responseCode = conn.getResponseCode();*/
           /* System.out.println("responseCode=" + responseCode);*/
 
            // Lấy Input Stream (Luồng đầu vào) của Connection
            // để đọc dữ liệu gửi đến từ Server.
            InputStream is = conn.getInputStream();
 
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
 
            // ==> {"success": true}
           /* System.out.println("Response: " + jsonObject);*/
 
            boolean success = jsonObject.getBoolean("success");
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getSITE_VERIFY_URL() {
		return SITE_VERIFY_URL;
	}

	public void setSITE_VERIFY_URL(String sITE_VERIFY_URL) {
		SITE_VERIFY_URL = sITE_VERIFY_URL;
	}

	public String getSITE_KEY() {
		return SITE_KEY;
	}

	public void setSITE_KEY(String sITE_KEY) {
		SITE_KEY = sITE_KEY;
	}

	public String getSECRET_KEY() {
		return SECRET_KEY;
	}

	public void setSECRET_KEY(String sECRET_KEY) {
		SECRET_KEY = sECRET_KEY;
	}


}