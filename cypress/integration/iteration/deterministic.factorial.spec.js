describe('Factorial method using iterative approach', () => {

    const lowerBound = 5;
    const upperLimit = 15;

    var randomCount;

    before('Figure how many Factorial numbers to calculate.', () => {
        randomCount = Math.floor(lowerBound + upperLimit * Math.random());
        cy.log(`Running to [${randomCount}]`);
    });

    // 24 is about the limit that a 32-bit unsigned int can hold.
    const factorials = [
        1,
        1,
        2,
        6,
        24,
        120,
        720,
        5040,
        40320,
        362880,
        3628800, //10
        39916800,
        479001600,
        6227020800,
        87178291200,
        1307674368000,
        20922789888000,
        355687428096000,
        6402373705728000,
        121645100408832000,
        2432902008176640000, //20
        51090942171709440000,
        1124000727777607680000,
        25852016738884976640000,
        15511210043330985984000000,
        403291461126605635584000000,
        10888869450418352160768000000,
        304888344611713860501504000000,
        8841761993739701954543616000000];

    function fact(n) {
        if (n < 0) throw {name: "RangeError", message: "Factorial is undefined for inputs less than 0."}
        for (var i = 1; i <= n; i++) {
            cy.log(factorials[i]);
        }
    }

    it('should compute a bunch of Factorial numbers', () => {
        fact(randomCount);
    });
});