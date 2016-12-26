import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.junit.Test;

import com.github.aimind.exponentialschedule_api.services.*;
import junit.framework.TestCase;

public class SecurityServiceTest extends TestCase {

	@Test
	public void testEncryptDecryptMessage() {
		
		String message = "Test password";
		String passphrase= "A1B2C3D4E5";
		List<String> result = new ArrayList<String>();
		String message2 = "";
		
		try {
			result = SecurityService.encryptAESMessage(message, passphrase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			message2 = SecurityService.decryptAESMessage(result.get(0), result.get(1), passphrase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(message,message2);
	}
}
