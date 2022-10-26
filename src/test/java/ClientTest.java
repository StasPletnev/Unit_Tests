import accounts.Account;
import accounts.CreditAccount;
import accounts.SavingsAccount;
import clients.Client;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClientTest {
    private Client client;
    private Account accountSaveLow = new SavingsAccount(1000, "credit", 0);
    private Account accountSaveBig = new SavingsAccount(100_000, "save", 0);
    private Account accountSaveFalse = new CreditAccount(1, "false");

    @BeforeEach
    void setUp() {
        client = new Client("Stas", 2);
        client.newAccount(accountSaveLow);
        client.newAccount(accountSaveBig);
    }


    @DisplayName("Тест Pay")
    @ParameterizedTest
    @CsvSource(value = {"1000,true", "10,true", "101000,false"})
    void testPay(int sum, boolean result) {
        Assertions.assertEquals(result, client.pay(sum));
    }

    @DisplayName("Тест Accept")
    @ParameterizedTest
    @CsvSource(value = {"5000, true", "200000, true", "1, true"})
    void testAccept(int sum, boolean result) {
        Assertions.assertEquals(result, client.accept(sum));
    }

    @Test
    @DisplayName("Тест на добавление счета")
    void testAddAccount() {
        Assertions.assertEquals(false, client.newAccount(accountSaveFalse));
    }
}
