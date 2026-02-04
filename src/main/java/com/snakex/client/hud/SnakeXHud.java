package com.snakex.client.hud;

import com.snakex.client.SnakeXTheme;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;

public class SnakeXHud implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.options.hudHidden) return;

        int fps = client.getCurrentFps();
        String text = "§aSnakeX v" + SnakeXTheme.VERSION + " §7| §f" + fps + " FPS";

        drawContext.drawText(client.textRenderer, text, 5, 5, SnakeXTheme.GREEN, true);
    }
}
