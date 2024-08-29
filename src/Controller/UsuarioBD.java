package Controller;

import Model.Pair;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioBD {
    
    private Connection conn;
    
    public UsuarioBD() {
        ConnectBD connx = new ConnectBD();
        conn = connx.getConnection();
    }
    
    public void InsertaUsuario(String id, Pair uno, Pair dos){
        try {
             
            String sql = "INSERT INTO usuariog(id,nombre,edad, eps, fecha" 
             + ") VALUES(?,?,?,?,?)";
            try(
                 PreparedStatement stm = conn.prepareStatement(sql)){
                 stm.setString(1, id);
                 stm.setObject(2,uno.getFirst());
                 stm.setObject(3,uno.getSecond());                 
                 stm.setObject(4, dos.getFirst());
                 stm.setObject(5, dos.getSecond());                 
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
             throw new RuntimeException();
            }
     }
     
    }
