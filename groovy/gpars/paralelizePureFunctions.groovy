@Grab(group='org.codehaus.gpars', module='gpars', version='0.12')
import groovyx.gpars.GParsPool

// The idea is to run pure functions (without side effects concurrently)

GParsPool.withPool{
	def computeSum = { i ->
		(1 .. i).inject(0, {a, b -> a + 1/(b * b)})
	}.asyncFun()

	def Closure getPiFromSum = {sumResult ->
		Math.sqrt(6 * sumResult)
	}.asyncFun()

	def promiseSum = computeSum(100)
	// the result is a Promise, which is also a DataflowVariable, so you can request its status
	println "Computation is asynchronous. Are we done yet? " + promiseSum.bound
	def promiseRes = getPiFromSum(promiseSum.get())
	promiseRes.whenBound {res -> println res}
}

