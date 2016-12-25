package com.github.aimind.exponentialschedule_api;

import com.github.aimind.exponentialschedule_api.core.Constraint;
import com.github.aimind.exponentialschedule_api.core.ElementComponent;
import com.github.aimind.exponentialschedule_api.core.HourElement;
import com.github.aimind.exponentialschedule_api.enums.ConstraintTypeEnum;

import exponentialschedule.webservices.interfaces.Input;
import exponentialschedule.webservices.interfaces.Output;

public class AppTest {

	public static void main(String[] args) {
		
		Constraint constraint1 = new Constraint(5, 10, ConstraintTypeEnum.CONSECUTIVE_HOURS);
		
		ElementComponent element1 = new ElementComponent(1, "Teacher 1");
		element1.addConstraint(constraint1);
		
		HourElement hourElement1 = new HourElement(1, "Physics subject");
		hourElement1.addComponent(element1);
		
		try{
			Input input = new Input("http://localhost:8080/ExponentialScheduleWS/ExponentialScheduleWS", "test2", "test2", "A1B2C3D4", 10, 5);
			input.addHourDistribution(8);
			input.addHourElement(hourElement1);
		
			Output schedules = input.GenerateSchedule();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
