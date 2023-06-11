package com.example.CozaStore.controller;

import com.example.CozaStore.exception.FileNotFoundException;
import com.example.CozaStore.payload.request.ProductRequest;
import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.*;
import java.util.Base64;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Value("${root.file.path}")
    private String rootPath;

    @Autowired
    IProductService iProductService;

    Logger log = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/file/{filename}")
    public ResponseEntity<?> downloadFileProduct(@PathVariable String filename) {
        try {
            // Định nghĩa đường dẫn folder để lưu file
            Path path = Paths.get(rootPath);

            Path pathFile = path.resolve(filename);
            Resource resource = new UrlResource(pathFile.toUri());
            if (resource.exists() || resource.isReadable()){
            // Cho phép download file
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
                }else {
                throw new FileNotFoundException ("Không tìm thấy file");
//                throw new RuntimeException("Không tìm thấy file");
                }
            }catch(Exception e){
                throw new FileNotFoundException ("Không tìm thấy file");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByCategoryId(
            HttpServletRequest request,
            @PathVariable int id){

        log.trace("trace log");
        log.debug("debug log");
        log.info("ìno log");
        log.warn("warn log");
        log.error("error log");

        String host = request.getHeader("host");
        BaseResponse response = new BaseResponse();
        response.setData(iProductService.getProductByCategory(host ,3));

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
            String rootFolder = rootPath;
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
