package ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InvitationStageFXMLRoot extends BorderPane {

    protected final Text invitationText;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Text myNameText;
    protected final Text text;
    protected final Text opponentNameText;
    protected final ImageView myImageView;
    protected final ImageView opponentImageView;
    protected final ProgressIndicator progressIndicator;
    protected final FlowPane flowPane;
    protected final Text invitationStatusText;
    protected final Button invitationActionBt;
    protected final Button recordBt;
    
    private Stage stage;

    public InvitationStageFXMLRoot(Stage stage) {
        this.stage=stage;

        invitationText = new Text();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        myNameText = new Text();
        text = new Text();
        opponentNameText = new Text();
        
        myImageView= new ImageView(new Image(getClass().getResourceAsStream("/assets/images/player_image.jpg")));
        opponentImageView = new ImageView(new Image(getClass().getResourceAsStream("/assets/images/opponent_image.jpg")));
        
        progressIndicator = new ProgressIndicator();
        flowPane = new FlowPane();
        invitationStatusText = new Text();
        invitationActionBt = new Button();
        recordBt = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(invitationText, javafx.geometry.Pos.CENTER);
        invitationText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        invitationText.setStrokeWidth(0.0);
        invitationText.setText("Invitation To Ahmed");
        invitationText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        invitationText.setWrappingWidth(599.13671875);
        invitationText.setFont(new Font("Segoe UI Bold", 58.0));
        BorderPane.setMargin(invitationText, new Insets(0.0));
        setTop(invitationText);
        setPadding(new Insets(10.0));

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(250.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(250.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(188.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(91.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(240.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(239.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(myNameText, javafx.geometry.HPos.CENTER);
        GridPane.setRowSpan(myNameText, 2);
        GridPane.setValignment(myNameText, javafx.geometry.VPos.CENTER);
        myNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        myNameText.setStrokeWidth(0.0);
        myNameText.setText("Player");
        myNameText.setFont(new Font(32.0));

        GridPane.setColumnIndex(text, 1);
        GridPane.setHalignment(text, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(text, 1);
        GridPane.setValignment(text, javafx.geometry.VPos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("VS");
        text.setFont(new Font("System Bold", 64.0));

        GridPane.setColumnIndex(opponentNameText, 2);
        GridPane.setHalignment(opponentNameText, javafx.geometry.HPos.CENTER);
        GridPane.setRowSpan(opponentNameText, 2);
        GridPane.setValignment(opponentNameText, javafx.geometry.VPos.CENTER);
        opponentNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        opponentNameText.setStrokeWidth(0.0);
        opponentNameText.setText("Ahmed");
        opponentNameText.setFont(new Font(32.0));

        GridPane.setHalignment(myImageView, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(myImageView, 2);
        GridPane.setValignment(myImageView, javafx.geometry.VPos.CENTER);
        myImageView.setFitHeight(150.0);
        myImageView.setFitWidth(200.0);
        myImageView.setPickOnBounds(true);
        myImageView.setPreserveRatio(true);
        
        

        GridPane.setColumnIndex(opponentImageView, 2);
        GridPane.setHalignment(opponentImageView, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(opponentImageView, 2);
        GridPane.setValignment(opponentImageView, javafx.geometry.VPos.CENTER);
        opponentImageView.setFitHeight(150.0);
        opponentImageView.setFitWidth(200.0);
        opponentImageView.setPickOnBounds(true);
        opponentImageView.setPreserveRatio(true);

        GridPane.setColumnIndex(progressIndicator, 1);
        GridPane.setRowIndex(progressIndicator, 3);

        GridPane.setColumnIndex(flowPane, 1);
        GridPane.setHalignment(flowPane, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(flowPane, 4);
        GridPane.setValignment(flowPane, javafx.geometry.VPos.CENTER);
        flowPane.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);
        flowPane.setVgap(10.0);

        invitationStatusText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        invitationStatusText.setStrokeWidth(0.0);
        invitationStatusText.setText("Waiting..");
        invitationStatusText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        invitationStatusText.setWrappingWidth(103.13671875);

        invitationActionBt.setMnemonicParsing(false);
        invitationActionBt.setPrefHeight(38.0);
        invitationActionBt.setPrefWidth(104.0);
        invitationActionBt.setText("Cancel");

        GridPane.setColumnIndex(recordBt, 2);
        GridPane.setHalignment(recordBt, javafx.geometry.HPos.RIGHT);
        GridPane.setRowIndex(recordBt, 5);
        GridPane.setValignment(recordBt, javafx.geometry.VPos.BOTTOM);
        recordBt.setMnemonicParsing(false);
        recordBt.setText("Start Recording");
        recordBt.setFont(new Font(15.0));
        
        ImageView recordIcon = new ImageView(new Image(getClass().getResourceAsStream("/assets/images/record_icon.png")));
        recordIcon.setPreserveRatio(true);
        recordIcon.setFitHeight(20);
        recordBt.setGraphic(recordIcon);
        setCenter(gridPane);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(myNameText);
        gridPane.getChildren().add(text);
        gridPane.getChildren().add(opponentNameText);
        gridPane.getChildren().add(myImageView);
        gridPane.getChildren().add(opponentImageView);
        gridPane.getChildren().add(progressIndicator);
        flowPane.getChildren().add(invitationStatusText);
        flowPane.getChildren().add(invitationActionBt);
        gridPane.getChildren().add(flowPane);
        gridPane.getChildren().add(recordBt);
        
        
        invitationActionBt.setOnAction((event) -> {
            Parent root = new ChooseSymbolStageFXML(stage, "Online Player", 2);
            stage.setScene(new Scene(root, 600, 500));
        });

    }
}