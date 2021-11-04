package cz.skoleni.helloworld;

import java.math.BigDecimal;

public class MainDoubleTrouble {

    public static void main(String[] args) {
        // 0.1 je double
        // 0.1 + 0.2 = 0.30000000000000004
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));

        // Jak tomuto predejit?
        // A) Zaokrouhleni na urcity pocet desetinnych mist
        // B) BigDecimal
        BigDecimal a = BigDecimal.valueOf(0.1);
        BigDecimal b = BigDecimal.valueOf(0.2);
        System.out.println("0.1 + 0.2 = " + a.add(b)); // 0.3
    }

}
