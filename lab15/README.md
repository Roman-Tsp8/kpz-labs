# Лабораторна робота №15. Поведінкові шаблони (Strategy, State, Template Method)

Варіант 8: каршерінг «Міськавто». Мова: Java.

| Завдання | Шаблон | Пакет |
|---|---|---|
| 1. Розрахунок вартості поїздки | Strategy | `com.miskavto.lab15.strategy` |
| 2. Огляд авто | Template Method | `com.miskavto.lab15.template` |
| 3. Стан авто | State | `com.miskavto.lab15.state` |

## Збірка і запуск (з кореня проєкту)

    javac -d out $(find src -name "*.java")
    java -cp out com.miskavto.lab15.Main

Приклад виводу: `docs/demo_output.txt`.
Діаграми Mermaid (`.mmd`): `docs/diagrams/`. Для здачі експортуй їх у PNG/SVG (mermaid.live або `mmdc -i файл.mmd -o файл.svg`).
