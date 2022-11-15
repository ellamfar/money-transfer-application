// package com.ellamfar.moneytransferapplication;

// import java.util.List;
// import java.util.ArrayList;

// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// class TransferRequestController {

//   private final AccountRepository repository;

//   TransferRequestController(AccountRepository repository) {
//     this.repository = repository;
//   }

//   @PutMapping("/transfer")
//   List<Account> performTransfer(@RequestBody TransferRequest transferRequest) {
//     Account accountFrom = repository.findById(transferRequest.getAccountFromID()).get();
//     Account accountTo = repository.findById(transferRequest.getAccountToID()).get();
//     double newBalanceFrom = accountFrom.getBalance() - transferRequest.getAmount();
//         if not accountFrom.withdraw(amount) {
//             return error;
//         }

//     SQL mysql = new SQL("127.0.0.1:3306")

//     double newBalanceTo = accountTo.getBalance() + transferRequest.getAmount();
//     accountFrom.setBalance(newBalanceFrom);
//     accountTo.setBalance(newBalanceTo);
//     List<Account> updatedAccountList = new ArrayList<Account>();
//     updatedAccountList.add(accountFrom);
//     updatedAccountList.add(accountTo);
//     return repository.saveAll(updatedAccountList);
//   }

// }