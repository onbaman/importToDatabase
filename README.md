# importToDatabase
This was created for my database project where I needed to load custom CSV files into a AWS RDS server. Certain areas have been redacted for privacy.

Just because I'm lazy I created multiple arrays that store all of my CSV data. If your CSV contained a header row you could do fancy stuff with arraylists to dynamically create and modify your header rows.

**For this to work you need to add a special webdriver depending on what type of SQL server you are using. In my case I am using the MySQL driver. Simply google search "MySQL/SQL webdriver java" and add that to your IDE


**The file named json-simple-1.1.1.jar is the specific webdriver library that I used
