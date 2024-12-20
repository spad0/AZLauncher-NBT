import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagInt;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class GlintItem {
    private ItemStack item;

    public GlintItem() {
        item = new ItemStack(Material.BOW, 1);
        item = addGlintTags(item);
    }

    private ItemStack addGlintTags(ItemStack item) {
        net.minecraft.server.v1_8_R3.ItemStack nmsItem = CraftItemStack.asNMSCopy(item);

        NBTTagCompound tag;
        if (nmsItem.hasTag()) {
            tag = nmsItem.getTag();
        } else {
            tag = new NBTTagCompound();
        }

        tag.set("PacRender", new NBTTagCompound());
        tag.getCompound("PacRender").set("Glint", new NBTTagInt(1));

        tag.set("PacDisplay", new NBTTagCompound());
        tag.getCompound("PacDisplay").set("Glint", new NBTTagInt(1));

        nmsItem.setTag(tag);

        return CraftItemStack.asBukkitCopy(nmsItem);
    }

    public ItemStack getItem() {
        return item;
    }
}
