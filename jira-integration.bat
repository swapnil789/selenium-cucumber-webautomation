curl -H "Content-Type: multipart/form-data" -u username:password -F "file=@target/cucumber-reports/Cucumber.xml" -k https://jira-dev-muc.abc.com/rest/raven/1.0/import/execution/junit?projectKey=abc
