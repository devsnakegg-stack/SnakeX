package com.snakex.client;

import com.snakex.client.features.Fullbright;
import com.snakex.client.hud.SnakeXHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class SnakeXClient implements ClientModInitializer {
    private static KeyBinding fullbrightKey;

    @Override
    public void onInitializeClient() {
        fullbrightKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.snakex.fullbright",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_B,
                "category.snakex"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (fullbrightKey.wasPressed()) {
                Fullbright.toggle();
            }
        });

        HudRenderCallback.EVENT.register(new SnakeXHud());
    }
}
