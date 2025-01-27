import lt.itakademija.exam.NumberFilter;

public class MyFilter implements NumberFilter {
    @Override
    public boolean accept(int i) {
        return false;
    }
}
