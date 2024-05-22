INSERT INTO brands (name, description, logo_url) VALUES
('Apple', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235711/Brands/Apple_ticin6.jpg'),
('Samsung', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235727/Brands/Samsung_eiuffz.jpg'),
('Google', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235779/Brands/Google_vg5dns.jpg'),
('Acer', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235704/Brands/Acer_p2ylhp.jpg'),
('Dell', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235712/Brands/Dell_wgfrfy.jpg'),
('HP', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235719/Brands/HP_ghu0sb.jpg'),
('Lenovo', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716235723/Brands/Lenovo_bfkgdj.jpg'),
('Nothing', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716274386/Brands/Nothing_st5njk.png'),
('Anker', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716284560/Brands/Anker_ywdwjt.png'),
('Energizer', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716286327/Brands/Energizer_joeqac.png'),
('Insignia', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716285787/Brands/Insignia_fepyeh.jpg'),
('JBL', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716289647/Brands/Jbl_y5uwm3.png'),
('Cellularline', 'dummy description', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716289156/Brands/Cellularline_ouu025.jpg');


INSERT INTO categories (name, image_url, parent_id) VALUES
('Laptops', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233519/Categories/Laptops.jpg', NULL),
('Smartphones', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716220466/Categories/Smartphones.jpg', NULL),
('Tablets', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233290/Categories/Tablets.jpg', NULL),
('Accessories', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716331140/Categories/Accessories_iosn6f.jpg', NULL),
('Cables', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234373/Categories/Cables.jpg', 4),
('Chargers', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234100/Categories/Chargers.jpg', 4),
('Earbuds', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716234093/Categories/Earbuds.jpg', 4),
('Powerbanks', 'https://res.cloudinary.com/dztiecgdt/image/upload/v1716233753/Categories/Powerbanks.jpg', 4);

-- Smartphones

INSERT INTO products (name, original_price, category_id, brand_id, stock, description) VALUES
('Apple - iPhone 15 Pro 128GB - Black Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - White Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - Blue Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 128GB - Natural Titanium', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Black Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - White Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Blue Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 256GB - Natural Titanium', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Black Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - White Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Blue Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 512GB - Natural Titanium', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Black Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - White Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Blue Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro 1TB - Natural Titanium', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Black Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - White Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Blue Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 256GB - Natural Titanium', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Black Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - White Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Blue Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 512GB - Natural Titanium', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Black Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - White Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Blue Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Pro Max 1TB - Natural Titanium', 1599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Black', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Yellow', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Pink', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 128GB - Green', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Yellow', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Pink', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 256GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Black', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Yellow', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Pink', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 512GB - Green', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Yellow', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Pink', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 128GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Yellow', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Pink', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 256GB - Green', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Yellow', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Blue', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Pink', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 15 Plus 512GB - Green', 1199.00, 2, 1, 50, 'dummy description'),

('Apple - iPhone SE (3rd generation) 64GB - Starlight', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 64GB - Product Red', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 64GB - Midnight', 429.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Starlight', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Product Red', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 128GB - Midnight', 479.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Starlight', 579.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Product Red', 579.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone SE (3rd generation) 256GB - Midnight', 579.00, 2, 1, 50, 'dummy description'),

('Apple - iPhone 14 Pro 128GB - Space Black', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 128GB - Deep Purple', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Space Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 256GB - Deep Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Space Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 512GB - Deep Purple', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Space Black', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Silver', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Gold', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro 1TB - Deep Purple', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Space Black', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 128GB - Deep Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Space Black', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 256GB - Deep Purple', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Space Black', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Silver', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Gold', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 512GB - Deep Purple', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Space Black', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Silver', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Gold', 1499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Pro Max 1TB - Deep Purple', 1499.00, 2, 1, 50, 'dummy description'),

('Apple - iPhone 14 128GB - Midnight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Blue', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Starlight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 128GB - Purple', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 256GB - Purple', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Midnight', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Starlight', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 512GB - Purple', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 128GB - Purple', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Midnight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Starlight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 256GB - Purple', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Midnight', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Starlight', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 14 Plus 512GB - Purple', 1099.00, 2, 1, 50, 'dummy description'),

('Apple - iPhone 13 Pro 128GB - Sierra Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Graphite', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Silver', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 128GB - Gold', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Sierra Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Graphite', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 256GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Sierra Blue', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Graphite', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Silver', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 512GB - Gold', 1099.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Sierra Blue', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Graphite', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Silver', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro 1TB - Gold', 1299.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Sierra Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Graphite', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Silver', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 128GB - Gold', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Sierra Blue', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Graphite', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Silver', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 256GB - Gold', 999.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Sierra Blue', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Graphite', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Silver', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 512GB - Gold', 1199.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Sierra Blue', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Graphite', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Silver', 1399.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Pro Max 1TB - Gold', 1399.00, 2, 1, 50, 'dummy description'),

('Apple - iPhone 13 128GB - Starlight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Midnight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Blue', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 128GB - Green', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Starlight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Midnight', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Blue', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 256GB - Green', 699.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Starlight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Midnight', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Blue', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 512GB - Green', 899.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Starlight', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Midnight', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Blue', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 128GB - Green', 499.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Starlight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Midnight', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Blue', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 256GB - Green', 599.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Starlight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Midnight', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Blue', 799.00, 2, 1, 50, 'dummy description'),
('Apple - iPhone 13 Mini 512GB - Green', 799.00, 2, 1, 50, 'dummy description');




INSERT INTO smartphones (id, screen_size, screen_resolution, ram, storage, battery_capacity, front_camera, rear_camera, refresh_rate, color, year_of_release) VALUES
(1, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(2, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(3, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(4, '6.1 inches', '2556 x 1179 pixels', '8 GB', '128 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(5, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(6, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(7, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(8, '6.1 inches', '2556 x 1179 pixels', '8 GB', '256 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(9, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(10, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(11, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(12, '6.1 inches', '2556 x 1179 pixels', '8 GB', '512 GB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(13, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(14, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(15, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(16, '6.1 inches', '2556 x 1179 pixels', '8 GB', '1 TB', '3274 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(17, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(18, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(19, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(20, '6.7 inches', '2796 x 1290 pixels', '8 GB', '256 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(21, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(22, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(23, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(24, '6.7 inches', '2796 x 1290 pixels', '8 GB', '512 GB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(25, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2023),
(26, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2023),
(27, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'blue', 2023),
(28, '6.7 inches', '2796 x 1290 pixels', '8 GB', '1 TB', '4441 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'natural', 2023),
(29, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(30, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(31, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(32, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(33, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),
(34, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(35, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(36, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(37, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(38, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),
(39, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(40, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(41, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(42, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(43, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3349 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),
(44, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(45, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(46, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(47, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(48, '6.7 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),
(49, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(50, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(51, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(52, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(53, '6.7 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),
(54, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'black', 2023),
(55, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'yellow', 2023),
(56, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'blue', 2023),
(57, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'pink', 2023),
(58, '6.7 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '4383 mAh', '12 MP', '48 + 12 MP', '60 Hz', 'green', 2023),

(59, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 2022),
(60, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 2022),
(61, '4.7 inches', '1334 x 750 pixels', '4 GB', '64 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 2022),
(62, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 2022),
(63, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 2022),
(64, '4.7 inches', '1334 x 750 pixels', '4 GB', '128 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 2022),
(65, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'white', 2022),
(66, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'red', 2022),
(67, '4.7 inches', '1334 x 750 pixels', '4 GB', '257 GB', '2018 mAh', '7 MP', '12 MP', '60 Hz', 'blue', 2022),

(68, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(69, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(70, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(71, '6.1 inches', '2556 x 1179 pixels', '6 GB', '128 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(72, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(73, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(74, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(75, '6.1 inches', '2556 x 1179 pixels', '6 GB', '256 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(76, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(77, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(78, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(79, '6.1 inches', '2556 x 1179 pixels', '6 GB', '512 GB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(80, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(81, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(82, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(83, '6.1 inches', '2556 x 1179 pixels', '6 GB', '1 TB', '3200 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(84, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(85, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(86, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(87, '6.7 inches', '2796 x 1290 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(88, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(89, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(90, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(91, '6.7 inches', '2796 x 1290 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(92, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(93, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(94, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(95, '6.7 inches', '2796 x 1290 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(96, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'black', 2022),
(97, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'white', 2022),
(98, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'gold', 2022),
(99, '6.7 inches', '2796 x 1290 pixels', '6 GB', '1 TB', '4323 mAh', '12 MP', '48 + 12 + 12 MP', '120 Hz', 'purple', 2022),
(100, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(101, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(102, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(103, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),
(104, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(105, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(106, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(107, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),
(108, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(109, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(110, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(111, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3279 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),
(112, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(113, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(114, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(115, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),
(116, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(117, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(118, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(119, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),
(120, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(121, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2022),
(122, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2022),
(123, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4323 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'purple', 2022),

(124, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(125, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(126, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(127, '6.1 inches', '2532 x 1170 pixels', '6 GB', '128 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(128, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(129, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(130, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(131, '6.1 inches', '2532 x 1170 pixels', '6 GB', '256 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(132, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(133, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(134, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(135, '6.1 inches', '2532 x 1170 pixels', '6 GB', '512 GB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(136, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(137, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(138, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(139, '6.1 inches', '2532 x 1170 pixels', '6 GB', '1 TB', '3095 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(140, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(141, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(142, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(143, '6.7 inches', '2778 x 1284 pixels', '6 GB', '128 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(144, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(145, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(146, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(147, '6.7 inches', '2778 x 1284 pixels', '6 GB', '256 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(148, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(149, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(150, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(151, '6.7 inches', '2778 x 1284 pixels', '6 GB', '512 GB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),
(152, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'blue', 2021),
(153, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'graphite', 2021),
(154, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'white', 2021),
(155, '6.7 inches', '2778 x 1284 pixels', '6 GB', '1 TB', '4352 mAh', '12 MP', '12 + 12 + 12 MP', '120 Hz', 'gold', 2021),

(156, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(157, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(158, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(159, '6.1 inches', '2532 x 1170 pixels', '4 GB', '128 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021),
(160, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(161, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(162, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(163, '6.1 inches', '2532 x 1170 pixels', '4 GB', '256 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021),
(164, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(165, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(166, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(167, '6.1 inches', '2532 x 1170 pixels', '4 GB', '512 GB', '3240 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021),
(168, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(169, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(170, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(171, '5.4 inches', '2340 x 1080 pixels', '4 GB', '128 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021),
(172, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(173, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(174, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(175, '5.4 inches', '2340 x 1080 pixels', '4 GB', '256 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021),
(176, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'white', 2021),
(177, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(178, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'blue', 2021),
(179, '5.4 inches', '2340 x 1080 pixels', '4 GB', '512 GB', '2438 mAh', '12 MP', '12 + 12 MP', '60 Hz', 'green', 2021);



