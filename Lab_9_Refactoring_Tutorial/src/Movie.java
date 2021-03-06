public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String _title;

    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    private Price _price;

    public Price getPrice() {
        return _price;
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public void set_priceCode(int _priceCode) {
        switch (_priceCode) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public Movie(String title, int priceCode) {
        setTitle(title);

        set_priceCode(priceCode);
    }

    public int getFrequentRenterPoints(int daysRented) {
        // add frequent renter points
        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((get_priceCode() == Movie.NEW_RELEASE)
                && daysRented > 1) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    public class ChildrensPrice extends Price {

        @Override
        public int getPriceCode() {

            return Movie.CHILDRENS;

        }

        @Override
        public double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 1.5;
            if (daysRented > 3) {
                result += (daysRented - 3) * 1.5;
            }
            return result;
        }
    }

    public class NewReleasePrice extends Price {

        public int getPriceCode() {

            return Movie.NEW_RELEASE;

        }

        @Override
        public double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 0;
            result += daysRented * 3;
            return result;
        }

        @Override
        public int getFrequentRenterPoints(int daysRented) {
            // add frequent renter points
            int frequentRenterPoints = 1;
            // add bonus for a two day new release rental
            if ((get_priceCode() == Movie.NEW_RELEASE)
                    && daysRented > 1) frequentRenterPoints++;
            return frequentRenterPoints;
        }
    }

    public class RegularPrice extends Price {

        public int getPriceCode() {
            return Movie.REGULAR;
        }

        @Override
        public double getCharge(int daysRented) {
            //determine amounts for each line
            double result = 0;
            result += 2;
            if (daysRented > 2) {
                result += (daysRented - 2) * 1.5;
            }
            return result;
        }

    }
}

