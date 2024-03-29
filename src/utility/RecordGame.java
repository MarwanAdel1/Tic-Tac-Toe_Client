/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import pojo.GameStep;
import ui.MainPageFXML;
import ui.RecordsFXML;

/**
 *
 * @author Marwan Adel
 */
public class RecordGame {

    File dir, savedFile;
    String time;
    DateTimeFormatter dateTimeFormatter;
    FileOutputStream fileOutputStream;
    FileInputStream fileInputStream;

    ArrayList<GameStep> gameSteps;
    int i;
    Thread th;

    public RecordGame() {
        dir = new File("../Records");

        if (!dir.exists()) {
            dir.mkdirs();
        }
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd---HH-mm-ss");
        time = dateTimeFormatter.format(LocalDateTime.now());
    }

    public void recordGameSteps(String opName, GameStep gameStep) {

        savedFile = new File(dir, opName + " " + time);

        String step = gameStep.getSymbol() + ";" + String.valueOf(gameStep.getRow()) + ";" + String.valueOf(gameStep.getCol()) + "\n";

        try {
            fileOutputStream = new FileOutputStream(savedFile, true);
            fileOutputStream.write(step.getBytes());
            fileOutputStream.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void playGameSteps(String fileName) {
        if (th != null) {
            if (th.isAlive()) {
                th.suspend();
            }
        }
        th = new Thread(() -> {
            Scanner scanner = null;
            gameSteps = new ArrayList<>();
            savedFile = new File(dir, fileName);
            if (savedFile.exists()) {
                try {
                    fileInputStream = new FileInputStream(savedFile);
                    scanner = new Scanner(fileInputStream);

                    while (scanner.hasNextLine()) {
                        String[] str = scanner.nextLine().split(";");

                        GameStep gameStep = new GameStep();
                        gameStep.setSymbol(str[0]);
                        gameStep.setRow(Integer.parseInt(str[1]));
                        gameStep.setCol(Integer.parseInt(str[2]));

                        gameSteps.add(gameStep);
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        scanner.close();
                        fileInputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                for (i = 0; i < gameSteps.size(); i++) {
                    Platform.runLater(() -> {
                        RecordsFXML.showStep(gameSteps.get(i).getSymbol(), gameSteps.get(i).getRow(), gameSteps.get(i).getCol());
                    });

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RecordGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                Platform.runLater(() -> {
                    RecordsFXML.showFileNotFoundDialog();
                });
            }
        });
        th.start();
    }

    public void stopReadingThread() {
        if (th != null) {
            if (th.isAlive()) {
                th.suspend();
            }
        }
    }

    public String[] getAllFiles() {
        String[] files = dir.list();
        return files;
    }

}
