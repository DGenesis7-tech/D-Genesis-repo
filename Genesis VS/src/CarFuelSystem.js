
let powerState = 'OFF';
let guage = 0.0;
let speed = 0;

tPower = () => {
    if (guage <= 0) powerState = 'OFF';
    return powerState;
}

 togglePower = () => {
    if (tPower()) {
        if (guage < 5 ) throw new Error('Tank`s guage critically low, fillup fuel tank to start the engine');
        else powerState = 'ON';
    } 
    if (!tPower()) powerState = 'OFF';
}

fGuage = () =>{return guage}

tankGuage =() => {
    if (guage <= 5 && guage > 2) return `${guage}Liters, WARNING: FUEL TANK LOW, ENTERING RESERVE!!!`;
    if (guage <= 2 && guage > 0) return `${guage}Liters, CRITICAL WARNING: FUEL TANK CRITICALLY LOW, REFILL IMMEDIATELY!!!`;
    if (guage > 40 && guage < 50) return `${guage}Liters, FUEL TANK FULL!!!`;
    if (guage >= 50) return `${guage}Liters, FUEL TANK FULL!!! \n REFILLING FUEL TANK WILL LEAD TO OVERFILLING, HENCE SPILLAGE!!!`;
    if (guage > 5 && guage <= 40) return `${guage}Liters, FUEL TANK OK!!!`;
    if (guage <= 0) {
        return `${guage}Liters, FUEL TANK EMPTY!!!`;
    }
}   

fuelRefill = (liters) => {
    if (guage <= 50) {guage += liters}
    if (guage > 50) {guage = 50}  
    return guage;  
}

accelerate = () => {
    if (speed > 35) speed += 4;
    if (speed > 25 && speed <= 35) speed += 3;
    if (speed > 15 && speed <= 25) speed += 2;
    if (speed >= 0 && speed <= 15) speed += 1;
}

decelerate = () => {
    if (speed > 0 && speed <= 15) speed -= 1;
    if (speed > 15 && speed <= 25) speed -= 2;
    if (speed > 25 && speed <= 35) speed -= 3;
    if (speed > 35) speed -= 4;
    if (speed <= 0) speed = 0;
}

mySpeed = () => {return speed}


speedDisplay = () => {
    if (speed > 35 ) return `GEAR(G4)  ${speed}km/h`;
    if (speed > 25 && speed <=35) return `GEAR(G3)  ${speed}km/h`;
    if (speed > 15 && speed <= 25) return `GEAR(G2)  ${speed}km/h`;
    if (speed > 1 && speed <= 15) return `GEAR(G1)  ${speed}km/h`;
    if (speed == 1) return `DRIVE(D) ${speed}km/h`;
    if (speed == 0) return `NEUTRAL(N) ${speed}km/h`;
}


module.exports = {tPower, fGuage, togglePower, fuelRefill, tankGuage}