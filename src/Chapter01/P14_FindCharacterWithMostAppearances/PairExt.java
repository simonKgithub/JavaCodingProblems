package Chapter01.P14_FindCharacterWithMostAppearances;

public final class PairExt<V, C> {

    final V character;
    final C occurrences;

    public PairExt(V character, C occurrences) {
        this.character = character;
        this.occurrences = occurrences;
    }

    static <V, C> PairExt<V, C> of (V character, C occurrences) {
        return new PairExt<>(character, occurrences);
    }

    @Override
    public int hashCode(){
        return character.hashCode() ^ occurrences.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PairExt)) {
            return false;
        }
        PairExt obj = (PairExt) o;
        return this.character.equals(obj.character)
                && this.occurrences.equals(obj.occurrences);
    }
}
