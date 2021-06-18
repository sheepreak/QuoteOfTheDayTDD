# Quote of the day TDD Kata

-----
## Choices

- Spring boot for familiarity and JUnit
- MockMVC for integration tests so tests can be launched independently from the implementation and can allow end to end API tests (full request -> response processing)
-----
## Steps

#### TDD 1

First test consists of calling the not-existing yet generic endpoint and just get an OK status (HTTP 200)

[X] Write the test and expect a 200 -> expected to fail

[X] Implement the first endpoint to return a 200

#### TDD 2

Now we'll have to implement getting a quote from the endpoint we created

[ ] Write the test and check the returned quote came from the YAML file

[ ] Alter the first endpoint so it returns a quote (and status should still be 200)

#### TDD 3

TBC