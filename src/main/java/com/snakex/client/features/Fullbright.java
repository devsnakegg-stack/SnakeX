package com.snakex.client.features;

import net.minecraft.client.MinecraftClient;

public class Fullbright {
    private static boolean enabled = false;
    private static double originalGamma = 1.0;

    public static void toggle() {
        enabled = !enabled;
        MinecraftClient client = MinecraftClient.getInstance();
        if (enabled) {
            originalGamma = client.options.getGamma().getValue();
            client.options.getGamma().setValue(16.0);
        } else {
            client.options.getGamma().setValue(originalGamma);
        }
    }

    public static boolean isEnabled() {
        return enabled;
    }
}
