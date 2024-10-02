package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class Perro_db {
Conexion con=new Conexion();
Connection conexion=null;
PreparedStatement ps=null;
Statement st=null;
ResultSet res=null;

public ArrayList<Perro> datos=new ArrayList<>();

public boolean insertarPerro(Perro p){

    String sql="INSERT INTO Perro(Nombre, Genero, Raza, Edad, Peso, dueño) VALUES (?,?,?,?,?,?)";
    boolean resultado=false;
    Perro perro=buscarPerro(p.getNombre(),p.getRaza(),p.getDuenio());
    try{
        if(perro==null){
            conexion=con.conecta();
            ps=conexion.prepareStatement(sql);
            ps.setString(1,p.getNombre());
            ps.setString(2,p.getGenero());
            ps.setString(3, p.getRaza());
            ps.setInt(4,p.getEdad());
            ps.setFloat(5, p.getPeso());
            ps.setString(6,p.getDuenio());
            resultado=ps.executeUpdate()>0;
            conexion.close();
        }else{
            System.out.println("La mascota ya se encuentra registrada.");
        }
    }catch (SQLException e) {
        //throw new RuntimeException(e);
        System.out.println("Error al insertar la mascota."+ e);
    }
    return resultado;
}

public Perro buscarPerro(String nombre, String raza, String duenio){
    String sql="select * from perro where nombre=? and raza=? and dueño=?;";
    Perro p=null;
    try{
        conexion=con.conecta();
        ps=conexion.prepareStatement(sql);
        ps.setString(1,nombre);
        ps.setString(2,raza);
        ps.setString(3,duenio);
        res=ps.executeQuery();
        while(res.next()){
          p=new Perro(res.getInt(1),res.getString(2),
                  res.getString(3),res.getString(4),res.getFloat(5),
                  res.getInt(6),res.getString(7));
        }
        conexion.close();
    }catch (SQLException e){
        System.out.println("Error al consultar "+e);
    }
    return p;
}

public ArrayList<Perro> consultarTodos(){
    String sql="Select * from perro";
    Perro p;
    try{
        conexion=con.conecta();
        st= conexion.createStatement();
        res=st.executeQuery(sql);
        //System.out.println(res);

        while (res.next()){
            p=new Perro(res.getInt(1),res.getString(2),
                    res.getString(3),res.getString(4),res.getFloat(5),
                    res.getInt(6),res.getString(7));
            datos.add(p);
        }

    }catch (SQLException e){

    }
    return datos;
}

    public Perro buscarCodigo(int cod){
        String sql="select * from perro where id_perro=?;";
        Perro p=null;
        try{
            conexion=con.conecta();
            ps=conexion.prepareStatement(sql);
            ps.setInt(1,cod);
            res=ps.executeQuery();
            while(res.next()){
                p=new Perro(res.getInt(1),res.getString(2),
                        res.getString(3),res.getString(4),res.getFloat(5),
                        res.getInt(6),res.getString(7));
            }
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al consultar "+e);
        }
        return p;
    }

    public boolean actualizarPerro(Perro perro){
    Perro p=buscarCodigo(perro.getId_perro());
    boolean resultado=false;
    String sql="update perro set nombre=?, genero=?,raza=?,peso=?,edad=?,dueño=? where id_perro=?";
    try{
        if(p!=null){
            conexion=con.conecta();
            ps=conexion.prepareStatement(sql);
            ps.setString(1,perro.getNombre());
            ps.setString(2,perro.getGenero());
            ps.setString(3, perro.getRaza());
            ps.setFloat(4,perro.getPeso());
            ps.setInt(5, perro.getEdad());
            ps.setString(6,perro.getDuenio());
            ps.setInt(7,perro.getId_perro());
            resultado=ps.executeUpdate()>0;
            conexion.close();
        }else{
            System.out.println("La mascota a actualizar, no esta registrada.");
        }
    }catch (SQLException e){
        System.out.println(e);
    }
    return resultado;
    }
}
