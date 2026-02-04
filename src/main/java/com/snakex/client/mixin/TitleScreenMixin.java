package com.snakex.client.mixin;

import com.snakex.client.SnakeXTheme;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;render(Lnet/minecraft/client/gui/DrawContext;IIF)V"))
    public void onBeforeSuperRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        // Fill background with black (Solid Black)
        context.fill(0, 0, this.width, this.height, 0xFF000000 | SnakeXTheme.BLACK);

        // Draw SnakeX Logo in Green
        String logo = "SnakeX";
        int textWidth = this.textRenderer.getWidth(logo);
        context.drawTextWithShadow(this.textRenderer, logo, (this.width - textWidth) / 2, 50, SnakeXTheme.GREEN);
    }
}
