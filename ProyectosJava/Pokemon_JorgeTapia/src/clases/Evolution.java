package clases;

public class Evolution 
{
    //A
    private String num;
    private String name;

    //C
    public Evolution() {
    
    }

    //M
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Evolution [num=" + num + ", name=" + name + "]";
    }

    

}
