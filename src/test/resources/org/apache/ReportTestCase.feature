Feature: Report
  Background: Tôi đã truy cập vào Tenant với tài khoản hợp lệ, đã có sẵn các folder report , Custom Report và bắt đầu sử dụng CustomReport
    Scenario: Verify Custom Report with Static Type
    Given Report page is opened
    When I add a new key with type Static and value "1000"
    Then I will see "1000" on the result

  Scenario: Verify Custom Report with Static Type
    Given Report page is opened
    When I add a new key with type Static and value "-10"
    Then I will see "-10 " on the result


    Scenario: Verify Custom Report with RollUp Type With no Condition and Aggregation =  Count
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And I choose Field ContactID
      Then I will see the expected result


    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Sum
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And I add new Condition And I choose field test select option And I choose type (IS EMPTY) And I choose Field MoneyShit And I Choose Sum
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Max
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And  I choose Field MoneyShit And I choose Type ( And I choose Field MoneyShit And I Choose Max
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Min
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And I choose Field MoneyShit And I Choose Min
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 1 Condition and Aggregation = Average
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And I choose Field MoneyShit And I Choose Average
      Then I will see the expected result

    Scenario: Verify Custom Report with RollUp Type With 2 Condition and Aggregation =  Sum
      Given Report page is opened
      When  I add new key with Type RollUp
      And  I choose Object Contact And I choose Field MoneyShit And I Choose Sum
      Then I will see the expected result

  Scenario: Verify Custom Report with RollUp Type With 2 Condition and Aggregation =  Max
    Scenario: Verify Custom Report with RollUp Type With 2 Condition and Aggregation =  Min
    Scenario: Verify Custom Report with RollUp Type With 2 Condition and Aggregation = Average

    Scenario: Verify Custom Report With Related Type (Key + Key)
    Scenario: Verify Custom Report With Related Type (Key - Key)
    Scenario: Verify Custom Report With Related Type (Key * Key)
    Scenario: Verify Custom Report With Related Type (Key / Key)
    Scenario: Verify Custom Report With Related Type (Key + Key)
    Scenario: Verify Custom Report With Related Type (Key + Key)*(key+Key)/(key*Key)
    Scenario: Kiểm tra check box Show khi run Report
    Scenario: Kiểm tra check box Hide khi run Report
    Scenario: Xóa Key
    Scenario: Xóa Key với trường hợp đang sử dụng
    Scenario: Verify Notification After Run Report















