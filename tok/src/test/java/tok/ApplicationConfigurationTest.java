package tok;

import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tok.conf.ApplicationConfiguration;
import com.tok.dao.TokenDAO;
import com.tok.model.Token;


public class ApplicationConfigurationTest {

/*	@Autowired
	TokenDAO tokenDAO;*/
	
	@Test
	public void applicatioContextLoadTest()
	{
		/*		ApplicationContext actx  = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);	

		Token t = tokenDAO.getToken();
		
		System.out.println("token: "+t);
		*/
	}
}
