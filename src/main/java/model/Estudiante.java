package model;

public class Estudiante {
    private int id;
    private String nombre;
    private String identificacion;
    private String email;
    private String fecha_nacimiento;
    private boolean estado;

    public Estudiante(int id, String nombre, String identificacion, String email, String fecha_nacimiento, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
