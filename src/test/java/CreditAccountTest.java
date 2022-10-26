import accounts.CreditAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CreditAccountTest {
    private CreditAccount creditAccount;

    @BeforeEach
    void setUp() {
        creditAccount = new CreditAccount(0, "Credit");
    }


    @DisplayName("Тест метода Pay")
    @ParameterizedTest
    @CsvSource(value = {"1000, true", "10000000, true", "0, true"})
    void testPay(int sum, boolean result) {
        Assertions.assertEquals(result, creditAccount.pay(sum));
    }

    @DisplayName("Тест метода Accept")
    @ParameterizedTest
    @CsvSource(value = {"1000, true", "10000000, false", "0, true"})
    void testAccept(int sum, boolean result) {
        creditAccount.pay(2000);
        Assertions.assertEquals(result, creditAccount.accept(sum));
    }

    @DisplayName("Тест метода Add")
    @ParameterizedTest
    @CsvSource(value = {"1000, true", "10000000, false", "0, true"})
    void testAdd(int sum, boolean result) {
        creditAccount.pay(2000);
        Assertions.assertEquals(result, creditAccount.add(sum));
    }

}
