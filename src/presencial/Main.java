package presencial;

import java.sql.*;

public class Main {
    private static final String SQL_CREATE_TABLE="drop table if exists animales; create table animales( ID int primary key, NOMBRE varchar(100) not null, TIPO varchar(100) not null)";
    private static final String SQL_INSERT_1="insert into animales(ID, NOMBRE, TIPO) values (1,'Pancho', 'Perro'), (2, 'Babu', 'Perro'), (3, 'Luna', 'Gato'), (4, 'Pupilon', 'Gato' ), (5, 'Parsel', 'Serpiente')";
    private static final String SQL_SELECT ="select * from animales";



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection= DriverManager.getConnection("jdbc:h2:~/backend-clase11","sa", "sa");
        Statement statement= connection.createStatement();
        statement.execute(SQL_CREATE_TABLE);
        statement.execute(SQL_INSERT_1);
        // statement.execute -> ejecuta sql en la bd desde java -> no espero ninguna respuesta;
        // executeQuery -> realiza una consulta a la bd -> espera una respuesta que se guardara en ResulSet para despues poder trabajar con ella desde java.
        ResultSet rs=statement.executeQuery(SQL_SELECT);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+ rs.getString(3));
        }
    }
}
