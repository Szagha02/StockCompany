import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A calculator!
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 2</p>
 *
 * @author Purdue CS
 * @version February 21, 2021
 */

public class DataSystem {
    Company companies;
    Report report;
    Validator validator;

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        Validator validator = new Validator();
        Validator.checkFile(fileName);
        String strLine = "";
        int maxValue = 0;
        int minValue = 0;
        int companyNumber = 0;
        int cntr = 0;
        try {
            File input = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(input));
            ArrayList<Company> companyList = new ArrayList<Company>();
            while (strLine != null) {
                cntr++;

                switch (cntr) {

                    case (1):
                        try {
                            strLine = br.readLine();
                            System.out.println(strLine);
                            Validator.checkValueFormat(strLine, "MaxValue");
                            strLine = strLine.substring(4);
                            maxValue = Integer.parseInt(strLine.substring(4,strLine.length()));
                        } catch (WrongFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case (2):
                        try {
                            strLine = br.readLine();
                            Validator.checkValueFormat(strLine, "MinValue");
                            strLine = strLine.substring(4,strLine.length());
                            minValue = Integer.parseInt(strLine);
                        } catch (WrongFormatException e) {
                            e.printStackTrace();
                        }
                        break;

                    case (3):

                        try {
                            strLine = br.readLine();
                            Validator.checkValueFormat(strLine, "CompanyNumberValue");
                            strLine = strLine.substring(14,strLine.length());
                            companyNumber = Integer.parseInt(strLine);
                        } catch (WrongFormatException e) {
                            e.printStackTrace();
                        }
                        break;


                }

                try {
                    for (int i = 0; i < companyNumber; i++) {

                        strLine = br.readLine();
                        if (strLine != null) {
                            int indexEquals = strLine.indexOf(":");
                            String companyName = strLine.substring(0, indexEquals);
                            String prices = strLine.substring(indexEquals + 1);
                            int[] price = Arrays.stream(prices.split(",")).mapToInt(Integer::parseInt).toArray();
                            for (int z = 0; z < price.length; z++) {
                                Validator.checkPrice(price[i]);

                            }
                            Company companies = new Company(companyName, price);
                            companyList.add(companies);
                        }
                    }

                } catch (InvalidPriceException e) {
                    e.printStackTrace();
                }
            }
            Report report = new Report(minValue, maxValue, companyList);
            br.close();
            report.generateReport();
            report.generateReportMax();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
