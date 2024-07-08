package com.example.spoleto;

import com.example.spoleto.infra.ChecksDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpoletoApplication {

	public static void main(String[] args) {
		ChecksDB.checkDataBase();
		SpringApplication.run(SpoletoApplication.class, args);
	}

}
