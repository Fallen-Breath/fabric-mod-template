/*
 * This file is part of the TemplateMod project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2023  Fallen_Breath and contributors
 *
 * TemplateMod is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TemplateMod is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with TemplateMod.  If not, see <https://www.gnu.org/licenses/>.
 */

package me.fallenbreath.template_mod;

//#if MC >= 1.18.2
//$$ import com.mojang.logging.LogUtils;
//$$ import org.slf4j.Logger;
//#else
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//#endif

//#if FABRIC
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
//#elseif FORGE
//$$ import net.minecraftforge.fml.ModList;
//$$ import net.minecraftforge.forgespi.language.IModInfo;
//#elseif NEOFORGE
//$$ import net.neoforged.fml.ModList;
//$$ import net.neoforged.neoforgespi.language.IModInfo;
//#endif

@net.minecraftforge.fml.common.Mod(TemplateMod.MOD_ID)
@net.neoforged.fml.common.Mod(TemplateMod.MOD_ID)
public class TemplateMod
{
	public static final Logger LOGGER =
			//#if MC >= 11802
			//$$ LogUtils.getLogger();
			//#else
			LogManager.getLogger();
			//#endif

	public static final String MOD_ID = "template_mod";

	//#if !MERGED
	public static String MOD_VERSION = "unknown";
	public static String MOD_NAME = "unknown";
	//#endif

	//#if FABRIC
	public void fabricInit()
	{
		//#if !MERGED
		FabricMeta.load();
		LOGGER.info("Hello {} v{} from fabric!", MOD_NAME, MOD_VERSION);
		//#endif
		this.commonInit();
	}
	//#elseif FORGE_LIKE
	//$$ public TemplateMod()
	//$$ {
	//$$ 	this.forgeInit();
	//$$ }
	//$$
	//$$ public void forgeInit()
	//$$ {
	//$$ 	ForgeMeta.load();
	//$$ 	LOGGER.info("Hello {} v{} from forge-like!", MOD_NAME, MOD_VERSION);
	//$$ 	this.commonInit();
	//$$ }
	//#endif

	private void commonInit()
	{
		// common init here
	}

	//#if FABRIC && !MERGED
	private static class FabricMeta
	{
		public static void load()
		{
			ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
			MOD_NAME = metadata.getName();
			MOD_VERSION = metadata.getVersion().getFriendlyString();
		}
	}
	//#endif

	//#if FORGE_LIKE
	//$$ private static class ForgeMeta
	//$$ {
	//$$ 	public static void load()
	//$$ 	{
	//$$ 		IModInfo modInfo = ModList.get().getModContainerById(MOD_ID).orElseThrow(RuntimeException::new).getModInfo();
	//$$ 		MOD_NAME = modInfo.getDisplayName();
	//$$ 		MOD_VERSION = modInfo.getVersion().toString();
	//$$ 	}
	//$$ }
	//#endif
}
