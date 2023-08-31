Feature: Report
  Background: Tôi đã truy cập vào Tenant với tài khoản hợp lệ, đã có sẵn các folder report , Custom Report và bắt đầu sử dụng CustomReport
    Scenario: Verify Custom Report with Static Type
    Given Report page is opened
    When I add a new key with type Static and value "1000"
    Then I will see "1000" on the result

    Scenario: Verify Custom Report with RollUp Type With no Condition
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact
      And I choose Field ContactID
      And I Choose Count
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 1 Condition
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact
      And I Add new Condition with field Gender Equals Male
      And I choose Field ContactID
      And I Choose Count
      Then I will see the expected result


    Scenario: Verify Custom Report with RollUp Type With 1 Condition
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact
      And I Add new Condition with field Gender Equals Male
      And I choose Field ContactID
      And I Choose Count
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Sum

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Max

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Min

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Average


    Scenario: Verify Custom Report with RollUp Related
















