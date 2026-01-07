package net.jfjjrmfjg.reachhelmet;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

// not sure if this works yet, use what eddy sent since I changed a few stuff
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;

public class copper_hard_hat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(ReachHelmet.MOD_ID, "copper_hard_hat"), "main");

	private final ModelPart bb_main;

	public copper_hard_hat(ModelPart root) {
        super(root);
        this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(40, 29).addBox(-6.0F, 0.0F, -9.0F, 12.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-4.0F, 0.0F, -10.0F, 8.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-5.0F, -3.0F, -6.0F, 10.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(40, 33).addBox(-2.0F, -3.0F, -7.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 31).addBox(-6.0F, 0.0F, 7.0F, 12.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(50, 33).addBox(-2.0F, -3.0F, 6.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 37).addBox(-2.0F, -4.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 27).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 40).addBox(5.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(44, 14).addBox(-6.0F, -3.0F, -5.0F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}