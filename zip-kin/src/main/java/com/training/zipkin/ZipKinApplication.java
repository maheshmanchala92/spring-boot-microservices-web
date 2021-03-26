package com.training.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipKinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipKinApplication.class, args);
	}

}
