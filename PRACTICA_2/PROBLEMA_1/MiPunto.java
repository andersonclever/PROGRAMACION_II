public class MiPunto {
    private double x;
    private double y;

    public MiPunto() {
        this.x = 0;
        this.y = 0;
    }

    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distancia(MiPunto otro) {
        double dx = this.x - otro.x;
        double dy = this.y - otro.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distancia(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;

        return Math.sqrt(dx * dx + dy * dy);
    }
}