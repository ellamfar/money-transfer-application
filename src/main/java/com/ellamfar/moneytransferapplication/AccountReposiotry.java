package com.ellamfar.moneytransferapplication;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Account, Long> {

}
