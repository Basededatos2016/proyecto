package db_helper;

import data_model.Vendedor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Sulpick on 06/11/2016.
 */
public class conexion_db {


    private Connection _con = null;
    private String _url;
    private String _user;
    private String _pass;


    public conexion_db()
    {
        this.init_connection();
    }

    private boolean get_data_from_prop()
    {
        Properties __prop = new Properties();
        FileInputStream __in = null;
        try
        {
            __in = new FileInputStream("src/db_helper/db_config.properties");
            //System.out.println("properties readed");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            //System.out.println("properties faild");
            return false;
        }

        try
        {
            __prop.load(__in);
            this._url  = __prop.getProperty("url");
            this._user = __prop.getProperty("user");
            this._pass = __prop.getProperty("pass");

            __in.close();

            //System.out.println("properties loaded"+ _url + _user + _pass);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }



    private boolean init_connection()
    {
        if (get_data_from_prop())
        {
            try
            {
                _con = DriverManager.getConnection(this._url, this._user, this._pass);

                //System.out.println("connected to db");


            } catch (SQLException e)
            {
                //System.out.println("Faild to connect to db");

                e.printStackTrace();
                return false;
            }
            return true;
        }
        else
            return false;
    }



    public Connection get_connection()
    {
        if (init_connection())
        {
            return this._con;
        }
        else
            return null;
    }


    public boolean close_connection()
    {
        if (this._con != null)
        {
            try
            {
                _con.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        return true;
    }


    public ResultSet execute_query(String sql_query)
    {
        try
        {
            Statement __st =  this._con.createStatement();
            return __st.executeQuery(sql_query);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  null;
    }


    public int execute_update(String sql_update_query)
    {
        try
        {
            Statement __st =  this._con.createStatement();
            return __st.executeUpdate(sql_update_query);

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  -1;
    }



    public Vendedor get_vendedor_por_login(String login, String contraseña) throws SQLException
    {
        ResultSet rs = this.execute_query("select * from Vendedor where Vendedor.login=" + login + "and Vendedor.contraseña =" + contraseña);

        if (rs.next())
        {
            String cedula = rs.getString("cedula");
            String login_ven = rs.getString("login");
            String contraseña_ven = rs.getString("contraseña");
            Integer permisos = rs.getInt("permiso");

            return new Vendedor(cedula,login,contraseña,permisos);
        }


        return null;

    }

}
