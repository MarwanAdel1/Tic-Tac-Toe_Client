package ui.fxml;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChooseSymbolStageFXML extends AnchorPane {

    protected final Button XButtonChoose;
    protected final Button OButtonChoose;
    protected final Text chooseText;
    protected final Text gameText;

    public ChooseSymbolStageFXML() {

        XButtonChoose = new Button();
        OButtonChoose = new Button();
        chooseText = new Text();
        gameText = new Text();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(600.0);

        XButtonChoose.setLayoutX(45.0);
        XButtonChoose.setLayoutY(179.0);
        XButtonChoose.setMnemonicParsing(false);
        XButtonChoose.setPrefHeight(265.0);
        XButtonChoose.setPrefWidth(227.0);
        XButtonChoose.setText("X");
        XButtonChoose.setFont(new Font(96.0));

        OButtonChoose.setLayoutX(330.0);
        OButtonChoose.setLayoutY(179.0);
        OButtonChoose.setMnemonicParsing(false);
        OButtonChoose.setPrefHeight(265.0);
        OButtonChoose.setPrefWidth(227.0);
        OButtonChoose.setText("O");
        OButtonChoose.setFont(new Font(96.0));

        chooseText.setLayoutX(28.0);
        chooseText.setLayoutY(146.0);
        chooseText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        chooseText.setStrokeWidth(0.0);
        chooseText.setText("Choose Symbol ");
        chooseText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        chooseText.setWrappingWidth(543.6708984375);
        chooseText.setFont(new Font("Segoe UI Bold", 41.0));

        gameText.setLayoutX(14.0);
        gameText.setLayoutY(63.0);
        gameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gameText.setStrokeWidth(0.0);
        gameText.setText("Tic-Tac-Toe Game");
        gameText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameText.setWrappingWidth(571.13671875);
        gameText.setFont(new Font("Segoe UI Bold Italic", 64.0));

        getChildren().add(XButtonChoose);
        getChildren().add(OButtonChoose);
        getChildren().add(chooseText);
        getChildren().add(gameText);

    }
}