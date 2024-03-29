package ui;

import data.ClientRequestsHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import utility.JsonConverter;

public class MultiplayersStageFXML extends AnchorPane {

    protected final Text gameText;
    protected final Label label;
    protected final Button backBt;
    protected final Button inviteBt;
    protected final ScrollPane scrollPane;
    protected static ListView listView = new ListView();

    private static String myUsername;
    private static String css;

    private Stage stage;

    public MultiplayersStageFXML(Stage stage) {
        this.stage = stage;
        css = getClass().getResource("/assets/styles/style.css").toExternalForm();

        gameText = new Text();
        label = new Label();
        backBt = new Button();
        inviteBt = new Button();
        scrollPane = new ScrollPane();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(600.0);

        gameText.setLayoutX(14.0);
        gameText.setLayoutY(69.0);
        gameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        gameText.setStrokeWidth(0.0);
        gameText.setText("Tic-Tac-Toe Game");
        gameText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameText.setWrappingWidth(571.13671875);
        gameText.setFont(new Font("Segoe UI Bold Italic", 64.0));

        label.setLayoutX(98.0);
        label.setLayoutY(105.0);
        label.setText("Online Players");
        label.setUnderline(true);
        label.setFont(new Font("System Italic", 61.0));

        backBt.setLayoutX(122.0);
        backBt.setLayoutY(426.0);
        backBt.setMnemonicParsing(false);
        backBt.setPrefHeight(36.0);
        backBt.setPrefWidth(87.0);
        backBt.setText("Back");

        inviteBt.setLayoutX(362.0);
        inviteBt.setLayoutY(426.0);
        inviteBt.setMnemonicParsing(false);
        inviteBt.setPrefHeight(36.0);
        inviteBt.setPrefWidth(94.0);
        inviteBt.setText("Invite");

        scrollPane.setLayoutX(109.0);
        scrollPane.setLayoutY(194.0);
        scrollPane.setPrefHeight(200.0);
        scrollPane.setPrefWidth(358.0);

        listView.setPrefHeight(207.0);
        listView.setPrefWidth(359.0);
        scrollPane.setContent(listView);

        getChildren().add(gameText);
        getChildren().add(label);
        getChildren().add(backBt);
        getChildren().add(inviteBt);
        getChildren().add(scrollPane);

        gameText.setId("gameText");
        label.setId("greentext");
        inviteBt.setId("greenButton");
        backBt.setId("orangeButton");
        scrollPane.setId("containerSharp");
        listView.setId("containerSharp");

        backBt.setOnAction((ActionEvent event) -> {
            Parent root = new MainPageFXML(stage);
            Scene scene = new Scene(root, 600, 500);
            scene.getStylesheets().add(getClass().getResource("/assets/styles/style.css").toExternalForm());
            stage.setScene(scene);
        });

        inviteBt.setOnAction((ActionEvent event) -> {
            if (!listView.getSelectionModel().isEmpty()) {
                String selectedUser = (String) listView.getSelectionModel().getSelectedItem();
                System.out.println(selectedUser);

                ClientRequestsHandler clientRequestsHandler = ClientRequestsHandler.createClientRequest(stage);
                clientRequestsHandler.sendJsonMessageToServer(JsonConverter.convertInviteMessageToJson(myUsername, selectedUser));
                clientRequestsHandler.sendJsonMessageToServer(JsonConverter.convertAvailablityToJson(myUsername, false));

                Parent root = new InvitationStageFXMLRoot(stage, myUsername, selectedUser);
                Scene scene = new Scene(root, 600, 500);
                scene.getStylesheets().add(getClass().getResource("/assets/styles/style.css").toExternalForm());
                stage.setScene(scene);
            }
        });

        stage.setOnCloseRequest((event) -> {
            ClientRequestsHandler clientRequestsHandler = ClientRequestsHandler.createClientRequest(stage);
            clientRequestsHandler.sendJsonMessageToServer(JsonConverter.convertGoOfflineToJson());
            Platform.exit();
            System.exit(0);
        });

    }

    public static void updateOnlineListUI(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            jSONArray = jSONObject.getJSONArray("OnlinePlayers");
            listView.getItems().clear();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    listView.getItems().add(jSONArray.get(i));
                } catch (JSONException ex) {
                    Logger.getLogger(MultiplayersStageFXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            myUsername = jSONObject.getString("myUsername");
            listView.getItems().remove(myUsername);

        } catch (JSONException ex) {
            Logger.getLogger(MultiplayersStageFXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
