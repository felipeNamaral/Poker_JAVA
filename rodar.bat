@echo off
java --module-path lib/javafx-sdk-25/lib --add-modules javafx.controls,javafx.fxml -cp bin Main
pause