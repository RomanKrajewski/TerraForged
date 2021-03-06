package com.terraforged.mod.feature.decorator.poisson;

import com.terraforged.core.util.poisson.Poisson;
import com.terraforged.core.util.poisson.PoissonContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class PoissonVisitor extends PoissonContext implements Poisson.Visitor {

    private final BlockPos pos;
    private final IWorld world;
    private final ConfiguredFeature<?, ?> feature;
    private final PoissonDecorator decorator;
    private final ChunkGenerator<?> generator;
    private final BlockPos.Mutable mutable = new BlockPos.Mutable();

    private boolean placedOne = false;

    public PoissonVisitor(PoissonDecorator decorator, ConfiguredFeature<?, ?> feature, IWorld world, ChunkGenerator<?> generator, Random random, BlockPos pos) {
        super(world.getSeed(), random);
        this.pos = pos;
        this.world = world;
        this.feature = feature;
        this.decorator = decorator;
        this.generator = generator;
    }

    public boolean hasPlacedOne() {
        return placedOne;
    }

    @Override
    public void visit(int x, int z) {
        mutable.setPos(x, pos.getY(), z);
        mutable.setY(decorator.getYAt(world, mutable, random));
        if (feature.place(world, generator, random, mutable)) {
            placedOne = true;
        }
    }
}
