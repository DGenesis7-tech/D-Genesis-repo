const {tPower, fGuage, togglePower, fuelRefill, fuelGuage} = require('../src/CarFuelSystem')

describe('Test for Genesis Car power and fuel tank feautures', () => {
    test('car initial power should be off', () => {
        let result = tPower();
        expect(result).toBe('OFF');
    });

    test('car initial fuel guage should be zero Liters', () => {
        let result = fGuage();
        expect(result).toBe(0);
    });

    test('throw error for starting car when fuel guage is less than 5 liters', () => {
        expect(() => togglePower()).toThrow('Tank`s guage critically low, fillup fuel tank to start the engine'); 
    });

    test('to fuel car', () => {
        fuelRefill(10);
        let result = fGuage();
        expect(result).toBe(10);
    });

    test('to display the car`s fuel guage ', () => {
       let result = tankGuage();
       expect(result).toBe(`${fGuage()}Liters, FUEL TANK OK!!!`); 
    });

    test('to prevent overfilling of fuel tank', () => {
        fuelRefill(60);
        let result = fGuage();
        expect(result).toBe(50);
    });

    test('to display the car`s fuel guage overfilled', () => {
        let result = tankGuage();
        expect(result).toBe(`${fGuage()}Liters, FUEL TANK FULL!!! \n REFILLING FUEL TANK WILL LEAD TO OVERFILLING, HENCE SPILLAGE!!!`);
    });

    test('to start car', () => {
        togglePower(); // on
        let result = tPower();
        expect(result).toBe('ON');
    });
});

describe('Test for Genesis Car fuel tank warning levels', () => {
    test('to display the car`s fuel guage at low level', () => {
        fuelRefill(-46);
        let result = tankGuage();
        expect(result).toBe(`${fGuage()}Liters, WARNING: FUEL TANK LOW, ENTERING RESERVE!!!`);
    });

    test('to display the car`s fuel guage at critically low level', () => {
        fuelRefill(-2);
        let result = tankGuage();
        expect(result).toBe(`${fGuage()}Liters, CRITICAL WARNING: FUEL TANK CRITICALLY LOW, REFILL IMMEDIATELY!!!`);
    });

    test('to display the car`s fuel guage at empty level', () => {
        fuelRefill(-2);
        let result = tankGuage();
        expect(result).toBe(`${fGuage()}Liters, FUEL TANK EMPTY!!!`);
    });

    test('car power should be off when fuel tank is empty', () => {
        let result = tPower();
        expect(result).toBe('OFF');
    });

describe('Test for Genesis Car fuel refill feature', () => {
    test('to refill car fuel tank', () => {
        fuelRefill(20);
        let result = fGuage();
        expect(result).toBe(20);
    });

    test('to display the car`s fuel guage after refilling', () => {
        let result = tankGuage();
        expect(result).toBe(`${fGuage()}Liters, FUEL TANK OK!!!`);
    });
});

describe('Test for Genesis Car gear and speed features', () => {
    test
}); 