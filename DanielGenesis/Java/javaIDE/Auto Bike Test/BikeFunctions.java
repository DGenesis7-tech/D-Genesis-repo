public class BikeFunctions {
    Bike bike = new Bike() ;

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public String accelerate() {
        String dashBoard = "";
        if (bike.getPower() == false) {
            throw new IllegalArgumentException("Bike power is off");
        }
        if (bike.getSpeed() >= 41) {
            bike.setSpeed(bike.getSpeed() + 4);
            dashBoard = "Gear 4 : " + bike.getSpeed() + "kmp";
        }
        if (bike.getSpeed() <= 40 & bike.getSpeed() >= 31) {
            bike.setSpeed(bike.getSpeed() + 3);
            if (bike.getSpeed() >= 31 && bike.getSpeed() <= 40) {
                dashBoard = "Gear 3 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() >= 41 && bike.getSpeed() <= 43) {
                dashBoard = "Gear 4 : " + bike.getSpeed() + "kmp";
            }
        }
        if (bike.getSpeed() <= 30 & bike.getSpeed() >= 21) {
            bike.setSpeed(bike.getSpeed() + 2);
            if (bike.getSpeed() >= 21 && bike.getSpeed() <= 30) {
                dashBoard = "Gear 2 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() >= 31 && bike.getSpeed() <= 32) {
                dashBoard = "Gear 3 : " + bike.getSpeed() + "kmp";
            }
        }
        if (bike.getSpeed() <= 20 & bike.getSpeed() >= 0) {
            bike.setSpeed(bike.getSpeed() + 1);
            if (bike.getSpeed() >= 0 && bike.getSpeed() <= 20) {
                dashBoard = "Gear 1 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() == 21) {
                dashBoard = "Gear 2 : " + bike.getSpeed() + "kmp";
            }
        }
    return dashBoard;
    }


    public String decelerate() {
        String dashBoard = "";
        if (bike.getPower() == false) {
            throw new IllegalArgumentException("Bike power is off");
        }
        if (bike.getSpeed() <= 20 & bike.getSpeed() >= 0) {
            bike.setSpeed(bike.getSpeed() - 1);
            if (bike.getSpeed() >= 0 && bike.getSpeed() <= 20) {
                dashBoard = "Gear 1 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() < 0) {
                dashBoard = "Gear 1 : " + 0 + "kmp";
                bike.setSpeed(0);
            }
        }
        if (bike.getSpeed() <= 30 & bike.getSpeed() >= 21) {
            bike.setSpeed(bike.getSpeed() - 2);
            if (bike.getSpeed() >= 21 && bike.getSpeed() <= 30) {
                dashBoard = "Gear 2 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() >= 19 && bike.getSpeed() <= 20) {
                dashBoard = "Gear 1 : " + bike.getSpeed() + "kmp";
            }
        }
        if (bike.getSpeed() <= 40 & bike.getSpeed() >= 31) {
            bike.setSpeed(bike.getSpeed() - 3);
            if (bike.getSpeed() >= 31 && bike.getSpeed() <= 40) {
                dashBoard = "Gear 3 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() >= 28 && bike.getSpeed() <= 30) {
                dashBoard = "Gear 2 : " + bike.getSpeed() + "kmp";
            }
        }
        if (bike.getSpeed() >= 41) {
            bike.setSpeed(bike.getSpeed() - 4);
            if (bike.getSpeed() < 41) {
                dashBoard = "Gear 3 : " + bike.getSpeed() + "kmp";
            }
            else if (bike.getSpeed() >= 41) {
                dashBoard = "Gear 4 : " + bike.getSpeed() + "kmp";
            }
        }
        return dashBoard;
    }
}
