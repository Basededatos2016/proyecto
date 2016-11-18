package conexionDB;

import Vendedor.Vendedor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Sulpick on 06/11/2016.
 */
public class conexion_db{


    private Connection _con = null; //esto es una clase creada o una propiedad de java?
    private String _url;
    private String _user;
    private String _pass;

/** Para iniciar conexion con la base de datos **/

    public conexion_db()
    {
        this.init_connection();
    }


/** Para obtener datos del archivo propiedades del servidor de la base de datos **/

    private boolean get_data_from_prop()
    {
        Properties __prop = new Properties(); // para que sirve esto?
        FileInputStream __in = null; //instancia archivo de lectura
        try
        {
            __in = new FileInputStream("src/conexion_db/db_config_properties");
            // Abre el archivo de propiedades
            //System.out.println("properties readed");
        }
        catch (FileNotFoundException e)    // si no consigue el archivo arroja la excepcion
        {
            e.printStackTrace();    //buscar esta funcion
            //System.out.println("properties faild");
            return false;
        }

        try
        {
            __prop.load(__in);
            // carga en propiedades la informacion del archivo que se abrio y las almacena
            this._url  = __prop.getProperty("url");
            this._user = __prop.getProperty("user");
            this._pass = __prop.getProperty("pass");

            __in.close();

            //System.out.println("properties loaded"+ _url + _user + _pass);
        }
        catch (IOException e) // lanza una excepcion
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }


   /** Para iniciar la conexion **/

    private boolean init_connection()
    {
        if (get_data_from_prop())
        {
            try
            {
                _con = DriverManager.getConnection(this._url, this._user, this._pass); //usa funcion y pasa datos

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


/** conectate **/
    public Connection get_connection()
    {
        if (init_connection())
        {
            return this._con;
        }
        else
            return null;
    }

/** terminar la conexion **/
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

    /** ejecutar la consulta **/

    public ResultSet execute_query(String sql_query)
    {
        try
        {
            Statement __st =  this._con.createStatement(); //crea la sentencia con esta funcion
            return __st.executeQuery(sql_query); //ejecuta la sentencia, que se paso.

         //lanza excepcion
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  null;
    }


/** actualiza una sentencia en sql ya creada **/
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



    /** Se instancia el objeto vendedor **/
    /** Obtener informacion del vendedor **/


    public Vendedor get_vendedor_por_login(String login, String contraseña) throws SQLException
     {
        /** obtiene datos de la setencia  **/

        ResultSet rs = this.execute_query("select * from Vendedor where Vendedor.login=" + login + "and Vendedor.contraseña =" + contraseña);

        /** si hay siguiente linea, esto revisa la primera linea al parecer**/
        //porque no se usa un while? es una funcion
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
