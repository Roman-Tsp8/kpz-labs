package ua.miskauto.chain;

import java.util.List;

/** Збирає ланцюг з переданого переліку ланок: склад і порядок задаються під час виконання. */
public final class CheckChainFactory {
    private CheckChainFactory() { }

    public static CheckHandler build(List<CheckHandler> handlers) {
        if (handlers.isEmpty()) {
            throw new IllegalArgumentException("ланцюг не може бути порожнім");
        }
        for (int i = 0; i < handlers.size() - 1; i++) {
            handlers.get(i).setNext(handlers.get(i + 1));
        }
        return handlers.get(0);
    }

    /** Конфігурація для звичайних авто. */
    public static CheckHandler standard() {
        return build(List.of(new LicenseCheck(), new DebtCheck(), new BalanceCheck(), new BlockCheck()));
    }

    /** Конфігурація для преміальних авто: додається перевірка стажу. */
    public static CheckHandler premium() {
        return build(List.of(new LicenseCheck(), new ExperienceCheck(3), new DebtCheck(),
                new BalanceCheck(), new BlockCheck()));
    }
}
