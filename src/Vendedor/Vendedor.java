package Vendedor;

/**
 * Created by Sulpick on 06/11/2016.
 */

/**
 * Created by Sulpick on 06/11/16.
 */
public class Vendedor
{

    private String cedula;
    private String login;
    private String contraseña;
    private Integer permisos;



    public Vendedor(String cedula, String login, String contraseña, Integer permisos)
    {
        this.cedula = cedula;
        this.login = login;
        this.contraseña = contraseña;
        this.permisos = permisos;


    }

    public Vendedor() {
        this.cedula = new String();
        this.login = new String();
        this.contraseña = new String();
        this.permisos = new Integer(0);

    }



    /** Obtener informacion de cada atributo de la entidad vendedor */
    public String get_cedula()
    {
        return cedula;
    }

    public void set_cedula(String cedula)
    {
        if(cedula.isEmpty())
            this.cedula = new String("empty");

        else if(cedula == null)
            this.cedula = new String("null");

        else
            this.cedula = cedula;
    }


    public String get_login()
    {
        return login;
    }

    public void set_login(String login)
    {
        if(login.isEmpty())
            this.login = new String("empty");

        else if(login == null)
            this.login = new String("null");

        else
            this.login = login;

    }

    public String get_contraseña() { return contraseña; }

    public void set_contraseña(String contraseña)
    {
        if(contraseña.isEmpty())
            this.contraseña = new String("empty");
        else
            this.contraseña = contraseña;
    }


    public Integer get_permisos()
    {
        return permisos;
    }

    public void set_permisos(Integer permiso)
    {
        if(permisos < 0)
            this.permisos = new Integer(0);
        else
            this.permisos = permiso;
    }



    @Override
    public String toString()
    {
        return this.login + " " + this.contraseña;
    }

}
