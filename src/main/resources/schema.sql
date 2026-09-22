-- 1. ユーザーテーブル
CREATE TABLE IF NOT EXISTS users (
                                     user_id INT AUTO_INCREMENT PRIMARY KEY,
                                     email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- 2. 生産者テーブル
CREATE TABLE IF NOT EXISTS producers (
                                         producer_id INT AUTO_INCREMENT PRIMARY KEY,
                                         producer_name VARCHAR(150) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- 3. 店舗テーブル
CREATE TABLE IF NOT EXISTS shops (
                                     shop_id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(255),
    shop_name VARCHAR(150) NOT NULL,
    area VARCHAR(100),
    category VARCHAR(50),
    shop_address VARCHAR(255) NOT NULL,
    description TEXT,
    image VARCHAR(255),
    price VARCHAR(50),
    map_query VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

-- 4. お気に入りテーブル
CREATE TABLE IF NOT EXISTS favorites (
                                         favorite_id INT AUTO_INCREMENT PRIMARY KEY,
                                         user_id INT NOT NULL,
                                         shop_id INT NOT NULL,
                                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         CONSTRAINT fk_favorites_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_favorites_shop FOREIGN KEY (shop_id) REFERENCES shops(shop_id) ON DELETE CASCADE,
    CONSTRAINT unique_user_shop UNIQUE (user_id, shop_id)
    );

-- 5. 訪問記録（スタンプ）テーブル
CREATE TABLE IF NOT EXISTS stamps (
                                      stamp_id INT AUTO_INCREMENT PRIMARY KEY,
                                      user_id INT NOT NULL,
                                      shop_id INT NOT NULL,
                                      visited_at DATE NOT NULL,
                                      memo TEXT,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      CONSTRAINT fk_stamps_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_stamps_shop FOREIGN KEY (shop_id) REFERENCES shops(shop_id) ON DELETE CASCADE
    );