describe('Calculate Fibonacci Sequence', () => {

    const lowerBound = 5;
    const upperLimit = 10;

    var randomCount;

    before('Figure number of Fibonacci members to calculate', () => {
        randomCount = Math.floor(lowerBound + upperLimit * Math.random())
        cy.log(`Running to:  [${randomCount}]`);
    });

    function fib(n) {
        if (n < 0) throw {name: "RangeError", message: "Fibonacci is not defined for values less than zero."};
        var nMinus2 = 0;
        var nMinus1 = 1;
        var curr = 1;
        var i = 0;
        while (i++ < n) {
            cy.log(curr);
            curr = nMinus2 + nMinus1;
            nMinus2 = nMinus1;
            nMinus1 = curr;
        }
    }

    it('should give first few Fibonacci numbers', () => {
        fib(randomCount);
    });
});
