package com.example.tokachi_wagyu_navi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Reactからのアクセスを許可
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    // ★追加：ルートパス（/）にアクセスされたときのお出迎えメッセージ
    @GetMapping("/")
    public String index() {
        return "十勝和牛ナビ APIサーバーへようこそ！ データを見るには /shops にアクセスしてください。";
    }

    @GetMapping("/shops")
    public List getAllShops() {
        return shopRepository.findAll();
    }

    // 新規登録用のAPI
    @PostMapping("/shops")
    public Shop createShop(@RequestBody Shop shop) {
        shop.setId(null); // IDをリセットして新規登録にする
        return shopRepository.save(shop);
    }

    // 削除用のAPI
    @DeleteMapping("/shops/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopRepository.deleteById(id);
    }
}