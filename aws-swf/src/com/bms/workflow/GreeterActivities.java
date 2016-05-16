package com.bms.workflow;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities;
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions;

/* 
 * The flow framework will see these annotations and will generate an 
 * activities client class
 */
@ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds=300,
		defaultTaskStartToCloseTimeoutSeconds=10)
@Activities(version="1.0")
public interface GreeterActivities {
	public String getName();
	public String getGreeting(String name);
	public void say(String what);
}
