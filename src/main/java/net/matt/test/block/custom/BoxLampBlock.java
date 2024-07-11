package net.matt.test.block.custom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class BoxLampBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");
//    public static final BooleanProperty LIT = Properties.LIT;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    public BoxLampBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(LIT, false));
    }

//    @Override
//    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if(!world.isClient()) {
//            if (!state.get(LIT).booleanValue()) {
//                world.setBlockState(pos, (BlockState) state.with(LIT, true));
//            }
//        }
//
//        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
//    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            world.setBlockState(pos, state.cycle(LIT));
        }

        return ActionResult.SUCCESS;
        //return super.onUse(state, world, pos, player, hit);
    }


}
