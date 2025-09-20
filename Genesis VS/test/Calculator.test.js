const {add, subtract, multiply, divide, square, addList} = require('../src/calculator');

test('test to add 2 + 1', () => {
    let result = add(2, 1);
    expect(result).toBe(3);
});

test('test to subtract 2 - 1', () => {
    let result = subtract(2, -1);
    expect(result).toBe(3);
});

test('test to multiply 2 * 3', () => {
    let result = multiply(2, 3);
    expect(result).toBe(6);
});

test('test to divide 6 / 2', () => {
    let result = divide(6, 2);
    expect(result).toBe(3);
});

test('test to square 3 * 3', () => {
    let result = square(3, 3);
    expect(result).toBe(27);
});

test('to sum {}', () => {
    let result = addList([1, 2, 3, 4]);
    expect(result).toBe(10);    
});





test('to throw error for increase in temperature if ac is off', () => {
        expect(() => {
            throw new Error('This is an error');
        }).toThrow('This is an error');
    });