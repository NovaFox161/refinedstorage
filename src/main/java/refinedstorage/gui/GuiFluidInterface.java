package refinedstorage.gui;

import mezz.jei.gui.ingredients.FluidStackRenderer;
import refinedstorage.api.storage.CompareUtils;
import refinedstorage.container.ContainerFluidInterface;
import refinedstorage.gui.sidebutton.SideButtonCompare;
import refinedstorage.gui.sidebutton.SideButtonRedstoneMode;
import refinedstorage.tile.TileFluidInterface;

public class GuiFluidInterface extends GuiBase {
    private static final FluidStackRenderer TANK_IN_RENDERER = new FluidStackRenderer(TileFluidInterface.TANK_CAPACITY, true, 12, 47, null);

    public GuiFluidInterface(ContainerFluidInterface container) {
        super(container, 211, 204);
    }

    @Override
    public void init(int x, int y) {
        addSideButton(new SideButtonRedstoneMode(TileFluidInterface.REDSTONE_MODE));

        addSideButton(new SideButtonCompare(TileFluidInterface.COMPARE, CompareUtils.COMPARE_NBT));
    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void drawBackground(int x, int y, int mouseX, int mouseY) {
        bindTexture("gui/fluid_interface.png");

        drawTexture(x, y, 0, 0, width, height);

        if (TileFluidInterface.TANK_IN.getValue() != null) {
            TANK_IN_RENDERER.draw(mc, x + 46, y + 56, TileFluidInterface.TANK_IN.getValue());
        }

        if (TileFluidInterface.TANK_OUT.getValue() != null) {
            TANK_IN_RENDERER.draw(mc, x + 118, y + 56, TileFluidInterface.TANK_OUT.getValue());
        }
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        drawString(7, 7, t("gui.refinedstorage:fluid_interface"));
        drawString(43 + 4, 20, t("gui.refinedstorage:fluid_interface.in"));
        drawString(115 + 1, 20, t("gui.refinedstorage:fluid_interface.out"));
        drawString(7, 111, t("container.inventory"));
    }
}