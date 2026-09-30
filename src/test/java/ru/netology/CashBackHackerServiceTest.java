package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashBackHackerServiceTest {
    private final CashBackHackerService service = new CashBackHackerService();

    @Test
    void remain_whenAmountIsZero_returnsBoundary() {
        assertEquals(1000, service.remain(0));
    }

    @Test
    void remain_whenAmountIsLessThanBoundary_returnsDifference() {
        assertEquals(500, service.remain(500));
        assertEquals(1, service.remain(999));
    }

    @Test
    void remain_whenAmountEqualsBoundary_returnsBoundary() {
        // По текущей реализации при amount=1000 возвращается 1000
        assertEquals(1000, service.remain(1000));
    }

    @Test
    void remain_whenAmountExceedsBoundary_returnsToNextThreshold() {
        assertEquals(750, service.remain(1250));
        assertEquals(1000, service.remain(2000));
    }

    @Test
    void remain_whenAmountIsMultipleOfBoundary_returnsBoundary() {
        assertEquals(1000, service.remain(3000));
        assertEquals(1000, service.remain(10000));
    }
}