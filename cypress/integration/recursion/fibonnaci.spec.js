describe('Calculate Fibonacci Sequence', () => {

    const lowerBound = 5;
    const upperLimit = 10;

    var randomCount;

    before('Figure number of Fibonacci members to calculate', () => {
        randomCount = Math.floor(lowerBound + upperLimit * Math.random())
        cy.log(`Running to:  [${randomCount}]`);
    });

    function fib(n) {
        for (var i = 0; i < n; i++) {
            if (n < 0) throw {name: "RangeError", message: "Fibonacci is not defined for values less than zero."};
            cy.log(innerFib(i));
        }
    }

    function innerFib(i) {
        if (i == 0) {
            return 1;
        }
        if (i <= 2) {
            return i;
        }
        return innerFib(i-2) + innerFib(i-1);
    }

    it('should give first few Fibonacci numbers', () => {
        fib(randomCount);
    });
});
