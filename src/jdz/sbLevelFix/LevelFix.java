
package jdz.sbLevelFix;

import java.lang.reflect.Field;

import org.bukkit.plugin.java.JavaPlugin;

import com.wasteofplastic.askyblock.LevelCalcByChunk;

public class LevelFix extends JavaPlugin {

	@Override
	public void onEnable() {
		try {
			Field field = LevelCalcByChunk.class.getDeclaredField("MAX_CHUNKS");
			FieldChanger.setFinalStatic(field, 1024);
			getLogger().info("Set max island level calc chunks to 1024");
		}
		catch (ReflectiveOperationException e) {
			getLogger().info("Failed to set island level calc chunks to 1024");
			e.printStackTrace();
		}
	}
}
