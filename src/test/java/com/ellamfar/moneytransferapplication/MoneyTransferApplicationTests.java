package com.ellamfar.moneytransferapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = { 
	"spring.datasource.url=jdbc:mysql://localhost:3306/app_accounts_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false",
	"spring.datasource.username=moneytransfer_user" })
class MoneyTransferApplicationTests {

	@Test
	void contextLoads() {
	}

}
