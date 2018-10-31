//This is the first version
//Mainly a rush job, next job will be functionalized to make it easier to use
//Some areas have been modified to remove any identifying features

import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.String;

public class connectionTomysql {

    private static final String barFields[] = {"name", "address", "city", "opening", "closing", "phoneNum"};
    private static final String beersFields[] = {"name", "manf"};
    private static final String billFields[] = {"billID", "bar", "drinker", "date", "time", "transID", "quant"};
    private static final String frequentsFields[] = {"name", "bar"};
    private static final String likesField[] = {"name", "beer"};
    private static final String sellsField[] = {"bar", "menu", "manf", "price"};
    private static final String itemsField[] = {"Item", "manf"};
    private static final String transactionField[] = {"TransID", "item"};
    private static final String drinkerFields[] = {"name", "address", "city", "phoneNum"};

    private static final String CSVFILES[] = { "bars.csv", "names.csv", "beers.csv", "bill.csv", "frequents.csv", "likes.csv",
                                    "transaction.csv", "sells.csv", "items.csv", "drinkers.csv"};
    private static final String CSVNAMES[] = {"bars", "beers", "bill", "frequents", "likes", "transactions", "sells", "items", "drinkers"};

    private static void createTable(String tableName, Connection conn, Statement stmt, int table) throws SQLException{
        stmt = conn.createStatement();
        System.out.println("Creating table: " + tableName);
        int fieldLength = (tableName + "Fields").length();
        StringBuilder tableString = new StringBuilder();
    }

