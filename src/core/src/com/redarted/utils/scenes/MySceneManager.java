package com.redarted.utils.scenes;

import com.redarted.utils.boost.SceneManager;
import com.redarted.utils.events.EventHandler;
import com.redarted.utils.events.EventsHolder;
import com.redarted.utils.networking.NetworkManager;

public class MySceneManager extends SceneManager {
    public static Intro intro;
    public static Game game;

    public EventHandler eventHandler;
    public EventsHolder eventsHolder;

    @Override
    public void createSceneManager() {
        super.createSceneManager();
        intro = new Intro();
        game = new Game();
        addScene(intro);

        eventsHolder = new EventsHolder();
        eventHandler = new EventHandler(eventsHolder);
        NetworkManager.create(false, eventsHolder, eventHandler);
    }

    int networkDistributionCounter = 0;

    @Override
    public void act() {
        super.act();

        // events handling (from network)
        eventHandler.handleEvents();
        if (networkDistributionCounter > 5) {
            networkDistributionCounter = 0;
            NetworkManager.networkManager.distributeEvents();
        }
        networkDistributionCounter++;
    }
}
