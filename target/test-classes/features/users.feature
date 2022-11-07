Feature:
  As an admin, I should be able to get the list of users.

  Scenario: Get users
    Given admin access
    When I get users
    Then 200 response code should be returned