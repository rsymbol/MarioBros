package com.sol.mariobros.sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;

public class Pipe extends InteractiveTileObject{
    public Pipe(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
    }
}
