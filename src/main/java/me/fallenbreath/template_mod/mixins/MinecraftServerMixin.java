package me.fallenbreath.template_mod.mixins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin
{
	@Inject(
			//#if MC >= 11600
			//$$ method = "runServer",
			//#else
			method = "run",
			//#endif
			at = @At("HEAD")
	)
	private void onRun(CallbackInfo ci)
	{
		//#if MC >= 11500
		System.err.println("Hello world from mc11500 branch");
		//#elseif MC >= 11400
		//$$ System.err.println("Hello world from mc11400 branch");
		//#endif

		CompoundTag nbt = new CompoundTag();
		nbt.putString("key", "value");
		System.err.println("nbt: " + nbt);
	}
}
