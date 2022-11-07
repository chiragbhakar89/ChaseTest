Feature:
  As a user I should be able to comment on a post.

  Scenario: Comment on an existing post
    Given an existing post
    When user comment following on the post: "This is a new comment"
    Then 201 response code should be returned

    # this scenario is failing right now because the api is not implemented correctly
  Scenario: Comment on an deleted post
    Given an existing post
    And user delete a post
    When user comment following on the post: "This is a another comment"
    Then 404 response code should be returned