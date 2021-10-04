package com.shop.shopws;

import com.shop.shopws.entities.Cart;
import com.shop.shopws.entities.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ShopWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopWsApplication.class, args);
	}

}
