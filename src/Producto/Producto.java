package Producto;

/**
 * Created by Evely on 13/12/2016.
 */
public class Producto
{
    public Integer Id_Producto;
    public String Nombre;
    public String Anio;
    public Float Precio;
    public String Formato;
    public String Genero;
    public Integer Existencia;

    public Producto(Integer id, String nombre, String annio, Float precio, String formato, String genero, Integer exist)
    {
        this.Id_Producto = id;
        this.Nombre = nombre;
        this.Anio = annio;
        this.Precio = precio;
        this.Formato =formato;
        this.Genero = genero;
        this.Existencia = exist;
    }

    public  Producto()
    {

        this.Id_Producto = new Integer(0);
        this.Nombre = new String();
        this.Anio = new String();
        this.Precio = new Float(0);
        this.Formato = new String();
        this.Genero = new String();
        this.Existencia = new Integer(0);
    }


    public Integer get_id()
    {
        return Id_Producto;
    }

    public void set_id(Integer id)
    {
        if( Id_Producto < new Long(0))
            this.Id_Producto = new Integer(0);
        else
            this.Id_Producto = id;
    }

    public String get_Nombre()
    {
        return Nombre;
    }

    public void setNombre(String nombre)
    {
        if(nombre.isEmpty())
            this.Nombre = new String("empty");

        else if(nombre == null)
            this.Nombre = new String("null");

        else
            this.Nombre = nombre;

    }

    public String getAnio() { return Anio; }

    public void setAnio(String anio)
    {
        if(Anio.isEmpty())
            this.Anio = new String("empty");
        else
            this.Anio = anio;
    }


    public Float getPrecio()
    {
        return Precio;
    }

    public void setPrecio(Float precio)
    {
        this.Precio = precio;
    }

    public String Formato()
    {
        return Formato;
    }

    public void setFormato(String formato)
    {
        if(Formato.isEmpty())
            this.Formato = new String("empty");
        else
            this.Formato = formato;
    }

    public String GetGenero()
    {
        return Genero;
    }

    public void setGenero(String genero)
    {
        if(Genero.isEmpty())
            this.Genero = new String("empty");
        else
            this.Genero = genero;
    }

    public Integer GetExistencia()
    {
        return Existencia;
    }

    public void setExistencia(Integer exist)
    {
        if( Existencia < new Long(0))
            this.Existencia = new Integer(0);
        else
            this.Existencia = exist;
    }
    
}