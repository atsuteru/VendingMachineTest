package my.groovy;

import static org.hamcrest.core.Is.is

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test

import spock.lang.*;

class VendingMachineSpockTest extends Specification {
	
	@Unroll
	def "想定外のお金#insertMoneyは投入時に#payBackMoney円払い戻される"() {
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
