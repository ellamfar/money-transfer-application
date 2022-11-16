package com.ellamfar.moneytransferapplication;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountController {

  private final AccountRepository repository;

  AccountController(AccountRepository repository) {
    this.repository = repository;
  }


  // Retrieve all accounts in database
  @GetMapping("/accounts")
  List<Account> all() {
    return repository.findAll();
  }

  // Create a new account and save it to database
  @PostMapping("/accounts")
  Account newAccount(@RequestBody Account newAccount) {
    return repository.save(newAccount);
  }

  // Retrieve a single account
  @GetMapping("/accounts/{id}")
  Account one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new AccountNotFoundException(id));
  }

  // Update account with new data
  @PutMapping("/accounts/{id}")
  Account replaceAccount(@RequestBody Account newAccount, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(account -> {
        account.setFirstName(newAccount.getFirstName());
        account.setLastName(newAccount.getLastName());
        account.setBalance(newAccount.getBalance());
        return repository.save(account);
      })
      .orElseGet(() -> {
        newAccount.setId(id);
        return repository.save(newAccount);
      });
  }

  // Perform money transfer
  @PutMapping("/transfer")
  public List<Account> performTransfer(@RequestBody TransferRequest transferRequest) {
    Account accountFrom = repository.findById(transferRequest.getAccountFromID()).get();
    Account accountTo = repository.findById(transferRequest.getAccountToID()).get();
    if(!accountFrom.withdraw(transferRequest.getAmount())){
      throw new InsufficientFundsException();
    }
    accountTo.deposit(transferRequest.getAmount());
    List<Account> updatedAccountList = new ArrayList<Account>();
    updatedAccountList.add(accountFrom);
    updatedAccountList.add(accountTo);
    return repository.saveAll(updatedAccountList);
  }

  // Delete account
  @DeleteMapping("/accounts/{id}")
  void deleteAccount(@PathVariable Long id) {
    repository.deleteById(id);
  }

}