package Modelo;

public class Perro {
    private int id_perro;
    private String nombre;
    private String genero;
    private String raza;
    private float peso;
    private int edad;
    private String duenio;

    public Perro(int id_perro, String nombre, String genero, String raza, float peso, int edad, String duenio) {
        this.id_perro = id_perro;
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.peso = peso;
        this.edad = edad;
        this.duenio = duenio;
    }

    public Perro(String nombre, String genero, String raza, float peso, int edad, String duenio) {
        this.nombre = nombre;
        this.genero = genero;
        this.raza = raza;
        this.peso = peso;
        this.edad = edad;
        this.duenio = duenio;
    }

    public int getId_perro() {
        return id_perro;
    }

    public void setId_perro(int id_perro) {
        this.id_perro = id_perro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "id_perro=" + id_perro +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", raza='" + raza + '\'' +
                ", peso=" + peso +
                ", edad=" + edad +
                ", duenio='" + duenio + '\'' +
                "}\n";
    }
}
