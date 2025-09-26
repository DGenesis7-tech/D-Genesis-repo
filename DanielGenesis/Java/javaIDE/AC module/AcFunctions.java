public class AcFunctions {
    AC object = new AC();

    public void setObject(AC object) {
        this.object = object;
    }

    public String switchMessage(boolean acPower) {
        String message;
        if (acPower) {
            message = "Switched On";
        }
        else {
            message = "Switched Off";
        }
    return  message;
    }

    public void increaseTemperature() {
        if (object.getPower()) {
            if (object.getTemperature() >= 16 && object.getTemperature() < 32) {
                object.setTemperature(object.getTemperature() + 1);
            }
            else {
                throw new IllegalArgumentException("Cannot increase temperature when AC is in minimum temperature.");
            }
        }
        else {
        throw new IllegalArgumentException("Cannot increase temperature when AC is off.");
        }
    }

    public void decreaseTemperature() {
        if (object.getPower()) {
            if (object.getTemperature() > 16 && object.getTemperature() <= 32) {
                object.setTemperature(object.getTemperature() - 1);
            }
            else {
                throw new IllegalArgumentException("Cannot decrease temperature when AC is in maximum temperature.");
            }
        }
        else {
           throw new IllegalArgumentException("Cannot decrease temperature when AC is off.");
        }
    }


}


