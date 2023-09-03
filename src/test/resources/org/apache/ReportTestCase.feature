Feature: Custom Report

  Scenario: Filter data in reports
    Given Log in to the UCRM with a valid user account
    When The custom report page is displayed
    And Apply filter conditions to limit data in the report.
    And I click Save Report and Noti "Success"
    And I Click RunReport Btn
    Then I see Expected Result and Noti "Success"

  Scenario: Update and Del Report
    Given The custom report page is displayed
    When I Click Del btn
    Then The Key is deleted

  Scenario: Caculated in CustomReport
    Given The custom report page is displayed
    When I Add 10 key with Static, RollUp
    And I Add 5 Key with Related Type
    And I click Save Report and Noti "Success"
    And I Click RunReport Btn
    Then The Result is displays



