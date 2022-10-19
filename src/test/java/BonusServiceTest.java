import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);

    }
    @Test
    void shouldCalculateAnRegisteredAndUnderLimit(){
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }


    @Test
     void shouldCalculateAnRegisteredAndOverLimit(){
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
     void shouldCalculateRegisteredZeroLimit(){

        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void  shouldCalculateAnRegisteredZeroLimit(){
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual =  service.calculate(expected,registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredNegativeLimit(){

        BonusService service = new BonusService();

        long amount = -500;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(expected, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateAnRegisteredNegativeLimit(){

        BonusService service = new BonusService();

        long amount = -500;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(expected, registered);
        assertEquals(expected, actual);
    }
}