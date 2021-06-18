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

[X] Write the test and check the returned quote came from the YAML file

[X] Alter the first endpoint so it returns a quote (and status should still be 200)

#### TDD 3 

Next step is implementing the fact that the quote returned by two successive calls will never be systematically the same

[X] Write the test that makes 2 successive calls and checks that the content differs

[X] Alter the endpoint and add a randomizer

Usage of SecureRandom allows more efficient way of returning different quotes, although it can happen so this test might have to be pruned. But it allows the implementation of the randomizer so I'll keep it there.

#### TDD 4

Now that our endpoint returns a random quote, add the parameter that will allow a search

[ ] Write the test that will call our endpoint with a query parameter and returns a quote from the library containing our parameter

[ ] Write another test that returns a 404 if no quote contains the given parameter

[ ] Alter the endpoint to allow this parameter

#### TDD 5 

An issue with our previous addition is that it should only work when the parameter is a single word (no special characters or spaces)

[ ] Write the test that will call our endpoint with a bad parameter and shall return a 400 error

[ ] Implement this mechanic