public class triangulo extends Figura {

    private double base;
    private double  altura;

    public triangulo(double base, double altura)
    {
        this.altura = altura;
        this.base = base;
    }

    public double getAltura()
    {
        return altura;
    }

    public double getBase()
    {
        return base;
    }

    public void setAltura(double altura)
    {
        this.altura = altura;
    }
    
     public void setBase(double base)
    {
        this.base = base;
    }
    
    public double CalcularArea()
    {
        return (base * altura) / 2;
    }
   
} 