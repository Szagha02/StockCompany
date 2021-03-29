import java.io.*;
import java.util.ArrayList;

/**
 * A calculator!
 *
 * <p>Purdue University -- CS18000 -- Spring 2021 -- Project 2</p>
 *
 * @author Purdue CS
 * @version February 21, 2021
 */

public class Report {
    private int minPrice;
    private int maxPrice;
    private ArrayList<Company> companyList;

    public Report(int minPrice, int maxPrice, ArrayList<Company> companyList) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.companyList = companyList;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(ArrayList<Company> companyList) {
        this.companyList = companyList;
    }

    public void generateReport() {

        try {
            File out = new File("Report.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(out, false));
            int max = getMaxPrice();
            int min = getMinPrice();
            String name = "";
            for (int i = 0; i < companyList.size(); i++) {
                Company company = companyList.get(i);
                name = company.getName();
                if (name == null) {
                    break;


                } else {
                    bw.write(name + " Report\n");
                    int[] prices = company.getPrices();
                    int cntr = 0;
                    for (int z = 0; z < prices.length; z++) {
                        if (prices[z] < min) {
                            bw.write("Below Minimum Price at " + z + " with " + prices[z] + ".\n");
                        } else if (prices[z] > max) {
                            bw.write("Above Maximum Price at " + z + " with " + prices[z] + ".\n");

                        } else {
                            cntr++;
                        }
                        if (cntr == prices.length) {
                            bw.write("All prices are within the range.\n");
                        }
                    }

                }


            }
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void generateReportMax() {

        try {
            File out = new File("ReportMax.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(out, false));

            for (int i = 0; i < companyList.size(); i++) {
                int maxCompany = 0;
                Company company = companyList.get(i);
                String name = company.getName();
                if (name == null) {
                    break;
                } else {
                    int[] prices = company.getPrices();
                    for (int j = 0; j < prices.length; j++) {

                        if (prices[j] > maxCompany) {
                            maxCompany = prices[j];
                        }
                    }
                }
                bw.write(name + "-" + maxCompany + "\n");
            }

            bw.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
