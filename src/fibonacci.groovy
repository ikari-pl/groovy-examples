/**
 * Calculates n-th number of the Fibonacci sequence by recursion (as in definition).
 * Is very slow. Better not to use for n >= 30.
 * @param n index of the sequence element to calculate
 * @return n-th Fibonacci sequence element
 */
def fib(n) { n < 2 ? n : fib(n - 2) + fib(n - 1) }





//region Here you'll see a faster fibonacci
/**
 * This one uses the memoization magic to optimize the recursion.
 */
def fastFib;
def fiboClosure = { BigInteger n -> n < 2 ? n : fastFib(n - 2) + fastFib(n - 1) }
fastFib = fiboClosure.memoize()
//endregion





//region And an execution time measurement closure :)
def measure = { closure ->
    start = System.currentTimeMillis()
    closure.call()
    now = System.currentTimeMillis()
    now - start
}
//endregion





println fib(30)
println fiboClosure(50)
//region fiboClosure measured
def duration = measure {
    println fiboClosure(300)
}
println "Calculation of fib(300) took ${duration}ms"
//endregion

assert fiboClosure(500) == 139423224561697880139724382870407283950070256587697307264108962948325571622863290691557658876222521294125
/* see http://www.wolframalpha.com/input/?i=fib(500) */
