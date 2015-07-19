package com.jamesrskemp.tappingdemo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.jamesrskemp.tappingdemo.objects.Box;

public class TappingDemoGame extends ApplicationAdapter {
	/**
	 * Rendering batch that we'll use throughout.
	 */
	SpriteBatch batch;

	/**
	 * Basic camera for the main 'world.'
	 */
	OrthographicCamera camera;

	/**
	 * Main game stage, housing our actionable actors.
	 */
	Stage stage;

	@Override
	public void create () {
		batch = new SpriteBatch();

		// Create a camera and for now just set it equal to the size of the display.
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		// Create a stage that fills the entire display.
		stage = new Stage(new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
		stage.getViewport().setCamera(camera);

		camera.update();

		// Create a box to display in the left half of the screen.
		Box box1 = new Box();
		box1.setPosition(0, Gdx.graphics.getHeight() / 2 - box1.getHeight() / 2);
		stage.addActor(box1);

		// Create another box to display in the right half of the screen.
		Box box2 = new Box();
		box2.setPosition(Gdx.graphics.getWidth() - box2.getWidth(), Gdx.graphics.getHeight() / 2 - box2.getHeight() / 2);
		stage.addActor(box2);

		// Create a multiplexer so we can later handle multiple processors (such as a camera or HUD).
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		// We want our boxes to respond to touch, so add the stage as an input processor.
		inputMultiplexer.addProcessor(stage);

		Gdx.input.setInputProcessor(inputMultiplexer);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose() {
		super.dispose();

		stage.dispose();
		batch.dispose();
	}
}
