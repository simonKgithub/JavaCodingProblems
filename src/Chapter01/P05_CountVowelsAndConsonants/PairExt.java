package Chapter01.P05_CountVowelsAndConsonants;

public class PairExt<V, C> {
    final V vowels;
    final C consonants;

    public PairExt(V vowels, C consonants) {
        this.vowels = vowels;
        this.consonants = consonants;
    }

    static <V, C> PairExt<V, C> of(V vowels, C consonants) {
        return new PairExt<>(vowels, consonants);
    }

    @Override
    public int hashCode() {
        return vowels.hashCode() ^ consonants.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PairExt)) {
            return false;
        }

        PairExt obj = (PairExt) o;
        return this.vowels.equals(obj.vowels) && this.consonants.equals(obj.consonants);
    }
}