    public static void main(String arg[]) throws SQLException, IOException {
        Connection conn;

        System.out.println("Fucking connect AWS databsae");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbName = REDACTED;
            String userName = REDACTED;
            String password = REDACTED;
            String hostname = HOSTNAME;
            String port = PORTNUM;
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            //Establishing the connection
            //System.out.println("JDBC URL:" + jdbcUrl);
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection successfull\nSuck my internet cock you cunt");

            /**************************/
            /*CREATION OF THE TABLES*/
            /*************************/
            Statement stmt = conn.createStatement();
            String createTable;

//            System.out.println("Creating Names Table");
////            //bars table
//            createTable = "CREATE TABLE bars "
//                    + " (" + barFields[0] + " VARCHAR(255), "
//                    + " " + barFields[1] + " VARCHAR(255), "
//                    + " " + barFields[2] + " VARCHAR(255), "
//                    + " " + barFields[3] + " VARCHAR(255), "
//                    + " " + barFields[4] + " VARCHAR(255), "
//                    + " " + barFields[5] + " VARCHAR(255), "
//                    + " PRIMARY KEY (" + barFields[0] + "))";
//            stmt.executeUpdate(createTable);

//            System.out.println("Creating beer table");
            //beers table
//            createTable = "CREATE TABLE " + CSVNAMES[1]
//                    + " (" + beersFields[0] + " VARCHAR(255), "
//                    + " " + beersFields[1] + " VARCHAR(255)) ";
//
//            stmt.executeUpdate(createTable);
//            System.out.println("Name Table Created");

//            System.out.printf("Creating bill table");
//            createTable = "CREATE TABLE " + CSVNAMES[2]
//                    + " (" + billFields[0] + " VARCHAR(255), "
//                    + " " + billFields[1] + " VARCHAR(255), "
//                    + " " + billFields[2] + " VARCHAR(255), "
//                    + " " + billFields[3] + " VARCHAR(255), "
//                    + " " + billFields[4] + " VARCHAR(255), "
//                    + " " + billFields[5] + " VARCHAR(255), "
//                    + " " + billFields[6] + " VARCHAR(255), "
//                    + " PRIMARY KEY (" + billFields[5] + "))";
//            stmt.executeUpdate(createTable);

//            System.out.println("Creating frequents table");
//            createTable = "CREATE TABLE " + CSVNAMES[3]
//                    + " (" + frequentsFields[0] + " VARCHAR(255), "
//                    + " " + frequentsFields[1] + " VARCHAR(255), "
//                    + " PRIMARY KEY (" + frequentsFields[0] + "," + frequentsFields[1] + "))";
//            stmt.executeUpdate(createTable);

//            System.out.println("Creating likes table");
//            createTable = "CREATE TABLE " + CSVNAMES[4]
//                    + " (" + likesField[0] + " VARCHAR(255), "
//                    + " " + likesField[1] + " VARCHAR(255), "
//                    + " PRIMARY KEY (" + likesField[0] + "," + likesField[1] + "))";
//            stmt.executeUpdate(createTable);

//            System.out.println("Creating transactions table");
//            createTable = "CREATE TABLE " + CSVNAMES[5]
//                    + " (" + transactionField[0] + " INTEGER, "
//                    + " " + transactionField[1] + " VARCHAR(255), "
//                    + " PRIMARY KEY (" + transactionField[0] + "," + transactionField[1] +"))";
//            stmt.executeUpdate(createTable);

            System.out.println("Creating sells table");
            createTable = " CREATE TABLE " + CSVNAMES[6]
                    + " (" + sellsField[0] + " VARCHAR(255), "
                    + " " + sellsField[1] + " VARCHAR(255), "
                    + " " + sellsField[2] + " VARCHAR(255), "
                    + " " + sellsField[3] + " VARCHAR(255), "
                    + " PRIMARY KEY (" + sellsField[0] + "," + sellsField[1] + "))";
            stmt.executeUpdate(createTable);

//            System.out.println("Creating items table");
//            createTable = " CREATE TABLE " + CSVNAMES[7]
//                    + " (menu VARCHAR(255), "
//                    + " PRIMARY KEY (menu))";
//            stmt.executeUpdate(createTable);

//            System.out.println("Creating drinkers table");
//            createTable = " CREATE TABLE " + CSVNAMES[8]
//                        + " (" + drinkerFields[0] + " VARCHAR(255), "
//                        + " " + drinkerFields[1] + " VARCHAR(255), "
//                        + " " + drinkerFields[2] + " VARCHAR(255), "
//                        + " " + drinkerFields[3] + " VARCHAR(255), "
//                        + " PRIMARY KEY (" + drinkerFields[0] + "))";
//
//            stmt.executeUpdate(createTable);


            /**********************************************/
            /************INSERTION OF DATA*****************/
            /**********************************************/
            //Uploading bar data
//            String insertData, line, lineArray[];
//            File openCSV = new File(FILEPATH + CSVFILES[0]);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    insertData = "INSERT INTO bars (name, address, city, opening, closing, phoneNum) VALUE (?,?,?,?,?,?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    prepare.setString(1, lineArray[0]);
//                    prepare.setString(2, lineArray[1].replaceFirst(" ",""));
//                    prepare.setString(3, lineArray[2].replaceFirst(" ",""));
//                    prepare.setString(4, lineArray[3].replaceFirst(" ",""));
//                    prepare.setString(5, lineArray[4].replaceFirst(" ",""));
//                    prepare.setString(6, lineArray[5].replaceFirst(" ",""));
//                    System.out.println("Inserting: " + lineArray[0] + " " + lineArray[1] + " " + lineArray[2] + " " + lineArray[3]
//                            + " " + lineArray[4]+ " " + lineArray[5]);
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
            //Uploading Frequents table
//            String insertData, line, lineArray[], name[], bar[];
//            File openCSV = new File(FILEPATH + CSVFILES[4]);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    //System.out.println("Line: " + line);
//                    insertData = "INSERT INTO frequents (name, bar) VALUE (?,?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    System.out.println("Frequents: " + lineArray[0] + " " + lineArray[1]);
//                    prepare.setString(1, lineArray[0]);
//                    prepare.setString(2, lineArray[1].replaceFirst(" ", ""));
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }

            //Insertion of transaction data
//            String insertData, line, lineArray[], transID[], item[];
//            File openCSV = new File(FILEPATH + CSVFILES[6]);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    insertData = "INSERT INTO transactions (TransID, item) VALUE (?,?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    transID = lineArray[0].split("=");
//                    item = lineArray[1].split("=");
//
//                    prepare.setString(1, transID[1]);
//                    prepare.setString(2, item[1]);
//                    System.out.println("trans:" + transID[1] + item[1]);
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
            //Insertion of the likes table
//            String insertData, line, lineArray[], name[], beer[];
//            File openCSV = new File(FILEPATH + CSVFILES[5]);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    //System.out.println("Line: " + line);
//                    insertData = "INSERT INTO likes (name, beer) VALUE (?,?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    System.out.println("Likes: " + lineArray[0] + " " + lineArray[1]);
//                    prepare.setString(1, lineArray[0]);
//                    prepare.setString(2, lineArray[1].replaceFirst(" ", ""));
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }

            //Insertion of items table
