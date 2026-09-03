public class Sample
{
    int x;
    int y;
    public Sample(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Sample(int x) {
        this.x = x;
    }

    public Sample() {
    }

    public int getY() {
        return y;
    }

    public void withdraw() { }
    public void deposit() { }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}