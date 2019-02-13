package javabeat.net.articles.spring.ibatis;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


public class JsrClientApplication {

	public static void main(String[] args) {

		
		Resource resource = new FileSystemResource(
				"C:\\Users\\Mahesh\\AllWorkspaces\\POCsWorkspace\\IbatisSpring\\src\\main\\java\\javabeat\\net\\articles\\spring\\ibatis\\spring-ibatis.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		JsrDaoImpl jsrDao = (JsrDaoImpl) beanFactory.getBean("jsrDao");

		
		System.out.println("Inserting JSR's");
		insertJsrs(jsrDao);

		System.out.println("Listing all JSR's");
		List<Jsr> allJsrs = jsrDao.selectAllJsrs();
		System.out.println(allJsrs.size());
		for (Jsr aJsr : allJsrs) {
			System.out.println(aJsr);
		}

	/*	System.out.println("Selecting a JSR by Id 'JSR002'");
		Jsr aJsr = jsrDao.selectJsrById("JSR002");
		System.out.println(aJsr);*/

//		System.out.println("Updating a JSR");
//		Jsr fourthJsr = allJsrs.get(3);
//		fourthJsr.setName("Servlets-Updated");
//		fourthJsr.setDescription("Java Servlets and JSP-Updated");
//		fourthJsr.setSpecLead("Belkin-Updated");
//		jsrDao.updateJsr(fourthJsr);

		System.out.println("Deleting a JSR");
		jsrDao.deleteJsr("JSR002");
	}

	static void insertJsrs(JsrDaoImpl jsrDao) {
		Jsr newJsr = createJsr("JSR001", "JMX", "Java Management Extension", "McManus");
		jsrDao.insertJsr(newJsr);

		newJsr = createJsr("JSR002", "XML", "XML Parsing Spec", "Rajiv");
		jsrDao.insertJsr(newJsr);

	/*	newJsr = createJsr("JSR003", "JDO", "Java Data Objects", "Russell");
		jsrDao.insertJsr(newJsr);

		newJsr = createJsr("JSR004", "Servlets", "Java Servlets and JSP", "Belkin");
		jsrDao.insertJsr(newJsr);*/
	}

	static Jsr createJsr(String id, String name, String description, String specLead) {
		Jsr newJsr = new Jsr();
		newJsr.setId(id);
		newJsr.setName(name);
		newJsr.setDescription(description);
		newJsr.setSpecLead(specLead);
		return newJsr;
	}
}