/*
 * This file is licensed under the MIT License, part of Create's Delight.
 * Copyright (c) 2021~2023 Phoupraw
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ho.artisan.createreibugfix.inject;

import com.simibubi.create.compat.rei.category.CreateRecipeCategory;
import com.simibubi.create.compat.rei.display.CreateDisplay;
import com.simibubi.create.content.kinetics.crusher.AbstractCrushingRecipe;

import io.github.fabricators_of_create.porting_lib.fluids.FluidStack;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.common.util.EntryStacks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.util.collection.DefaultedList;

import ho.artisan.createreibugfix.utils.REICreateUtils;

import java.util.List;

@Environment(EnvType.CLIENT)
public interface MillingCategoryInject {
    static void drawFluidSlot(CreateDisplay<AbstractCrushingRecipe> display, Rectangle bounds, Point origin, List<Widget> widgets) {
        DefaultedList<FluidStack> fluidResults = display.getRecipe().getFluidResults();
        if (fluidResults.isEmpty()) return;
        int outputIndex = display.getRecipe().getRollableResults().size();
        int xOffset = outputIndex % 2 == 0 ? 0 : 19;
        int yOffset = (outputIndex / 2) * -19;
        widgets.add(REICreateUtils.slotOf(new Point((origin.x + 133 + xOffset) + 1, (origin.y + 27 + yOffset) + 1), List.of(EntryStacks.of(CreateRecipeCategory.convertToREIFluid(fluidResults.get(0)))))
                .markOutput());
    }
}
