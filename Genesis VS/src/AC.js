let switchPower = false;
let acTemperature = 16;
let acTemperatureDisplay = `${acTemperature}°C`;

function power() {
    return switchPower;
}

function toggleButton() {
    switchPower = !switchPower;
    if (switchPower) {
        acTemperature = 16;
        acTemperatureDisplay = `${acTemperature}°C`;
    }
}

function statusDisplay() {
    if (switchPower) return "AC is on";
    else return "AC is off";
}

function temperature() {
    return acTemperature;
}

function temperatureDisplay() {
    return acTemperatureDisplay;
}

function decreaseTemperature() {
    if (!power()) {
        throw new Error('AC is off, invalid action');
    }   
    if (acTemperature >= 16 && acTemperature < 30) {
        acTemperature++;
        acTemperatureDisplay = `${acTemperature}°C`;
    }
    if (acTemperature > 30) {
        acTemperature = 30;
        acTemperatureDisplay = `${acTemperature}°C`;
    }
    return acTemperature;
}

function increaseTemperature() {
    if (!power()) {
        throw new Error('AC is off, invalid action');
    }   
    if (acTemperature > 16 && acTemperature <= 30) {
        acTemperature--;
        acTemperatureDisplay = `${acTemperature}°C`;
    }
    if (acTemperature < 16) {
        acTemperature = 16;
        acTemperatureDisplay = `${acTemperature}°C`;
    }
    return acTemperature;
}
    



module.exports = {power, toggleButton, statusDisplay, temperature, temperatureDisplay, decreaseTemperature, increaseTemperature};