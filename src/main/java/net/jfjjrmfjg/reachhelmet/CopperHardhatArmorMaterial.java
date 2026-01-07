package net.jfjjrmfjg.reachhelmet;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class CopperHardhatArmorMaterial {
    public static final int BASE_DURABILITY = 11;
    public static final ArmorMaterial INSTANCE = ArmorMaterials.COPPER;

    //idk if this is needed so it can just stay here for now ig
    //public static final ResourceKey<EquipmentAsset> COPPER_HARDHAT_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(ReachHelmet.MOD_ID, "copper_hardhat"));
    //public static final TagKey<Item> REPAIRS_COPPER_HARDHAT = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(ReachHelmet.MOD_ID, "repairs_copper_hardhat"));
}
