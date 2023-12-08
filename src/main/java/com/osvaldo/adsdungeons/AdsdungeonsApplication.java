package com.osvaldo.adsdungeons;

import com.osvaldo.adsdungeons.domain.Batalha;
import com.osvaldo.adsdungeons.domain.Inimigo;
import com.osvaldo.adsdungeons.repositories.BatalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdsdungeonsApplication {

	public static void main(String[] args) {

		SpringApplication.run(AdsdungeonsApplication.class, args);
	}

}
