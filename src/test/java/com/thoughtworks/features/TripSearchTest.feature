Feature: MarsAir Trip Search

  @E2E
  Scenario Outline: Verify trip search flow without promo code
    Given Mark is on "MarsAir" home page
    When He selects "<departure>" and "<return>" for his trip
    And He clicks search
    Then He verifies the "<results>" about seat availability

    Examples:
      | departure | return                         | results                                                         |
      | July      | December (two years from now)  | Seats available!                                                |
      | July      | December                       | Unfortunately, this schedule is not possible. Please try again. |
      | July      | July (next year)               | Sorry, there are no more seats available.                       |

  @E2E
  Scenario Outline: Verify trip search flow without promo code
    Given Mark is on "MarsAir" home page
    When He selects "July" and "December (two years from now)" for his trip
    And he enters "<promo>" code
    And He clicks search
    Then he verifies the results with promo code "<message>"

    Examples:
      | promo       | message                                          |
      | AF3-FJK-418 | Promotional code AF3-FJK-418 used: 30% discount! |
      | JJ5-OPQ-320 | Promotional code JJ5-OPQ-320 used: 50% discount! |
      | !!x78       | Sorry, code !!x78 is not valid                   |