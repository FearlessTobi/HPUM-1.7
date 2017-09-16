package snidgert.harrypottermod.mobs;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class UkaranianIronbelly extends ModelBase
{
    ModelRenderer right_foot;
    ModelRenderer right_foot_nail_1;
    ModelRenderer right_foot_nail_2;
    ModelRenderer right_foot_nail_3;
    ModelRenderer lower_right_leg;
    ModelRenderer right_back_nail;
    ModelRenderer upper_right_leg;
    ModelRenderer left_foot;
    ModelRenderer left_foot_nail_1;
    ModelRenderer left_foot_nail_2;
    ModelRenderer left_foot_nail_3;
    ModelRenderer lower_left_leg;
    ModelRenderer left_back_nail;
    ModelRenderer upper_left_leg;
    ModelRenderer lower_body;
    ModelRenderer upper_body;
    ModelRenderer neck_1;
    ModelRenderer neck_2;
    ModelRenderer head;
    ModelRenderer lower_nose;
    ModelRenderer upper_nose;
    ModelRenderer inner_right_arm;
    ModelRenderer middle_right_arm;
    ModelRenderer outer_right_arm;
    ModelRenderer right_wing;
    ModelRenderer inner_left_arm;
    ModelRenderer middle_left_arm;
    ModelRenderer outer_left_arm;
    ModelRenderer left_wing;
    ModelRenderer tail_1;
    ModelRenderer tail_2;
    ModelRenderer tail3;
    ModelRenderer tail5;
    ModelRenderer left_hand;
    ModelRenderer right_hand;
    ModelRenderer nose;
    ModelRenderer lower_teeth;
    ModelRenderer upper_teeth;
    ModelRenderer BigHorn1;
    ModelRenderer BigHorn2;
    ModelRenderer BigHorn3;
    ModelRenderer BigHorn4;
    ModelRenderer BigHorn5;
    ModelRenderer eyebrowL;
    ModelRenderer eyebrowR;
    ModelRenderer bodyhorns1;
    ModelRenderer bodyhorns2;
    ModelRenderer bodyhorns3;
    ModelRenderer bodyhorns4;
    ModelRenderer bodyhorns5;
    ModelRenderer bodyhorns6;
    ModelRenderer bodyhorns7;
    ModelRenderer bodyhorns8;
    ModelRenderer bodyhorns9;
    ModelRenderer bodyhorns10;
    ModelRenderer bodyhorns11;
    ModelRenderer bodyhorns12;
    ModelRenderer bodyhorns13;
    ModelRenderer bodyhorns14;
    ModelRenderer bodyhorns15;
    ModelRenderer bodyhorns16;
    ModelRenderer bodyhorns17;
    
    public UkaranianIronbelly() {
        super.textureWidth = 512;
        super.textureHeight = 512;
        (this.right_foot = new ModelRenderer(this, 0, 0)).addBox(-3.5f, 0.0f, -3.5f, 7, 3, 7);
        this.right_foot.setRotationPoint(-7.5f, 21.0f, 20.0f);
        this.right_foot.setTextureSize(512, 512);
        this.right_foot.mirror = true;
        this.setRotation(this.right_foot, 0.0f, 0.0f, 0.0f);
        (this.right_foot_nail_1 = new ModelRenderer(this, 35, 0)).addBox(-1.0f, -1.0f, -5.0f, 2, 2, 5);
        this.right_foot_nail_1.setRotationPoint(-5.5f, 23.0f, 17.0f);
        this.right_foot_nail_1.setTextureSize(512, 512);
        this.right_foot_nail_1.mirror = true;
        this.setRotation(this.right_foot_nail_1, 0.0f, -0.3490659f, 0.0f);
        (this.right_foot_nail_2 = new ModelRenderer(this, 35, 10)).addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6);
        this.right_foot_nail_2.setRotationPoint(-7.5f, 23.0f, 17.0f);
        this.right_foot_nail_2.setTextureSize(512, 512);
        this.right_foot_nail_2.mirror = true;
        this.setRotation(this.right_foot_nail_2, 0.0f, 0.0f, 0.0f);
        (this.right_foot_nail_3 = new ModelRenderer(this, 35, 0)).addBox(-1.0f, -1.0f, -5.0f, 2, 2, 5);
        this.right_foot_nail_3.setRotationPoint(-9.5f, 23.0f, 17.0f);
        this.right_foot_nail_3.setTextureSize(512, 512);
        this.right_foot_nail_3.mirror = true;
        this.setRotation(this.right_foot_nail_3, 0.0f, 0.3490659f, 0.0f);
        (this.lower_right_leg = new ModelRenderer(this, 5, 25)).addBox(-2.5f, 0.0f, -2.5f, 5, 15, 5);
        this.lower_right_leg.setRotationPoint(-7.5f, 9.5f, 13.5f);
        this.lower_right_leg.setTextureSize(512, 512);
        this.lower_right_leg.mirror = true;
        this.setRotation(this.lower_right_leg, 0.5189514f, 0.0f, 0.0f);
        (this.right_back_nail = new ModelRenderer(this, 35, 30)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6);
        this.right_back_nail.setRotationPoint(-7.5f, 19.0f, 20.0f);
        this.right_back_nail.setTextureSize(512, 512);
        this.right_back_nail.mirror = true;
        this.setRotation(this.right_back_nail, -0.1745329f, 0.0f, 0.0f);
        (this.upper_right_leg = new ModelRenderer(this, 58, 0)).addBox(-6.0f, -10.0f, -5.0f, 6, 14, 10);
        this.upper_right_leg.setRotationPoint(-4.5f, 7.0f, 21.0f);
        this.upper_right_leg.setTextureSize(512, 512);
        this.upper_right_leg.mirror = true;
        this.setRotation(this.upper_right_leg, 2.181662f, 0.0f, 0.0f);
        (this.left_foot = new ModelRenderer(this, 0, 0)).addBox(-3.5f, 0.0f, -3.5f, 7, 3, 7);
        this.left_foot.setRotationPoint(7.5f, 21.0f, 20.0f);
        this.left_foot.setTextureSize(512, 512);
        this.left_foot.mirror = true;
        this.setRotation(this.left_foot, 0.0f, 0.0f, 0.0f);
        (this.left_foot_nail_1 = new ModelRenderer(this, 35, 0)).addBox(-1.0f, -1.0f, -5.0f, 2, 2, 5);
        this.left_foot_nail_1.setRotationPoint(9.5f, 23.0f, 17.0f);
        this.left_foot_nail_1.setTextureSize(512, 512);
        this.left_foot_nail_1.mirror = true;
        this.setRotation(this.left_foot_nail_1, 0.0f, -0.3490659f, 0.0f);
        (this.left_foot_nail_2 = new ModelRenderer(this, 35, 10)).addBox(-1.0f, -1.0f, -6.0f, 2, 2, 6);
        this.left_foot_nail_2.setRotationPoint(7.5f, 23.0f, 17.0f);
        this.left_foot_nail_2.setTextureSize(512, 512);
        this.left_foot_nail_2.mirror = true;
        this.setRotation(this.left_foot_nail_2, 0.0f, 0.0f, 0.0f);
        (this.left_foot_nail_3 = new ModelRenderer(this, 35, 0)).addBox(-1.0f, -1.0f, -5.0f, 2, 2, 5);
        this.left_foot_nail_3.setRotationPoint(5.5f, 23.0f, 17.0f);
        this.left_foot_nail_3.setTextureSize(512, 512);
        this.left_foot_nail_3.mirror = true;
        this.setRotation(this.left_foot_nail_3, 0.0f, 0.3490659f, 0.0f);
        (this.lower_left_leg = new ModelRenderer(this, 5, 25)).addBox(-2.5f, 0.0f, -2.5f, 5, 15, 5);
        this.lower_left_leg.setRotationPoint(7.5f, 9.5f, 13.5f);
        this.lower_left_leg.setTextureSize(512, 512);
        this.lower_left_leg.mirror = true;
        this.setRotation(this.lower_left_leg, 0.5189514f, 0.0f, 0.0f);
        (this.left_back_nail = new ModelRenderer(this, 35, 30)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6);
        this.left_back_nail.setRotationPoint(7.5f, 19.0f, 20.0f);
        this.left_back_nail.setTextureSize(512, 512);
        this.left_back_nail.mirror = true;
        this.setRotation(this.left_back_nail, -0.1745329f, 0.0f, 0.0f);
        (this.upper_left_leg = new ModelRenderer(this, 58, 0)).addBox(0.0f, -10.0f, -5.0f, 6, 14, 10);
        this.upper_left_leg.setRotationPoint(4.5f, 6.0f, 21.0f);
        this.upper_left_leg.setTextureSize(512, 512);
        this.upper_left_leg.mirror = true;
        this.setRotation(this.upper_left_leg, 2.181662f, 0.0f, 0.0f);
        (this.lower_body = new ModelRenderer(this, 300, 0)).addBox(-7.0f, -6.0f, -11.5f, 14, 12, 23);
        this.lower_body.setRotationPoint(0.0f, 2.0f, 19.0f);
        this.lower_body.setTextureSize(512, 512);
        this.lower_body.mirror = true;
        this.setRotation(this.lower_body, -0.2617994f, 0.0f, 0.0f);
        (this.upper_body = new ModelRenderer(this, 0, 300)).addBox(-8.0f, -8.0f, -12.0f, 16, 16, 24);
        this.upper_body.setRotationPoint(0.0f, -2.0f, -2.0f);
        this.upper_body.setTextureSize(512, 512);
        this.upper_body.mirror = true;
        this.setRotation(this.upper_body, -0.0872665f, 0.0f, 0.0f);
        (this.neck_1 = new ModelRenderer(this, 400, 0)).addBox(-4.5f, -4.5f, -10.0f, 9, 9, 10);
        this.neck_1.setRotationPoint(0.0f, -3.5f, -13.0f);
        this.neck_1.setTextureSize(512, 512);
        this.neck_1.mirror = true;
        this.setRotation(this.neck_1, 0.0f, 0.0f, 0.0f);
        (this.neck_2 = new ModelRenderer(this, 400, 400)).addBox(-4.5f, -4.5f, -12.0f, 9, 9, 12);
        this.neck_2.setRotationPoint(0.0f, -3.5f, -22.5f);
        this.neck_2.setTextureSize(512, 512);
        this.neck_2.mirror = true;
        this.setRotation(this.neck_2, 0.0872665f, 0.0f, 0.0f);
        (this.head = new ModelRenderer(this, 300, 300)).addBox(-5.5f, -6.5f, -14.0f, 11, 12, 14);
        this.head.setRotationPoint(0.0f, -3.2f, -33.0f);
        this.head.setTextureSize(512, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.lower_nose = new ModelRenderer(this, 175, 175)).addBox(-4.0f, -2.0f, -10.0f, 8, 4, 10);
        this.lower_nose.setRotationPoint(0.0f, 0.0f, -46.0f);
        this.lower_nose.setTextureSize(512, 512);
        this.lower_nose.mirror = true;
        this.setRotation(this.lower_nose, 0.0872665f, 0.0f, 0.0f);
        (this.upper_nose = new ModelRenderer(this, 200, 200)).addBox(-5.0f, -3.0f, -11.0f, 10, 6, 11);
        this.upper_nose.setRotationPoint(0.0f, -6.5f, -46.5f);
        this.upper_nose.setTextureSize(512, 512);
        this.upper_nose.mirror = true;
        this.setRotation(this.upper_nose, -0.0349066f, 0.0f, 0.0f);
        (this.inner_right_arm = new ModelRenderer(this, 0, 200)).addBox(0.0f, -2.5f, -2.5f, 20, 5, 5);
        this.inner_right_arm.setRotationPoint(7.0f, -4.5f, -11.5f);
        this.inner_right_arm.setTextureSize(512, 512);
        this.inner_right_arm.mirror = true;
        this.setRotation(this.inner_right_arm, 0.0f, 0.1745329f, 0.0f);
        (this.middle_right_arm = new ModelRenderer(this, 200, 0)).addBox(15.0f, -2.5f, 8.5f, 35, 5, 5);
        this.middle_right_arm.setRotationPoint(7.0f, -4.5f, -11.5f);
        this.middle_right_arm.setTextureSize(512, 512);
        this.middle_right_arm.mirror = true;
        this.setRotation(this.middle_right_arm, 0.0f, 0.7853982f, 0.0f);
        (this.outer_right_arm = new ModelRenderer(this, 150, 150)).addBox(22.0f, -2.5f, -45.5f, 50, 5, 5);
        this.outer_right_arm.setRotationPoint(7.0f, -4.5f, -11.5f);
        this.outer_right_arm.setTextureSize(512, 512);
        this.outer_right_arm.mirror = true;
        this.setRotation(this.outer_right_arm, 0.0f, -0.5235988f, 0.0f);
        (this.right_wing = new ModelRenderer(this, 215, 226)).addBox(0.0f, 0.0f, -22.0f, 83, 1, 61);
        this.right_wing.setRotationPoint(7.0f, -5.0f, -15.0f);
        this.right_wing.setTextureSize(512, 512);
        this.right_wing.mirror = true;
        this.setRotation(this.right_wing, 0.0f, 0.0f, 0.0f);
        (this.inner_left_arm = new ModelRenderer(this, 0, 200)).addBox(-20.0f, -2.5f, -2.5f, 20, 5, 5);
        this.inner_left_arm.setRotationPoint(-7.0f, -4.5f, -11.5f);
        this.inner_left_arm.setTextureSize(512, 512);
        this.inner_left_arm.mirror = true;
        this.setRotation(this.inner_left_arm, 0.0f, -0.1745329f, 0.0f);
        (this.middle_left_arm = new ModelRenderer(this, 200, 0)).addBox(-50.0f, -2.5f, 8.0f, 35, 5, 5);
        this.middle_left_arm.setRotationPoint(-7.0f, -4.5f, -11.5f);
        this.middle_left_arm.setTextureSize(512, 512);
        this.middle_left_arm.mirror = true;
        this.setRotation(this.middle_left_arm, 0.0f, -0.7853982f, 0.0f);
        (this.outer_left_arm = new ModelRenderer(this, 150, 150)).addBox(-71.0f, -2.5f, -46.0f, 50, 5, 5);
        this.outer_left_arm.setRotationPoint(-7.0f, -4.5f, -11.5f);
        this.outer_left_arm.setTextureSize(512, 512);
        this.outer_left_arm.mirror = true;
        this.setRotation(this.outer_left_arm, 0.0f, 0.5235988f, 0.0f);
        (this.left_wing = new ModelRenderer(this, 260, 158)).addBox(-83.0f, 0.0f, -22.0f, 83, 1, 61);
        this.left_wing.setRotationPoint(-7.0f, -5.0f, -14.0f);
        this.left_wing.setTextureSize(512, 512);
        this.left_wing.mirror = true;
        this.setRotation(this.left_wing, 0.0f, 0.0f, 0.0f);
        (this.tail_1 = new ModelRenderer(this, 91, 40)).addBox(-4.0f, -4.0f, 0.0f, 8, 8, 25);
        this.tail_1.setRotationPoint(0.0f, 5.0f, 28.0f);
        this.tail_1.setTextureSize(512, 512);
        this.tail_1.mirror = true;
        this.setRotation(this.tail_1, 0.1745329f, 0.0f, 0.0f);
        (this.tail_2 = new ModelRenderer(this, 97, 0)).addBox(-3.5f, -3.5f, 0.0f, 7, 7, 18);
        this.tail_2.setRotationPoint(0.0f, 1.0f, 51.0f);
        this.tail_2.setTextureSize(512, 512);
        this.tail_2.mirror = true;
        this.setRotation(this.tail_2, 0.0f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer(this, 0, 71)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 20);
        this.tail3.setRotationPoint(0.0f, 1.0f, 68.0f);
        this.tail3.setTextureSize(512, 512);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 0.1047198f, 0.0f, 0.0f);
        (this.tail5 = new ModelRenderer(this, 0, 144)).addBox(-2.5f, -2.5f, 0.0f, 5, 5, 13);
        this.tail5.setRotationPoint(0.0f, -1.0f, 87.0f);
        this.tail5.setTextureSize(512, 512);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, 0.1047198f, 0.0f, 0.0f);
        (this.left_hand = new ModelRenderer(this, 400, 100)).addBox(39.5f, -7.0f, -39.0f, 5, 5, 15);
        this.left_hand.setRotationPoint(7.0f, -4.5f, -11.5f);
        this.left_hand.setTextureSize(512, 512);
        this.left_hand.mirror = true;
        this.setRotation(this.left_hand, 0.1745329f, 0.0f, 0.0f);
        (this.right_hand = new ModelRenderer(this, 400, 100)).addBox(-44.5f, -7.0f, -39.0f, 5, 5, 15);
        this.right_hand.setRotationPoint(-7.0f, -4.5f, -11.5f);
        this.right_hand.setTextureSize(512, 512);
        this.right_hand.mirror = true;
        this.setRotation(this.right_hand, 0.1745329f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer(this, 0, 51)).addBox(-4.5f, -3.0f, -4.0f, 9, 6, 4);
        this.nose.setRotationPoint(0.0f, -6.8f, -55.0f);
        this.nose.setTextureSize(512, 512);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0872665f, 0.0f, 0.0f);
        (this.lower_teeth = new ModelRenderer(this, 41, 43)).addBox(-3.5f, -2.0f, -3.0f, 7, 2, 8);
        this.lower_teeth.setRotationPoint(0.0f, -0.9f, -52.0f);
        this.lower_teeth.setTextureSize(512, 512);
        this.lower_teeth.mirror = true;
        this.setRotation(this.lower_teeth, 0.0872665f, 0.0f, 0.0f);
        (this.upper_teeth = new ModelRenderer(this, 41, 53)).addBox(-4.0f, 0.0f, -3.0f, 8, 2, 8);
        this.upper_teeth.setRotationPoint(0.0f, -4.0f, -54.0f);
        this.upper_teeth.setTextureSize(512, 512);
        this.upper_teeth.mirror = true;
        this.setRotation(this.upper_teeth, 0.0f, 0.0f, 0.0f);
        (this.BigHorn1 = new ModelRenderer(this, 0, 228)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 15);
        this.BigHorn1.setRotationPoint(0.0f, -8.0f, -41.0f);
        this.BigHorn1.setTextureSize(512, 512);
        this.BigHorn1.mirror = true;
        this.setRotation(this.BigHorn1, 0.3490659f, 0.0f, 0.0f);
        (this.BigHorn2 = new ModelRenderer(this, 0, 228)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 15);
        this.BigHorn2.setRotationPoint(2.0f, -7.0f, -42.0f);
        this.BigHorn2.setTextureSize(512, 512);
        this.BigHorn2.mirror = true;
        this.setRotation(this.BigHorn2, 0.3490659f, 0.1745329f, 0.0f);
        (this.BigHorn3 = new ModelRenderer(this, 0, 228)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 15);
        this.BigHorn3.setRotationPoint(-2.0f, -7.0f, -42.0f);
        this.BigHorn3.setTextureSize(512, 512);
        this.BigHorn3.mirror = true;
        this.setRotation(this.BigHorn3, 0.3490659f, -0.1745329f, 0.0f);
        (this.BigHorn4 = new ModelRenderer(this, 0, 228)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 15);
        this.BigHorn4.setRotationPoint(3.5f, -6.0f, -42.0f);
        this.BigHorn4.setTextureSize(512, 512);
        this.BigHorn4.mirror = true;
        this.setRotation(this.BigHorn4, 0.3490659f, 0.2617994f, 0.0f);
        (this.BigHorn5 = new ModelRenderer(this, 0, 228)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 15);
        this.BigHorn5.setRotationPoint(-3.5f, -6.0f, -42.0f);
        this.BigHorn5.setTextureSize(512, 512);
        this.BigHorn5.mirror = true;
        this.setRotation(this.BigHorn5, 0.3490659f, -0.2617994f, 0.0f);
        (this.eyebrowL = new ModelRenderer(this, 0, 13)).addBox(0.0f, -1.0f, -3.0f, 2, 2, 6);
        this.eyebrowL.setRotationPoint(4.0f, -10.0f, -43.0f);
        this.eyebrowL.setTextureSize(512, 512);
        this.eyebrowL.mirror = true;
        this.setRotation(this.eyebrowL, 0.0f, 0.0f, 0.0f);
        (this.eyebrowR = new ModelRenderer(this, 0, 13)).addBox(-2.0f, -1.0f, -3.0f, 2, 2, 6);
        this.eyebrowR.setRotationPoint(-4.0f, -10.0f, -43.0f);
        this.eyebrowR.setTextureSize(512, 512);
        this.eyebrowR.mirror = true;
        this.setRotation(this.eyebrowR, 0.0f, 0.0f, 0.0f);
        (this.bodyhorns1 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns1.setRotationPoint(0.0f, 1.0f, -32.0f);
        this.bodyhorns1.setTextureSize(512, 512);
        this.bodyhorns1.mirror = true;
        this.setRotation(this.bodyhorns1, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns2 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns2.setRotationPoint(0.0f, 1.0f, -29.0f);
        this.bodyhorns2.setTextureSize(512, 512);
        this.bodyhorns2.mirror = true;
        this.setRotation(this.bodyhorns2, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns3 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns3.setRotationPoint(0.0f, 0.5f, -26.0f);
        this.bodyhorns3.setTextureSize(512, 512);
        this.bodyhorns3.mirror = true;
        this.setRotation(this.bodyhorns3, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns4 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns4.setRotationPoint(0.0f, 0.0f, -23.0f);
        this.bodyhorns4.setTextureSize(512, 512);
        this.bodyhorns4.mirror = true;
        this.setRotation(this.bodyhorns4, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns5 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns5.setRotationPoint(0.0f, 0.0f, -20.0f);
        this.bodyhorns5.setTextureSize(512, 512);
        this.bodyhorns5.mirror = true;
        this.setRotation(this.bodyhorns5, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns6 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns6.setRotationPoint(0.0f, -1.0f, -17.0f);
        this.bodyhorns6.setTextureSize(512, 512);
        this.bodyhorns6.mirror = true;
        this.setRotation(this.bodyhorns6, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns7 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns7.setRotationPoint(0.0f, -4.0f, -12.0f);
        this.bodyhorns7.setTextureSize(512, 512);
        this.bodyhorns7.mirror = true;
        this.setRotation(this.bodyhorns7, -0.1745329f, 0.0f, 0.0f);
        (this.bodyhorns8 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns8.setRotationPoint(0.0f, -5.0f, -8.0f);
        this.bodyhorns8.setTextureSize(512, 512);
        this.bodyhorns8.mirror = true;
        this.setRotation(this.bodyhorns8, -0.1745329f, 0.0f, 0.0f);
        (this.bodyhorns9 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns9.setRotationPoint(0.0f, -6.0f, -4.0f);
        this.bodyhorns9.setTextureSize(512, 512);
        this.bodyhorns9.mirror = true;
        this.setRotation(this.bodyhorns9, -0.1745329f, 0.0f, 0.0f);
        (this.bodyhorns10 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns10.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bodyhorns10.setTextureSize(512, 512);
        this.bodyhorns10.mirror = true;
        this.setRotation(this.bodyhorns10, -0.1745329f, 0.0f, 0.0f);
        (this.bodyhorns11 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns11.setRotationPoint(0.0f, -5.0f, 3.0f);
        this.bodyhorns11.setTextureSize(512, 512);
        this.bodyhorns11.mirror = true;
        this.setRotation(this.bodyhorns11, -0.2268928f, 0.0f, 0.0f);
        (this.bodyhorns12 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns12.setRotationPoint(0.0f, -3.0f, 6.0f);
        this.bodyhorns12.setTextureSize(512, 512);
        this.bodyhorns12.mirror = true;
        this.setRotation(this.bodyhorns12, -0.2617994f, 0.0f, 0.0f);
        (this.bodyhorns13 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns13.setRotationPoint(0.0f, -1.0f, 10.0f);
        this.bodyhorns13.setTextureSize(512, 512);
        this.bodyhorns13.mirror = true;
        this.setRotation(this.bodyhorns13, -0.3490659f, 0.0f, 0.0f);
        (this.bodyhorns14 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns14.setRotationPoint(0.0f, 1.0f, 13.0f);
        this.bodyhorns14.setTextureSize(512, 512);
        this.bodyhorns14.mirror = true;
        this.setRotation(this.bodyhorns14, -0.3490659f, 0.0f, 0.0f);
        (this.bodyhorns15 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns15.setRotationPoint(0.0f, 2.0f, 16.0f);
        this.bodyhorns15.setTextureSize(512, 512);
        this.bodyhorns15.mirror = true;
        this.setRotation(this.bodyhorns15, -0.3839724f, 0.0f, 0.0f);
        (this.bodyhorns16 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns16.setRotationPoint(0.0f, 3.5f, 19.0f);
        this.bodyhorns16.setTextureSize(512, 512);
        this.bodyhorns16.mirror = true;
        this.setRotation(this.bodyhorns16, -0.418879f, 0.0f, 0.0f);
        (this.bodyhorns17 = new ModelRenderer(this, 0, 103)).addBox(-0.5f, -12.0f, -0.5f, 1, 12, 1);
        this.bodyhorns17.setRotationPoint(0.0f, 5.0f, 22.0f);
        this.bodyhorns17.setTextureSize(512, 512);
        this.bodyhorns17.mirror = true;
        this.setRotation(this.bodyhorns17, -0.418879f, 0.0f, 0.0f);
    }
    
    @Override
	public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.right_foot.render(par7);
        this.right_foot_nail_1.render(par7);
        this.right_foot_nail_2.render(par7);
        this.right_foot_nail_3.render(par7);
        this.lower_right_leg.render(par7);
        this.right_back_nail.render(par7);
        this.upper_right_leg.render(par7);
        this.left_foot.render(par7);
        this.left_foot_nail_1.render(par7);
        this.left_foot_nail_2.render(par7);
        this.left_foot_nail_3.render(par7);
        this.lower_left_leg.render(par7);
        this.left_back_nail.render(par7);
        this.upper_left_leg.render(par7);
        this.lower_body.render(par7);
        this.upper_body.render(par7);
        this.neck_1.render(par7);
        this.neck_2.render(par7);
        this.head.render(par7);
        this.lower_nose.render(par7);
        this.upper_nose.render(par7);
        this.inner_right_arm.render(par7);
        this.middle_right_arm.render(par7);
        this.outer_right_arm.render(par7);
        this.right_wing.render(par7);
        this.inner_left_arm.render(par7);
        this.middle_left_arm.render(par7);
        this.outer_left_arm.render(par7);
        this.left_wing.render(par7);
        this.tail_1.render(par7);
        this.tail_2.render(par7);
        this.tail3.render(par7);
        this.tail5.render(par7);
        this.left_hand.render(par7);
        this.right_hand.render(par7);
        this.nose.render(par7);
        this.lower_teeth.render(par7);
        this.upper_teeth.render(par7);
        this.BigHorn1.render(par7);
        this.BigHorn2.render(par7);
        this.BigHorn3.render(par7);
        this.BigHorn4.render(par7);
        this.BigHorn5.render(par7);
        this.eyebrowL.render(par7);
        this.eyebrowR.render(par7);
        this.bodyhorns1.render(par7);
        this.bodyhorns2.render(par7);
        this.bodyhorns3.render(par7);
        this.bodyhorns4.render(par7);
        this.bodyhorns5.render(par7);
        this.bodyhorns6.render(par7);
        this.bodyhorns7.render(par7);
        this.bodyhorns8.render(par7);
        this.bodyhorns9.render(par7);
        this.bodyhorns10.render(par7);
        this.bodyhorns11.render(par7);
        this.bodyhorns12.render(par7);
        this.bodyhorns13.render(par7);
        this.bodyhorns14.render(par7);
        this.bodyhorns15.render(par7);
        this.bodyhorns16.render(par7);
        this.bodyhorns17.render(par7);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    @Override
	public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.inner_left_arm.rotateAngleZ = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.inner_right_arm.rotateAngleZ = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.outer_left_arm.rotateAngleZ = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.outer_right_arm.rotateAngleZ = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.middle_left_arm.rotateAngleZ = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.middle_right_arm.rotateAngleZ = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.left_hand.rotateAngleZ = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.right_hand.rotateAngleZ = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.left_wing.rotateAngleZ = -MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
        this.right_wing.rotateAngleZ = MathHelper.cos(par1 * 0.6222f) * 2.0f * par2 * 0.5f;
    }
}