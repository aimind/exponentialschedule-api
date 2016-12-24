package exponentialschedule.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import exponentialschedule.webservices.interfaces.*;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ExponentialScheduleWS {

	@WebMethod Output GenerateNewSchedule(Input input);	
}
