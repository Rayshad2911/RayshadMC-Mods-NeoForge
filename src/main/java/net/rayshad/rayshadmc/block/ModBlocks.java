package net.rayshad.rayshadmc.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rayshad.rayshadmc.RayshadMC;
import net.rayshad.rayshadmc.block.custom.CornCropBlock;
import net.rayshad.rayshadmc.block.custom.ModFlammableRotatedPillarBlock;
import net.rayshad.rayshadmc.block.custom.ModSaplingBlock;
import net.rayshad.rayshadmc.item.ModItems;
import net.rayshad.rayshadmc.worldgen.tree.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RayshadMC.MOD_ID);

    public static final DeferredBlock<Block> KROIPNITE_BLOCK = registerBlock("kroipnite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> OPYX_BLOCK = registerBlock("opyx_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> OPYX_HARDENED_BLOCK = registerBlock("opyx_hardened_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<StairBlock> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new StairBlock(ModBlocks.MAPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<PressurePlateBlock> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(0.5f)));
    public static final DeferredBlock<ButtonBlock> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new ButtonBlock(BlockSetType.OAK, 30, BlockBehaviour.Properties.of().strength(0.5f)
                    .noCollission()));
    public static final DeferredBlock<FenceBlock> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final DeferredBlock<Block> CHORUS_PLANKS = registerBlock("chorus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }
            });
    public static final DeferredBlock<StairBlock> CHORUS_STAIRS = registerBlock("chorus_stairs",
            () -> new StairBlock(ModBlocks.CHORUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> CHORUS_SLAB = registerBlock("chorus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<PressurePlateBlock> CHORUS_PRESSURE_PLATE = registerBlock("chorus_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(0.5f)));
    public static final DeferredBlock<ButtonBlock> CHORUS_BUTTON = registerBlock("chorus_button",
            () -> new ButtonBlock(BlockSetType.WARPED, 30, BlockBehaviour.Properties.of().strength(0.5f)
                    .noCollission()));
    public static final DeferredBlock<FenceBlock> CHORUS_FENCE = registerBlock("chorus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> CHORUS_FENCE_GATE = registerBlock("chorus_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> CHORUS_DOOR = registerBlock("chorus_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> CHORUS_TRAPDOOR = registerBlock("chorus_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final DeferredBlock<Block> PALE_CHORUS_PLANKS = registerBlock("pale_chorus_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return false;
                }
            });
    public static final DeferredBlock<StairBlock> PALE_CHORUS_STAIRS = registerBlock("pale_chorus_stairs",
            () -> new StairBlock(ModBlocks.PALE_CHORUS_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> PALE_CHORUS_SLAB = registerBlock("pale_chorus_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<PressurePlateBlock> PALE_CHORUS_PRESSURE_PLATE = registerBlock("pale_chorus_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(0.5f)));
    public static final DeferredBlock<ButtonBlock> PALE_CHORUS_BUTTON = registerBlock("pale_chorus_button",
            () -> new ButtonBlock(BlockSetType.WARPED, 30, BlockBehaviour.Properties.of().strength(0.5f)
                    .noCollission()));
    public static final DeferredBlock<FenceBlock> PALE_CHORUS_FENCE = registerBlock("pale_chorus_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> PALE_CHORUS_FENCE_GATE = registerBlock("pale_chorus_fence_gate",
            () -> new FenceGateBlock(WoodType.WARPED, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> PALE_CHORUS_DOOR = registerBlock("pale_chorus_door",
            () -> new DoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> PALE_CHORUS_TRAPDOOR = registerBlock("pale_chorus_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.WARPED, BlockBehaviour.Properties.of().strength(3f).noOcclusion()));

    public static final DeferredBlock<Block> KROIPNITE_ORE = registerBlock("kroipnite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_KROIPNITE_ORE = registerBlock("deepslate_kroipnite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> OPYX_SOIL = registerBlock("opyx_soil",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .strength(0.5f).sound(SoundType.SOUL_SOIL)));

    public static final DeferredBlock<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(ModTreeGrowers.MAPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<Block> CHORUS_STEM = registerBlock("chorus_stem",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_STEM)));
    public static final DeferredBlock<Block> CHORUS_HYPHAE = registerBlock("chorus_hyphae",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE)));
    public static final DeferredBlock<Block> PALE_CHORUS_STEM = registerBlock("pale_chorus_stem",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
    public static final DeferredBlock<Block> PALE_CHORUS_HYPHAE = registerBlock("pale_chorus_hyphae",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));
    public static final DeferredBlock<Block> CHORUS_LEAVES = registerBlock("chorus_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<Block> CHORUS_TREE_SEED = registerBlock("chorus_tree_seed",
            () -> new ModSaplingBlock(ModTreeGrowers.CHORUS, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SAPLING), () -> Blocks.END_STONE));
    public static final DeferredBlock<Block> PALE_CHORUS_TREE_SEED = registerBlock("pale_chorus_tree_seed",
            () -> new ModSaplingBlock(ModTreeGrowers.PALE_CHORUS, BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_SAPLING), () -> Blocks.END_STONE));

    public static final DeferredBlock<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, Supplier<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
