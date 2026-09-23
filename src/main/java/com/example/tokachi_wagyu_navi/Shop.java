package com.example.tokachi_wagyu_navi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Longに変更

    private String name;        // メニュー名
    private String shopName;    // お店の名前
    private String area;        // エリア
    private String shopAddress; // 店舗住所

    @Column(columnDefinition = "TEXT")
    private String description; // こだわり詳細

    private String image;       // 画像パス
    private String price;       // 価格
    private String mapQuery;    // Googleマップ用

    // --- Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; } // 引数もLongに変更

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getShopAddress() { return shopAddress; }
    public void setShopAddress(String shopAddress) { this.shopAddress = shopAddress; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getMapQuery() { return mapQuery; }
    public void setMapQuery(String mapQuery) { this.mapQuery = mapQuery; }
}