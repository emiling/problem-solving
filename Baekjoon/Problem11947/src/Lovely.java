class Lovely {
    long min;
    long max;
    int length;
    long boundary;

    public void getPair(long data) {
        long complement = (long)Math.pow(10, length)-1;
        this.min = Math.min(data,complement-data);
        this.max = Math.max(data,complement-data);
    }

    Lovely (long data) {
        this.boundary = data;
        this.length = (int)Math.log10(data)+1;
        getPair(data);
    }
}