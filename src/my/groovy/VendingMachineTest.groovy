package my.groovy;

import static org.junit.Assert.*
import static org.hamcrest.core.Is.is

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test

class VendingMachineTest {

	VendingMachine sut
	
	@Before
	public void setup() {
		sut = new VendingMachine()
	}
	
	@Test
	public void ���z�̑��v���擾����() throws Exception {
		def actual = sut.getTotalAmount()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void "100�~�𓊓�����"() throws Exception {
		sut.insert(100)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void "1000�~�𓊓�����"() throws Exception {
		sut.insert(1000)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(1000))
	}
	
	@org.junit.Test
	public void �����𕡐��񓊓�����() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void �����߂����ł���() throws Exception {
		sut.insert(100)
		def actual = sut.payBack()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void �������Ȃ������ꍇ�̕����߂��z��0�~�ł���() throws Exception {
		def actual = sut.payBack()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void �����񓊓����Ă������߂����ł���() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.payBack()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void �����������z�ȏ�̕����߂����Ȃ�����() throws Exception {
		sut.insert(100)
		assertThat("������P��ڂ̕����߂���100�~", sut.payBack(), is(100))
		assertThat("������Q��ڂ̕����߂���0�~", sut.payBack(), is(0))
	}
	
	@org.junit.Test
	public void �z��O�̂����͓������ɕ����߂����() throws Exception {
		assertThat("1�~�̏ꍇ", sut.insert(1), is(1))
		assertThat("5�~�̏ꍇ", sut.insert(5), is(5))
		assertThat("5000�~�̏ꍇ", sut.insert(5000), is(5000))
	}
	
	@org.junit.Test
	public void �z��O����̕����߂���̑��v��0�~�ł���() throws Exception {
		sut.insert(1)
		assertThat(sut.getTotalAmount(), is(0))
	}
	
	@Ignore("�v���_�N�g�R�[�h������")
	@org.junit.Test
	public void �W���[�X��1��ފi�[�ł��邱��() throws Exception {
		def drinkInfo = new DrinkInfo()
		sut.setDrinkInfo(drinkInfo)
		assertThat(sut.getDrinkInfo(), is(drinkInfo))
	}
}
