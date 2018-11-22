package ru.itpark;



import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class creditServiceTest {

    @org.junit.jupiter.api.Test
    void creditCalc() {
        creditService service = new creditService();
        double sum = service.creditCalc(30_000.00, 13.9, 36 );
        assertEquals (1023.87, sum);
    }{
        creditService service = new creditService();
        double sum = service.creditCalc(1_299_350.00, 10, 120 );
        assertEquals (17171.0, sum);
    }{
        creditService service = new creditService();
        double sum = service.creditCalc(100_000, 10, 10 );
        assertEquals (10464.03, sum);
    }{
        creditService service = new creditService();
        double sum = service.creditCalc(-1000, 10, 1 );
        assertEquals (0, sum);

    }
}