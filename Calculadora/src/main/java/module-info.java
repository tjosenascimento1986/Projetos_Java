module org.example.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.scripting;
    requires exp4j;


    opens org.example.calculadora to javafx.fxml;
    exports org.example.calculadora;
}