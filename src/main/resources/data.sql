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
('Apple - iPhone 15 Pro Max 1TB - Natural Titanium', 1599.00, 2, 1, 50, 'dummy description');


INSERT INTO smartphones (id, screen_size, screen_resolution, ram, storage, battery_capacity, front_camera, rear_camera, refresh_rate, color, year_of_release) VALUES
(1, '6.1 inches', '2556 x 1179', 8, 128, '3274 mAh', '12MP', '48MP + 12MP + 12MP', '', ''),
