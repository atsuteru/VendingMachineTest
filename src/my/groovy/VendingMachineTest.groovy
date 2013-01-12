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
	public void ‹àŠz‚Ì‘Œv‚ğæ“¾‚·‚é() throws Exception {
		def actual = sut.getTotalAmount()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void "100‰~‚ğ“Š“ü‚·‚é"() throws Exception {
		sut.insert(100)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void "1000‰~‚ğ“Š“ü‚·‚é"() throws Exception {
		sut.insert(1000)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(1000))
	}
	
	@org.junit.Test
	public void ‚¨‹à‚ğ•¡”‰ñ“Š“ü‚·‚é() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.getTotalAmount()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void •¥‚¢–ß‚µ‚ª‚Å‚«‚é() throws Exception {
		sut.insert(100)
		def actual = sut.payBack()
		assertThat(actual, is(100))
	}
	
	@org.junit.Test
	public void “Š“ü‚µ‚È‚©‚Á‚½ê‡‚Ì•¥‚¢–ß‚µŠz‚Í0‰~‚Å‚ ‚é() throws Exception {
		def actual = sut.payBack()
		assertThat(actual, is(0))
	}
	
	@org.junit.Test
	public void •¡”‰ñ“Š“ü‚µ‚Ä‚à•¥‚¢–ß‚µ‚ª‚Å‚«‚é() throws Exception {
		sut.insert(500)
		sut.insert(100)
		sut.insert(50)
		def actual = sut.payBack()
		assertThat(actual, is(650))
	}
	
	@org.junit.Test
	public void “Š“ü‚µ‚½‹àŠzˆÈã‚Ì•¥‚¢–ß‚µ‚ª‚È‚¢‚±‚Æ() throws Exception {
		sut.insert(100)
		assertThat("“Š“üŒã‚P‰ñ–Ú‚Ì•¥‚¢–ß‚µ‚Í100‰~", sut.payBack(), is(100))
		assertThat("“Š“üŒã‚Q‰ñ–Ú‚Ì•¥‚¢–ß‚µ‚Í0‰~", sut.payBack(), is(0))
	}
	
	@org.junit.Test
	public void ‘z’èŠO‚Ì‚¨‹à‚Í“Š“ü‚É•¥‚¢–ß‚³‚ê‚é() throws Exception {
		assertThat("1‰~‚Ìê‡", sut.insert(1), is(1))
		assertThat("5‰~‚Ìê‡", sut.insert(5), is(5))
		assertThat("5000‰~‚Ìê‡", sut.insert(5000), is(5000))
	}
	
	@org.junit.Test
	public void ‘z’èŠO‹àí‚Ì•¥‚¢–ß‚µŒã‚Ì‘Œv‚Í0‰~‚Å‚ ‚é() throws Exception {
		sut.insert(1)
		assertThat(sut.getTotalAmount(), is(0))
	}
	
	@Ignore("ƒvƒƒ_ƒNƒgƒR[ƒh–¢À‘•")
	@org.junit.Test
	public void ƒWƒ…[ƒX‚ğ1í—ŞŠi”[‚Å‚«‚é‚±‚Æ() throws Exception {
		def drinkInfo = new DrinkInfo()
		sut.setDrinkInfo(drinkInfo)
		assertThat(sut.getDrinkInfo(), is(drinkInfo))
	}
}
