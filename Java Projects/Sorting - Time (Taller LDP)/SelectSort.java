public final class SelectSort extends Sort {

    @Override
    public final void sort(final int[] t) {
        for (int i = 0; i < t.length - 1; ++i) {
            int minj = i, minx = t[i];
            for (int j = i + 1; i < t.length; ++i) {
                if (t[j] < minx) {
                    minj = j;
                    minx = t[j];
                }
                t[minj] = t[i];
                t[i] = minx;
            }
        }
    }
	
}
