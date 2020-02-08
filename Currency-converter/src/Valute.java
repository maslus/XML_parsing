public class Valute {
    String ID;
    Integer NumCode;
    String CharCode;
    Integer Nominal;
    String Name;
    Double Value;

    @Override
    public String toString () {
        return "Valute: " +
                "NumCode=" + NumCode + ", CharCode=" + CharCode +
                ", Nominal=" + Nominal + ", Name=" + Name +
                ", Value="+ Value;


    }
}
