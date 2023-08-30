Feature: Login

  Scenario: The Validate mess should be shown for blank credential
    Given The login page page is showed1
    When The user login with blank value for both username and password
    Then The msg "Vui lòn nhập dữ liệu" will be showed for username and "Vui lòng nhập dữ liệu" for pwd

  Scenario: The error msg should be show for wrong pwd
    Given  The login page page is showed1
    When The user attempt to login with username "quanbnm@basebs.com" and pwd "123456678x@X"
    Then The msg "" should be showed