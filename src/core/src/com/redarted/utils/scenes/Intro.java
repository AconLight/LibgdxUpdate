package com.redarted.utils.scenes;

import com.redarted.utils.assets.AssetLoader;
import com.redarted.utils.boost.GameObject;
import com.redarted.utils.boost.MyScene;
import com.badlogic.gdx.Gdx;

public class Intro extends MyScene {
    GameObject splash;

    float time;

    public Intro() {
        super();
        splash = AssetLoader.getAsset("redartedSplash");
        splash.alfa = 0;
        splash.setShader("drunk");
        stage.addActor(splash);
        time = 0;
    }

    float k = 5f;
    boolean flag = true, flag2 = true;
    public void act() {
        super.act();
        time += Gdx.graphics.getDeltaTime();
        splash.shader.setUniformf("time", time);
        float a = (float) Math.sin(time/k);
        splash.alfa = a*a*a*a*a*a;
        if (time/k > Math.PI*0.7f && flag) {
            MySceneManager.addScene(MySceneManager.game);
            flag = false;
        }
        if (time/k > Math.PI && flag2) {
            MySceneManager.removeScene(this);
            MySceneManager.switchInputToScene(MySceneManager.game);
            flag2 = false;
        }
    }
}
