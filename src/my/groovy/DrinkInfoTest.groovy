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
	public void ������Ԃō݌ɂ��T�{�i�[���Ă���() throws Exception {
		def actual = sut.getStock()
		assertThat(actual, is(5))
	}
	
	@Test
	public void ������ԂŖ��O�̓R�[���ł���() throws Exception {
		def actual = sut.getName()
		assertThat(actual, is("�R�[��"))
	}
	
	@Test
	public void ������ԂŒl�i��120�~�ł���() throws Exception {
		def actual = sut.getPrice()
		assertThat(actual, is(120))
	}

	@Test
	public void ������Ԃ���{�������炷() throws Exception {
		sut.decrementStock()
		def actual = sut.getStock()
		assertThat(actual, is(4))
	}
	
	@Test
	public void ������Ԃ���T�񌸂炷�ƍ݌ɂ�0�{() throws Exception {
		5.times {
			sut.decrementStock()
		}
		assertThat(sut.getStock(), is(0))
	}

	@Test(expected = UnsupportedOperationException)
	public void ������Ԃ���U�񌸂炷�Ƒ����O() throws Exception {
		6.times {
			sut.decrementStock()
		}
	}

}
