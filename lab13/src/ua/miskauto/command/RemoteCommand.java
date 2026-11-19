package ua.miskauto.command;

/** Command: віддалена команда, що знає, як виконатися і як скасуватися. */
public interface RemoteCommand {
    void execute();
    void undo();
    String description();
}
