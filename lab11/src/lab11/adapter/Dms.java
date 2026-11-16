package lab11.adapter;

/** Координата у форматі градуси-хвилини-секунди (формат стороннього виробника). */
public record Dms(int degrees, int minutes, double seconds, char hemisphere) {
    @Override
    public String toString() {
        return String.format("%d°%d'%.1f\"%c", degrees, minutes, seconds, hemisphere);
    }
}
