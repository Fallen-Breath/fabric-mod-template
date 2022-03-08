package me.fallenbreath.template_mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TemplateMod implements ModInitializer
{
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_NAME = "TemplateMod";
	public static final String MOD_ID = "template_mod";
	public static String VERSION = "unknown";

	@Override
	public void onInitialize()
	{
		VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
	}
}
