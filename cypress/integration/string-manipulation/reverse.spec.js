const casual = require('casual-browserify');

describe('Reverse a string.', () => {

    it('should reverse a string', () => {
        var origin = casual.sentence;
        cy.log(`Original words:  [${origin}]`)
        var splitSentence = origin.split("");
        var revSentence = splitSentence.reverse().join("");
        cy.log(`Reversed word:  [${revSentence}]`);
    });
});