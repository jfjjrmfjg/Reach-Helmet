package net.jfjjrmfjg.reachhelmet;

import com.jcraft.jorbis.Block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    private static final double EXTRA_REACH_COPPER = 1.0;
    private static final double EXTRA_REACH_IRON = 2.0;
    private static final double EXTRA_REACH_DIAMOND = 3.0;

    private static final double ARMOR_COPPER = 2;
    private static final double ARMOR_IRON = 2;
    private static final double ARMOR_DIAMOND = 3;


    public static final Item COPPER_HARDHAT = register(
            "copper_hardhat",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(CopperHardhatArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(CopperHardhatArmorMaterial.BASE_DURABILITY))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.ARMOR,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_armor"),
                                                    ARMOR_COPPER,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .add(Attributes.BLOCK_INTERACTION_RANGE,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_reach_helmet"),
                                                    EXTRA_REACH_COPPER,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .build()
                    )
    );

    public static final Item IRON_HARDHAT = register(
            "iron_hardhat",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(IronHardhatArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(IronHardhatArmorMaterial.BASE_DURABILITY))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.ARMOR,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_armor"),
                                                    ARMOR_IRON,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .add(Attributes.BLOCK_INTERACTION_RANGE,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_reach_helmet"),
                                                    EXTRA_REACH_IRON,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .build()
                    ));

    public static final Item DIAMOND_HARDHAT = register(
            "diamond_hardhat",
            Item::new,
            new Item.Properties()
                    .humanoidArmor(DiamondHardhatArmorMaterial.INSTANCE, ArmorType.HELMET)
                    .durability(ArmorType.HELMET.getDurability(DiamondHardhatArmorMaterial.BASE_DURABILITY))
                    .attributes(
                            ItemAttributeModifiers.builder()
                                    .add(Attributes.ARMOR,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_armor"),
                                                    ARMOR_DIAMOND,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .add(Attributes.BLOCK_INTERACTION_RANGE,
                                            new AttributeModifier(
                                                    Identifier.withDefaultNamespace("base_reach_helmet"),
                                                    EXTRA_REACH_DIAMOND,
                                                    AttributeModifier.Operation.ADD_VALUE
                                            ),
                                            EquipmentSlotGroup.bySlot(ArmorType.HELMET.getSlot())
                                    )
                                    .build()
                    )
    );


    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ReachHelmet.MOD_ID, name));

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ReachHelmet.LOGGER.info("Initializing Reach Helmet...");
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register((itemGroup) -> itemGroup.accept(ModItems.COPPER_HARDHAT));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register(itemGroup -> itemGroup.accept(ModItems.IRON_HARDHAT));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT)
                .register(itemGroup -> itemGroup.accept(ModItems.DIAMOND_HARDHAT));
    }

}
