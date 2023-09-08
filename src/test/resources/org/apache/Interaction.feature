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
      When Khi có Email gửi đến Status Email Ticket = Unread
      And Mở Consolidated view của record và đọc mail
      Then Status Email Ticket = Read và Update thời gian đọc mail qua object Interaction thành ngày và giờ hiện tại

    Scenario: Khi có email của Ticket gửi ra => Update Trạng thái phản hồi Ticket => Đã phản hồi  => Trigger has change Trạng thái thay đổi => Update ngược về Interaction Incoming => Trạng thái Đã phản hồi.
      Given Trang Login UAT được mở
      When Màn hình Consolidated view của record thuộc object Ticket hiển thị
      And Khi gửi Email ra từ UCRM field Trạng thái phản hồi sẽ được update thành "Đã phản hồi"
      And Trang object Interaction được mở ra
      Then Field Trạng thái phản hồi Email1 được update thành "Đã phản hồi"

    Scenario: Khi Email Reply vào hệ thống => Update tại các Status Ticket về ban đầu: Status mail = Unread, Trạng thái phản hồi = Chưa phản hồi.
      Given Trang Login UAT được mở
      When Khi có Email reply vào UCRM => Status của ticket sẽ được update về "Unread"
      Then Field Trạng thái phản hồi Email2 được update thành "Chưa phản hồi"

    Scenario: Khi có Email phản hồi ra tiếp => hệ thống sẽ tự động Update lại trạng thái Ticket như luồng cũ
      Given Trang Login UAT được mở
      When Màn hình Consolidated view của record thuộc object Ticket hiển thị
      And Khi gửi Email ra từ UCRM field Trạng thái phản hồi sẽ được update thành "Đã phản hồi"
      And Trang object Interaction được mở ra
      Then Field Trạng thái phản hồi Email1 được update thành "Đã phản hồi"
