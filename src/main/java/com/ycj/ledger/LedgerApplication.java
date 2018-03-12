package com.ycj.ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author ycj
 * @version V1.0 <>
 * @date 2017-12-07 16:05
 */
@SpringBootApplication
public class LedgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LedgerApplication.class, args);
	}
}


//public class LedgerApplication  extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(LedgerApplication.class);
//	}
//}