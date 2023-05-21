package com.example.CozaStore.controller;

import com.example.CozaStore.dto.UserDto;
import com.example.CozaStore.payload.request.SignUpRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Tên file bên BE sẽ đặt theo tên màn hình bên FE
 *
 *  Cấu trúc response chuẩn bên ngoài hay sử dụng
 *      statusCode: Mã lỗi của chương trình
 *      message: Những câu thông báo tương ứng với mã lỗi
 *      data: Dữ liệu trả ra nếu có (đây là dữ liệu trả ra cho FE xử lý)
 *
 *  Package payload : Chứa tất cả những file quy định request và respone của toàn bộ project
 *
 */
@RestController
@RequestMapping("/login")
// Cho phép domain khác gọi vào link API
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin (@RequestParam String username, @RequestParam String password){
        boolean isSuccess = loginService.checklogin(username,password);

        BaseResponse response = new BaseResponse();
        response.setMessage(isSuccess ? "Đăng nhập thành công" : "Đăng nhập thất bại");
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> insertUser (@RequestBody SignUpRequest signup){
        boolean isSuccess = loginService.insertUser(signup);

        BaseResponse response = new BaseResponse();
        response.setMessage(isSuccess ? "Đăng ký thành công" : "Đăng ký thất bại");
        response.setData(isSuccess);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
