package P;


public class Boook {
    private String ISBN;
    private String Bname;
    private int Bpublish;
    private String Bauthor;
    private String Bpress;
    private int Bnumber;
    private String Kind;

    public String getISBN() {
        return ISBN;
    }

    public String getBname() {
        return Bname;
    }

    public int getBpublish() {
        return Bpublish;
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

    public String getKind() {
        return Kind;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public void setBpublish(int bpublish) {
        Bpublish = bpublish;
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

    public void setKind(String kind) {
        Kind = kind;
    }
}
