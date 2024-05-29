package com.techie.dataInitialization;

import com.techie.dataInitialization.data.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        imageMap.put(TabletData.huawei_matepad_grey, TabletData.huawei_matepad_grey_urls);
        imageMap.put(TabletData.huawei_matepadT_blue, TabletData.huawei_matepadT_blue_urls);

        imageMap.put(TabletData.lenovo_tab_m10, TabletData.lenovo_tab_m10_urls);
        imageMap.put(TabletData.lenovo_tab_m11, TabletData.lenovo_tab_m11_urls);
        imageMap.put(TabletData.lenovo_tab_p11, TabletData.lenovo_tab_p11_urls);
        imageMap.put(TabletData.lenovo_tab_p12, TabletData.lenovo_tab_p12_urls);

        imageMap.put(TabletData.samsung_tab_a9_navy, TabletData.samsung_tab_a9_navy_urls);
        imageMap.put(TabletData.samsung_tab_a9_silver, TabletData.samsung_tab_a9_silver_urls);
        imageMap.put(TabletData.samsung_tabs9_graphite, TabletData.samsung_tabs9_graphite_urls);
        imageMap.put(TabletData.samsung_tabs9_plus_graphite_, TabletData.samsung_tabs9_plus_graphite_urls);
        imageMap.put(TabletData.samsung_tab_s9_ultra_beige, TabletData.samsung_tab_s9_ultra_beige_urls);
        imageMap.put(TabletData.samsung_tab_s9_ultra_graphite, TabletData.samsung_tab_s9_ultra_graphite_urls);

        imageMap.put(LaptopData.macbook_air_gray, LaptopData.macbook_air_gray_urls);
        imageMap.put(LaptopData.macbook_air_midnight, LaptopData.macbook_air_midnight_urls);
        imageMap.put(LaptopData.macbook_air_starlight, LaptopData.macbook_air_starlight_urls);
        imageMap.put(LaptopData.macbook_pro_black, LaptopData.macbook_pro_black_urls);
        imageMap.put(LaptopData.macbook_pro_silver, LaptopData.macbook_pro_silver_urls);

        imageMap.put(LaptopData.acer_one,LaptopData.acer_one_urls);
        imageMap.put(LaptopData.acer_two,LaptopData.acer_two_urls);
        imageMap.put(LaptopData.acer_three,LaptopData.acer_three_urls);
        imageMap.put(LaptopData.acer_four,LaptopData.acer_four_urls);
        imageMap.put(LaptopData.acer_five,LaptopData.acer_five_urls);
        imageMap.put(LaptopData.acer_six,LaptopData.acer_six_urls);
        imageMap.put(LaptopData.acer_seven,LaptopData.acer_seven_urls);
        imageMap.put(LaptopData.acer_eight,LaptopData.acer_eight_urls);
        imageMap.put(LaptopData.acer_nine,LaptopData.acer_nine_urls);
        imageMap.put(LaptopData.acer_ten,LaptopData.acer_ten_urls);

        imageMap.put(LaptopData.dell_one,LaptopData.dell_one_urls);
        imageMap.put(LaptopData.dell_two,LaptopData.dell_two_urls);
        imageMap.put(LaptopData.dell_three,LaptopData.dell_three_urls);
        imageMap.put(LaptopData.dell_four,LaptopData.dell_four_urls);
        imageMap.put(LaptopData.dell_five,LaptopData.dell_five_urls);
        imageMap.put(LaptopData.dell_six,LaptopData.dell_six_urls);

        imageMap.put(LaptopData.lenovo_one,LaptopData.lenovo_one_urls);
        imageMap.put(LaptopData.lenovo_two,LaptopData.lenovo_two_urls);
        imageMap.put(LaptopData.lenovo_three,LaptopData.lenovo_three_urls);
        imageMap.put(LaptopData.lenovo_four,LaptopData.lenovo_four_urls);
        imageMap.put(LaptopData.lenovo_five,LaptopData.lenovo_five_urls);

        imageMap.put(LaptopData.hp_one,LaptopData.hp_one_urls);
        imageMap.put(LaptopData.hp_two,LaptopData.hp_two_urls);
        imageMap.put(LaptopData.hp_three,LaptopData.hp_three_urls);
        imageMap.put(LaptopData.hp_four,LaptopData.hp_four_urls);
        imageMap.put(LaptopData.hp_five,LaptopData.hp_five_urls);
        imageMap.put(LaptopData.hp_six,LaptopData.hp_six_urls);
        imageMap.put(LaptopData.hp_seven,LaptopData.hp_seven_urls);

        imageMap.put(CablesData.cables_one,CablesData.cables_one_urls);
        imageMap.put(CablesData.cables_two,CablesData.cables_two_urls);
        imageMap.put(CablesData.cables_three,CablesData.cables_three_urls);
        imageMap.put(CablesData.cables_four,CablesData.cables_four_urls);
        imageMap.put(CablesData.cables_five,CablesData.cables_five_urls);
        imageMap.put(CablesData.cables_six,CablesData.cables_six_urls);
        imageMap.put(CablesData.cables_seven,CablesData.cables_seven_urls);
        imageMap.put(CablesData.cables_eight,CablesData.cables_eight_urls);
        imageMap.put(CablesData.cables_nine,CablesData.cables_nine_urls);
        imageMap.put(CablesData.cables_ten,CablesData.cables_ten_urls);
        imageMap.put(CablesData.cables_eleven,CablesData.cables_eleven_urls);
        imageMap.put(CablesData.cables_twelve,CablesData.cables_twelve_urls);

        imageMap.put(ChargersData.chargers_one,ChargersData.chargers_one_urls);
        imageMap.put(ChargersData.chargers_two,ChargersData.chargers_two_urls);
        imageMap.put(ChargersData.chargers_three,ChargersData.chargers_three_urls);
        imageMap.put(ChargersData.chargers_four,ChargersData.chargers_four_urls);
        imageMap.put(ChargersData.chargers_five,ChargersData.chargers_five_urls);
        imageMap.put(ChargersData.chargers_six,ChargersData.chargers_six_urls);
        imageMap.put(ChargersData.chargers_seven,ChargersData.chargers_seven_urls);
        imageMap.put(ChargersData.chargers_eight,ChargersData.chargers_eight_urls);
        imageMap.put(ChargersData.chargers_nine,ChargersData.chargers_nine_urls);
        imageMap.put(ChargersData.chargers_ten,ChargersData.chargers_ten_urls);

        imageMap.put(PowerBankData.bank_one,PowerBankData.bank_one_urls);
        imageMap.put(PowerBankData.bank_two,PowerBankData.bank_two_urls);
        imageMap.put(PowerBankData.bank_three,PowerBankData.bank_three_urls);
        imageMap.put(PowerBankData.bank_four,PowerBankData.bank_four_urls);
        imageMap.put(PowerBankData.bank_five,PowerBankData.bank_five_urls);
        imageMap.put(PowerBankData.bank_six,PowerBankData.bank_six_urls);
        imageMap.put(PowerBankData.bank_seven,PowerBankData.bank_seven_urls);
        imageMap.put(PowerBankData.bank_eight,PowerBankData.bank_eight_urls);

        imageMap.put(EarphonesData.earphones_one,EarphonesData.earphones_one_urls);
        imageMap.put(EarphonesData.earphones_two,EarphonesData.earphones_two_urls);
        imageMap.put(EarphonesData.earphones_three,EarphonesData.earphones_three_urls);
        imageMap.put(EarphonesData.earphones_four,EarphonesData.earphones_four_urls);
        imageMap.put(EarphonesData.earphones_five,EarphonesData.earphones_five_urls);
        imageMap.put(EarphonesData.earphones_six,EarphonesData.earphones_six_urls);
        imageMap.put(EarphonesData.earphones_seven,EarphonesData.earphones_seven_urls);
        imageMap.put(EarphonesData.earphones_eight,EarphonesData.earphones_eight_urls);
        imageMap.put(EarphonesData.earphones_eight_white,EarphonesData.earphones_eight_white_urls);
        imageMap.put(EarphonesData.earphones_nine,EarphonesData.earphones_nine_urls);
        imageMap.put(EarphonesData.earphones_ten,EarphonesData.earphones_ten_urls);
        imageMap.put(EarphonesData.earphones_eleven,EarphonesData.earphones_eleven_urls);
        imageMap.put(EarphonesData.earphones_twelve,EarphonesData.earphones_twelve_urls);
        imageMap.put(EarphonesData.earphones_thirteen,EarphonesData.earphones_thirteen_urls);
        imageMap.put(EarphonesData.earphones_fourteen,EarphonesData.earphones_fourteen_urls);
        imageMap.put(EarphonesData.earphones_fifteen,EarphonesData.earphones_fifteen_urls);
        imageMap.put(EarphonesData.earphones_sixteen,EarphonesData.earphones_sixteen_urls);
        imageMap.put(EarphonesData.earphones_seventeen,EarphonesData.earphones_seventeen_urls);
        imageMap.put(EarphonesData.earphones_eighteen,EarphonesData.earphones_eighteen_urls);
        imageMap.put(EarphonesData.earphones_nineteen,EarphonesData.earphones_nineteen_urls);
        imageMap.put(EarphonesData.earphones_twenty,EarphonesData.earphones_twenty_urls);
        imageMap.put(EarphonesData.earphones_twentyOne,EarphonesData.earphones_twentyOne_urls);
        imageMap.put(EarphonesData.earphones_twentyTwo,EarphonesData.earphones_twentyTwo_urls);
        imageMap.put(EarphonesData.earphones_twentyThree,EarphonesData.earphones_twentyThree_urls);
        imageMap.put(EarphonesData.earphones_twentyFour,EarphonesData.earphones_twentyFour_urls);
        imageMap.put(EarphonesData.earphones_twentyFive,EarphonesData.earphones_twentyFive_urls);
        imageMap.put(EarphonesData.earphones_twentySix,EarphonesData.earphones_twentySix_urls);
        imageMap.put(EarphonesData.earphones_twentySeven,EarphonesData.earphones_twentySeven_urls);
        imageMap.put(EarphonesData.earphones_twentyEight,EarphonesData.earphones_twentyEight_urls);
        imageMap.put(EarphonesData.earphones_twentyNine,EarphonesData.earphones_twentyNine_urls);
    }

    public Map<List<String>, List<String>> getImageMap() {
        if (imageMap.isEmpty()) {
            initializeData(); // Populate the map if it's empty
        }
        return imageMap;
    }
}
