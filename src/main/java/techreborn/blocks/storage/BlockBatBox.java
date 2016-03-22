package techreborn.blocks.storage;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import reborncore.common.blocks.BlockMachineBase;
import reborncore.common.blocks.IRotationTexture;
import techreborn.Core;
import techreborn.client.GuiHandler;
import techreborn.client.TechRebornCreativeTab;
import techreborn.tiles.storage.TileBatBox;

/**
 * Created by modmuss50 on 14/03/2016.
 */
public class BlockBatBox  extends BlockMachineBase implements IRotationTexture {

    public BlockBatBox() {
        super();
        setUnlocalizedName("techreborn.batBox");
        setCreativeTab(TechRebornCreativeTab.instance);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,  EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (!player.isSneaking())
            player.openGui(Core.INSTANCE, GuiHandler.batboxID, world, x, y, z);
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileBatBox();
    }
    
    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> items = new ArrayList<ItemStack>();
        items.add(new ItemStack(this));
        return items;
    }

    protected final String prefix = "techreborn:blocks/machine/storage/";

    @Override
    public String getFrontOff() {
        return prefix + "batbox_front";
    }

    @Override
    public String getFrontOn() {
        return prefix + "batbox_front";
    }

    @Override
    public String getSide() {
        return prefix + "batbox_side";
    }

    @Override
    public String getTop() {
        return prefix + "batbox_top";
    }

    @Override
    public String getBottom() {
        return prefix + "batbox_bottom";
    }
}