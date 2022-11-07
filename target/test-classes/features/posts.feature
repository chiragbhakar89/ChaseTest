Feature:
  As a user, I should be able to create posts, edit posts, delete posts

  Scenario: Create a post
    Given a valid user
    When user create following post: "Hello World!!"
    Then 201 response code should be returned

    ## this scenario will fail because the functionality is not implementedß
  Scenario: Invalid user should not be able to create a post
    Given an invalid user
    When user create following post: "Hello World!!ß"
    Then 401 response code should be returned

  Scenario: Edit a post
    Given user create following post: "Hello World!!"
    When user edits the post: "Hey World!!"
    Then 201 response code should be returned

  Scenario: Delete a post
    Given user create following post: "Hello World!!"
    When user delete a post
    Then 200 response code should be returned

     ## this scenario will fail because the functionality is not implementedß
  Scenario: Edit a non existent post
    Given user create following post: "Hello World!!"
    And user delete a post
    When user edits the post: "Hey World!!"
    Then 404 response code should be returned