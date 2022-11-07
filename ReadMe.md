##How to run this Project
Go to project root directory and run following commands: 
- mvn clean install
- mvn test

##Improvements
- Creating a CI pipeline for the test execution
- Integrating the cucumber reports with CI runs to generate run artifacts
- Currently, the tests only reflects integration between api's and due to the limitations of the api's there are no end to end tests but, we should follow the testing pyramid and hence create less tests at end to end level.
- Using builder pattern to serialize/deserialize the request/responses for more complex api's ( can use Immutables for that).
- Some tests are designed to fail the execution since the api implementation is limited, please open respective feature file to understand more.
