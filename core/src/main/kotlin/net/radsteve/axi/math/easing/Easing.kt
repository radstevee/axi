package net.radsteve.axi.math.easing

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/** An easing function. */
public fun interface Easing {
  /** Applies this easing function. */
  public fun apply(x: Double): Double

  public companion object {
    // Yanked from https://github.com/ai/easings.net/blob/master/src/easings/easingsFunctions.ts
    private const val PI: Double = Math.PI
    private const val C1: Double = 1.70158
    private const val C2: Double = C1 * 1.525
    private const val C3: Double = C1 + 1
    private const val C4: Double = (2 * PI) / 3
    private const val C5: Double = (2 * PI) / 4.5
    private val bounceOut: Easing = Easing { x ->
      val n1 = 7.5625
      val d1 = 2.75

      when {
        x < 1 / d1 -> n1 * x * x
        x < 2 / d1 -> n1 * (x - 1.5 / d1).let { y -> y * y } + 0.75
        x < 2.5 / d1 -> n1 * (x - 2.25 / d1).let { y -> y * y } + 0.9375
        else -> n1 * (x - 2.625 / d1).let { y -> y * y } + 0.984375
      }
    }
    public val Linear: Easing = Easing { x -> x }
    public val EaseInQuad: Easing = Easing { x -> x * x }
    public val EaseOutQuad: Easing = Easing { x -> 1 - (1 - x).let { y -> y * y } }
    public val EaseInOutQuad: Easing = Easing { x ->
      if (x < 0.5) {
        2 * x * x
      } else {
        1 - (-2 * x + 2).let { y -> y * y } / 2
      }
    }
    public val EaseInCubic: Easing = Easing { x -> x * x * x }
    public val EaseOutCubic: Easing = Easing { x -> 1 - (1 - x).let { y -> y * y * y } }
    public val EaseInOutCubic: Easing = Easing { x ->
      if (x < 0.5) {
        4 * x * x * x
      } else {
        1 - (-2 * x + 2).let { y -> y * y * y } / 2
      }
    }
    public val EaseInQuart: Easing = Easing { x -> x * x * x * x }
    public val EaseOutQuart: Easing = Easing { x -> 1 - (1 - x).let { y -> y * y * y * y } }
    public val EaseInOutQuart: Easing = Easing { x ->
      if (x < 0.5) {
        8 * x * x * x * x
      } else {
        1 - (-2 * x + 2).let { y -> y * y * y * y } / 2
      }
    }
    public val EaseInQuint: Easing = Easing { x -> x * x * x * x * x }
    public val EaseOutQuint: Easing = Easing { x -> 1 - (1 - x).let { y -> y * y * y * y * y } }
    public val EaseInOutQuint: Easing = Easing { x ->
      if (x < 0.5) {
        16 * x * x * x * x * x
      } else {
        1 - (-2 * x + 2).let { y -> y * y * y * y * y } / 2
      }
    }
    public val EaseInSine: Easing = Easing { x -> 1 - cos((x * PI) / 2) }
    public val EaseOutSine: Easing = Easing { x -> sin((x * PI) / 2) }
    public val EaseInOutSine: Easing = Easing { x -> -(cos(PI * x) - 1) / 2 }
    public val EaseInExpo: Easing = Easing { x ->
      if (x == 0.0) {
        0.0
      } else {
        2.0.pow(10 * x - 10)
      }
    }
    public val EaseOutExpo: Easing = Easing { x ->
      if (x == 1.0) {
        1.0
      } else {
        1 - 2.0.pow(-10 * x)
      }
    }
    public val EaseInOutExpo: Easing = Easing { x ->
      when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        in 0.0..0.5 -> 2.0.pow(20 * x - 10) / 2
        else -> (2 - 2.0.pow(-20 * x + 10)) / 2
      }
    }
    public val EaseInCirc: Easing = Easing { x -> 1 - sqrt(1 - x * x) }
    public val EaseOutCirc: Easing = Easing { x -> sqrt(1 - (x - 1).let { y -> y * y }) }
    public val EaseInOutCirc: Easing = Easing { x ->
      if (x < 0.5) {
        (1 - sqrt(1 - (2 * x).let { y -> y * y })) / 2
      } else {
        (sqrt(1 - (-2 * x + 2).let { y -> y * y }) + 1) / 2
      }
    }
    public val EaseInBack: Easing = Easing { x -> C3 * x * x * x - C1 * x * x }
    public val EaseOutBack: Easing = Easing { x ->
      val t = x - 1
      1 + C3 * t * t * t + C1 * t * t
    }
    public val EaseInOutBack: Easing = Easing { x ->
      if (x < 0.5) {
        val t = 2 * x
        (t * t * ((C2 + 1) * t - C2)) / 2
      } else {
        val t = 2 * x - 2
        (t * t * ((C2 + 1) * t + C2) + 2) / 2
      }
    }
    public val EaseInElastic: Easing = Easing { x ->
      when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        else -> (-2.0).pow(10 * x - 10) * sin((x * 10 - 10.75) * C4)
      }
    }
    public val EaseOutElastic: Easing = Easing { x ->
      when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        else -> 2.0.pow(-10 * x) * sin((x * 10 - 0.75) * C4) + 1
      }
    }
    public val EaseInOutElastic: Easing = Easing { x ->
      when (x) {
        0.0 -> 0.0
        1.0 -> 1.0
        in 0.0..0.5 -> -(2.0.pow(20 * x - 10) * sin((20 * x - 11.125) * C5)) / 2
        else -> (2.0.pow(-20 * x + 10) * sin((20 * x - 11.125) * C5)) / 2 + 1
      }
    }
    public val EaseInBounce: Easing = Easing { x -> 1 - bounceOut.apply(1 - x) }
    public val EaseOutBounce: Easing = bounceOut
    public val EaseInOutBounce: Easing = Easing { x ->
      if (x < 0.5) {
        (1 - bounceOut.apply(1 - 2 * x)) / 2
      } else {
        (1 + bounceOut.apply(2 * x - 1)) / 2
      }
    }
  }
}
