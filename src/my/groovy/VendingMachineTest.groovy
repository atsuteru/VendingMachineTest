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
	public void 金額の総計を取得する() throws Exception {
		def actual = sut.getTotalAmount()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void "100円を投入する"() throws Exception {
		sut.insert(100)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void "1000円を投入する"() throws Exception {
		sut.insert(1000)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(1000))
	}
	
	@org.junit.Test
	public void お金を複数回投入する() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void 払い戻しができる() throws Exception {
		sut.insert(100)
		def actual = sut.payBack()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void 投入しなかった場合の払い戻し額は0円である() throws Exception {
		def actual = sut.payBack()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void 複数回投入しても払い戻しができる() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.payBack()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void 投入した金額以上の払い戻しがないこと() throws Exception {
		sut.insert(100)
		assertThat("投入後１回目の払い戻しは100円", sut.payBack(), is(100))
		assertThat("投入後２回目の払い戻しは0円", sut.payBack(), is(0))
	}
	
	@org.junit.Test
	public void 想定外のお金は投入時に払い戻される() throws Exception {
		assertThat("1円の場合", sut.insert(1), is(1))
		assertThat("5円の場合", sut.insert(5), is(5))
		assertThat("5000円の場合", sut.insert(5000), is(5000))
	}
	
	@org.junit.Test
	public void 想定外金種の払い戻し後の総計は0円である() throws Exception {
		sut.insert(1)
		assertThat(sut.getTotalAmount(), is(0))
	}
	
	@Ignore("プロダクトコード未実装")
	@org.junit.Test
	public void ジュースを1種類格納できること() throws Exception {
		def drinkInfo = new DrinkInfo()
		sut.setDrinkInfo(drinkInfo)
		assertThat(sut.getDrinkInfo(), is(drinkInfo))
	}
}
