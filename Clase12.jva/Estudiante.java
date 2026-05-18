public class Estudiante {
    
    //Atributos
    private int identificacion;
    private String nombres;
    private String apellidos;
    private int edad;

    //Constructor de la clase
    //El constructor permite inicializar la clase
    //El constructor se llama igual que la clase
    //la palabra reservada "this" es una autoreferencia al atributo de la clase

    public Estudiante(String identificacion, String nombres, String apellidos, double edad){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    //Métodos get y set para el atributo nombres
    public String getNombres(){
        return nombres;
    }

    public void setNombres(String nombres){
        this.nombres = nombres;
    }

    //El método toString permite mostrar la información que tiene el objeto.
    public String toString(){
        return "Estudiante { identificación: " + identificacion + 
               " nombres y apellidos: " + nombres + " " + apellidos + 
               " edad: " + edad + "}";
    }

    public double calcularNotaFinal (double n1, double n2, double n3){
        double notaFinal = ((n1 * 0.30) + (n2 * 0.30) + (n3 * 0.40));
        return notaFinal;
    }

    public void agregarHorasDeporte(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarHorasDeporte'");
    }

    public void agregarHorasCultura(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarHorasCultura'");
    }

    public void agregarHorasSalud(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarHorasSalud'");
    }

    public void mostrarInformacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarInformacion'");
    }

    public int getHorasDeporte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorasDeporte'");
    }

    public int getHorasCultura() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorasCultura'");
    }

    public int getHorasSalud() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHorasSalud'");
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

}