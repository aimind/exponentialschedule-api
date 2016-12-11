package com.github.aimind.exponentialschedule_api.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.github.aimind.exponentialschedule_api.*;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ExponentialScheduleWS {

	@WebMethod Output GenerateNewSchedule(Input input);	
}
