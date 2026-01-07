package net.jfjjrmfjg.reachhelmet;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.*;

import java.util.Map;

public class CopperHardhatArmorMaterial {
    public static final int BASE_DURABILITY = 11;

    public static final TagKey<Item> REPAIRS_COPPER_HARDHAT = TagKey
            .create(BuiltInRegistries.ITEM.key(),
                    Identifier.fromNamespaceAndPath(ReachHelmet.MOD_ID, "repairs_copper_hardhat")
            );

    public static final ResourceKey<EquipmentAsset> COPPER_HARDHAT_ARMOR_MATERIAL_KEY = ResourceKey
            .create(EquipmentAssets.ROOT_ID, Identifier.
                    fromNamespaceAndPath(ReachHelmet.MOD_ID, "copper_hardhat")
            );

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3
            ),
            ArmorMaterials.COPPER.enchantmentValue(),
            SoundEvents.ARMOR_EQUIP_COPPER,
            ArmorMaterials.COPPER.toughness(),
            ArmorMaterials.COPPER.knockbackResistance(),
            REPAIRS_COPPER_HARDHAT,
            COPPER_HARDHAT_ARMOR_MATERIAL_KEY
    );
}
