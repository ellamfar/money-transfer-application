#!/bin/bash

echo -e "\nFirst two accounts were preloaded into the database.\n"
echo -e "Listing all accounts in the database...\n"

curl -v 0.0.0.0:8080/accounts

echo -e "\n\nAdding two new accounts...\n"

curl -X POST 0.0.0.0:8080/accounts -H 'Content-type:application/json' -d '{"firstName": "Samwise", "lastName": "Gamgee", "balance": 15000}'

echo -e "\n"

curl -X POST 0.0.0.0:8080/accounts -H 'Content-type:application/json' -d '{"firstName": "Gandalf", "lastName": "the Grey", "balance": 100000}'

echo -e "\n\nListing all accounts again. Two new accounts should have been added...\n"

curl -v 0.0.0.0:8080/accounts

echo -e "\n\nTransfering 5,000 from account with id:1 to account with id:2."
echo -e "Let's see their current balances.\n"

echo -e "Account 1\n"

curl -v 0.0.0.0:8080/accounts/1

echo -e "\n\nAccount 2\n"

curl -v 0.0.0.0:8080/accounts/2

echo -e "\n\nInitializing transfer of funds...\n"

curl -X PUT 0.0.0.0:8080/transfer -H 'Content-type:application/json' -d '{"accountFromID": 1, "accountToID": 2, "amount": 5000}'

echo -e "\n\nFunds should have been transferred. Listing their new balances.\n"

echo -e "Account 1\n"

curl -v 0.0.0.0:8080/accounts/1

echo -e "\n\nAccount 2\n"

curl -v 0.0.0.0:8080/accounts/2

echo -e "\n\nTransferring 50,000 from account with id:2 to account with id:3."
echo -e "Account with id:2 does not have enough funds for the transfer so an"
echo -e "exception will be thrown below.\n"

curl -X PUT 0.0.0.0:8080/transfer -H 'Content-type:application/json' -d '{"accountFromID": 2, "accountToID": 3, "amount": 50000}'







