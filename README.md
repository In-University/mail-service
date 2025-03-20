# mail-service
Võ Minh Khoa
Lê Anh Tú
# Project Giữa kỳ - Backend

Dự án cung cấp các API để quản lý danh mục, sản phẩm, xác thực người dùng thông qua hệ thống mail xác nhận OTP. Dự án này được xây dựng dựa trên Spring Boot 3, MySQL, Spring JPA, Spring Security, JWT, send mail với Java Mail, Lombok.

## Mục Lục

- [Giới thiệu](#giới-thiệu)
- [Các Controller](#các-controller)
  - [CategoryController](#categorycontroller)
  - [ProductController](#productcontroller)
  - [AuthenticationController](#authenticationcontroller)
  - [UserController](#usercontroller)
- [Cách chạy dự án](#cách-chạy-dự-án)
- [Liên hệ](#liên-hệ)

---

## Giới thiệu

Dự án  cung cấp các endpoint API phục vụ cho việc:
- Quản lý danh mục và sản phẩm.
- Xác thực và cấp phát token cho người dùng.
- Quản lý đăng ký, xác nhận OTP, quên mật khẩu và cập nhật thông tin người dùng.
---

## Các Controller
Dự án hỗ trợ Swagger tại [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
### CategoryController

- **Endpoint:** `/api/categories`
- **Mô tả:**  
  Quản lý các danh mục và cung cấp API để lấy danh sách danh mục và sản phẩm theo danh mục.
- **Các phương thức:**
  - `GET /api/categories`  
    Trả về danh sách tất cả các danh mục.
  - `GET /api/categories/{id}/products`  
    Lấy danh sách các sản phẩm theo mã danh mục.

---

### ProductController

- **Endpoint:** `/api/products`
- **Mô tả:**  
  Quản lý sản phẩm và cung cấp API để lấy danh sách tất cả các sản phẩm.
- **Các phương thức:**
  - `GET /products` (hoặc endpoint tương tự)  
    Trả về danh sách tất cả sản phẩm.

---

### AuthenticationController

- **Endpoint:** `/auth`
- **Mô tả:**  Quản lý các chức năng xác thực người dùng, bao gồm việc kiểm tra tính hợp lệ của token và đăng nhập.
- **Các phương thức:**
  - `GET /auth/introspect`  
    Kiểm tra và xác thực token từ header `Authorization`.  
    - Nếu header không hợp lệ hoặc không bắt đầu bằng "Bearer ", trả về lỗi.
  - `POST /auth/login`  
    Xác thực thông tin đăng nhập và trả về token khi đăng nhập thành công.

---

### UserController

- **Endpoint:** /
- **Mô tả:**  
  Quản lý các chức năng liên quan đến người dùng như đăng ký, xác nhận OTP, quên mật khẩu và cập nhật thông tin cá nhân.
- **Các phương thức:**
  - `POST /register`  Đăng ký người dùng mới và gửi OTP xác minh email.
  - `POST /validate-otp-register`   Xác nhận OTP đã gửi khi đăng ký và kích hoạt tài khoản người dùng.
  - `POST /forgot-password`  
    Gửi OTP đến email khi người dùng quên mật khẩu.
- `POST /reset-password`  Xác nhận OTP và cập nhật mật khẩu mới cho người dùng.
  - `GET /test-mail?mail=`  Endpoint dùng để kiểm tra chức năng gửi mail OTP (chỉ dành cho test).
  - `POST /validate-otp`  Xác thực OTP từ người dùng.
  - `GET /profile`  Lấy thông tin hồ sơ của người dùng dựa trên token xác thực gửi trong header `Authorization`.
---
## Cách chạy dự án

1. **Cài đặt JDK và Maven:**  
   Đảm bảo đã cài đặt JDK 17 (hoặc phiên bản phù hợp) và Maven.
2. **Clone repository:**
   ```bash
   git clone https://github.com/In-University/mail-service
   cd mail-service
Build và chạy ứng dụng:
   ```bash
mvn clean install
mvn spring-boot:run
