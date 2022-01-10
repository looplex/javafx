package com.example.javafx;

import com.example.javafx.ChartApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Value("classpath:/chart.fxml")
    private Resource chartResource;

    @Override
    public void onApplicationEvent(StageReadyEvent event) {


        try {
            FXMLLoader fxmlLoader= new FXMLLoader(chartResource.getURL());
            Parent parent = fxmlLoader.load();

            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800, 600));
            stage.setTitle("JavaFx Application");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
}
