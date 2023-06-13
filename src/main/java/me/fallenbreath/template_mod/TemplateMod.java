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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//#if FABRIC
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

public class TemplateMod implements ModInitializer
{
	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MOD_ID = "template_mod";
	public static String MOD_VERSION = "unknown";
	public static String MOD_NAME = "unknown";

	@Override
	public void onInitialize()
	{
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata();
		MOD_NAME = metadata.getName();
		MOD_VERSION = metadata.getVersion().getFriendlyString();

		LOGGER.info("Hello {} v{} from fabric!", MOD_NAME, MOD_VERSION);
	}
}
//#elseif FORGE
//$$ import net.minecraftforge.fml.ModList;
//$$ import net.minecraftforge.fml.common.Mod;
//$$ import net.minecraftforge.forgespi.language.IModInfo;
//$$
//$$ @Mod(TemplateMod.MOD_ID)
//$$ public class TemplateMod
//$$ {
//$$ 	public static final Logger LOGGER = LogManager.getLogger();
//$$
//$$ 	public static final String MOD_ID = "template_mod";
//$$ 	public static String MOD_VERSION = "unknown";
//$$ 	public static String MOD_NAME = "unknown";
//$$
//$$ 	public TemplateMod()
//$$ 	{
//$$ 		IModInfo modInfo = ModList.get().getModContainerById(MOD_ID).orElseThrow(RuntimeException::new).getModInfo();
//$$ 		MOD_NAME = modInfo.getDisplayName();
//$$ 		MOD_VERSION = modInfo.getVersion().toString();
//$$ 		LOGGER.info("Hello {} v{} from forge!", MOD_NAME, MOD_VERSION);
//$$ 	}
//$$ }
//#endif
