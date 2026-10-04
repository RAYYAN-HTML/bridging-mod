# Hybrid Bridging

A Fabric **client-side** mod for Minecraft Java **1.21.1** that keeps normal Java block placement when it already works, and adds a Bedrock-style fallback search when it does not—useful for bridging at edges and while moving diagonally.

No server install is required.

## Features

- Vanilla placement wins whenever the standard crosshair raycast hits a block.
- Fallback placement runs only when that raycast misses (or the incoming hit is not a block).
- Configurable fallback search radius, tolerance, edge assistance, and diagonal assistance.
- Does not change movement, reach, or physics—only how placement is chosen on the client.

## Requirements

- Minecraft **1.21.1**
- [Fabric Loader](https://fabricmc.net/use/) **0.16.10+**
- [Fabric API](https://modrinth.com/mod/fabric-api)

## Installation

1. Install Fabric Loader for Minecraft 1.21.1.
2. Download **Fabric API** and place it in your `mods` folder.
3. Build the mod (see below) or download a release JAR, then copy `bridging-mod-*.jar` into `mods`.
4. Launch the game.

## Configuration

On first run the mod creates `config/bridging-mod.json`:

| Option | Default | Description |
|--------|---------|-------------|
| `enabled` | `true` | Master toggle for hybrid placement. |
| `fallbackSearchRadius` | `3` | Block radius around your feet to search for fallback anchors. |
| `placementTolerance` | `0.25` | How far a candidate may be from your crosshair line. |
| `edgeAssistance` | `true` | Prefer helpful placements when bridging over a gap ahead of you (on ground or sneaking). |
| `diagonalAssistance` | `true` | Bias fallback scoring when you move diagonally relative to your facing. |

Edit the file while the game is closed, then restart to apply changes.

## Build from source

```powershell
cd bridging-mod
.\gradlew build
```

The mod JAR is written to `build/libs/bridging-mod-<version>.jar`.

Run tests:

```powershell
.\gradlew test
```

### Gradle without the wrapper

If you prefer a local Gradle install:

```powershell
gradle build
```

## GitHub setup

1. Create a new repository (for example `bridging-mod`).
2. Replace `YOUR_USERNAME` in `src/main/resources/fabric.mod.json` with your GitHub username.
3. Optionally add your name to the `authors` array in the same file.
4. Push this project:

```powershell
git init
git add .
git commit -m "Initial release of Hybrid Bridging"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/bridging-mod.git
git push -u origin main
```

## License

[MIT](LICENSE)
