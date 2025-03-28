# Entity Component System

![A diagram of an example ECS](/ecs.png)

*ECS Block
Diagram ([Unity](https://docs.unity3d.com/Packages/com.unity.entities@0.1/manual/ecs_core.html))*

> [An] Entity-component-system (ECS) is a software
> architectural pattern
> mostly used in video game development for the
> representation of game
> world objects.

[Wikipedia ↗](https://en.wikipedia.org/wiki/Entity_component_system)

## Creating an Entity

All you need to do to create an entity is to implement the
`Attachable` interface
with no implementing required.

If you are however wanting to implement this for an already
existing class, you can
use the `WrappedAttachable<T>` class, and will unfortunately
have to make extensions
for data management, or access your wrapped attachable
directly.

## Creating a Component

A component is represented using the `Any` class. This means
that any object can
be used as a component. Components are identified by their
classes.

## Storing and retrieving Data

The extensions on `Attachable` help you manage the data of
your entity:

```kt
fun <T : Any> Attachable.get(klass: KClass<T>): T?
inline fun <reified T : Any> Attachable.get(): T?

fun <T : Any> Attachable.set(value: T?, klass: KClass<T>): T?
inline fun <reified T : Any> Attachable.set(value: T?): T?

fun <T : Any> Attachable.getOrPut(value: T, klass: KClass<T>): T
inline fun <reified T : Any> Attachable.getOrPut(value: T): T

inline fun <reified T : Any> Attachable.data(): ReadWriteProperty<Any?, T?>

fun Attachable.components(): Set<WrappedComponent<*>>
```

So, let's see this in action!

```kt
class Entity : Attachable

data class IntegerComponent(val int: Int)
data class StringComponent(val string: String)

val entity = Entity()

println(entity.get<IntegerComponent>()) // null
println(entity.getOrPut(IntegerComponent(-1))) // IntegerComponent(int = -1)
println(entity.set<IntegerComponent>(null)) // null
println(entity.getOrPut<StringComponent>(StringComponent("hello, world!"))) // StringComponent(string = "hello, world!")

var stringComponent by entity.data<StringComponent>() // StringComponent(string = "hello, world!")
stringComponent = StringComponent("bye, world!")
println(entity.get<StringComponent>()?.string) // bye, world!

val otherEntity = Entity()
println(otherEntity.get<IntegerComponent>()) // null
println(otherEntity.get<StringComponent>()) // null
```

There's a lot to unpack here.

First up, we create an entity class implementing the
`Attachable` interface.
This is our entity that can store components!

Then, we create two components:

- An `IntegerComponent` storing an `Int`
- A `StringComponent` storing a `String`

Now, we can perform any kind of data manipulation on this
entity, for example
we can:

- Get the component
- Get the component, or put it if it does not exist
- Set the component
- Obtain a delegating property to the component

## Creating a system

To create a system, you will need to implement the `System`
interface and provide component archetypes this system filters:

```kt
object ExampleSystem : System {
  override val archetypes: Sequence<KClass<out Any>> = sequenceOf(Position::class)
  
  override suspend fun tick(tick: Int, attachable: Attachable) {
    // This will not be null because of our [archetypes] filter.
    val position = attachable.get<Position>()!!
    println("Attachable ${attachable.identity} is at position $position!")
  }
}
```

Now, we can start and stop ticking this system using the
`System#start` and `System#stop` functions:

```kt
class ExamplePlugin : AxiPlugin() {
  override suspend fun enable() {
    // ...
    ExampleSystem.start()
  }
}
```
