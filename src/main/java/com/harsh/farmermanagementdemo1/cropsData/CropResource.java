package com.harsh.farmermanagementdemo1.cropsData;

import com.harsh.farmermanagementdemo1.authenticate.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/farmers")
public class CropResource {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private JwtUtil jwtUtil;
    @GetMapping("/view_Crops")
    public CropItems getAllCrops(){
       CropItems items = restTemplate.getForObject("http://crop-info-service/crops/",CropItems.class);
       return items;
    }

    @PostMapping("/add_Crops")
    public CropItem addCropItem(@RequestHeader("Authorization") String token,
                                @RequestBody RequestItem cropItem){
        String userEmail = null;
        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);
            userEmail = jwtUtil.extractUsername(jwtToken);
        }
        cropItem.setEmail(userEmail);

        CropItem item = restTemplate.postForObject("http://crop-info-service/crops/",
                cropItem,CropItem.class);
        return item;
    }

}
