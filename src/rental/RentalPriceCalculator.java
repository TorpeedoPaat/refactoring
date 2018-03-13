package rental;

public class RentalPriceCalculator {

    private final int ADULT = 18;
    private final int EXPERIENCED_ADULT = 21;

    public double calculatePrice(int rentalAge, int drivingLicence, int carTypeBySize, boolean causedAccidents, boolean participatedInAccidents, boolean highSeason) {

        if (rentalAge < ADULT) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }

        if (rentalAge <= EXPERIENCED_ADULT && carTypeBySize > 1) {
            throw new UnsupportedOperationException("Drivers 21 years old or less can only rent Class 1 vehicles");
        }

        if (drivingLicence < 1) {
            throw new IllegalArgumentException("Driver must hold driving drivingLicence at least for one year. Can not rent a car!");
        }

        double rentalPrice = rentalAge;

        if (carTypeBySize >= 4 && rentalAge <= 25 && highSeason) {
            rentalPrice = rentalPrice * 2;
        }

        if (drivingLicence < 3) {
            rentalPrice = rentalPrice * 1.3;
        }

        if (causedAccidents && rentalAge < 30) {
            rentalPrice += 15;
        }

        if (carTypeBySize > 3 && rentalAge <= 25 && highSeason) {
            rentalPrice *= 1.5;
        }

        if (rentalPrice > 1000) {
            return 1000.00;
        }

        return rentalPrice;
    }
}