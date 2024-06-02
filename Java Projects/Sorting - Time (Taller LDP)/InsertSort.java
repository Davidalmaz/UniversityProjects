public final class InsertSort extends Sort {

    @Override
    public final void sort(final int[] t) {
        for (int i = 1; i < t.length; ++i) {
            int x = t[i], j = i - 1;
            for (; j > 0 && x < t[j]; --j)
                t[j + 1] = t[j];
            t[j + 1] = x;
        }
    }
}
