# Name Tag API

Axi supports setting player name tags to components via
the `DisplayNameComponent` and its `Player.displayNameTag`
extension.

This will set the player's name tag value to the given
component and will recreate the text display when necessary.
This includes: teleporting (across dimensions), respawning
and reconnecting.

::: warn
**Important**: When using this API, do not call `Player#teleport`
for cross-world teleports. This will fail. Instead, use
`Player#axiTeleport`.
:::
