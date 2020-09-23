package com.automation.emailtrigger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.kpit.mailutility.SendMail;
import com.kpit.managers.FileReaderManager;

public class EmailTrigger {

	@Test
	public void emailTrigger() {
		try {
			String project_name = "Release Management Webapp";
			String report_path = System.getProperty("user.dir") + "\\target\\cucumber-reports\\Automation_Report.html";
			List<String> recipients = new ArrayList<String>();
			if (null != recipients && !"".equals(recipients)) {
				recipients = Arrays.asList(
						FileReaderManager.getInstance().getConfigReader().getEmailRecepients().split("\\s*,\\s*"));
			}
			SendMail.sendSeleniumTestSuiteEmail(project_name, recipients, report_path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
