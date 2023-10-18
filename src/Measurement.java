public class Measurement {
    private int numComparisons;
    private long timeTaken;

    public Measurement() {
        this.numComparisons = 0;
        this.timeTaken = 0;
    }

    public void incrementComparisons() {
        this.numComparisons++;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public int getNumComparisons() {
        return this.numComparisons;
    }

    public long getTimeTaken() {
        return this.timeTaken;
    }
}