//            String insertData, line, lineArray[], item[];
//            StringBuilder tempLine;
//            File openCSV = new File(FILEPATH);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    tempLine = new StringBuilder();
//                    //System.out.println("Line: " + line);
//                    insertData = "INSERT INTO items (menu) VALUE (?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    //item = lineArray[0].split("=");
//                    System.out.println("Item: " + lineArray[0]);
//                    prepare.setString(1, lineArray[0]);
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
        //Insertion of drinkers
////            String insertData, line, lineArray[], name[], address[], city[], phoneNum[];
////            File openCSV = new File(FILEPATH + CSVFILES[1]);
////            BufferedReader buffer;
////            try {
////                buffer = new BufferedReader(new FileReader(openCSV));
////                while( (line = buffer.readLine()) != null){
////                    //System.out.println("Line: " + line);
////                    insertData = "INSERT INTO drinkers (name, address, city, phoneNum) VALUE (?,?,?,?)";
////                    PreparedStatement prepare = conn.prepareStatement(insertData);
////                    lineArray = line.split(",");
////                    System.out.println("Item: " + lineArray[0] + " " + lineArray[1] + " " + lineArray[2] + " " + lineArray[3]);
////                    prepare.setString(1, lineArray[0]);
////                    prepare.setString(2, lineArray[1].replaceFirst(" ", ""));
////                    prepare.setString(3, lineArray[2].replaceFirst(" ", ""));
////                    prepare.setString(4, lineArray[3].replaceFirst(" ", ""));
////                    prepare.executeUpdate();
////
////                }
////            } catch (IOException e){
////                e.printStackTrace();
////            }
            //Insertion of bill
//            String insertData, line, lineArray[];
//            File openCSV = new File(FILEPATH + CSVFILES[3]);
//            BufferedReader buffer;
//            try {
//                buffer = new BufferedReader(new FileReader(openCSV));
//                while( (line = buffer.readLine()) != null){
//                    insertData = "INSERT INTO bill (billID, drinker, bar, date, time, transID, quant) VALUE (?,?,?,?,?,?,?)";
//                    PreparedStatement prepare = conn.prepareStatement(insertData);
//                    lineArray = line.split(",");
//                    //System.out.println("Line Size: " + lineArray.length);
//                    System.out.println("Bill:-" + lineArray[0] + "-" + lineArray[1].replaceFirst(" ","") + "-"
//                            + lineArray[2].replaceFirst(" ","") + "-" + lineArray[3].replaceFirst(" ","") + "-"
//                            + lineArray[4].replaceFirst(" ","") + "-" + lineArray[5].replaceFirst(" ","") + "-" + lineArray[6]);
//                    prepare.setString(1, lineArray[0]);
//                    prepare.setString(2, lineArray[1].replaceFirst(" ",""));
//                    prepare.setString(3, lineArray[2].replaceFirst(" ",""));
//                    prepare.setString(4, lineArray[3].replaceFirst(" ",""));
//                    prepare.setString(5, lineArray[4].replaceFirst(" ",""));
//                    prepare.setString(6, lineArray[5].replaceFirst(" ",""));
//                    prepare.setString(7, lineArray[6]);
//                    prepare.executeUpdate();
//
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//            //Insertion of sells table
            String insertData, line, lineArray[], bar[], menu[];
            File openCSV = new File(FILEPATH);
            BufferedReader buffer;
            try {
                buffer = new BufferedReader(new FileReader(openCSV));
                while( (line = buffer.readLine()) != null){
                    //System.out.println("Line: " + line);
                    insertData = "INSERT INTO sells (bar, menu, manf, price) VALUE (?,?,?,?)";
                    PreparedStatement prepare = conn.prepareStatement(insertData);
                    lineArray = line.split(",");
                    System.out.println("Sells:-" + lineArray[0] + "-" + lineArray[1] + "-" +lineArray[2] + "-" +lineArray[3]);
                    prepare.setString(1, lineArray[0]);
                    prepare.setString(2, lineArray[1]);
                    if(lineArray[2].equals(""))
                        prepare.setNull(3, Types.VARCHAR);
                    else
                        prepare.setString(3, lineArray[2]);
                    prepare.setString(4, lineArray[3]);
                    prepare.executeUpdate();

                }
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\nFuck yes");

    }
}
