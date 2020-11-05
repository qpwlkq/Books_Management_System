package P;

import java.security.PrivateKey;

public class Boook {
    private String ISBN;
    private String Bname;
    private int Bpulish;
    private String Bauthor;
    private String Bpress;
    private int Bnumber;
    private char Kind;

    public String getISBN() {
        return ISBN;
    }

    public String getBname() {
        return Bname;
    }

    public int getBpulish() {
        return Bpulish;
    }

    public String getBauthor() {
        return Bauthor;
    }

    public String getBpress() {
        return Bpress;
    }

    public int getBnumber() {
        return Bnumber;
    }

    public char getKind() {
        return Kind;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public void setBpulish(int bpulish) {
        Bpulish = bpulish;
    }

    public void setBauthor(String bauthor) {
        Bauthor = bauthor;
    }

    public void setBpress(String bpress) {
        Bpress = bpress;
    }

    public void setBnumber(int bnumber) {
        Bnumber = bnumber;
    }

    public void setKind(char kind) {
        Kind = kind;
    }
}
