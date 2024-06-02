public abstract class Sort implements Time {

    public abstract void sort(int[] t);

    @Override
    public final long time() {
        return System.nanoTime();
    }
    
}
