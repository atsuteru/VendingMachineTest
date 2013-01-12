package my.groovy;

import static org.junit.Assert.*
import static org.hamcrest.core.Is.is

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test

public class DrinkInfoTest {

	DrinkInfo sut
	
	@Before
	public void setup() {
		sut = new DrinkInfo()
	}

	@Test
	public void 初期状態で在庫を５本格納している() throws Exception {
		def actual = sut.getStock()
		assertThat(actual, is(5))
	}
	
	@Test
	public void 初期状態で名前はコーラである() throws Exception {
		def actual = sut.getName()
		assertThat(actual, is("コーラ"))
	}
	
	@Test
	public void 初期状態で値段は120円である() throws Exception {
		def actual = sut.getPrice()
		assertThat(actual, is(120))
	}

	@Test
	public void 初期状態から本数を減らす() throws Exception {
		sut.decrementStock()
		def actual = sut.getStock()
		assertThat(actual, is(4))
	}
	
	@Test
	public void 初期状態から５回減らすと在庫は0本() throws Exception {
		5.times {
			sut.decrementStock()
		}
		assertThat(sut.getStock(), is(0))
	}

	@Test(expected = UnsupportedOperationException)
	public void 初期状態から６回減らすと操作例外() throws Exception {
		6.times {
			sut.decrementStock()
		}
	}

}
