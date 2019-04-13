package com.iss.rs.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iss.rs.entity.Productinfo;
import com.iss.rs.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/lot")
public class LotController {
    //添加一个日志器
    private static final Logger logger = LoggerFactory.getLogger(LotController.class);

    @Resource(name = "ProductService")
    private ProductService productService;

    //映射一个action
    @RequestMapping(value = "/getProduct.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, List<String>> getProduct() throws Exception {
        //输出日志文件
        logger.info("/getProduct.do");
        List<Productinfo> product = productService.getAllProduct();
        Map<String, List<String>> resultMap = new HashMap<>();
        product.stream().forEach(p -> {
            String head = p.getProductType().substring(0, 1);
            if (resultMap.containsKey(head)) {
                List<String> list = resultMap.get(head);
                list.add(p.getProductType());
                resultMap.put(head, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(p.getProductType());
                resultMap.put(head, list);
            }
        });
        return resultMap;
    }

    @RequestMapping(value = "/getProductType.do", produces = "application/json")
    @ResponseBody
    public List<String> getProductType(@RequestBody String data) throws Exception {
        //输出日志文件
        logger.info("/getProductType.do");
        Gson gson = new Gson();
        String series = gson.fromJson(data, JsonObject.class).get("series").getAsString();
        System.out.println(series);
        List<String> productType = productService.getProductType(series);
        return productType;
    }
}
