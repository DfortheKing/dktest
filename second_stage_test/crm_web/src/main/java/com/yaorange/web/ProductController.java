package com.yaorange.web;

import com.yaorange.entity.Products;
import com.yaorange.service.ProductService;
import com.yaorange.utils.Pagination;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource(name = "productService")
    private ProductService productService;

    @RequestMapping("/page/{current}/{pageSize}")
    @ResponseBody
    public Pagination getPage(@PathVariable Integer current,@PathVariable Integer pageSize){
        Pagination page = productService.getPage(current, pageSize);
        return page;
    }

    @PostMapping("/add/{fileName}")
    public String add(@RequestBody Products products,@PathVariable String fileName){
        System.out.println("fileName=="+fileName+".jpg");
        if(fileName==null||fileName==""){
            products.setFlag("1");
            productService.addProduct(products);
            return "ok";
        }else{
            products.setFlag("1");
            products.setPimg("products/"+fileName+".jpg");
            productService.addProduct(products);
            return "ok";
        }

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){

        System.out.println("id=="+id);
        Products product = productService.getOneById(id);
        product.setFlag("0");
        productService.deleteProduct(product);
        return "ok";
    }

    @PostMapping("/importCustomer")
    public Map<String,Object> importCustomer(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        //返回的消息对象
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("status",false);
        if(file.isEmpty()){
            msgMap.put("msg","请选择上传文件");
            return msgMap;
        }

        //获取文件存储路径

        String realPath = request.getServletContext().getRealPath("/upload/products");
        System.out.println("realPath======"+realPath);

        String filename = file.getOriginalFilename();
        //创建File对象
        File uploadFile = new File(realPath, filename);
        //判断是否需要创建目录
        if(!uploadFile.getParentFile().exists()){//当前File对象的目录不存在
            uploadFile.mkdirs();
        }
        //写入文件
        file.transferTo(uploadFile);
        msgMap.put("status",true);
        msgMap.put("msg","上传成功");
        msgMap.put("fileName",filename);
        System.out.println("上传成功......");
        return msgMap;
    }

}
