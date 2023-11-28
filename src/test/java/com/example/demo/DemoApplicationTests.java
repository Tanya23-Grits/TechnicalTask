package com.example.demo;

import com.example.demo.model.BankAccount;
import com.example.demo.model.Status;
import com.example.demo.model.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.AccountServiceImpl;
import com.example.demo.service.TransactionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private AccountServiceImpl accountService;
    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void testFindAll() {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount("Tanya", "1010"));
        accounts.add(new BankAccount("Maksim", "2020"));
        Mockito.when(accountRepository.findAll()).thenReturn(accounts);

        List<BankAccount> result = accountService.findAll();
        assertEquals(accounts, result);
    }

	@Test
	public void testCreateNewAccount() {
		BankAccount account = new BankAccount("Tanya", "1010");
		Mockito.when(accountRepository.save(account)).thenReturn(account);

		Long result = accountService.createNewAccount("Tanya", "1010");
		assertEquals(account.getId(), result);
	}

    @Test
    public void testFindById() {
        BankAccount account = new BankAccount("Tanya", "1010");
        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        BankAccount result = accountService.findById(1L);
        assertEquals(account, result);
    }

	@Test
	public void testGetTransactions() {
		BankAccount account = new BankAccount("Tanya", "1010");
		Transaction transaction1 = new Transaction(1L, 500.0);
		Transaction transaction2 = new Transaction(1L, -200.0);
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction1);
		transactions.add(transaction2);
		account.setTransactions(transactions);
		Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

		List<Transaction> result = transactionService.getTransactions(1L);
		assertEquals(transactions, result);
	}

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Tanya", "1010");
        account.setCurrentBalance(1000.0);
        Transaction transaction = new Transaction(1L, 500.0);
        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

        Status result = transactionService.deposit(1L, 500.0);
        assertEquals(Status.APPROVED, result);
        assertEquals(1500.0, account.getCurrentBalance(), 0.0);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("Tanya", "1010");
        account.setCurrentBalance(1000.0);
        Transaction transaction = new Transaction(1L, -500.0);
        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

        Status result = transactionService.withdraw(1L, "1010", 500.0);
        assertEquals(Status.APPROVED, result);
        assertEquals(500.0, account.getCurrentBalance(), 0.0);
    }

    @Test
    public void testTransfer() {
        BankAccount fromAccount = new BankAccount("Tanya", "1010");
        fromAccount.setCurrentBalance(1000.0);
        BankAccount toAccount = new BankAccount("Maksim", "2020");
        Transaction transaction = new Transaction(1L, -500.0);
        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(fromAccount));
        Mockito.when(accountRepository.findById(2L)).thenReturn(Optional.of(toAccount));
        Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);

        Status result = transactionService.transfer(1L, 2L, "1010", 500.0);
        assertEquals(Status.APPROVED, result);
        assertEquals(500.0, fromAccount.getCurrentBalance(), 0.0);
        assertEquals(500.0, toAccount.getCurrentBalance(), 0.0);
    }
}
