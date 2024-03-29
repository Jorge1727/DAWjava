package ClasesT6.Interfaces;

public class Perro implements Sonido_I, Comparable<Perro> {
    
    String nombre;
    String raza;


    public Perro(String nombre, String raza)
    {
        this.nombre = nombre;
        this.raza = raza;
    }

    //Metodo de la interfaz Sonido_I
    public void voz()
    {
        System.out.println("GUAU!");
    }

    //Metodo de la interfaz que estoy redefiniendo - No hace falta incluirlo
    public void vozDurmiendo()
    {
        System.out.println("Perro voz Durmiendo");
    }

    @Override
    public int compareTo(Perro p) {
        
        return this.nombre.compareTo(p.nombre);
    }


    @Override
    public String toString() {
        
        return this.nombre;
    }

    
}
