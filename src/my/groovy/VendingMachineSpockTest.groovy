package my.groovy;

import static org.hamcrest.core.Is.is

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test

import spock.lang.*;

class VendingMachineSpockTest extends Specification {
	
	@Unroll
	def "‘z’èŠO‚Ì‚¨‹à#insertMoney‚Í“Š“üŽž‚É#payBackMoney‰~•¥‚¢–ß‚³‚ê‚é"() {
		setup:
		def sut = new VendingMachine()
		
		expect:
		sut.insert(insertMoney) == payBackMoney
		
		where:
		insertMoney	|payBackMoney
		1			|1
		5000		|5000
		10			|0
	}
	
}
