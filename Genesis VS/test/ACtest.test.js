const {power, toggleButton, statusDisplay, temperature, temperatureDisplay, decreaseTemperature, increaseTemperature} = require('../src/AC');

describe('Test for Genesis AC`s Power feature', () => {
    test('should be powered off initially', () => {
        let result = power();
        expect(result).toBe(false);
    });

    test('should power on', () => {
        toggleButton(); // on
        let result = power();
        expect(result).toBe(true);
    });

    test('should display status if power off', () => {
        toggleButton(); // off
        let result = statusDisplay();
        expect(result).toBe("AC is off");
    });

    test('should display status if power on', () => {
        toggleButton(); // on
        let result = statusDisplay();
        expect(result).toBe("AC is on");
    });
});

describe('Test for Genesis AC`s Temperature feature', () => {
    test('default temperature is 16°C when Ac is turned on', () => {
        toggleButton(); // off
        toggleButton(); // on
        let result = temperature();
        expect(result).toBe(16);
        let result2 = temperatureDisplay();
        expect(result2).toBe(`${temperature()}°C`);
    });

    test('decrease temperature by default 1 when Ac is on', () => {
        let temp = temperature();
        decreaseTemperature();
        let result = temperature();
        expect(result).toBe(temp + 1);
        let result2 = temperatureDisplay();
        expect(result2).toBe(`${result}°C`);
    });

    test('throw error for decrease in temperature if Ac is off', () => {
        toggleButton(); // off
        expect(() => decreaseTemperature()).toThrow('AC is off, invalid action'); 
    });

    test('default minimum temperature is 30', () => {
        toggleButton(); // on
        for (let count = 0; count < 14; count++) {
            decreaseTemperature();
        }
        let result = decreaseTemperature();
        expect(result).toBe(30);
        let result2 = temperatureDisplay();
        expect(result2).toBe(`${temperature()}°C`);
    });

    test('to increase temperature by default 1 when Ac is on', () => {
        increaseTemperature();
        let result  = increaseTemperature();
        expect(result).toBe(28);
        let result2 = temperatureDisplay();
        expect(result2).toBe(`${result}°C`);
    });
    
    test('temperature maintains minimum temperature if decrease at minimum temperature', () => {
        for (let count = 0; count < 20; count++) {
            decreaseTemperature();
        }
        let result = decreaseTemperature();
        expect(result).toBe(30);
    });

    test('temperature maintains maximum temperature if decrease at maximum temperature', () => {
        for (let count = 0; count <= 17; count++) {
            increaseTemperature();
        }
        let result = increaseTemperature();
        expect(result).toBe(16);
    });

    test('throw error for increase in temperature if Ac is off', () => {
        toggleButton(); // off  
        expect(() => increaseTemperature()).toThrow('AC is off, invalid action'); 
    });

});