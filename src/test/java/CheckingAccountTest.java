import accounts.CheckingAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Тестирование класса CheckingAccount")
public class CheckingAccountTest {

    private CheckingAccount check;
    @BeforeEach
    void setUp(){
        check = new CheckingAccount(2000, "Stas");
    }


    @DisplayName("Тест Pay")
    @ParameterizedTest
    @CsvSource(value = {"2000,true", "1000,true", "2001,false"})
    void testPay(int sum, boolean result){
        Assertions.assertEquals(result, check.pay(sum));
    }

    @DisplayName("Тест accept")
    @ParameterizedTest
    @CsvSource(value = {"5000,true", "1,true", "89412,true"})
    void testAccept(int sum, boolean result){
        Assertions.assertEquals(result, check.accept(sum));
    }

}
