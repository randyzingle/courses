package com.bms.workflow;

/*
 * This is the workflow starter which starts the WF execution
 */
public class GreeterMain {

	public static void main(String[] args) {
		GreeterWorkflow greeter = new GreeterWorkflowImpl();
		greeter.greet();
	}

}
