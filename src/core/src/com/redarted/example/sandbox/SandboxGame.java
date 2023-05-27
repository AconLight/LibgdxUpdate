package com.redarted.example.sandbox;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.ScreenUtils;
import com.redarted.utils.assets.AssetLoader;
import com.redarted.utils.boost.GameObjectManager;
import com.redarted.utils.networking.NetworkApi;
import com.redarted.utils.scenes.MySceneManager;

public class SandboxGame extends ApplicationAdapter {
	MySceneManager manager;
	@Override
	public void create () {
		NetworkApi.create();
		ShaderProgram.pedantic = false;
		GameObjectManager.create();
		AssetLoader.load();
		manager = new MySceneManager();
		manager.createSceneManager();
		// AssetLoader.soundtrack_menu.play();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		manager.act();
	}
}
