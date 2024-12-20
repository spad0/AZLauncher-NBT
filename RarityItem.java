import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagString;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class RarityItem {
    private ItemStack item;

    public RarityItem() {
        item = new ItemStack(Material.RAW_FISH, 1);
        item = addRarityTags(item);
    }

    private ItemStack addRarityTags(ItemStack item) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound tag;
        if (nmsItem.hasTag()) {
            tag = nmsItem.getTag();
        } else {
            tag = new NBTTagCompound();
        }

        tag.set("PacRender", new NBTTagCompound());
        tag.getCompound("PacRender").set("Rarity", new NBTTagString("MYTHIC"));

        tag.set("PacDisplay", new NBTTagCompound());
        tag.getCompound("PacDisplay").set("Rarity", new NBTTagString("MYTHIC"));

        nmsItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    public ItemStack getItem() {
        return item;
    }
}
