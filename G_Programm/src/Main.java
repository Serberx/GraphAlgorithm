import constants.Constants;
import constantsSec.ConstantsHiden;
import exception.GraphenException;
import model.Matrix;
import model.MatrixVerwaltung;
import persister.PersisterException;
import test.FinalTests;

import java.io.*;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.http.WebSocketHandshakeException;
import java.nio.channels.Channels;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.sql.*;

public class Main{
    public static void main(String[] args){

        String url = ConstantsHiden.URL;
        String user = ConstantsHiden.USER;
        String pw = ConstantsHiden.PW;
        try(Connection con = DriverManager.getConnection(url, user, pw);){
            System.out.println("einfuegen");
            System.out.println("---------------------------------------------");

            String query = "INSERT INTO person (id, vorname, nachname) VALUES ( 7, 'eingefuegt3', 'eingefuegt3') ";
//            String query = "DELETE  FROM person WHERE vorname = 'eingefuegt3' ";

            Statement stmt = con.createStatement();
            stmt.execute(query);

            System.out.println("funkt1");
            stmt.close();


            System.out.println("ausgeben");
            System.out.println("---------------------------------------------");
             query = "SELECT * FROM person ORDER BY id ASC";
             stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int col = rs.getMetaData().getColumnCount();

            System.out.println(col);

            for(int i = 1; i<=col; i++){
                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));
            }
            System.out.println();
            System.out.println("-----------------------------------");
            while(rs.next()){
                for(int i = 1; i<=col; i++){
                    System.out.print(String.format("%-15s", rs.getString(i)));
                }
                System.out.println();
            }

            rs.close();
            stmt.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }


    }
}