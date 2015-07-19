package com.jamesrskemp.tappingdemo.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

/**
 * Box object that can be acted upon. For our purposes it can be tapped on.
 */
public class Box extends Actor {
	private final static String TAG = Box.class.getName();

	public int totalTaps;

	Texture img;

	public Box(){
		this.totalTaps = 0;

		img = new Texture("badlogic.jpg");

		setBounds(getX(), getY(), img.getWidth(), img.getHeight());
		setTouchable(Touchable.enabled);

		addListener(new ActorGestureListener() {
			@Override
			public void tap(InputEvent event, float x, float y, int count, int button) {
				// Increase by one and ignore the count.
				totalTaps++;
				Gdx.app.log(TAG, "tap on actor " + event.getTarget() +  ": <" + x + "," + y + "> " + count + " by " + button);
				Gdx.app.log(TAG, "Total taps on actor: " + totalTaps);
				super.tap(event, x, y, count, button);
			}
		});
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(img, getX(), getY());
	}


}
