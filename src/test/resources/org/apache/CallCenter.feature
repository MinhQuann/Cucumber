Feature: : Call Center
  Scenario:Thực hiện Save nhưng các giá trị ở PickList vẫ hiển thị
    Given The login page page is showed
    When Đợi 10s
    When KH mới sẽ được set "Default" name
    When Field Category được mở khi đã được setting PickList Dependency
    When Thực hiện chọn Category "Kiểm tra GD"
    When Thực hiện chọn Topic LV1 "Kiểm tra GD DV Thẻ"
    When Thực hiện chọn Topic LV2 "Thẻ Khác"
    When Thực hiện chọn Topic LV3 "Vấn tin GD; hạn mức"
    When Thực hiện Save
    Then "Kiểm tra GD", "Kiểm tra GD DV Thẻ","Thẻ Khác","Vấn tin GD; hạn mức" vẫn hiển thị
    
