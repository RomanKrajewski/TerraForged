/*
 *   
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
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

package com.terraforged.api.biome.modifier;

import com.terraforged.core.cell.Cell;
import com.terraforged.world.climate.Climate;
import net.minecraft.world.biome.Biome;

public abstract class AbstractOffsetModifier implements BiomeModifier {

    private final Climate climate;

    public AbstractOffsetModifier(Climate climate) {
        this.climate = climate;
    }

    @Override
    public Biome modify(Biome in, Cell cell, int x, int z) {
        float dx = climate.getOffsetX(x, z, 50);
        float dz = climate.getOffsetX(x, z, 50);
        return modify(in, cell, x, z, x + dx, z + dz);
    }

    protected abstract Biome modify(Biome in, Cell cell, int x, int z, float ox, float oz);
}
