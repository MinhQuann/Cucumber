Feature: Login

  Scenario: The Validate mess should be shown for blank credential
    Given The login page page is showed1
    When The user login with blank value for both username and password
    Then The msg "Please input your username!" will be showed for username and "Please input your password!" for pwd

  Scenario: The error msg should be show for wrong pwd and wrong username
    Given  The login page page is showed1
    When The user attempt to login with wrong username "quanbnm12314@gmail.com" and wrong pwd "123456678x@X"
    Then The msg "Username or password incorrect. Please check again" should be showed

  Scenario: The Dashboard Title will be show when login Success
    Given The login page page is showed1
    When The user attempt to login with username "quanbnm003@yopmail.com" and pwd "12345678x@X"
    Then The title "Dashboard" should be showed

  Scenario: The Dashboard Title will be show when login Success after Dev change Email
    Given The login page page is showed1
    When The user attempt to login with username and password in ExcelFile and "Dashboard" title is showed
    Then Quit