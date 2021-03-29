import java.io.File;
import java.io.FileNotFoundException;

/**
 * A calculator!
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 2</p>
 *
 * @author Purdue CS
 * @version February 21, 2021
 */

public class Validator {


    public static int checkPrice(int price) throws InvalidPriceException {

        if (price >= 0) {
            return price;
        } else {
            throw new InvalidPriceException("Invalid Price Format:" + price);

        }
    }

    public static int checkValueFormat(String line, String valueType) throws WrongFormatException {
        int z = 0;
        switch (valueType) {


            case ("MaxValue"):
                if (line.contains("Max:")) {
                    line = line.substring(4,line.length());
                    z = Integer.parseInt(line);


                } else {
                    throw new WrongFormatException("Invalid " + valueType + " error.");
                }
                break;
            case ("MinValue"):
                if (line.contains("Min:")) {
                    line = line.substring(4,line.length());
                    z = Integer.parseInt(line);
                } else {
                    throw new WrongFormatException("Invalid " + valueType + " error.");
                }
                break;

            case ("CompanyNumberValue"):
                if (line.contains("CompanyNumber")) {
                    line = line.substring(14,line.length());
                    z = Integer.parseInt(line);
                }
                break;
        }

        return z;
    }

    public static void checkFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (f.exists()) {

        } else {
            throw new FileNotFoundException("File: " + fileName + " is invalid.");
        }
    }
}
