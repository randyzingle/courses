package com.bms.workflow;

import java.util.List;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;
import com.amazonaws.services.simpleworkflow.model.DomainInfo;
import com.amazonaws.services.simpleworkflow.model.DomainInfos;
import com.amazonaws.services.simpleworkflow.model.ListDomainsRequest;

/*
 * This is the workflow starter which starts the WF execution
 */
public class GreeterWorker {

	public static void main(String[] args) throws Exception {
		ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);
		String swfAccessId = System.getenv("AWS_ACCESS_KEY_ID");
		String swfSecretKey = System.getenv("AWS_SECRET_ACCESS_KEY");
		String swfSecurityToken = System.getenv("AWS_SECURITY_TOKEN");
		BasicSessionCredentials credentials = 
				new BasicSessionCredentials(swfAccessId, swfSecretKey, swfSecurityToken);
		System.out.println(credentials.getAWSAccessKeyId());
		AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(credentials, config);
		service.setEndpoint("https://swf.us-east-1.amazonaws.com");
		
		String domain = "cuppett1606"; // needs to be a pre-created domain in SWF
		String taskListToPoll = "baldurdash";
		
//		DomainInfos dos = service.listDomains(new ListDomainsRequest());
//		List<DomainInfo> dlist = dos.getDomainInfos();
//		for (DomainInfo di: dlist) {
//			System.out.println(di.toString());
//		}
		
		ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
		aw.addActivitiesImplementation(new GreeterActivitiesImpl());
		aw.start();
		WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
		wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
		wfw.start();
		
		GreeterWorkflow greeter = new GreeterWorkflowImpl(); 
		greeter.greet();
	}

}
