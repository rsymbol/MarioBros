package com.sol.mariobros.sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.sol.mariobros.MarioBros;
import com.sol.mariobros.screens.PlayScreen;

public class Mario extends Sprite {
    public enum State {FALLING, JUMPING, STANDING, RUNNING}

    ;
    public State currentState;
    public State previousState;
    public World world;
    public Body b2body;
    private TextureRegion marioStand;
    private Animation marioRun;
    private Animation marioJump;
    private float stateTimer;
    private boolean runningRight;

    public Mario(World world, PlayScreen screen) {
        super(screen.getAtlas().findRegion("little_mario"));
        this.world = world;
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();
        for (int i = 1; i < 4; i++)
            frames.add(new TextureRegion(getTexture(), i * 16, 0, 16, 16));
        marioRun = new Animation(0.1f, frames);
        frames.clear();

        for (int i = 1; i < 4; i++)
            frames.add(new TextureRegion(getTexture(), i * 16, 0, 16, 16));
        marioJump = new Animation(0.1f, frames);
        frames.clear();

        marioStand = new TextureRegion(getTexture(), 0, 0, 16, 16);

        defineMario();
        setBounds(0, 0, 16 / MarioBros.PPM, 16 / MarioBros.PPM);
        setRegion(marioStand);
    }

    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);
    }

    public void defineMario() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / MarioBros.PPM, 32 / MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 / MarioBros.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }
}
