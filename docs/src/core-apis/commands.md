# Commands

Axi provides a command API wrapping
around [Cloud](https://github.com/incendo/cloud)
with a Kotlin DSL and coroutines integration.

## Declaring your first Command

To declare a command, all you need to do is to call the
`Command` function:

```kt
val TestCommand = Command("test")
```

## Adding an executor

Now, this command is very basic. It does not have any
executor, arguments,
nor subcommands. To make this a little more interesting, we
can use the DSL
to add an executor:

```kt
val TestCommand = Command("test") {
  executor {
    ctx.sendMesage(text("Hello, world!"))
  }
}
```

::: info
Executors are executed inside of a `CommandExecutionContext`
and are always suspending, but run synchronous by default.
`CommandExecutionContext` implements `CoroutineScope` so you
can launch jobs inside of your command just fine.
:::

We could even make this a bit fancier and use a
player-specific executor
that only accepts players:

```kt
val TestCommand = Command("test") {
  playerExecutor { player ->
    player.sendMesage(text("Hello, world!"))
  }
}
```

We could also make the executor run asynchronously:

```kt
val TestCommand = Command("test") {
  async()

  executor {
    ctx.sendMesage(text("Hello, world!"))
  }
}
```

::: warning
Never call any of the Bukkit API from an async executor
without using a synchronous coroutine context like the
`syncContext` function offers.

Asynchronous executors are experimental.
:::

## Adding aliases

This is already much better. This will create a `/test`
command that will
respond to the sender with `Hello, world`.

Now, maybe we would like to add an alias to this command. We
can do that by
using the `aliases` function:

```kt
val TestCommand = Command("test") {
  aliases("hello")

  executor {
    ctx.sendMesage(text("Hello, world!"))
  }
}
```

## Adding subcommands

What if we want to add a subcommand? Well, that's easy, we
can use the `sub`
function provided by the `CommandBuilder` DSL:

```kt
val TestCommand = Command("test") {
  aliases("hello")

  executor {
    ctx.sendMesage(text("Hello, world!"))
}

  sub("bye") {
    executor {
      ctx.sendMessage(text("Bye, world!"))
    }
  }
}
```

This `sub` function will create a new `CommandBuilder`, to
which you can apply
the same concepts, we won't be repeating them here.

## Adding arguments

Now, we obviously want to have an argument in our command.
Let's take in a `name`
to greet or say goodbye to:

```kt
val TestCommand = Command("test") {
  aliases("hello")

  val name by arg("name", stringParser()) // stringParser comes from Cloud's StringParser

  executor {
    ctx.sendMesage(text("Hello, $name!"))
  }

  sub("bye") {
    executor {
      ctx.sendMessage(text("Bye, $name!"))
    }
  }
}
```

This will work for `/hello rad`: `Hello, rad!`. But when we
try to do `/hello bye rad`
or `/hello rad bye`, we will either get a syntax exception
or this cloud exception:

```txt
There is no object in the registry identified by the key 'name'
```

This happens because we are declaring a command argument to
our root command, but not
to our subcommand. This means we will have to redeclare it
in the subcommand's builder:

```kt
val TestCommand = Command("test") {
  aliases("hello")
 
  val name by arg("name", stringParser())

  executor {
    ctx.sendMesage(text("Hello, $name!"))
  }

  sub("bye") {
    val name by arg("name", stringParser())

    executor {
      ctx.sendMessage(text("Bye, $name!"))
    }
  }
}
```

Now, we can use `/hello bye rad` and it will say
`Bye, rad!`. Great!
We now have a working command. But what if we want to
restrict this
so only some users can execute it?

## Using Permissions

Axi commands default to the permission
`<plugin>.command.<name>`, where `plugin`
is the name of the plugin that is adding this command and
`name` is the name
of the command. In our case, it would be:

- `axi-demo.command.test`
- `axi-demo.command.test.bye`

We can change this using the `permission` function:

```kt
val TestCommand = Command("test") {
  aliases("hello")
 
  val name by arg("name", stringParser())

  permission("axi.testcommands.hello")
 
  executor {
    ctx.sendMesage(text("Hello, $name!"))
  }
 
  // ...
}
```

Now, we would need to give players access to our
`axi.testcommands.hello`
permission in our permission plugin in order for them to be
able to use it.

::: info
Subcommand permissions append `.<name>` to the parent
command permission.
In our case it would be `axi.testcommands.hello.bye`.
:::

## Registering your command

Great! We now have our command! But... how do we actually
register it?

Well, there's two options:

- Use the KSP processor to register them automatically
- Register them manually

### Automatic Registration

First, make sure you are using the
Axi gradle plugin, as specified in the
[Quickstart](/getting-started/quickstart) page.

Then, all you need to do is to add the `@AutoRegistered`
annotation to your
command field:

```kt
@AutoRegistered
val MyCommand = Command("hello")
```

::: warning
If you are making an Axi module used
by other people, this will not work
due to library loading and classloaders.
See the manual section below.
:::

### Manual Registration

You can simply call `Command#register` in your plugin and it
will register
to the plugin provided to the command builder.
