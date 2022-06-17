package com.ccc.tcapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ccc.tcapi.configurations.FileUploadPropertiesConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileUploadPropertiesConfig.class
})
public class TcapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TcapiApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
