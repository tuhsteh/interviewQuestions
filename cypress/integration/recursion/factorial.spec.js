describe('Factorial method using iterative approach', () => {

    const lowerBound = 5;
    const upperLimit = 10;

    var randomCount;

    before('Figure how many Factorial numbers to calculate.', () => {
        randomCount = Math.floor(lowerBound + upperLimit * Math.random());
        cy.log(`Running to [${randomCount}]`);
    });

    function fact(n) {
        if (n == 0) {return 1;}
        var result = n * fact(n - 1);
        cy.log(result);
        return result;
    }

    it('should compute a bunch of Factorial numbers', () => {
        fact(randomCount);
    });
});