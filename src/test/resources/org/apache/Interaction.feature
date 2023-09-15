Feature: Interaction
  Background: Interaction:
  - ID Ticket tạm (Text)

  - Thời gian đọc email (Datetime-local)
  - Thời gian phản hồi email (Datetime-local)
  - Tổng thời gian xử lý (Formula - Date diff)

  - Trạng thái phản hồi Email (Text)
  - Status Email
  - Thứ (Formula - Date to part - weekly): Lấy ra thứ của field Create date


  Ticket:
  - Nguồn (Select): Email, Chat,...
  - Status Email (Select): Read, Unread.
  - Thời gian đọc Email (Datetime-local)

  Luồng:

  Ticket tạo mới: có mapping các field trong Rule.
  - Status Email: Unread
  - Nguồn: Email
  - Trạng thái phản hồi: Chưa phản hồi.

  Ticket Reply: Có mapping Reply email đối với các field
  - Status Email: Unread
  - Trạng thái phản hồi: Chưa phản hồi

    Scenario: Khi đọc mail: Status Email Ticket = Read => Update lại Thời gian đọc email record Interaction Incoming
      Given Trang Login UAT được mở
      When Khi có Email gửi đến Mở màn hình Object Ticket
      And Status Email Ticket = "Unread"
      And Mở Consolidated view của record và đọc mail
      And Status Email Ticket = "Read"  Update
      Then thời gian đọc mail qua object Interaction thành ngày và giờ hiện tại

    Scenario: Khi có email của Ticket gửi ra => Update Trạng thái phản hồi Ticket => Đã phản hồi  => Trigger has change Trạng thái thay đổi => Update ngược về Interaction Incoming => Trạng thái Đã phản hồi.
      Given Màn hình Consolidated view của record thuộc object Ticket hiển thị
      When Khi gửi Email ra từ UCRM
      And field Trạng thái phản hồi sẽ được update thành Đã phản hồi
      And Trang object Interaction được mở ra
      Then Field Trạng thái phản hồi Email1 được update thành Đã phản hồi
#
    Scenario: Khi Email Reply vào hệ thống => Update tại các Status Ticket về ban đầu: Status mail = Unread, Trạng thái phản hồi = Chưa phản hồi.
      Given Object Ticket Page được mở ra
      When Khi có Email reply vào UCRM
      And  Status Email Ticket = "Unread"
      Then Field Trạng thái phản hồi Email được update thành Chưa phản hồi
#
    Scenario: Khi có Email phản hồi ra tiếp => hệ thống sẽ tự động Update lại trạng thái Ticket như luồng cũ
      Given Màn hình Consolidated view của Email vừa được phản hồi mở ra
      When Khi gửi Email ra từ UCRM
      And Trạng thái phản hồi sẽ được update thành Đã phản hồi
      And Trang object Interaction được mở ra
      Then Field Trạng thái phản hồi Email1 được update thành Đã phản hồi
