describe('Recursive function example', () => {

    function recurse(number) {
        if(number <= 0){
            return cy.wrap(number);
        } else {
            cy.log(number);
            return recurse(number-1);
        }
    }

    it('should recurse a function call', () => {
        recurse(5);
    });
});