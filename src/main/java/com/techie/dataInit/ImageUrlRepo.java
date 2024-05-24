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

        imageMap.put(SmartPhoneData.galaxy_a55_blue, SmartPhoneData.galaxy_a55_blue_urls);
        imageMap.put(SmartPhoneData.galaxy_a55_navy, SmartPhoneData.galaxy_a55_navy_urls);
        imageMap.put(SmartPhoneData.galaxy_a55_lilac, SmartPhoneData.galaxy_a55_lilac_urls);
        imageMap.put(SmartPhoneData.galaxy_a55_lemon, SmartPhoneData.galaxy_a55_lemon_urls);
        imageMap.put(SmartPhoneData.galaxy_z_flip_5_cream, SmartPhoneData.galaxy_z_flip_5_cream_urls);
        imageMap.put(SmartPhoneData.galaxy_z_flip_5_graphite, SmartPhoneData.galaxy_z_flip_5_graphite_urls);
        imageMap.put(SmartPhoneData.galaxy_z_flip_5_lavender, SmartPhoneData.galaxy_z_flip_5_lavender_urls);
        imageMap.put(SmartPhoneData.galaxy_z_flip_5_mint, SmartPhoneData.galaxy_z_flip_5_mint_urls);
        imageMap.put(SmartPhoneData.galaxy_z_fold_5_black, SmartPhoneData.galaxy_z_fold_5_black_urls);
        imageMap.put(SmartPhoneData.galaxy_z_fold_5_blue, SmartPhoneData.galaxy_z_fold_5_blue_urls);
        imageMap.put(SmartPhoneData.galaxy_z_fold_5_cream, SmartPhoneData.galaxy_z_fold_5_cream_urls);
        imageMap.put(SmartPhoneData.galaxy_S23_black, SmartPhoneData.galaxy_S23_black_urls);
        imageMap.put(SmartPhoneData.galaxy_S23_cream, SmartPhoneData.galaxy_S23_cream_urls);
        imageMap.put(SmartPhoneData.galaxy_S23_green, SmartPhoneData.galaxy_S23_green_urls);
        imageMap.put(SmartPhoneData.galaxy_S23_graphite, SmartPhoneData.galaxy_S23_graphite_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_black, SmartPhoneData.galaxy_S24_black_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_grey, SmartPhoneData.galaxy_S24_grey_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_violet, SmartPhoneData.galaxy_S24_violet_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_yellow, SmartPhoneData.galaxy_S24_yellow_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_ULTRA_black, SmartPhoneData.galaxy_S24_ULTRA_black_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_ULTRA_grey, SmartPhoneData.galaxy_S24_ULTRA_grey_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_ULTRA_yellow, SmartPhoneData.galaxy_S24_ULTRA_yellow_urls);
        imageMap.put(SmartPhoneData.galaxy_S24_ULTRA_violet, SmartPhoneData.galaxy_S24_ULTRA_violet_urls);

        imageMap.put(SmartPhoneData.nova_Y91_silver, SmartPhoneData.nova_Y91_silver_urls);
        imageMap.put(SmartPhoneData.nova_10SE_black, SmartPhoneData.nova_10SE_black_urls);
        imageMap.put(SmartPhoneData.nova_12SE_green, SmartPhoneData.nova_12SE_green_urls);
        imageMap.put(SmartPhoneData.nova_10SE_silver, SmartPhoneData.nova_10SE_silver_urls);
        imageMap.put(SmartPhoneData.pura70_black, SmartPhoneData.pura70_black_urls);
        imageMap.put(SmartPhoneData.pura70_white, SmartPhoneData.pura70_white_urls);
        imageMap.put(SmartPhoneData.pura70_pro_black, SmartPhoneData.pura70_pro_black_urls);
        imageMap.put(SmartPhoneData.pura70_pro_white, SmartPhoneData.pura70_pro_white_urls);
        imageMap.put(SmartPhoneData.pura70_ultra_black, SmartPhoneData.pura70_ultra_black_urls);
        imageMap.put(SmartPhoneData.pura70_ultra_green, SmartPhoneData.pura70_ultra_green_urls);

        imageMap.put(SmartPhoneData.nothing2_black, SmartPhoneData.nothing2_black_urls);
        imageMap.put(SmartPhoneData.nothing2_white, SmartPhoneData.nothing2_white_urls);
        imageMap.put(SmartPhoneData.nothing2a_black, SmartPhoneData.nothing2a_black_urls);
        imageMap.put(SmartPhoneData.nothing2a_white, SmartPhoneData.nothing2a_white_urls);

        imageMap.put(SmartPhoneData.pixel_fold_obsidian,SmartPhoneData.pixel_fold_obsidian_urls);
        imageMap.put(SmartPhoneData.pixel_fold_porcelain,SmartPhoneData.pixel_fold_porcelain_urls);
        imageMap.put(SmartPhoneData.pixel_7a_charcoal,SmartPhoneData.pixel_7a_charcoal_urls);
        imageMap.put(SmartPhoneData.pixel_7a_sea,SmartPhoneData.pixel_7a_sea_urls);
        imageMap.put(SmartPhoneData.pixel_7a_snow,SmartPhoneData.pixel_7a_snow_urls);
        imageMap.put(SmartPhoneData.pixel_7_lemongrass,SmartPhoneData.pixel_7_lemongrass_urls);
        imageMap.put(SmartPhoneData.pixel_7_snow,SmartPhoneData.pixel_7_snow_urls);
        imageMap.put(SmartPhoneData.pixel_7_pro_obsidian,SmartPhoneData.pixel_7_pro_obsidian_urls);
        imageMap.put(SmartPhoneData.pixel_8_pro_obsidian,SmartPhoneData.pixel_8_pro_obsidian_urls);
        imageMap.put(SmartPhoneData.pixel_8_pro_bay,SmartPhoneData.pixel_8_pro_bay_urls);
        imageMap.put(SmartPhoneData.pixel_8_pro_porcelain,SmartPhoneData.pixel_8_pro_porcelain_urls);
        imageMap.put(SmartPhoneData.pixel_8_obsidian,SmartPhoneData.pixel_8_obsidian_urls);
        imageMap.put(SmartPhoneData.pixel_8_rose,SmartPhoneData.pixel_8_rose_urls);
        imageMap.put(SmartPhoneData.pixel_8a_bay,SmartPhoneData.pixel_8a_bay_urls);
        imageMap.put(SmartPhoneData.pixel_8a_obsidian,SmartPhoneData.pixel_8a_obsidian_urls);
        imageMap.put(SmartPhoneData.pixel_8a_porcelain,SmartPhoneData.pixel_8a_porcelain_urls);

        imageMap.put(TabletData.ipad_pro_black, TabletData.ipad_pro_black_urls);
        imageMap.put(TabletData.ipad_pro_silver, TabletData.ipad_pro_silver_urls);
        imageMap.put(TabletData.ipad_air_gray, TabletData.ipad_air_gray_urls);
        imageMap.put(TabletData.ipad_air_purple, TabletData.ipad_air_purple_urls);
        imageMap.put(TabletData.ipad_air_starlight, TabletData.ipad_air_starlight_urls);
        imageMap.put(TabletData.ipad_silver, TabletData.ipad_silver_urls);
        imageMap.put(TabletData.ipad_blue, TabletData.ipad_blue_urls);


    }

    public Map<List<String>, List<String>> getImageMap() {
        if (imageMap.isEmpty()) {
            initializeData(); // Populate the map if it's empty
        }
        return imageMap;
    }
}
