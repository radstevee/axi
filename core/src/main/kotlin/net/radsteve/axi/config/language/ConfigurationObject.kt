package net.radsteve.axi.config.language

/** An object in a configuration file. */
public interface ConfigurationObject<V : Any> {
  /** The value. */
  public val value: V

  @JvmInline
  public value class String(public override val value: kotlin.String) : ConfigurationObject<kotlin.String>
  @JvmInline
  public value class Int(public override val value: kotlin.Int) : ConfigurationObject<kotlin.Int>
  @JvmInline
  public value class Float(public override val value: kotlin.Float) : ConfigurationObject<kotlin.Float>
  @JvmInline
  public value class Section(public override val value: ConfigurationFile) : ConfigurationObject<ConfigurationFile>
  @JvmInline
  public value class Collection(
    public override val value: kotlin.collections.Collection<ConfigurationObject<*>>
  ) : ConfigurationObject<kotlin.collections.Collection<ConfigurationObject<*>>>

  public data object Null : ConfigurationObject<Unit> {
    override val value: Unit = Unit
  }
}
