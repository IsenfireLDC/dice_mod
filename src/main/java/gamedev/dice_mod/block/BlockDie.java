package gamedev.dice_mod.block;

import javax.annotation.Nullable;

import gamedev.dice_mod.tileentity.TileEntityDie;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockDie extends BlockTileEntity<TileEntityDie> {
	
	public BlockDie() {
		super(Material.ROCK, "die");
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityDie tile = getTileEntity(world, pos);
			player.sendMessage(new TextComponentString("Roll: " + tile.roll()));
		}
		return true;
	}
	
	@Override
	public Class<TileEntityDie> getTileEntityClass() {
		return TileEntityDie.class;
	}
	
	@Nullable
	@Override
	public TileEntityDie createTileEntity(World world, IBlockState state) {
		return new TileEntityDie();
	}

}