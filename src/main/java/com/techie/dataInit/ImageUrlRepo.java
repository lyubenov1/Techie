package com.techie.dataInit;

import com.techie.dataInit.data.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ImageUrlRepo {

    private final Map<List<String>, List<String>> imageMap = new HashMap<>();

    public ImageUrlRepo() {
        initializeData();
    }

    private void initializeData() {
        imageMap.put(SmartPhoneData.iphone15_black_models, SmartPhoneData.iphone15_black_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_blue_models, SmartPhoneData.iphone15_blue_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_green_models, SmartPhoneData.iphone15_green_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_pink_models, SmartPhoneData.iphone15_pink_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_yellow_models, SmartPhoneData.iphone15_yellow_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_blue_models, SmartPhoneData.iphone14_blue_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_midnight_models, SmartPhoneData.iphone14_midnight_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_purple_models, SmartPhoneData.iphone14_purple_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_starlight_models, SmartPhoneData.iphone14_starlight_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_blue_models, SmartPhoneData.iphone13_blue_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_green_models, SmartPhoneData.iphone13_green_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_starlight_models, SmartPhoneData.iphone13_starlight_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_midnight_models, SmartPhoneData.iphone13_midnight_imageUrls);
        imageMap.put(SmartPhoneData.iphoneSE_midnight, SmartPhoneData.iphoneSE_midnight_imageUrls);
        imageMap.put(SmartPhoneData.iphoneSE_red, SmartPhoneData.iphoneSE_red_imageUrls);
        imageMap.put(SmartPhoneData.iphoneSE_starlight, SmartPhoneData.iphoneSE_starlight_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_pro_black_models, SmartPhoneData.iphone15_pro_black_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_pro_blue_models, SmartPhoneData.iphone15_pro_blue_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_pro_white_models, SmartPhoneData.iphone15_pro_white_imageUrls);
        imageMap.put(SmartPhoneData.iphone15_pro_natural_models, SmartPhoneData.iphone15_pro_natural_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_pro_gold_models, SmartPhoneData.iphone14_pro_gold_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_pro_purple_models, SmartPhoneData.iphone14_pro_purple_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_pro_white_models, SmartPhoneData.iphone14_pro_white_imageUrls);
        imageMap.put(SmartPhoneData.iphone14_pro_spaceBlack_models, SmartPhoneData.iphone14_pro_spaceBlack_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_pro_gold_models, SmartPhoneData.iphone13_pro_gold_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_pro_graphite_models, SmartPhoneData.iphone13_pro_graphite_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_pro_silver_models, SmartPhoneData.iphone13_pro_silver_imageUrls);
        imageMap.put(SmartPhoneData.iphone13_pro_sierraBlue_models, SmartPhoneData.iphone13_pro_sierraBlue_imageUrls);
    }

    public Map<List<String>, List<String>> getImageMap() {
        if (imageMap.isEmpty()) {
            initializeData(); // Populate the map if it's empty
        }
        return imageMap;
    }
}
