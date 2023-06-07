package com.example.CozaStore.controller;

import com.example.CozaStore.payload.request.ProductRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable int id){
        BaseResponse response = new BaseResponse();
        response.setData(iProductService.getProductByCategory(3));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *         Cách Upload File
     *
     * Cách 1: Chuyển file về dạng base64
     *   - Từ file chuyển thành chuỗi -> sau đó đẩy chuổi lên server
     *   - Server lấy chuỗi đó biến lại thành file ban đầu
     *   * Nhược điểm: kích thước file sẽ tăng khoảng x1.5
     *   * Ưu điểm: Vì file đã chuyển thành chuỗi nên lưu trữ được dưới dạng chuỗi(dễ lưu)
     *
     * Cách 2: Sử dụng Multipartfile
     *   - Mở 1 luồng đọc vào file (stream)
     *   -
     */
    @PostMapping("")
    public ResponseEntity<?> addProduct(@Valid ProductRequest productRequest)  {

        // Chuyển file về chuỗi base64
//        byte[] filename = file.getBytes();
//        String base64 = Base64.getEncoder().encodeToString();
        //Lấy tên file
//        String filename = file.getOriginalFilename();
//        String rootFolder= "D:\\IT\\Bootcamp Java 01\\GitHub\\Git_Cozastore\\image";
//        Path pathRoot = Paths.get(rootFolder);
//        if ((!Files.exists(pathRoot))){
//            //Tạo Folder
//            Files.createDirectory(pathRoot);
//        }
        //resolve tương đương như dấu "\\" -> pathRoot = D:\IT\Bootcamp Java 01\GitHub\Git_Cozastore\image\filename
//        Files.copy(file.getInputStream(),pathRoot.resolve(filename), StandardCopyOption.REPLACE_EXISTING);

        String filename = productRequest.getFile().getOriginalFilename();
        try {
            String rootFolder = "D:\\IT\\Bootcamp Java 01\\GitHub\\Git_Cozastore\\image";
            Path pathRoot = Paths.get(rootFolder);
            if (!Files.exists(pathRoot)) {
                Files.createDirectory(pathRoot);
            }
            Files.copy(productRequest.getFile().getInputStream(), pathRoot.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            iProductService.addProduct(productRequest);
        }catch (Exception e){

        }
        return new ResponseEntity<>(filename,HttpStatus.OK);
    }
}
