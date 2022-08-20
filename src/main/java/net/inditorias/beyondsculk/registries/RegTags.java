package net.inditorias.beyondsculk.registries;

import net.inditorias.beyondsculk.BeyondSculk;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegTags {

    public static void register(){

    }

    public static class Blocks{

        public static final TagKey<Block> RESONANT_FRAME_BLOCKS = createTag("resonant_frame_blocks");
        public static final TagKey<Block> UNSTABLE_FRAME_BLOCKS = createTag("unstable_frame_blocks");
        public static final TagKey<Block> SCULK_FRAME_BLOCKS = createTag("sculk_frame_blocks");        
        public static final TagKey<Block> RESONANT_PORTAL_REPLACEABLE = createTag("resonant_portal_replaceable");
        public static final TagKey<Block> UNSTABLE_PORTAL_REPLACEABLE = createTag("unstable_portal_replaceable");
        public static final TagKey<Block> SCULK_PORTAL_REPLACEABLE = createTag("sculk_portal_replaceable");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(BeyondSculk.MOD_ID, name));
        }

        private static TagKey<Block> createCommonTag(String name){
            return TagKey.of(Registry.BLOCK_KEY, new Identifier("c", name));
        }
    }

    public static class Items{
        private static TagKey<Item> createTag(String name){
            return TagKey.of(Registry.ITEM_KEY, new Identifier(BeyondSculk.MOD_ID, name));
        }

        private static TagKey<Item> createCommonTag(String name) {
            return TagKey.of(Registry.ITEM_KEY, new Identifier("c", name));
        }
    }
}
