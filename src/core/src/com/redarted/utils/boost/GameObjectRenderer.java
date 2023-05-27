package com.redarted.utils.boost;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class GameObjectRenderer {

    public Stage stage;

    public GameObjectRenderer(Stage stage) {
        this.stage = stage;
    }
    public void render() {
        ArrayList<Float> idxs = new ArrayList<>(GameObjectManager.indexes);
        idxs.sort((e1, e2) -> (int)(e1 - e2));

        for (float index: idxs) {
            GameObjectManager.currentIndex = index;
            stage.draw();
        }
    }


}
