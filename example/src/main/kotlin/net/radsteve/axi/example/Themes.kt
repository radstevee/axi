package net.radsteve.axi.example

import net.kyori.adventure.text.format.TextColor.color
import net.radsteve.axi.ui.theme.ColorPalette
import net.radsteve.axi.ui.theme.Theme

// https://github.com/decaycs/decaycs#decayce
public val Decayce: Theme = Theme(
  // Not the actual fg but the gray just looks horrendous without the
  // actual decayce bg
  foreground = color(0xd0d3d8),
  accent = color(0x86aaec),
  palette = ColorPalette(
    black = color(0x0d0f18),
    darkBlue = color(0x668acc),
    darkGreen = color(0x70ae8a),
    darkAqua = color(0x73aec9),
    darkRed = color(0xbd4757),
    darkPurple = color(0xa77bd0),
    gold = color(0xdcc390),
    gray = color(0x9daec7),
    darkGray = color(0x8596af),
    blue = color(0x86aaec),
    green = color(0x90ceaa),
    aqua = color(0x93cee9),
    red = color(0xdd6777),
    pink = color(0xc79bf0),
    yellow = color(0xecd3a0),
    white = color(0xd0d3d8),
  ),
)
