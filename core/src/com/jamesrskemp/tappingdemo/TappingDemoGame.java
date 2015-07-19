package com.jamesrskemp.tappingdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.jamesrskemp.tappingdemo.objects.Box;

public class TappingDemoGame extends ApplicationAdapter {
	SpriteBatch batch;

	OrthographicCamera camera;

	Stage stage;

	//Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		stage = new Stage(new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
		stage.getViewport().setCamera(camera);

		camera.update();

		Box box1 = new Box();
		box1.setPosition(0, Gdx.graphics.getHeight() / 2 - box1.getHeight() / 2);
		stage.addActor(box1);

		Box box2 = new Box();
		box2.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - box2.getHeight() / 2);
		stage.addActor(box2);

		//img = new Texture("badlogic.jpg");

		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(stage);

		Gdx.input.setInputProcessor(inputMultiplexer);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();

		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}

	@Override
	public void dispose() {
		super.dispose();

		stage.dispose();
		//img.dispose();
		batch.dispose();
	}
}
