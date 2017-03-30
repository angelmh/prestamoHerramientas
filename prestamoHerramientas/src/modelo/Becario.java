package modelo;

public class Becario extends Persona{
   private int     matricula;
   private String  carrera;
   private String  horarioE;
   private String  horarioS;
   private boolean estatus;

    public Becario(String nombre,String aPaterno, String aMaterno, int edad,
            int matricula,String carrera, String horarioE,String horarioS, boolean estatus) 
    {
   
        super(nombre,aPaterno,aMaterno,edad);
        this.matricula = matricula;
        this.carrera = carrera;
        this.horarioE = horarioE;
        this.horarioS = horarioS;
        this.estatus = estatus;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getHorarioE() {
        return horarioE;
    }

    

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setHorarioE(String horarioE) {
        this.horarioE = horarioE;
    }

    public void setHorarioS(String horarioS) {
        this.horarioS = horarioS;
    }

    public String getHorarioS() {
        return horarioS;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    
}
