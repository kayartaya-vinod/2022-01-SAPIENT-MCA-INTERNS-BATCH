Feature: FactorialGenerator features

  Scenario: Generate factorial of 5
    Given I have a factorial generator
    When I pass 5 as parameter
    Then I should get 120 as factorial

  Scenario Outline: Generate factorial of <input>
    Given I have a factorial generator
    When I pass <input> as parameter
    Then I should get <expected> as factorial

    Examples: 
      | input | expected |
      |     1 |        1 |
      |     5 |      120 |
      |     4 |       24 |
      |     6 |      720 |
      |    10 |  3628800 |
