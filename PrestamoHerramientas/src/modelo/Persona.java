package modelo;

class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
  
    Persona(String nombre,String apellidoP, String apellidoM, int edad )
    {
        this.nombre    = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad      = edad;
    }
}
