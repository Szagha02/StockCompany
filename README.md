# StockCompany

Classes: InvalidPriceException, Company, Report, Validator, DataSystem, WrongFormateException  
Takes in input directly from terminal   
javac DataSystem.java   
java DataSystem fileLog.txt
   
File input given as    
    
Max:[Maximum Price]   
Min:[Minimum Price]   
CompanyNumber:[Number of companies in this file]   
[Company Name]:[Price list]  // Repeat for the number of companies   

Ex.   
Max:1000   
Min:100   
CompanyNumber:2   
GameStart:200,300,120,300   
RedBerry:200,800,80,1000,0,10,20,10,9,3   

1 max and 1 min in each file, n companies x prices   


Output:  
   
Report.txt   
GameStart Report   
All prices are within the range.   
RedBerry Report   
Below Minimum Price at 2 with 80.   
Below Minimum Price at 4 with 0.   
Below Minimum Price at 5 with 10.   
Below Minimum Price at 6 with 20.   
Below Minimum Price at 7 with 10.   
Below Minimum Price at 8 with 9.   
Below Minimum Price at 9 with 3.    

ReportMax.txt   
[Company Name]-[MaxPrice]   
[Company Name]-[MaxPrice]   
Lists companies in order in which they appeared in log file   
GameStart-300   
RedBerry-1000   
