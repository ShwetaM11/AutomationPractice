1	Setup and Configuration for a Cucumber Framework (Prerequisites)

	Install Java (JDK 11.0.7)
	Install Cucumber plug-in and Natural plug-in in Eclipse through Market Place
	Set Environment Variable for
	Java Home
	Maven Home (3.6.3)
	
	Note: I have mentioned the versions which I used. If this configuration is present in the system then no need to apply any configuration.

2	Process to Execute the test automation project.

	Run Project in Eclipse 
	Open TestRun.java(.\AutomationPractice\src\test\java\com\automationpractice\TestRunner\TestRun.java) and 
	Run As --> Junit Test 
	After the successful run, refresh the project to verify the logs.
	Go to AutomationPractice-->Log-->application.html, application.log, testlog.log
	To verify the test output in html format, go to test-output-->index.html report.
	To verify the test output in JSON format Go to test-output--> cucumber.json
	To run the project with Maven, go to pom.xml-->Run as-->Maven test

3 Process to execute the automation suit in parallel

	To run the parallel execution, go to pom.xml-->Run as-->Maven install
	Here in test log, you will find the output as [pool-1-thread-1]  thread for parallel testing.
	To verify the log, go to test-output-->application.log and all results will be displayed on console.
	
4 Process to execute the automation suit  in cmd(command line)

	To run the suit in CMD,
	Open CMD --> Give the path till project folder (ex.- cd D:/AutomationProject)
	Run with "mvn clean test"
	
5 Process to run the test suits in MAC and Linux Machine	

	To run the suit in MAC machine, Go to the config.properties file and remove the comments for MAC Configuration.
	To run the suit in Linux machine, Go to the config.properties file and remove the comments for Linux Configuration.
	Make sure that at a time only one configuration should be activate.
	
	Note: I have automated the scripts and passed all scenarios with windows configuration.
	
