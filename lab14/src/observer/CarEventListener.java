package observer;

/** Observer: усе, що хоче отримувати події авто, реалізує цей інтерфейс. */
public interface CarEventListener {

    /** Назва, яка використовується як "джерело" в журналі. */
    String getName();

    /** Кожен отримувач сам вирішує, чи і як реагувати на подію. */
    void onCarEvent(CarEvent event);
}
