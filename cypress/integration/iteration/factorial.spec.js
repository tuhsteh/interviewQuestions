describe('Factorial method using iterative approach', () => {

    const lowerBound = 5;
    const upperLimit = 10;

    var randomCount;

    before('Figure how many Factorial numbers to calculate.', () => {
        randomCount = Math.floor(lowerBound + upperLimit * Math.random());
        cy.log(`Running to [${randomCount}]`);
    });

    function fact(n) {
        var prev = 1;
        for (var i = 1; i <= n; i++) {
            var curr = i * prev;
            cy.log(curr);
            prev = curr;
        }
    }

    it('should compute a bunch of Factorial numbers', () => {
        fact(randomCount);
    });
});