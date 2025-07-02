package com.company.aopdemo;

import com.company.aopdemo.dao.AccountDAO;
import com.company.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			demoTheAfterReturningAdvice(theAccountDAO);
		};

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call the method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\n Main Program: demoTheAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Goku");
		myAccount.setLevel("Super Saiyan");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();

	}

}
