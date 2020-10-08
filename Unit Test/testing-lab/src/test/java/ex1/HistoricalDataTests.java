package ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.Exception;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class HistoricalDataTests {

	@Test
	void addValueTest() {
		HistoricalData hd = new HistoricalData(0.0, 0.0, 0);
		hd.add(10);
		assertEquals(10, hd.max(), "after add 10 to 0, max should be 10");
	}

	@Test
	void divideByZeroExceptionAverage() {
		HistoricalData hd = new HistoricalData(0.0, 0.0, 0);
		Exception exception = assertThrows(ArithmeticException.class, () -> hd.average());
		assertEquals("/ by zero", exception.getMessage());
	}

	@Test
	void divideByZeroExceptionMax() {
		HistoricalData hd = new HistoricalData(0.0, 0.0, 0);
		Exception exception = assertThrows(ArithmeticException.class, () -> hd.max());
		assertEquals("/ by zero", exception.getMessage());
	}

}
