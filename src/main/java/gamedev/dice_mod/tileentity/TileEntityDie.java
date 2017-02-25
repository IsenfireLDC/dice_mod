package gamedev.dice_mod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDie extends TileEntity {
	
	private int max = 6;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("max", max);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		max = compound.getInteger("max");
		super.readFromNBT(compound);
	}
	
	public int roll() {
		int rolled = (int)Math.ceil(Math.random() * max);
		return rolled;
	}
}
