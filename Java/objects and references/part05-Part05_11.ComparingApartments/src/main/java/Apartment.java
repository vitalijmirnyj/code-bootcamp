public class Apartment {
    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {

        if (this.squares > compared.squares) {
            return true;

        } else {
            return false;
        }
    }

    public int priceDifference(Apartment compared) {

        int firstApartmentPrice = this.pricePerSquare * this.squares;
        int comparedApartmentPrice = compared.pricePerSquare * compared.squares;
        return Math.abs(firstApartmentPrice - comparedApartmentPrice);
    }

    public boolean moreExpensiveThan(Apartment compared) {

        if (this.pricePerSquare > compared.pricePerSquare) {
            return true;

        } else {
            return false;
        }
    }
}