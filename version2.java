//Functionalized so much cleaner to use
//Version 2.1
//ADDED INPUT VALIDATION TO CREATE TABLE FUNCTION

import java.sql.*;
import java.util.*;
import java.io.*;
import java.lang.String;

public class connectionTomysql {

    private static final String barsFields[] = {"name", "address", "city", "opening", "closing", "phoneNum"};
    private static final String barsKeys[] = {"name"};

    private static final String billFields[] = {"billID", "drinker", "bar", "date", "time", "transID", "quant"};
    private static final String billKey[] = {"transID"};

    private static final String frequentsFields[] = {"name", "bar"};
    private static final String frequentsKey[] = {"name", "bar"};

    private static final String likesField[] = {"name", "beer"};
    private static final String likesKey[] = {"name", "beer"};

    private static final String sellsField[] = {"bar", "menu", "price"};
    private static final String sellskey[] = {"bar", "menu"};

    private static final String itemsField[] = {"Item", "type", "manf"};
    private static final String itemsKey[] = {"Items"};

    private static final String transactionField[] = {"TransID", "item"};
    private static final String transactionKey[] = {"TransID"};

    private static final String drinkerFields[] = {"name", "address", "city", "phoneNum"};
    private static final String drinkerKey[] = {"name"};

    private static final String CSVFILES[] = { "bars.csv", "bill.csv", "frequents.csv", "likes (1).csv", "transaction.csv", "sells.csv", "items.csv", "drinkers.csv"};
    private static final String CSVNAMES[] = {"bars", "bill", "frequents", "likes", "transactions", "sells", "items", "drinkers"};
    private static final String FIELDS[][] = {barsFields, billFields, frequentsFields, likesField, transactionField, sellsField, itemsField, drinkerFields};
    private static final String FIELDSKEYS[][] = {barsKeys, billKey, frequentsKey, likesKey, transactionKey, sellskey, itemsKey, drinkerKey};

    /*0 = bars       | 3 = likes        | 6 = items****/
    /*1 = bill       | 4 = transaction  | 7 = drinkers*/
    /*2 = frequents  | 5 = sells        ***************/
    private static void createTable(Connection conn, int type) throws SQLException{
        Statement stmt = conn.createStatement();
        String tableArray = CSVNAMES[type];
        System.out.println("Creating table: " + tableArray);
        int fieldLength = FIELDS[type].length
           ,keyLength = FIELDSKEYS[type].length;
        StringBuilder sqlTableString = new StringBuilder()
                    , tableString = new StringBuilder()
                    , primaryKey = new StringBuilder();
        //System.out.println("Beer length: " + fieldLength);

        //Check if table already exists
        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet rs = dbm.getTables(null, null, CSVNAMES[type], null);
        if(rs.next()) {
            System.out.println(CSVNAMES[type] + " already exists");
            return;
        }
        else {
            //For table fields
            tableString.append("CREATE TABLE ").append(CSVNAMES[type]).append("(");
            for (int i = 0; i < fieldLength; i++)
                tableString.append(FIELDS[type][i]).append(" VARCHAR(255), ");

            //For primary keys
            primaryKey.append(" PRIMARY KEY (");
            for (int i = 0; i < keyLength; i++)
                primaryKey.append(" ").append(FIELDSKEYS[type][i]);
            primaryKey.append("))");
            sqlTableString.append(tableString).append(primaryKey);

            System.out.println("Table Line: " + sqlTableString.toString());
            stmt.executeUpdate(sqlTableString.toString());
        }
    }
    private static void insertData(Connection conn, int type) throws SQLException, IOException{
        String sqlInsert, currentLine, lineArray[];
        File openCSVfile = new File(FILEPATH + CSVFILES[type]);
        BufferedReader buffer = new BufferedReader(new FileReader(openCSVfile));

        //Building first bit of SQL Query
        int fields = FIELDS[type].length;
        StringBuilder sqlPartone = new StringBuilder()
                , sqlParttwo = new StringBuilder()
                , sqlCreatemerge = new StringBuilder()
                , printString;
        sqlPartone.append("INSERT INTO ").append(CSVNAMES[type]).append(" (");
        sqlParttwo.append(" VALUE (");
        for(int i  = 0; i < fields; i++) {
            if (fields - i == 1) {
                sqlPartone.append(FIELDS[type][i]).append(")");
                sqlParttwo.append("?)");
            }
            else {
                sqlPartone.append(FIELDS[type][i]).append(", ");
                sqlParttwo.append("?,");
            }
        }

        sqlCreatemerge.append(sqlPartone).append(sqlParttwo);
        System.out.println("Insert Line:" + sqlCreatemerge.toString());
        while((currentLine = buffer.readLine()) != null){
            System.out.println("Current line: " + currentLine);
            printString = new StringBuilder();
            printString.append("Line: ");
            lineArray = currentLine.split(",");
            PreparedStatement prepare = conn.prepareStatement(sqlCreatemerge.toString());
            for(int i = 0; i < fields; i++){
                if(lineArray[i].contains("BLANK")) {
                    prepare.setNull(i + 1, Types.VARCHAR);
                    printString.append("null");
                }
                else{
                    prepare.setString(i+1, lineArray[i]);
                    printString.append("-").append(lineArray[i]);
                }
            }
            System.out.println(printString.toString());
            //prepare.executeUpdate();
        }
    }

    public static void main(String arg[]) throws SQLException, IOException {
        Connection conn;

        System.out.println("Fucking connect AWS databsae");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbName = "barbeerdrinkerExtended";
            String userName = REDACTED;
            String password = REDACTED;
            String hostname = HOSTNAME;
            String port = PORTNUM;
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            //Establishing the connection
            //System.out.println("JDBC URL:" + jdbcUrl);
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("Connection successfull\nSuck my internet cock you cunt");

            /*0 = bars  | 3 = frequents    | 6 = sells****/
            /*1 = beers | 4 = likes        | 7 = items****/
            /*2 = bill  | 5 = transactions | 8 = drinkers*/
            createTable(conn, 1);
            insertData(conn, 1);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("\nFuck yes");

    }
}
