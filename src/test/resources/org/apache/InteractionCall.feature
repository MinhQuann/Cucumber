Feature: InteractionCall C247 Cloud
  Background: Đã login vào hệ thống tài khoản User Call 247 Cloud
    Given Màn hình Login UCRM hiển thị

    Scenario: Kiểm tra thông tin Owner, và general field của record Interaction
      When thực hiện cuộc gọi
      Then Interaction object sẽ assigned to người thực hiện cuộc gọi
      And The Interaction Detail Call sẽ asigned to người thực hiện cuộc gọi

    Scenario: Kiểm tra thông tin record Interaction Detail được tạo ra có linking đến record Interaction
      When thực hiện cuộc gọi
      And End call khi chưa kịp Popup thông tin khách hàng
      Then hiển thị đầy đủ thông tin các field của Interaction type Call cũ.

    Scenario: SĐT = 0, Kiểm tra Interaction được ghi cho contact được tìm kiếm trên Global Search trên Popup
      When Thực hiện cuộc gọi khi SĐT chưa tồn tại trong Contact
      And Bắt máy cuộc gọi
      And Tìm thông tin Contact khác trên CRM
      And Chọn Contact để ghi Interaction
      Then Interaction sẽ được ghi cho Contact trên CRM

    Scenario: Kiểm tra Interaction được tạo khi tạo Contact trên list popup có dùng Global Search
      When Thực hiện cuộc gọi khi SĐT chưa tồn tại trong Contact
      And Bắt máy cuộc đời
      And Bấm button Create trong List Popup
      And Nhập đầy đủ thông tin
      Then Interaction được ghi cho Contact được tạo trên Popup

    Scenario:  SĐT >= 2 Contact - Không chọn Contact và đóng tab
      When Thực hiên cuộc gọi
      And Bắt máy cuộc gọi
      And Không chọn Contact và đóng tab Popup
      Then Interaction được tạo sẽ không có thông tin Contact linking
      And  Interaction vãn sẽ có thông tin Linking đê record được tạo từ Trigger Interaction

    Scenario:  SĐT >=2 Contact - Có chọn 1 Contact rồi back lại chọn Contact khác sau khi End Call
      When Thực hiện cuộc gọi



