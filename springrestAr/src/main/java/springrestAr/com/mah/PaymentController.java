package springrestAr.com.mah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payment")
public class PaymentController {
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;

	@Autowired
	PersonDAO personDAO;

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
		BaseResponse response = new BaseResponse();
		if (sharedKey.equalsIgnoreCase(key)) {
	

			int userId = request.getUserId();
			String itemId = request.getItemId();
			double discount = request.getDiscount();
			// Process the request
			// ....
			// Return success response to the client.
			response.setStatus(SUCCESS_STATUS);
			response.setCode(CODE_SUCCESS);
		} else {
			response.setStatus(ERROR_STATUS);
			response.setCode(AUTH_FAILURE);
		}
		return response;
	}

	@RequestMapping(value = "/pay1", method = RequestMethod.GET)
	public BaseResponse pay1() {
		BaseResponse response = new BaseResponse();
		response.setStatus(ERROR_STATUS);
		response.setCode(AUTH_FAILURE);
		return response;
	}

	@RequestMapping(value = "/pay2", method = RequestMethod.GET)
	public String pay2() {
		Person p = new Person((long) 11, 11, "Mahesh", "napte");
		System.out.println("Before Inserting");
		personDAO.createPerson(p);
		System.out.println("done");
		
		return "Hi Mahesh";
	}
}